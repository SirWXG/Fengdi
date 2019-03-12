package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String selectAllAdmin(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                 @RequestParam(name = "rows",defaultValue = "10")Integer rows,HttpSession session, Model model){
        SimpleResult result = new SimpleResult();
        try{
            PageHelper.startPage(page,rows);
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            if(null==fAdmin){
                result.setErrCode("1");
                result.setErrMsg("登录失效，请重新登录");
            }
            fAdminService.updateAdminForLoginTime();
            List<FAdmin> list = fAdminService.selectByExample(null);
            PageInfo<FAdmin> info = new PageInfo<FAdmin>();
            model.addAttribute("admin",list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "admin-list";
    }

    /**
     * 通过搜索框条件查询
     * @param model
     * @return
     */
    @RequestMapping(value ="/selectAdminByStatus",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selectAdmin(@RequestParam(name = "loginTime")String loginTime,
                                    @RequestParam(name = "loginName")String loginName,Model model,HttpSession session){
        SimpleResult simpleResult = new SimpleResult();
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            if(null==fAdmin){
                simpleResult.setErrCode("1");
                simpleResult.setErrMsg("登录信息失效，请重新登录");
                simpleResult.setSuccess(false);
            }else{
                simpleResult.setSuccess(true);
            }
            map.put("loginName",loginName);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<FAdmin> list = fAdminService.selectAdminByStatus(map);
        for (FAdmin fAdmin: list) {
            System.out.println(fAdmin.getLoginName());
        }
        simpleResult.setData(list);
        model.addAttribute("admin",list);
        return simpleResult;
    }

    /**
     * 添加新的成员
     * @param fAdmin
     * @return
     */
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult addAdmin(FAdmin fAdmin,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            FAdmin f = (FAdmin) session.getAttribute("admin");
            if(null==f){
                result.setErrCode("1");
                result.setErrMsg("登录信息失效,请重新登录");
                result.setSuccess(false);
            }else{
                result.setSuccess(true);
                int i = fAdminService.insert(fAdmin);
                if(i<1){
                    result.setSuccess(false);
                    result.setErrMsg("添加失败,请重新添加");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
