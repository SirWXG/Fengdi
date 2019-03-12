package com.fengdi.keepsheep.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminExample;
import com.fengdi.keepsheep.mapper.FAdminMapper;
import com.fengdi.keepsheep.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdi.keepsheep.service.FAdminService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class FAdminImpl implements FAdminService{
	
	
	@Autowired
	private FAdminMapper fAdminMapper;

	@Override
	public List<FAdmin> checkLogin(Map<String, String> map) {
		List<FAdmin> list = fAdminMapper.checkLogin(map);
		return list;
	}

	public List<FAdmin> selectByExample(FAdminExample fAdminExample) {
		List<FAdmin> list = fAdminMapper.selectByExample(null);
		return list;
	}

	@Override
	public int updateAdminForLoginTime() {
		Map<String,Object> map = new HashMap<String, Object>();
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		try{
			HttpSession session = request.getSession();
			FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
			System.out.println(fAdmin.getAdminNo());
			Date date = new Date();
			map.put("loginTime",date);
			map.put("adminNo",fAdmin.getAdminNo());
			map.put("loginIp", IPUtil.getIpAddr(request));
		}catch (Exception e){
			e.printStackTrace();
		}
		return fAdminMapper.updateAdminForLoginTime(map);
	}

	@Override
	public List<FAdmin> selectAdminByStatus(Map<String,Object> map) {
		List<FAdmin> list = fAdminMapper.selectAdminByStatus(map);
		return list;
	}

}
