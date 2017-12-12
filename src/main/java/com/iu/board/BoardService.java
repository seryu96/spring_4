package com.iu.board;

import org.springframework.web.servlet.ModelAndView;

import com.iu.util.ListData;

public interface BoardService {

	public ModelAndView selectList(ListData listData) throws Exception;
	public BoardDTO selectOne(int num) throws Exception;
	public int insert(BoardDTO boardDTO) throws Exception;
	public int update(BoardDTO boardDTO) throws Exception;
	public int delete(int num) throws Exception;
	
}
