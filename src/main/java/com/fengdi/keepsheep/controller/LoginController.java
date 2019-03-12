package com.fengdi.keepsheep.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.shiro.Shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * shiro登录验证
 */

@Controller
@RequestMapping(value="/loginAdmin")
public class LoginController {

	@Autowired
	private FAdminService fAdminService;

	/**
	 * 登录认证
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam(name = "username") String username,
						  @RequestParam(name = "password") String password, Model model, HttpSession session) {
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
		Map<String,String> map = new HashMap<String, String>();
		map.put("loginName",username);
		map.put("password", Shiro.ToMD5(username,password));
		List<FAdmin> list = fAdminService.checkLogin(map);
		model.addAttribute("username", username);
		session.setAttribute("admin",list.get(0));
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("admin");
		SecurityUtils.getSubject().logout();
		return "redirect:/login/login";
	}
}
