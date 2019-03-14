package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.service.FAdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */

@Controller
@RequestMapping(value = "/roler")
public class RolerController {


    @Autowired
    private FAdminGroupService fAdminGroupService;


    /**
     * 查询所有角色和权限
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectAllRoler")
    public String selectAllRoler(HttpSession session, Model model){
        try{
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            List<FAdminGroup> list = fAdminGroupService.selectAllRoler();
            System.out.println("111");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin-role";
    }
}
