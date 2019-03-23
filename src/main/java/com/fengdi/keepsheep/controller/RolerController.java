package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.util.Random2Utils;
import com.fengdi.keepsheep.util.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/13.
 */

@Controller
@RequestMapping(value = "/roler")
public class RolerController {


    @Autowired
    private FAdminService fAdminService;

    @Autowired
    private FAuthorizeService fAuthorizeService;

    @Autowired
    private FAdminGroupService fAdminGroupService;


    /**
     * 查询一级权限
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectRolerForFirst",method = RequestMethod.POST)
    @ResponseBody
    public List<FAuthorize> selectAllRoler(HttpSession session, Model model){
        try{
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            List<FAuthorize> list = fAuthorizeService.selectFirst();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据一级编号查询二级权限
     */
    @RequestMapping(value = "/selectRolerSecound",method = RequestMethod.POST)
    @ResponseBody
    public List<FAuthorize> selectRolerByS(@RequestParam(name = "superAuthorizeNo")String superAuthorizeNo){
          List<FAuthorize> list = fAuthorizeService.selectAuthBySecond(superAuthorizeNo);
          return list;
    }


    @RequestMapping(value = "/selectAllAdmin",method = RequestMethod.POST)
    @ResponseBody
    public List<FAdmin> selectAllAdmin(){
        List<FAdmin> list = fAdminService.selectByExample(null);
        return list;
    }

    @RequestMapping(value = "/addRoler",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult addRoler(@RequestParam(name = "firstRemark")String firstRemark,
                                 @RequestParam(name = "s_remark")String sRemark,
                                 @RequestParam(name = "adminNo")String adminNo){
        SimpleResult result = new SimpleResult();
        if(checkAuth()){
            List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(adminNo);
            if(list.size()==0){
                FAdminGroup fAdminGroup = new FAdminGroup();
                fAdminGroup.setAdminNo(adminNo);
                fAdminGroup.setCreateTime(new Date());
                fAdminGroup.setUpdateTime(new Date());
                fAdminGroup.setAdminGroupNo(Random2Utils.buildSn(""));
                fAdminGroup.setAuthorizeList(firstRemark+","+sRemark+",");
                int flag = fAdminGroupService.addGroup(fAdminGroup);
                if(flag<1){
                    result.setErrMsg("增加权限失败");
                }else{
                    result.setSuccess(true);
                }
            }else{
                String auth = list.get(0).getAuthorizeList();
                if(auth.contains(firstRemark)&&!auth.contains(sRemark)){
                    auth=auth+sRemark+",";
                }
                if(auth.contains(sRemark)&&!auth.contains(firstRemark)){
                    auth=auth+firstRemark+",";
                }
                if(!auth.contains(sRemark)&&!auth.contains(firstRemark)){
                    auth=auth+firstRemark+","+sRemark+",";
                }
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("adminNo",adminNo);
                map.put("authorizeList",auth);
                map.put("updateTime",new Date());
                int flag = fAdminGroupService.updateGroup(map);
                if(flag<1){
                    result.setErrMsg("增加权限失败");
                }else{
                    result.setSuccess(true);
                }
            }
        }else{
            result.setErrMsg("权限不足,无法操作");
        }
        return result;
    }

    public  boolean checkAuth(){
        boolean flag = false;
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        //获得请求路径
        FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
        List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(fAdmin.getAdminNo());
        String c_auth = list.get(0).getAuthorizeList();
        String array_auth[] = c_auth.split(",");
        List<FAuthorize> auth_list = fAuthorizeService.selectListAuth(array_auth);
        for(FAuthorize fAuthorize : auth_list){
            if (fAuthorize.getResourcekey().equals(url)){
                return true;
            }else{
                flag = false;
            }
        }
        return flag;
    }
}