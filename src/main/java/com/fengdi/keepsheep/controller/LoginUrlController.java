package com.fengdi.keepsheep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/dologin")
public class LoginUrlController {

	/**
	 * 跳转login请求
	 * @return
	 */
	@RequestMapping(value="/login")
	public String toLogin() {
		return "/login/login";
	}
	
}
