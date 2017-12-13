package com.iu.notice;

import java.util.List;

// import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.ListData;

public class NoticeServiceTest extends AbstractTest {
	
	@Inject
	NoticeService noticeService;
	
	public void delete() throws Exception {
		noticeService.delete(664);
	}
	
	public void update() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("제목1");
		boardDTO.setContents("내용1");
		boardDTO.setNum(664);
		noticeService.update(boardDTO);
	}
	/*
	public void write() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("제목");
		boardDTO.setWriter("작성자");
		boardDTO.setContents("내용");
		noticeService.insert(boardDTO, );
	}*/
	
	public void view() throws Exception {
		BoardDTO boardDTO = noticeService.selectOne(662);
		System.out.println(boardDTO.getNum());
		System.out.println(boardDTO.getTitle());
	}
	
	public void list() throws Exception {
		ListData listData = new ListData();
		ModelAndView mv = noticeService.selectList(listData);
		@SuppressWarnings("unchecked")
		List<BoardDTO> list = (List<BoardDTO>)mv.getModel().get("list");
		for(BoardDTO dto: list) {
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
