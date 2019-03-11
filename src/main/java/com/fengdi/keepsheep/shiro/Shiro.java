package com.fengdi.keepsheep.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.service.FAdminService;

public class Shiro extends AuthenticatingRealm{

	@Autowired
	private FAdminService fAdminService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String username = upt.getUsername();
		char c[] = upt.getPassword();
		String pass = new String(c);
		Map<String, String> map = new HashMap<>();
		map.put("loginName", username);
		SimpleHash hash = new SimpleHash("MD5", pass, username, 1024);
		map.put("password", hash.toString());
		List<FAdmin> list = fAdminService.checkLogin(map);
		System.out.println(list.get(0).getLoginName()+"  "+list.get(0).getPwd());
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(list.get(0).getLoginName(),
				list.get(0).getPwd(), ByteSource.Util.bytes(username), getName());
		return simpleAuthenticationInfo;
	}
}
