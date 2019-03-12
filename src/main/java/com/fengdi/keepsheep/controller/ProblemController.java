package com.fengdi.keepsheep.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengdi.keepsheep.service.FProblemService;
import com.fengdi.keepsheep.util.SimpleResult;

@Controller
@RequestMapping(value="/problem")
public class ProblemController {

	
	@Autowired
	private FProblemService fProblemService;
	
	/**
	 * 查询问题列表
	 * @return
	 */
	@RequestMapping(value="/selectAllProblem")
	public String selectAllProblem(HttpSession session,Model model) {
		SimpleResult simpleResult = new SimpleResult();
		try {
			FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
		    if(null==fAdmin) {
		    	simpleResult.setErrCode("1");
		    	simpleResult.setErrMsg("登录失效，请重新登录");
		    }
		    List<FProblem> list = fProblemService.selectByExample(null);
		    model.addAttribute("MsgResult", simpleResult);
			model.addAttribute("problem", list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "question";
	}
}
