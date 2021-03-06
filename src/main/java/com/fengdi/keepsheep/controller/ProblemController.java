package com.fengdi.keepsheep.controller;

import com.alibaba.fastjson.JSONArray;
import com.fengdi.keepsheep.bean.*;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.service.FProblemService;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/problem")
public class ProblemController {

	
	@Autowired
	private FProblemService fProblemService;

	@Autowired
	private FAuthorizeService fAuthorizeService;

	@Autowired
	private FAdminGroupService fAdminGroupService;
	
	/**
	 * 查询问题列表
	 * @return
	 */
	@RequestMapping(value="/selectAllProblem")
	public String selectAllProblem(@RequestParam(name = "page",defaultValue = "1")Integer page,
								   @RequestParam(name = "rows",defaultValue = "10")Integer rows, HttpSession session, Model model, FProblemExample example) {
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
			if(checkAuth()){
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
			}else{
				result.setMessage("权限不足,无法操作");
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
			if(checkAuth()){
				FAdmin admin = (FAdmin) session.getAttribute("admin");
				if (null==admin){
					result.setErrCode("1");
					result.setErrMsg("登录信息失效,请重新登录");
					result.setSuccess(false);
				}else{
					System.out.println("Sataus:"+fProblemService.checkStatus());
					if(fProblemService.checkStatus()>3&&status.equals("1")){
						result.setErrMsg("最多只能展示四条问题，请重新设置");
					}else {
						result.setSuccess(true);
						boolean stu = fProblemService.updateByStatus(id, status);
						if (stu != true) {
							result.setSuccess(false);
							result.setErrMsg("修改失败,请重新修改");
						}
					}
				}
			}else{
				result.setErrMsg("权限不足,无法操作");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 根据ID查询问题列表
	 * @return
	 */
	@RequestMapping(value = "/selectById",method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult selectById(Integer id, HttpSession session){
		if(checkAuth()){
			FProblem fProblem = fProblemService.selectById(id);
			session.setAttribute("fProblem",fProblem);
			return new SimpleResult(fProblem!=null?true:false);
		}else {
			return new SimpleResult("权限不足,无法操作",false);
		}
	}
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping(value = "/updateById",method = RequestMethod.POST)
	@ResponseBody
	public SimpleResult updateById(FProblem fProblem){
		System.out.println(fProblem.getProblemNo());
		if(checkAuth()){
			FProblem fProblem1=new FProblem(fProblem.getProblemNo(),fProblem.getId(),fProblem.getProblemAnswers(),fProblem.getStatus());
			boolean result = fProblemService.updateById(fProblem1);
			return new SimpleResult(result);
		}else{
			return new SimpleResult("权限不足,无法操作",false);
		}
	}
	/**
	 * 模糊查
	 * @return
	 */
	@RequestMapping(value = "/selectNoAndCn",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<FProblem> selectNoAndCn(@RequestParam(name = "problemNo",defaultValue = "")String problemNo,
											@RequestParam(name = "groupCnname",defaultValue = "")String group_name,
											@RequestParam(name = "page",defaultValue = "1")Integer page,
											@RequestParam(name = "rows",defaultValue = "10")Integer rows){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("problemNo",problemNo);
		map.put("groupCnname",group_name);
		PageHelper.startPage(page,rows);
		List<FProblem> list = fProblemService.selectNoAndCname(map);
		PageInfo<FProblem> info=new PageInfo<FProblem>(list,4);
		return info;
	}

	public  boolean checkAuth(){
		boolean flag = false;
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		String url = request.getServletPath();
		//获得请求路径
		FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
		List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(fAdmin.getAdminNo());
		String c_auth = list.get(0).getAuthorizeList();
		String array_auth[] = c_auth.split(",");
		List<FAuthorize> auth_list = fAuthorizeService.selectListAuth(array_auth);
		for(FAuthorize fAuthorize : auth_list){
			if (fAuthorize.getResourcekey().equals(url)){
				return true;
			}else{
				flag = false;
			}
		}
		return flag;
	}

}
