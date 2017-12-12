package com.iu.qna;

import java.util.List;

import javax.inject.Inject;

// import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.ListData;

public class QnaServiceTest extends AbstractTest {

	@Inject
	private QnaService qnaService;
	
	public void list() throws Exception {
		ListData listData = new ListData();
		ModelAndView mv = qnaService.selectList(listData);
		@SuppressWarnings("unchecked")
		List<BoardDTO> list = (List<BoardDTO>)mv.getModel().get("list");
		for(BoardDTO dto : list) {
			System.out.println(dto.getNum());
			System.out.println(dto.getTitle());
		}
	}
	
	@Test
	public void test() {
		try {
			this.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
