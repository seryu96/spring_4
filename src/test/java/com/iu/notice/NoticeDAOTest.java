package com.iu.notice;

// import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.RowNum;

public class NoticeDAOTest extends AbstractTest {

	@Inject
	NoticeDAO noticeDAO;
	
	public void getNum() throws Exception {
		int result = noticeDAO.getNum();
		System.out.println(result);
	}
	
	public void totalCount() throws Exception {
		RowNum rowNum = new RowNum();
		rowNum.setStartRow(1);
		rowNum.setLastRow(10);
		rowNum.setKind("title");
		rowNum.setSearch("test");
		int result = noticeDAO.totalCount(rowNum);
		System.out.println(result);
	}
	
	public void hitUpdate() throws Exception {
		noticeDAO.hitUpdate(642);
	}
	
	public void delete() throws Exception {
		noticeDAO.delete(542);
	}
	
	public void update() throws Exception {
		BoardDTO boardDTO = new NoticeDTO();
		boardDTO.setTitle("TEST");
		boardDTO.setContents("Test");
		noticeDAO.update(boardDTO);
	}
	
	public void insert() throws Exception {
		BoardDTO boardDTO = new NoticeDTO();
		boardDTO.setTitle("TEST");
		boardDTO.setContents("Contents");
		boardDTO.setWriter("TESTER");
		noticeDAO.insert(boardDTO);
	}
	
	public void view() throws Exception {
		NoticeDTO noticeDTO = (NoticeDTO)noticeDAO.selectOne(618);
		System.out.println(noticeDTO.getNum());
		System.out.println(noticeDTO.getTitle());
	}
	
	public void list() throws Exception {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		RowNum rowNum = new RowNum();
		rowNum.setStartRow(1);
		rowNum.setLastRow(10);
		rowNum.setKind("title");
		rowNum.setSearch("test");
		list = noticeDAO.selectList(rowNum);
		
		for(BoardDTO dto : list) {
			System.out.println(dto.getNum());
			System.out.println(dto.getTitle());
		}
	}

	@Test
	public void test() {
		try {
			this.insert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void before() {
		System.out.println("===============");
	}
	
	@After
	public void after() {
		System.out.println("===============");
	}
}
