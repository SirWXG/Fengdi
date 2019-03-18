package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FProblemService {

	public List<FProblem> selectByExample(FProblemExample fExample);

	public boolean deleteById(Integer id);

	public int insert(FProblem problem);

	public boolean updateByStatus(Integer id,String status);

	public FProblem selectById(Integer id);

	public boolean updateById(FProblem fProblem);

	public List<FProblem> selectNoAndCname(Map<String,Object> map);

	public int checkStatus();

	public List<FProblem> selectByStatus();

}
