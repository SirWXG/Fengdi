package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.shiro.Shiro;
import com.fengdi.keepsheep.util.AuthorizeUtils;
import com.fengdi.keepsheep.util.ReadProperties;
import com.fengdi.keepsheep.util.SimpleResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * shiro登录验证
 */

@Controller
@RequestMapping(value="/loginAdmin")
public class LoginController {

	@Autowired
	private FAdminService fAdminService;

	@Autowired
	private  FAuthorizeService fAuthorizeService;

	@Autowired
	private  FAdminGroupService fAdminGroupService;

	/**
	 * 登录认证
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult doLogin(@RequestParam(name = "username") String username,
								@RequestParam(name = "password") String password, Model model, HttpSession session) throws IOException {
		SimpleResult result = new SimpleResult();
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
				result.setErrCode("1");
				result.setErrMsg("用户名或密码错误,请重新登录");
				return result;
			}
		}
		List<FAdmin> list_s =  fAdminService.selectAdminByLoginName(username);
		Map<String,String> map = new HashMap<String, String>();
		map.put("loginName",username);
		map.put("password", Shiro.ToMD5(list_s.get(0).getSalt(),password));
		List<FAdmin> list = fAdminService.checkLogin(map);
		List<FAdminGroup> lists = fAdminGroupService.selectRolerByAdminNo(list.get(0).getAdminNo());
		if(lists.size()==0||lists.get(0).getAuthorizeList()==null||lists.get(0).getAuthorizeList().trim().length()<1){
			result.setErrMsg("您没有任何权限,请联系管理员分配权限");
		}else{
			if("break".equals(list.get(0).getStatus())){
				result.setErrCode("1");
				result.setErrMsg("用户已被冻结,请联系管理员");
			}else{
				session.setAttribute("admin",list.get(0));
				result.setSuccess(true);
			}
			session.setAttribute("auth", getAuth());
			session.setAttribute("imgUrl", ReadProperties.getUrl());
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) {
		session.setAttribute("admin",null);
		SecurityUtils.getSubject().logout();
		return "/login/login";
	}

	public  List<AuthorizeUtils> getAuth(){
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
		//一级权限
		List<AuthorizeUtils> utils = new ArrayList<AuthorizeUtils>();
        List<FAuthorize> arrays = getAuthList();
		String array[] = new String[arrays.size()];
		for(int i=0;i<arrays.size();i++){
			array[i] = String.valueOf(arrays.get(i).getAuthorizeNo());
		}
		List<FAuthorize> s_list = fAuthorizeService.selectList(array);
		for(FAuthorize fAuthorize : arrays){
			AuthorizeUtils util = new AuthorizeUtils();
			util.setAuthNo(fAuthorize.getAuthorizeNo());
			util.setUrl(fAuthorize.getResourcekey());
			util.setAuthName(fAuthorize.getRemark());
			utils.add(util);
		}
		return utils;
	}

	/**
	 * 得到权限列表
	 * @return
	 */
	public  List<FAuthorize> getAuthList(){
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		//获得请求路径
		FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
		List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(fAdmin.getAdminNo());
		String c_auth = list.get(0).getAuthorizeList();
		String array_auth[] = c_auth.split(",");
		List<FAuthorize> auth_list = fAuthorizeService.selectList(array_auth);
		return auth_list;
	}
}
