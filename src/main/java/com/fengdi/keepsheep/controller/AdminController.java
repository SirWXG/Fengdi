package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.util.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/3/11.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private FAdminService fAdminService;

    /**
     * 查询所有的会员
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectAllAdmin")
    public String selectAllAdmin(HttpSession session, Model model){
        SimpleResult result = new SimpleResult();
        try{
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            if(null==fAdmin){
                result.setErrCode("1");
                result.setErrMsg("登录失效，请重新登录");
            }
            fAdminService.updateAdminForLoginTime();
            List<FAdmin> list = fAdminService.selectByExample(null);
            model.addAttribute("admin",list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "admin-list";
    }

    /**
     * 通过搜索框条件查询
     * @param fAdmin
     * @param model
     * @return
     */
//    @RequestMapping(value ="/selectAdminByStatus",method = RequestMethod.POST)
//    @ResponseBody
//    public SimpleResult selectAdmin(FAdmin fAdmin,Model model){
//        SimpleResult simpleResult = new SimpleResult();
//        List<FAdmin> list = fAdminService.selectAdminByStatus();
//        try{
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        model.addAttribute("admin",list);
//        return null;
//    }null

}
