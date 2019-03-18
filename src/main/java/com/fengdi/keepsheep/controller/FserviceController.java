package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAnnouncement;
import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.service.Fsservice;
import com.fengdi.keepsheep.util.AnnouncementUtils;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.applet.Main;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/FserviceController")
public class FserviceController {

    @Resource
    private Fsservice fsservice;

    /*
    * 查所有
    * */
    @RequestMapping("/getall")
    public String getallFService(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                      @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model){
        PageHelper.startPage(page,rows);
        List<FService> selectByExample = fsservice.selectByExample();
        PageInfo<FService> info = new PageInfo<FService>(selectByExample,4);
        model.addAttribute("selectByExample", info);
        return "member-list";

    }

    /*
    * 添加一级标题
    * */
    @RequestMapping(value = "/getadd",method= RequestMethod.POST)
    public @ResponseBody
    SimpleResult getaddFService(FService fservice, HttpSession session){
        FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fservice.setGroupCnname(fAdmin.getAdminName());
        fservice.setAdminGroupNo(fAdmin.getAdminNo());
        fservice.setServiceLevel(0);
        fservice.setCreateTime(new Date());
        fservice.setUpdateTime(new Date());
        int insert = fsservice.insert(fservice);
        return new SimpleResult(insert>0?true:false);
    }

    /*
    * 查询一级标题
    * */
    @RequestMapping("/getservicelevel")
    @ResponseBody
    public SimpleResult getallFService(HttpSession session){
        List<FService> fService = fsservice.selectByservicelevel();
        int size = fService.size();
        session.setAttribute("fService",fService);
        return new SimpleResult(size>0?true:false);

    }

    /*
     * 添加二级标题
     * */
    @RequestMapping(value = "/getadd2",method= RequestMethod.POST)
    public @ResponseBody
    SimpleResult getaddFService2(FService fservice, HttpSession session){
        FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fservice.setGroupCnname(fAdmin.getAdminName());
        fservice.setAdminGroupNo(fAdmin.getAdminNo());
        fservice.setServiceLevel(1);
        fservice.setCreateTime(new Date());
        fservice.setUpdateTime(new Date());
        int insert = fsservice.insert(fservice);
        return new SimpleResult(insert>0?true:false);
    }

    /*
    * 修改页面查询
    * */
    @RequestMapping(value = "/getserviceNo")
    @ResponseBody
    public SimpleResult getserviceNo(Model model,String serviceNo,HttpSession session ){
        List<FService> Service = fsservice.selectByservicelevel();
        FService fService = fsservice.selectByPrimaryKey(serviceNo);
        FService fservice = fsservice.selectByPrimaryKey(fService.getSuperServiceNo());
        session.setAttribute("a",fservice);
        session.setAttribute("f",fService);
        session.setAttribute("s",Service);
        return new SimpleResult(fService!=null?true:false);
    }

    /*
    * 修改页面
    * */
    @RequestMapping(value = "/upd")
    public @ResponseBody SimpleResult upd(FService fservice, HttpSession session){
        FAdmin fAdmin =  (FAdmin)session.getAttribute("admin");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        fservice.setGroupCnname(fAdmin.getAdminName());
        fservice.setAdminGroupNo(fAdmin.getAdminNo());
        fservice.setUpdateTime(new Date());
        int insert = fsservice.updateByPrimaryKeySelective(fservice);
        return new SimpleResult(insert>0?true:false);
    }

    /*
    * 删除数据
    * */
    @RequestMapping(value = "/delserviceNo")
    public @ResponseBody SimpleResult delserviceNo(@RequestParam("serviceNo") String serviceNo){
        FService fService = fsservice.selectByPrimaryKey(serviceNo);
        if(fService.getServiceLevel()==0){
            int i = fsservice.deleteByPrimaryKey(serviceNo);
            int i1 = fsservice.deleteBysuperServiceNo(serviceNo);
            return new SimpleResult(i>0?true:false);
        }else{
            int i2 = fsservice.deleteByPrimaryKey(serviceNo);
            return new SimpleResult(i2>0?true:false);
        }
    }

    /*
    * 页面展示或未展示
    * */
    @RequestMapping(value = "/stop")
    public @ResponseBody SimpleResult stop(String serviceNo,String status) {
        FService fService = fsservice.selectByPrimaryKey(serviceNo);
        if (fService.getServiceLevel() == 0 && status.equals("0")) {
            int insert = fsservice.updatestauts(serviceNo, status);
            int i = fsservice.updatestauts2(serviceNo, status);
            return new SimpleResult(insert > 0 ? true : false);
        } else if (fService.getServiceLevel() == 0 && status.equals("1")) {
            List<FService> A = fsservice.selectStauts(status);
            int size = A.size();
            if (size > 4) {
                return new SimpleResult(false);
            } else {
                int insert = fsservice.updatestauts(serviceNo, status);
                return new SimpleResult(insert > 0 ? true : false);
            }
        } else if (fService.getServiceLevel() == 1 && status.equals("1")) {
            List<FService> ff = fsservice.selectStauts2(fService.getSuperServiceNo());
            int size = ff.size();
            if(size>4){
                return new SimpleResult(false);
            }else{
                int i = fsservice.updatestauts(fService.getSuperServiceNo(), status);
                int insert = fsservice.updatestauts(serviceNo, status);
                return new SimpleResult(insert > 0 ? true : false);
            }
        } else {
            int insert = fsservice.updatestauts(serviceNo, status);
            return new SimpleResult(insert > 0 ? true : false);
        }

    }

    /*
    * 模糊查询
    * */
    @RequestMapping(value = "/selectByMhcx")
    @ResponseBody
    public PageInfo<FService> selectByMhcx(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                                @RequestParam(name = "rows",defaultValue = "10")Integer rows, Model model,FService record) throws UnsupportedEncodingException {
        String serviceName = record.getServiceName();
        serviceName = new String(serviceName.getBytes("iso-8859-1"),"utf-8");
        record.setServiceName(serviceName);
        PageHelper.startPage(page,rows);
        List<FService> selectByMhcx = fsservice.selectByMhcx(record);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        PageInfo<FService> info = new PageInfo<FService>(selectByMhcx,4);
        model.addAttribute("selectByExample", info);
        return info;

    }


}
