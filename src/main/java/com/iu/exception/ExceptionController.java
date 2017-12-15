package com.iu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NullPointerException.class)
	public String test() {
		return "";
	}

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView test2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "error");
		modelAndView.setViewName("common/result");
		return modelAndView;
	}

}
