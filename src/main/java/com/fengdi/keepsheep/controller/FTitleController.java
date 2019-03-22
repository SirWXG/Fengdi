package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.bean.FTitle;
import com.fengdi.keepsheep.bean.FTitleExample;
import com.fengdi.keepsheep.service.FTitleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @create 2019-03-22 上午 11:42
 **/
@Controller
@RequestMapping("/FtitleController")
public class FTitleController {
    @Resource
    private FTitleService fTitleService;

    @RequestMapping("/getall")
    public String getallFService(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                 @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model){
        PageHelper.startPage(page,rows);
        List<FTitle> selectByExample = fTitleService.selectByExample(new FTitleExample());
        PageInfo<FTitle> info = new PageInfo<FTitle>(selectByExample,4);
        model.addAttribute("selectByExample", info);
        return "title-list";

    }
}
