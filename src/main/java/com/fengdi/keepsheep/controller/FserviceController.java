package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.service.Fservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/FserviceController")
public class FserviceController {

    @Resource
    private Fservice fservice;

    @RequestMapping("/getall")
    public String getallFAnnouncement(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                      @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model){
        PageHelper.startPage(page,rows);
        List<FService> selectByExample = fservice.selectByExample();
        PageInfo<FService> info = new PageInfo<FService>(selectByExample,4);
        model.addAttribute("selectByExample", info);
        return "member-list";

    }
}
