package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAnnouncementService;
import com.fengdi.keepsheep.service.FAuthorizeService;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/fannouncementService")
public class FAnnouncementController {
	@Resource
	private FAnnouncementService fannouncementService;

    @Autowired
    private FAuthorizeService fAuthorizeService;

    @Autowired
    private FAdminGroupService fAdminGroupService;

    /*
    * 查所有
    * */
	@RequestMapping("/getall")
	public String getallFAnnouncement(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                      @RequestParam(name = "rows",defaultValue = "10")Integer rows,Model model){
        PageHelper.startPage(page,rows);
		List<FAnnouncement> selectByExample = fannouncementService.selectByExample();
        int i = fannouncementService.countByExample();
        PageInfo<FAnnouncement> info = new PageInfo<FAnnouncement>(selectByExample,4);
		model.addAttribute("selectByExample", info);
		model.addAttribute("i",i);
		return "order-list";
		
	}

	/*
	* 页面添加
	* */
	@RequestMapping(value = "/getadd",method=RequestMethod.POST)
	public @ResponseBody SimpleResult getallFAnnouncement(String text,String status, FAnnouncement fannouncement, HttpSession session){
	    if(checkAuth()){
            FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            fannouncement.setAnnouncementName(text);
            fannouncement.setGroupCnname(fAdmin.getAdminName());
            fannouncement.setAdminGroupNo(fAdmin.getAdminNo());
            fannouncement.setCreateTime(new Date());
            fannouncement.setUpdateTime(new Date());
            fannouncement.setStatus(status);
            int insert = fannouncementService.insert(fannouncement);
            return new SimpleResult(insert>0?true:false);
        }else{
	        return new SimpleResult("权限不足,无法操作",false);
        }


	}

	/*
	* 根据主键查单个至页面修改
	* */
    @RequestMapping(value = "/getannouncementNo")
    @ResponseBody
    public SimpleResult getannouncementNo(Model model,String announcementNo,HttpSession session ){
        if(checkAuth()){
            FAnnouncement fAnnouncement = fannouncementService.selectByPrimaryKey(announcementNo);
            session .setAttribute("fAnnouncement",fAnnouncement);
            return new SimpleResult(fAnnouncement!=null?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }

    }

    /*
    *数据删除
    * */
    @RequestMapping(value = "/delannouncementNo")
    public @ResponseBody SimpleResult delannouncementNo(@RequestParam("announcementNo") String announcementNo){
        if(checkAuth()){
            int i = fannouncementService.deleteByPrimaryKey(announcementNo);
            return new SimpleResult(i>0?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }
    }

    /*
    * 页面修改
    * */
    @RequestMapping(value = "/upd")
    public @ResponseBody SimpleResult upd(FAnnouncement fannouncement, HttpSession session){
        if(checkAuth()){
            FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fannouncement.setGroupCnname(fAdmin.getAdminName());
        fannouncement.setAdminGroupNo(fAdmin.getAdminNo());
        fannouncement.setUpdateTime(new Date());
        int insert = fannouncementService.updateByPrimaryKeySelective(fannouncement);
        return new SimpleResult(insert>0?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }
    }

    /*
    * 页面展示或未展示
    * */
    @RequestMapping(value = "/stop")
    public @ResponseBody SimpleResult stop(String announcementNo,String status){
        if(checkAuth()){
            if(status.equals("1")){
                List<FAnnouncement> A = fannouncementService.selectStauts(status);
                int size = A.size();
                if(size>4){
                    return new SimpleResult(false);
                }else{
                    int insert = fannouncementService.updatestauts(announcementNo,status);
                    return new SimpleResult(insert>0?true:false);
                }
            }else{
                int insert = fannouncementService.updatestauts(announcementNo,status);
                return new SimpleResult(insert>0?true:false);
            }
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }

    }
    /*
    * 模糊查询
    * */
    @RequestMapping(value = "/selectByMhcx")
    @ResponseBody
    public PageInfo<FAnnouncement> selectByMhcx(@RequestParam(name = "announcementName",defaultValue = "")String announcementName,
                                                @RequestParam(name = "page",defaultValue = "1")Integer page,
                                                @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model) throws UnsupportedEncodingException {
	    PageHelper.startPage(page,rows);
        List<FAnnouncement> selectByMhcx = fannouncementService.selectByMhcx(announcementName);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        PageInfo<FAnnouncement> info = new PageInfo<FAnnouncement>(selectByMhcx,4);
        model.addAttribute("selectByExample", info);
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
