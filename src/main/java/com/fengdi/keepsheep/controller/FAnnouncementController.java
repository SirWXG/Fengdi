package com.fengdi.keepsheep.controller;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAnnouncement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fengdi.keepsheep.service.FAnnouncementService;
import com.fengdi.keepsheep.util.SimpleResult;

@Controller
@RequestMapping("/fannouncementService")
public class FAnnouncementController {
	@Resource
	private FAnnouncementService fannouncementService;
	
	@RequestMapping("/getall")
	public String getallFAnnouncement(Model model){
		List<FAnnouncement> selectByExample = fannouncementService.selectByExample();
		model.addAttribute("selectByExample", selectByExample);
		return "order-list";
		
	}
	@RequestMapping(value = "/getadd",method=RequestMethod.POST)
	public @ResponseBody SimpleResult getallFAnnouncement(String text,String status, FAnnouncement fannouncement, HttpSession session){
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
	}

    @RequestMapping(value = "/getannouncementNo")
    @ResponseBody
    public SimpleResult getannouncementNo(Model model,String announcementNo,HttpSession session ){
        FAnnouncement fAnnouncement = fannouncementService.selectByPrimaryKey(announcementNo);
        session .setAttribute("fAnnouncement",fAnnouncement);
        return new SimpleResult(fAnnouncement!=null?true:false);
    }

    @RequestMapping(value = "/delannouncementNo")
    public @ResponseBody SimpleResult delannouncementNo(@RequestParam("announcementNo") String announcementNo){
        int i = fannouncementService.deleteByPrimaryKey(announcementNo);
        return new SimpleResult(i>0?true:false);
    }

    @RequestMapping(value = "/upd")
    public @ResponseBody SimpleResult upd(FAnnouncement fannouncement, HttpSession session){
        FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fannouncement.setGroupCnname(fAdmin.getAdminName());
        fannouncement.setAdminGroupNo(fAdmin.getAdminNo());
        fannouncement.setUpdateTime(new Date());
        int insert = fannouncementService.updateByPrimaryKeySelective(fannouncement);
        return new SimpleResult(insert>0?true:false);
    }
}
