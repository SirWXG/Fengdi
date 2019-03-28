package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.*;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.service.FTitleService;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @create 2019-03-22 上午 11:42
 **/
@Controller
@RequestMapping("/FtitleController")
public class FTitleController {
    @Resource
    private FTitleService fTitleService;
    @Resource
    private FAdminGroupService fAdminGroupService;
    @Resource
    private FAuthorizeService fAuthorizeService;


    @RequestMapping("/getall")
    public String getallFService(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                 @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model){
        PageHelper.startPage(page,rows);
        List<FTitle> selectByExample = fTitleService.selectByExample(new FTitleExample());
        PageInfo<FTitle> info = new PageInfo<FTitle>(selectByExample,4);
        model.addAttribute("selectByExample", info);
        return "title-list";
    }

    @RequestMapping(value = "/stop")
    public @ResponseBody
    SimpleResult stop(String titleNo, String status){
        if(checkAuth()){
                int insert = fTitleService.updatestauts(titleNo,status);
                return new SimpleResult(insert>0?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }

    }

    /*
     * 根据主键查单个至页面修改
     * */
    @RequestMapping(value = "/gettitleNo")
    @ResponseBody
    public SimpleResult gettitleNo(Model model,String titleNo,HttpSession session ){
        if(checkAuth()){
            FTitle fTitle = fTitleService.selectByPrimaryKey(titleNo);
            session .setAttribute("fTitle",fTitle);
            return new SimpleResult(fTitle!=null?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }

    }

    /*
     * 页面修改
     * */
    @RequestMapping(value = "/upd")
    public @ResponseBody SimpleResult upd(FTitle fTitle, HttpSession session){
        if(checkAuth()){
            FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            fTitle.setUpdateTime(new Date());
            int insert = fTitleService.updateByPrimaryKeySelective(fTitle);
            return new SimpleResult(insert>0?true:false);
        }else{
            return new SimpleResult("权限不足,无法操作",false);
        }
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
