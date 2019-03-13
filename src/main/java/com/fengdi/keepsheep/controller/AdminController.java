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
                                 @RequestParam(name = "rows",defaultValue = "2")Integer rows,HttpSession session, Model model){
        SimpleResult result = new SimpleResult();
        try{
            List<FAdmin> list = fAdminService.selectByExample(null);
            PageHelper.startPage(page,rows);
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            if(null==fAdmin){
                result.setErrCode("1");
                result.setErrMsg("登录失效，请重新登录");
            }
            PageInfo<FAdmin> info = new PageInfo<FAdmin>(list,4);
            fAdminService.updateAdminForLoginTime();
            model.addAttribute("admin",info);
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

    @RequestMapping(value = "/selectAdminByAdminNo",method = RequestMethod.GET)
    public String selectAdminByAdminNo(@RequestParam(name = "adminNo")String adminNo){
        return "admin-edit";
    }

    /**
     * 根据编号删除会员
     * @param adminNo
     * @param session
     * @return
     */
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult deleteAdminByAdminNo(@RequestParam(name = "adminNo")String adminNo,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
            if(null==fAdmin){
                result.setErrCode("1");
                result.setErrMsg("登录信息失效,请重新登录");
            }
            int flag = fAdminService.deleteAdminByAdminNo(adminNo);
            if(flag<1){
                result.setErrCode("1");
                result.setErrMsg("删除失败,请重新删除");
            }else{
                result.setSuccess(true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/updateAdminStatus",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateAdminStatus(@RequestParam(name = "adminNo")String adminNo,@RequestParam(name = "status")String status,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
           FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
           if(null==fAdmin){
               result.setErrCode("1");
               result.setErrMsg("登录信息失效,请重新登录");
           }else{
               Map<String,String> map = new HashMap<String, String>();
               map.put("adminNo",adminNo);
               map.put("status",status);
               int flag = fAdminService.updateAdminStatus(map);
               if(flag<1){
                   result.setErrCode("1");
                   result.setErrMsg("更新失败,请重新操作");
               }else{
                   result.setSuccess(true);
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
