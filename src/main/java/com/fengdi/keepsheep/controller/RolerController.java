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
            if(firstRemark.trim().length()<1||adminNo.trim().length()<1){
                result.setErrMsg("一级权限或分配人员名称不能为空");
            }else{
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
                    String array[] = sRemark.split(",");
                    if(!auth.contains(firstRemark)){
                        auth = auth+","+firstRemark+",";
                    }
                    for(int i=0;i<array.length;i++){
                        if(!auth.contains(array[i])){
                            auth=auth+","+array[i]+",";
                        }
                    }
                    auth = auth.replace(",,",",");
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
            }
        }else{
            result.setErrMsg("权限不足,无法操作");
        }
        return result;
    }

    //根据选择框查询权限
    @RequestMapping(value = "/selAuth",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selAuth(@RequestParam(name = "firstAuth")String firstAuth,
                                @RequestParam(name = "adminNo")String adminNo){
        SimpleResult result = new SimpleResult();
        if(checkAuth()){
            if(firstAuth.trim().length()<1||adminNo.trim().length()<1){
                result.setErrMsg("选择框不能为空,");
            }else{
                List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(adminNo);
                String auth_list = list.get(0).getAuthorizeList();
                List<FAuthorize> list_auth = fAuthorizeService.selectAuthBySecond(firstAuth);
                String f[] = new String[list_auth.size()];
                for(int i = 0 ;i < list_auth.size();i++){
                    f[i] = String.valueOf(list_auth.get(i).getAuthorizeNo());
                }
                String auth_array[] = new String[list_auth.size()+1];
                int k = 0;
                for(int i=0;i<f.length;i++){
                    if(auth_list.contains(f[i])){
                        auth_array[k] = f[i];
                        k++;
                    }
                }
                if(auth_list.contains(firstAuth)){
                    auth_array[list_auth.size()] = firstAuth;
                }
                List<FAuthorize> lists = fAuthorizeService.selectListAuth(auth_array);
                if(lists.size()==0){
                    result.setErrMsg("查询结果为空");
                }else{
                    result.setSuccess(true);
                    result.setData(lists);
                }
            }
        }else{
            result.setErrMsg("权限不足,无法操作");
        }
        return  result;
    }


    @RequestMapping(value = "/delRoler",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult delRoler(@RequestParam(name = "authorizeNo")String authorizeNo,
                                 @RequestParam(name = "adminNo")String adminNo){
        SimpleResult result = new SimpleResult();
        if(checkAuth()){
            //得到对应的权限
            List<FAdminGroup> list = fAdminGroupService.selectRolerByAdminNo(adminNo);
            //根据一级编号查询的二级编号
            List<FAuthorize> list_auth = fAuthorizeService.selectAuthBySecond(authorizeNo);
            String auth = list.get(0).getAuthorizeList();
            if(list_auth.size()>=1){
                //管理员的权限编号列表
                //将二级编号放入数组之中
                String f[] = new String[list_auth.size()+1];
                for(int i = 0 ;i < list_auth.size();i++){
                    f[i] = String.valueOf(list_auth.get(i).getAuthorizeNo());
                }
                f[list_auth.size()] = authorizeNo;
                for(int i=0;i<f.length;i++){
                    if(auth.contains(f[i])){
                        auth = auth.replace(f[i],"");
                    }
                }
            }
                String newAuth = auth.replace(authorizeNo,"");
                String new_auth = newAuth.replace(",,",",");
                StringBuffer sb = new StringBuffer(new_auth);
                if(new_auth.endsWith(",")){
                    sb.replace(sb.length()-1,sb.length(),"");
                }
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("authorizeList",sb.toString());
                map.put("updateTime",new Date());
                map.put("adminNo",adminNo);
                int flag = fAdminGroupService.updateGroup(map);
                if(flag<1){
                    result.setErrMsg("删除失败，请重新操作");
                }else{
                    result.setSuccess(true);
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