package com.fengdi.keepsheep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * 跳转页面
 */

@Controller
public class UrlController {

	/**
	 * 跳转除login之外的请求
	 * @param url
	 * @return
	 */
	@RequestMapping(value="/view/{url}")
	public String returnUrl(@PathVariable String url) {
		return url;
	}
}
