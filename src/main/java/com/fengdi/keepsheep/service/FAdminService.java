package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminExample;

import java.util.List;
import java.util.Map;

public interface FAdminService {
	
	/**
	 * 验证登录
	 * @param map
	 * @return
	 */
	List<FAdmin> checkLogin(Map<String, String>map);

	List<FAdmin> selectByExample(FAdminExample fAdminExample);

	/**
	 * 更新登录时间
	 * @return
	 */
	int updateAdminForLoginTime();

	/**
	 * 条件查询
	 * @return
	 */
	List<FAdmin> selectAdminByStatus(Map<String,Object> map);
}
