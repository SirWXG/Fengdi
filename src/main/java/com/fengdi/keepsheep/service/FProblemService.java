package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;

import java.util.List;

public interface FProblemService {

	public List<FProblem> selectByExample(FProblemExample fExample);

	public boolean deleteById(Integer id);
}
