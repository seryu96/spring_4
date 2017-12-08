package com.iu.notice;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession; 
	private static final String namespace = "noticeMapper.";
	
	public NoticeDTO selectOne(int num) throws Exception {
		return sqlSession.selectOne(namespace+"selectOne", num);
	}

}
