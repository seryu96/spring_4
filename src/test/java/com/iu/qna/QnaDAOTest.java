package com.iu.qna;

// import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.RowNum;

public class QnaDAOTest extends AbstractTest {

	@Inject
	QnaDAO qnaDAO;
	
	public void getNum() throws Exception {
		System.out.println(qnaDAO.getNum());
	}
	
	public void totalCount() throws Exception {
		RowNum rowNum = new RowNum();
		rowNum.setKind("title");
		rowNum.setSearch("t");
		System.out.println(qnaDAO.totalCount(rowNum));
	}
	
	public void hitUpdate() throws Exception {
		qnaDAO.hitUpdate(648);
	}
	
	public void delete() throws Exception {
		qnaDAO.delete(261);
	}
	
	public void update() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(648);
		boardDTO.setTitle("제목");
		boardDTO.setContents("내용");
		qnaDAO.update(boardDTO);
	}
	
	public void insert() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("타이틀");
		boardDTO.setWriter("작성자");
		boardDTO.setContents("내용");
		qnaDAO.insert(boardDTO);
	}
	
	public void view() throws Exception {
		BoardDTO boardDTO = qnaDAO.selectOne(610);
		System.out.println(boardDTO.getNum());
		System.out.println(boardDTO.getTitle());
	}
	
	public void list() throws Exception {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		RowNum rowNum = new RowNum();
		rowNum.setStartRow(1);
		rowNum.setLastRow(10);
		rowNum.setKind("title");
		rowNum.setSearch("");
		list = qnaDAO.selectList(rowNum);
		
		for(BoardDTO dto : list) {
			System.out.println(dto.getNum());
			System.out.println(dto.getTitle());
		}
	}
	
	@Test
	public void test() {
		try {
			this.getNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
