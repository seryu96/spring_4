package com.iu.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.RowNum;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession; 
	private static final String namespace = "noticeMapper.";
	
	@Override
	public List<BoardDTO> selectList(RowNum rowNum) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", rowNum.getStartRow());
		map.put("lastRow", rowNum.getLastRow());
		map.put("kind", rowNum.getKind());
		map.put("search", rowNum.getSearch());
		
		return sqlSession.selectList(namespace+"selectList", map);		
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return sqlSession.selectOne(namespace+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(namespace+"insert", boardDTO);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+"update", boardDTO);
	}
	
	
	@Override
	public int delete(int num) throws Exception {
		return sqlSession.delete(namespace+"delete", num);
	}

	@Override
	public int hitUpdate(int num) throws Exception {
		return sqlSession.update(namespace+"hitUpdate", num);
	}

	@Override
	public int totalCount(RowNum rowNum) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", rowNum.getKind());
		map.put("search", rowNum.getSearch());
		return sqlSession.selectOne(namespace+"totalCount", map);
	}

	@Override
	public int getNum() throws Exception {
		return sqlSession.selectOne(namespace+"getNum");
	}
	
}
