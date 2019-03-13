package com.fengdi.keepsheep.shiro;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.service.FAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shiro extends AuthenticatingRealm{

	@Autowired
	private FAdminService fAdminService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String username = upt.getUsername();
		char c[] = upt.getPassword();
		String pass = new String(c);
		Map<String, String> map = new HashMap<String,String>();
		map.put("loginName", username);
		map.put("password", ToMD5(username,pass));
		List<FAdmin> list = fAdminService.checkLogin(map);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(list.get(0).getLoginName(),
				list.get(0).getPwd(), ByteSource.Util.bytes(username), getName());
		return simpleAuthenticationInfo;
	}

	public static String ToMD5(String username,String pass){
		SimpleHash simpleHash = new SimpleHash("MD5",pass,username,1024);
		return simpleHash.toString();
	}
}
