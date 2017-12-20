package com.iu.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="memberMapper."; 
	
	public List<MemberDTO> selectList() {
		return sqlSession.selectList(NAMESPACE+"selectList");
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	public void delete() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "test3");
		sqlSession.delete(NAMESPACE+"delete", map);
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void list() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", 1);
		map.put("endrow", 10);
		sqlSession.selectList(NAMESPACE+"list", map);
		
		@SuppressWarnings("unchecked")
		List<MemberDTO> list = (List<MemberDTO>)map.get("list");
		for(MemberDTO dto : list) {
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getJob());
			System.out.println("================");
		}
		
	}
}
