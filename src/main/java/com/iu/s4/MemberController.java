package com.iu.s4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {

	@RequestMapping(value="memberJoin")
	public void join() {
		
	}
}
