package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.bean.FTitle;
import com.fengdi.keepsheep.bean.FTitleExample;
import com.fengdi.keepsheep.service.*;
import com.fengdi.keepsheep.util.AnnouncementUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Controller
@RequestMapping(value = "/before")
public class BeforeController {

    @Autowired
    private FProductService fProductService;

    @Autowired
    private FPictureService fPictureService;

    @Autowired
    private FAnnouncementService fAnnouncementService;
    @Autowired
    private FProblemService fProblemService;

    @Resource
    private Fsservice fsservice;
    @Resource
    private FTitleService fTitleService;

    //与前端对接的借口  产品
    @RequestMapping(value = "/selectProductForBefore")
    public String selectProductForBefore(Model model){
        //产品图片
        model.addAttribute("_product",fProductService.selectProductForBefore());
        //前台轮播图片
        model.addAttribute("_before_lunbo",fPictureService.selectPicByLBANDPTLB());
        //热门推荐图片
        model.addAttribute("_before_hot",fPictureService.selectPicByHot());
        //新闻中心图片
        model.addAttribute("_before_note",fPictureService.selectPicByNote());
        //问题展示图片
        model.addAttribute("_before_problem",fPictureService.selectPicByProblem());
        //公司平台展示
        model.addAttribute("_before_employee",fPictureService.selectPicByEmployee());
        //平台公告展示
        model.addAttribute("_before_view",fAnnouncementService.selectByYes());
        //平台问题展示
        model.addAttribute("_before_question",fProblemService.selectByStatus());

        //标题展示
        List<AnnouncementUtils> list = new ArrayList<AnnouncementUtils>();
        //一级标题
        List<FService> list1 = fsservice.selectStauts3();
        for(FService l:list1){
            AnnouncementUtils utils = new AnnouncementUtils();
            List<FService> list2 = fsservice.selectStauts2(l.getServiceNo());
            utils.setS(list2);
            utils.setServiceName(l.getServiceName());
            list.add(utils);
        }
        model.addAttribute("m",list);

        List<FTitle> fTitles = fTitleService.selectByExample(new FTitleExample());
        int k=0;
        String s = "s";
        String a = "a";
        for(FTitle f:fTitles){
            model.addAttribute(s+k,f.getTitleName());
            model.addAttribute(a+k,f.getStatus());
            k++;
        }

        return "/before/index";
    }

}
