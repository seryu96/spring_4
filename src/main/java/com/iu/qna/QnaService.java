package com.iu.qna;

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
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	
	@Inject
	private FileDAO fileDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public ModelAndView selectList(ListData listData) throws Exception {
		ModelAndView mv = new ModelAndView();
		RowNum rowNum = listData.makeRow();
		Pager pager = listData.makePage(qnaDAO.totalCount(rowNum));
		mv.addObject("page", pager);
		mv.addObject("list", qnaDAO.selectList(rowNum));
		mv.addObject("board", "qna");
		return mv;
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		qnaDAO.hitUpdate(num);
		BoardDTO boardDTO = qnaDAO.selectOne(num);
		return boardDTO;
	}

	@Override
	public int insert(BoardDTO boardDTO, HttpSession session) throws Exception {
		MultipartFile[] files = ((QnaDTO)boardDTO).getFiles();
		int result = qnaDAO.insert(boardDTO);
		
		for(MultipartFile multipartFile : files) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fileSaver.fileSave(multipartFile, session, "upload"));
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDAO.insert(fileDTO);
		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return qnaDAO.delete(num);
	}
	
	public int reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		qnaDAO.stepUpdate(qnaDTO);
		
		MultipartFile[] files = qnaDTO.getFiles();
		for(MultipartFile multipartFile : files) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(qnaDTO.getNum());
			fileDTO.setFname(fileSaver.fileSave(multipartFile, session, "upload"));
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDAO.insert(fileDTO);
		}
		int result = qnaDAO.reply(qnaDTO);
		return result;
	}
}
