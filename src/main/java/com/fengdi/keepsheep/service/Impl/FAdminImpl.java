package com.fengdi.keepsheep.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.mapper.FAdminMapper;
import com.fengdi.keepsheep.service.FAdminService;


@Service
public class FAdminImpl implements FAdminService{
	
	
	@Autowired
	private FAdminMapper fAdminMapper;

	@Override
	public List<FAdmin> checkLogin(Map<String, String> map) {
		List<FAdmin> list = fAdminMapper.checkLogin(map);
		return list;
	}
	
}
