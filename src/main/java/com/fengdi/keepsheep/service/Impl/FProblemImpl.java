package com.fengdi.keepsheep.service.Impl;

import java.util.List;

import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;
import com.fengdi.keepsheep.mapper.FProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdi.keepsheep.service.FProblemService;


@Service
public class FProblemImpl implements FProblemService{

	@Autowired
	private FProblemMapper fProblemMapper;
	
	/**
	 * 查询所有问题请求
	 */
	@Override
	public List<FProblem> selectByExample(FProblemExample fExample) {
		List<FProblem> list = fProblemMapper.selectByExample(null);
		return list;
	}

}
