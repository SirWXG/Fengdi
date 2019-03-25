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
		List<FAdmin> lists =  fAdminService.selectAdminByLoginName(username);
		Map<String, String> map = new HashMap<String,String>();
		map.put("loginName", username);
		map.put("password", ToMD5(lists.get(0).getSalt(),pass));
		List<FAdmin> list = fAdminService.checkLogin(map);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(list.get(0).getSalt(),
				list.get(0).getPwd(), ByteSource.Util.bytes(lists.get(0).getSalt()),getName());
		return simpleAuthenticationInfo;
	}

	public static String ToMD5(String username,String pass){
		SimpleHash simpleHash = new SimpleHash("MD5",pass,username,1024);
		return simpleHash.toString();
	}
}
