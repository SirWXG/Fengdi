package com.fengdi.keepsheep.controller;

import java.io.UnsupportedEncodingException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * shiro登录验证
 */

@Controller
@RequestMapping(value="/loginAdmin")
public class LoginController {
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			try {
				username = new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				currentUser.login(token);
			}catch (AuthenticationException ae) {
				throw new AuthenticationException("认证失败");
			}
		}
		model.addAttribute("username", username);
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String doLogout(){
		SecurityUtils.getSubject().logout();
		return "/login/login";
	}
}
