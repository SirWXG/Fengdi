package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.service.Fsservice;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/FserviceController")
public class FserviceController {

    @Resource
    private Fsservice fsservice;

    @RequestMapping("/getall")
    public String getallFService(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                      @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model){
        PageHelper.startPage(page,rows);
        List<FService> selectByExample = fsservice.selectByExample();
        PageInfo<FService> info = new PageInfo<FService>(selectByExample,4);
        model.addAttribute("selectByExample", info);
        return "member-list";

    }

    @RequestMapping(value = "/getadd",method= RequestMethod.POST)
    public @ResponseBody
    SimpleResult getaddFService(FService fservice, HttpSession session){
        FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fservice.setGroupCnname(fAdmin.getAdminName());
        fservice.setAdminGroupNo(fAdmin.getAdminNo());
        fservice.setServiceLevel(0);
        fservice.setCreateTime(new Date());
        fservice.setUpdateTime(new Date());
        int insert = fsservice.insert(fservice);
        return new SimpleResult(insert>0?true:false);
    }

    @RequestMapping("/getservicelevel")
    @ResponseBody
    public SimpleResult getallFService(HttpSession session){
        List<FService> fService = fsservice.selectByservicelevel();
        session.setAttribute("fService",fService);
        return new SimpleResult(fService!=null?true:false);

    }
}
