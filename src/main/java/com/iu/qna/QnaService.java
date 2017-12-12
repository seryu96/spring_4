package com.iu.qna;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.util.ListData;
import com.iu.util.Pager;
import com.iu.util.RowNum;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	
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
		return qnaDAO.selectOne(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return qnaDAO.delete(num);
	}

}
