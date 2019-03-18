package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.service.FAnnouncementService;
import com.fengdi.keepsheep.service.FPictureService;
import com.fengdi.keepsheep.service.FProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //与前端对接的借口  产品
    @RequestMapping(value = "/selectProductForBefore")
    public String selectProductForBefore(Model model){
        //产品图片
        List<FProduct> list = fProductService.selectProductForBefore();
        model.addAttribute("_product",list);
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
        return "/before/index";
    }
}
