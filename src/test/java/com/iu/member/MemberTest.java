package com.iu.member;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.AbstractTest;

public class MemberTest extends AbstractTest {

	@Inject
	MemberDAO memberDAO;
	
	public void delete() throws Exception {
		memberDAO.delete();
	}
	
	public void list() throws Exception {
		memberDAO.list();
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
