package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.service.FAuthorizeService;
import com.fengdi.keepsheep.service.FProductService;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Created by Administrator on 2019/3/16.
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private FProductService fProductService;

    @Autowired
    private FAuthorizeService fAuthorizeService;

    @Autowired
    private FAdminGroupService fAdminGroupService;

    @RequestMapping(value = "/selectAllProduct")
    @ResponseBody
    public PageInfo<FProduct> selectAll(@RequestParam(name = "page",defaultValue = "1")Integer page,
            @RequestParam(name = "rows",defaultValue = "6")Integer rows,
            @RequestParam(name = "productName",defaultValue = "")String productName) throws UnsupportedEncodingException {
        PageHelper.startPage(page,rows);
        List<FProduct> list = fProductService.selectAllProduct(productName);
        PageInfo<FProduct> info = new PageInfo<FProduct>(list,4);
        return info;
    }


    @RequestMapping(value = "/delProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult delProduct(@RequestParam(name = "productNo")String productNo, HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                if(null==session.getAttribute("admin")){
                    result.setErrCode("1");
                    result.setErrMsg("登录信息失效，请重新登录");
                }else{
                    int flag = fProductService.deleteByPrimaryKey(productNo);
                    if(flag<1){
                        result.setErrMsg("删除失败,请重新操作");
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

    @RequestMapping(value = "/updateProductStatus",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateStatus(@RequestParam(name = "productNo")String productNo,
                                     @RequestParam(name = "status")String status,
                                     HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                if(null==session.getAttribute("admin")){
                    result.setErrCode("1");
                    result.setErrMsg("登录信息失效,请重新登录");
                }else{
                    Map<String,Object> map = new HashMap<String, Object>();
                    map.put("status",status);
                    map.put("productNo",productNo);
                    if("no".equals(status)){
                        int flag = fProductService.updateProductStatus(map);
                        if(flag<1){
                            result.setErrMsg("更新错误,请重新操作");
                        }else{
                            result.setSuccess(true);
                        }
                    }else{
                        int index = fProductService.checkProductImg();
                        if(index>4){
                            result.setErrCode("1");
                            result.setErrMsg("产品最多展示五个，请重新操作!");
                        }else{
                            int flag = fProductService.updateProductStatus(map);
                            if(flag<1){
                                result.setErrMsg("更新错误,请重新操作");
                            }else{
                                result.setSuccess(true);
                            }
                        }
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

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult addProduct(@RequestParam(name = "productName")String productName,
                                   @RequestParam(name = "productInfo")String productInfo,
                                   @RequestParam(name = "img")String file, HttpServletRequest request){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                if(result==request.getSession().getAttribute("admin")){
                    result.setErrCode("1");
                    result.setErrMsg("登录信息失效，请重新登录");
                }else{
                    FProduct product = new FProduct();
                    product.setProductImg(file);
                    product.setProductIntroduction(productInfo);
                    product.setProductName(productName);
                    int flag = fProductService.insert(product);
                    if(flag<1){
                        result.setErrMsg("新增失败");
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


    @RequestMapping(value = "/selectProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selectProduct(@RequestParam(name = "productNo")String productNo,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                if(session.getAttribute("admin")==null){
                    result.setErrCode("1");
                    result.setErrMsg("登录信息失效，请重新登录");
                }else{
                    List<FProduct> list = fProductService.selectProductByPno(productNo);
                    result.setSuccess(true);
                    session.setAttribute("f_product",list.get(0));
                }
            }else{
                result.setErrMsg("权限不足,无法操作");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updateProduct(@RequestParam(name = "productName")String productName,
                                      @RequestParam(name = "productInfo")String productInfo,
                                      @RequestParam(name = "img")String file, HttpServletRequest request){
        SimpleResult result = new SimpleResult();
        try{
            if(checkAuth()){
                if(null==request.getSession().getAttribute("admin")){
                    result.setErrMsg("登录信息失效,请重新登录");
                    result.setErrCode("1");
                }else{
                    HttpSession session = request.getSession();
                    FProduct product = (FProduct) session.getAttribute("f_product");
                    int flag;
                    if(file.length()==0){
                        Map<String,Object> map = new HashMap<String, Object>();
                        map.put("productName",productName);
                        map.put("productIntroduction",productInfo);
                        map.put("productNo",product.getProductNo());
                        flag =  fProductService.updateProducts(map);
                    }else{
                        Map<String,Object> maps = new HashMap<String, Object>();
                        maps.put("productName",productName);
                        maps.put("productIntroduction",productInfo);
                        maps.put("productImg",file);
                        maps.put("productNo",product.getProductNo());
                        flag =  fProductService.updateProduct(maps);
                    }
                    if(flag<1){
                        result.setErrMsg("修改失败");
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
