package com.fengdi.keepsheep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FProblem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengdi.keepsheep.service.FProblemService;
import com.fengdi.keepsheep.util.SimpleResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String selectAllProblem(@RequestParam(name = "page",defaultValue = "1")Integer page,
								   @RequestParam(name = "rows",defaultValue = "10")Integer rows,HttpSession session,Model model) {
		SimpleResult simpleResult = new SimpleResult();
		try {
			PageHelper.startPage(page,rows);
			List<FProblem> list = fProblemService.selectByExample(null);
			FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
		    if(null==fAdmin) {
		    	simpleResult.setErrCode("1");
		    	simpleResult.setErrMsg("登录失效，请重新登录");
		    }
			PageInfo<FProblem> info = new PageInfo<FProblem>(list,4);
		    model.addAttribute("problem",info);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "question";
	}
	/**
	 * 根据ID删除
	 * @return
	 */
	@RequestMapping(value = "delProblem.json",method = RequestMethod.GET)
	@ResponseBody
	public String deleteById(@RequestParam(value = "id",required = false)Integer id){
		Map<String,String> map=new HashMap<String,String>();
		boolean deleteById = fProblemService.deleteById(id);
		if(deleteById){
			map.put("delResult","true");
		}else {
			map.put("delResult","false");
		}
		String json = JSONArray.toJSONString(map);
		return json;
	}
	/**
	 * 增加
	 * @return
	 */
	@RequestMapping(value = "/addProblem",method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult addProblem(FProblem fProblem,HttpSession session){
		SimpleResult result=new SimpleResult();
		try {
			FAdmin admin = (FAdmin) session.getAttribute("admin");
			if (null==admin){
				result.setErrCode("1");
				result.setErrMsg("登录信息失效,请重新登录");
				result.setSuccess(false);
			}else{
				result.setSuccess(true);
				int insert = fProblemService.insert(fProblem);
				if(insert<1){
					result.setSuccess(false);
					result.setErrMsg("添加失败,请重新添加");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据ID修改状态
	 * @return
	 */
	@RequestMapping(value = "/updateByStatus",method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult updateByStatus(@RequestParam("id")Integer id,@RequestParam("status")String status,HttpSession session){
		SimpleResult result=new SimpleResult();
		try {
			FAdmin admin = (FAdmin) session.getAttribute("admin");
			if (null==admin){
				result.setErrCode("1");
				result.setErrMsg("登录信息失效,请重新登录");
				result.setSuccess(false);
			}else{
				result.setSuccess(true);
				boolean stu = fProblemService.updateByStatus(id, status);
				if(stu!=true){
					result.setSuccess(false);
					result.setErrMsg("修改失败,请重新修改");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
