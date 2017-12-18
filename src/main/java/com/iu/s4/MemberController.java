package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;

	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void join() {
	}
		
	@RequestMapping(value="student/memberJoin", method=RequestMethod.POST)
	public void studentJoin(MemberDTO memberDTO) {
	/*	System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getStudentDTO().getTid());*/
	}
	
	@RequestMapping(value="teacher/memberJoin", method=RequestMethod.POST)
	public void teacherJoin(MemberDTO memberDTO) {
	/*	System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getTeacherDTO().getSal());*/
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void memberLogin() {
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session) {
		try {
			memberDTO = memberService.login(memberDTO);
		} catch (Exception e) {
			memberDTO = null;
			e.printStackTrace();
		}
		
		if(memberDTO != null)
			session.setAttribute("member", memberDTO);
		return "redirect:/";
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
