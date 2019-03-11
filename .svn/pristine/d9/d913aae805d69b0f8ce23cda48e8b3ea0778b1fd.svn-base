package com.fengdi.keepsheep.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengdi.keepsheep.bean.FAnnouncement;
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
	@RequestMapping("/getadd")
	public @ResponseBody SimpleResult getallFAnnouncement(@RequestBody FAnnouncement fannouncement){
		
		int insert = fannouncementService.insert(fannouncement);
		return new SimpleResult(insert>0?true:false);
		
	}
}
