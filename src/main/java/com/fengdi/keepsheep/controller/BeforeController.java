package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FProduct;
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

    //与前端对接的借口  产品
    @RequestMapping(value = "/selectProductForBefore")
    public String selectProductForBefore(Model model){
        //产品图片
        List<FProduct> list = fProductService.selectProductForBefore();
        model.addAttribute("_product",list);
        //前台轮播图片
        model.addAttribute("_before_lunbo",fPictureService.selectPicByLBANDPTLB());


        return null;
    }
}
