package com.iu.notice;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Inject
	private FileDAO fileDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(noticeDAO.totalCount(rowNum));
		mv.addObject("page", pager);
		mv.addObject("list", noticeDAO.selectList(rowNum));
		mv.addObject("board", "notice");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		noticeDAO.hitUpdate(num);
		BoardDTO boardDTO = noticeDAO.selectOne(num);
		// ((NoticeDTO)boardDTO).setFileNames(fileDAO.selectList(num));
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		MultipartFile[] files = ((NoticeDTO)boardDTO).getFiles();
		// List<FileDTO> names = new ArrayList<FileDTO>();
		int result = noticeDAO.insert(boardDTO);
		
		for(MultipartFile multipartFile : files) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fileSaver.fileSave(multipartFile, session, "upload"));
			fileDTO.setOname(multipartFile.getOriginalFilename());
			// names.add(fileDTO);
			fileDAO.insert(fileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return noticeDAO.delete(num);
	}

}
