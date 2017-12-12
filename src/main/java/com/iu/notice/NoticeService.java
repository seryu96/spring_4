package com.iu.notice;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class NoticeService implements BoardService {

	@Inject
	private NoticeDAO noticeDAO;
	
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
		return noticeDAO.selectOne(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.insert(boardDTO);
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
