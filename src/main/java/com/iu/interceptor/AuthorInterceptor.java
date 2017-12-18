package com.iu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.member.MemberDTO;

public class AuthorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		if(!memberDTO.getJob().equals("teacher")) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message", "접근권한이 없습니다.");
		}
		
		System.out.println("Author");
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
