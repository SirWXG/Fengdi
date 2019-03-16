package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.service.FProductService;
import com.fengdi.keepsheep.util.ImgUtils;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    @RequestMapping(value = "/selectAllProduct")
    @ResponseBody
    public PageInfo<FProduct> selectAll(@RequestParam(name = "page",defaultValue = "1")Integer page,
            @RequestParam(name = "rows",defaultValue = "6")Integer rows,
            @RequestParam(name = "productName",defaultValue = "")String productName) throws UnsupportedEncodingException {
        productName = new String(productName.getBytes("iso-8859-1"),"utf-8");
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
                    if(index>6){
                        result.setErrCode("1");
                        result.setErrMsg("产品最多展示六个，请重新操作!");
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult addProduct(@RequestParam(name = "productName")String productName,
                                   @RequestParam(name = "productInfo")String productInfo,
                                   @RequestParam(name = "img")CommonsMultipartFile file, HttpServletRequest request){
        SimpleResult result = new SimpleResult();
        try{
            if(result==request.getSession().getAttribute("admin")){
                result.setErrCode("1");
                result.setErrMsg("登录信息失效，请重新登录");
            }else{
                String filePath = ImgUtils.getImgs(request,file);
                FProduct product = new FProduct();
                product.setProductImg(filePath);
                product.setProductIntroduction(productInfo);
                product.setProductName(productName);
                int flag = fProductService.insert(product);
                if(flag<1){
                    result.setErrMsg("新增失败");
                }else{
                    result.setSuccess(true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/selectProduct",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selectProduct(@RequestParam(name = "productNo")String productNo,HttpSession session){
        System.out.println(productNo);
        SimpleResult result = new SimpleResult();
        try{
            if(session.getAttribute("admin")==null){
                result.setErrCode("1");
                result.setErrMsg("登录信息失效，请重新登录");
            }else{
                List<FProduct> list = fProductService.selectProductByPno(productNo);
                result.setSuccess(true);
                session.setAttribute("f_product",list.get(0));
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
                                      @RequestParam(name = "img")CommonsMultipartFile file, HttpServletRequest request){
        SimpleResult result = new SimpleResult();
        try{
            if(null==request.getSession().getAttribute("admin")){
                result.setErrMsg("登录信息失效,请重新登录");
                result.setErrCode("1");
            }else{
                HttpSession session = request.getSession();
                FProduct product = (FProduct) session.getAttribute("f_product");
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("productName",productName);
                map.put("productIntroduction",productInfo);
                map.put("productImg",ImgUtils.getImgs(request,file));
                map.put("productNo",product.getProductNo());
                int flag =  fProductService.updateProduct(map);
                if(flag<1){
                    result.setErrMsg("修改失败");
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
