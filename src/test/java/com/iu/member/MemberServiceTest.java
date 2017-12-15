package com.iu.member;

//import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.AbstractTest;

public class MemberServiceTest extends AbstractTest {

	@Inject
	MemberService memberService;
	
	public void test1() {
		List<MemberDTO> list = memberService.selectList();
		for(MemberDTO dto : list) {
			System.out.println(dto.getId());
		}
	}
	
	@Test
	public void test() {
		this.test1();
	}

}
