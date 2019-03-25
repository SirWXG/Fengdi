package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAdminService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.shiro.Shiro;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private FAuthorizeService fAuthorizeService;

    @Autowired
    private FAdminGroupService fAdminGroupService;

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
            List<FAdmin> list = fAdminService.selectByExample(null);
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
    @RequestMapping(value ="/selectAdminByStatus",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<FAdmin> selectAdmin(@RequestParam(name = "realName",defaultValue = "")String realName,
                                    @RequestParam(name = "loginName",defaultValue = "")String loginName,
                                    @RequestParam(name = "page",defaultValue = "1")Integer page,
                                    @RequestParam(name = "rows",defaultValue = "10")Integer rows,Model model,HttpSession session) throws UnsupportedEncodingException {
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            FAdmin fAdmin = (FAdmin)session.getAttribute("admin");
            map.put("loginName",loginName);
            map.put("adminName",realName);
        }catch (Exception e){
            e.printStackTrace();
        }
        PageHelper.startPage(page,rows);
        List<FAdmin> list = fAdminService.selectAdminByStatus(map);
        PageInfo<FAdmin> info = new PageInfo<FAdmin>(list,4);
        return info;
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
            if(checkAuth()){
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
            }else{
                result.setErrMsg("权限不足,无法操作");
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
            if(checkAuth()) {
                FAdmin fAdmin = (FAdmin) session.getAttribute("admin");
                if (null == fAdmin) {
                    result.setErrCode("1");
                    result.setErrMsg("登录信息失效,请重新登录");
                }
                int flag = fAdminService.deleteAdminByAdminNo(adminNo);
                if (flag < 1) {
                    result.setErrCode("1");
                    result.setErrMsg("删除失败,请重新删除");
                } else {
                    result.setSuccess(true);
                }
            }else {
                result.setErrMsg("权限不足,无法操作");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 限制用户登录
     * @param adminNo
     * @param status
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateAdminStatus",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateAdminStatus(@RequestParam(name = "adminNo")String adminNo,@RequestParam(name = "status")String status,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()) {
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
            }else{
                result.setErrMsg("权限不足,无法操作");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据编号查询管理员
     * @param adminNo
     * @param session
     * @return
     */
    @RequestMapping(value = "/selectAdminByAdminNo",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selectAdminByAdminNo(@RequestParam(name = "adminNo")String adminNo,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                FAdmin admin = (FAdmin) session.getAttribute("admin");
                if(null==admin){
                    result.setErrCode("1");
                    result.setMessage("登录信息失效，请重新登录");
                }else{
                    List<FAdmin> fAdmin = fAdminService.selectAdminByAdminNo(adminNo);
                    if(fAdmin==null){
                        result.setErrMsg("查询失败,请重新查询");
                    }else{
                        result.setSuccess(true);
                        session.setAttribute("fAdmin",fAdmin.get(0));
                    }
                }
            }else{
                result.setErrMsg("权限不足,无法操作");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateAdmin(FAdmin fAdmin,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                FAdmin admin = (FAdmin)session.getAttribute("fAdmin");
                if(null==session.getAttribute("admin")){
                    result.setErrMsg("登录信息失效,请重新登录");
                    result.setErrCode("1");
                }else{
                    fAdmin.setAdminNo(admin.getAdminNo());
                    int flag;
                    if(fAdmin.getPwd().length()==32){
                        flag = fAdminService.updateByPrimaryKeySelective(fAdmin);
                    }else{
                        List<FAdmin> lists =  fAdminService.selectAdminByLoginName(admin.getLoginName());
                        fAdmin.setPwd(Shiro.ToMD5(lists.get(0).getSalt(),fAdmin.getPwd()));
                        flag = fAdminService.updateByPrimaryKeySelective(fAdmin);
                    }
                    if(flag<1){
                        result.setErrMsg("更新失败,请重新操作");
                    }else{
                        result.setSuccess(true);
                    }
                }
            }else{
                result.setErrMsg("权限不足,无法操作");
            }
        }catch (Exception e){
            e.printStackTrace();
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
