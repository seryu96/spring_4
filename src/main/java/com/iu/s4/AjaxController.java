package com.iu.s4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;


@RestController	// Ajax 전용 컨트롤러
@RequestMapping(value="/ajax/*")
public class AjaxController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="checkId", method=RequestMethod.GET)
	@ResponseBody
	public MemberDTO checkId(String id) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("t1");
		memberDTO.setPw("t1");
		memberDTO.setName("t1");
		memberDTO.setAge(25);
		memberDTO.setPhone("01012345678");
		memberDTO.setJob("teacher");
		
		return memberDTO;
	}
	
	@RequestMapping(value="memberList")
	@ResponseBody
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = memberService.selectList();
		return list;
	}
}
