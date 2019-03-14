package com.fengdi.keepsheep.service.Impl;

import java.util.Date;
import java.util.List;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;
import com.fengdi.keepsheep.mapper.FProblemMapper;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengdi.keepsheep.service.FProblemService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class FProblemImpl implements FProblemService{

	@Autowired
	private FProblemMapper fProblemMapper;
	
	/**
	 * 查询所有问题请求
	 */

	public List<FProblem> selectByExample(FProblemExample fExample) {
		List<FProblem> list = fProblemMapper.selectByExample(null);
		return list;
	}
	/**
	 * 根据ID删除
	 */
	public boolean deleteById(Integer id) {
		boolean deleteById = fProblemMapper.deleteById(id);
		return deleteById;
	}
	/**
	 * 添加
	 */
	public int insert(FProblem problem) {
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();
		FAdmin admin =(FAdmin) session.getAttribute("admin");
		problem.setProblemNo(problem.getProblemNo());
		problem.setProblemAnswers(problem.getProblemAnswers());
		problem.setGroupCnname(admin.getLoginName());
		problem.setAdminGroupNo(admin.getGroupNo());
		problem.setStatus(problem.getStatus());
		problem.setCreateTime(new Date());
		problem.setUpdateTime(new Date());
		int flag = fProblemMapper.insert(problem);
		return flag;
	}
	/**
	 * 根据ID修改状态
	 */
	public boolean updateByStatus(Integer id, String status) {
		boolean stu = fProblemMapper.updateByStatus(id, status);
		return stu;
	}
	/**
	 * 根据ID查询问题列表
	 */
	public FProblem selectById(Integer id) {
        FProblem fProblem = fProblemMapper.selectById(id);
        return fProblem;
	}
    /**
     * 编辑
     */
    public boolean updateById(FProblem fProblem) {
        boolean result = fProblemMapper.updateById(fProblem);
        return result;
    }


}
