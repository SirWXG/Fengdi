package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FPicture;
import com.fengdi.keepsheep.service.FPictureService;
import com.fengdi.keepsheep.util.SimpleResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/15.
 */

@Controller
@RequestMapping(value = "/picture")
public class PictureController {

    @Autowired
    private FPictureService fPictureService;



    /**
     * 模糊查询图片和全查
     * @param page
     * @param rows
     * @param pictureArea
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/selectPic",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<FPicture> selectPic(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                        @RequestParam(name = "rows",defaultValue = "10")Integer rows,
                                        @RequestParam(name = "pictureArea",defaultValue = "")String pictureArea) throws UnsupportedEncodingException {
        pictureArea = new String(pictureArea.getBytes("iso-8859-1"),"utf-8");
        PageHelper.startPage(page,rows);
        List<FPicture> list = fPictureService.selectPic(pictureArea);
        PageInfo<FPicture> info = new PageInfo<FPicture>(list,4);
        return info;
    }


    /**
     * 新增图片
     * @param pictureName
     * @param pictureText
     * @param file
     * @param pictureArea
     * @param pictureType
     * @param request
     * @return
     */
    @RequestMapping(value = "/addPicture",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult insert(@RequestParam(name = "pictureName")String pictureName,
                               @RequestParam(name = "pictureText")String pictureText,
                               @RequestParam(name = "img")String  file,
                               @RequestParam(name = "pictureArea")String pictureArea,
                               @RequestParam(name = "pictureType",defaultValue = "展示图片")String pictureType,HttpServletRequest request){
        System.out.println(file);
        SimpleResult result = new SimpleResult();
        try{
            if(null==request.getSession().getAttribute("admin")){
                result.setErrCode("1");
                result.setMessage("登录信息失效，请重新登录");
            }else{
                FPicture fp = new FPicture();
                fp.setPictureImg(file);
                fp.setPictureText(pictureText);
                fp.setPictureName(pictureName);
                fp.setPictureArea(pictureArea);
                fp.setPictureType(pictureType);
                int flag = fPictureService.insert(fp);
                if(flag<1){
                    result.setMessage("添加失败，请重新添加");
                }else{
                    result.setSuccess(true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除图片
     * @param picNo
     * @param session
     * @return
     */
    @RequestMapping(value = "/delpic",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult delPic(@RequestParam(name = "picNo")String picNo,HttpSession session){
        System.out.println(picNo);
        SimpleResult result = new SimpleResult();
        try{
            if(session.getAttribute("admin")==null){
                result.setErrCode("1");
                result.setErrMsg("登录信息失效，请重新登录");
            }else{
                int flag = fPictureService.deletePic(picNo);
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

    /**
     * 更新图片状态
     * @param picno
     * @param status
     * @param session
     * @return
     */
    @RequestMapping(value = "/updatePictureStatus",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updatePicStatus(@RequestParam(name = "picno")String picno,@RequestParam(name = "status")String status,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            if(null==session.getAttribute("admin")){
                result.setErrMsg("登录信息失效，请重新登录");
                result.setErrCode("1");
            }else{
                List<FPicture> list = fPictureService.selectPictureByPno(picno);
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("status",status);
                map.put("pictureNo",picno);
                if("平台轮播".equals(list.get(0).getPictureArea())){
                    if(fPictureService.checkPic()>4&&status.equals("yes")){
                        result.setErrMsg("平台轮播图片最多设置五张，请重新操作");
                    }else{
                        result.setSuccess(true);
                        fPictureService.updatePicStatus(map);
                    }
                }else if("新闻中心".equals(list.get(0).getPictureArea())){
                    if(fPictureService.checkPicForNote()>4&&status.equals("yes")){
                        result.setErrMsg("新闻中心图片最多设置一张，请重新操作");
                    }else{
                        result.setSuccess(true);
                        fPictureService.updatePicStatus(map);
                    }
                }else if("热门搜索".equals(list.get(0).getPictureArea())){
                    if(fPictureService.checkPicByHot()>3&&status.equals("yes")){
                        result.setErrMsg("热门搜索图片最多设置四张,请重新操作");
                    }else{
                        result.setSuccess(true);
                        fPictureService.updatePicStatus(map);
                    }
                }else if("公司平台展示".equals(list.get(0).getPictureArea())){
                    if(fPictureService.checkPicForEmployee()>2&&status.equals("yes")){
                        result.setErrMsg("公司平台展示图片最多设置三张，请重新操作");
                    }else{
                        result.setSuccess(true);
                        fPictureService.updatePicStatus(map);
                    }
                }else if("问题展示".equals(list.get(0).getPictureArea())){
                    if(fPictureService.checkPicByProblem()>0&&status.equals("yes")){
                        result.setErrMsg("问题展示图片最多设置一张，请重新操作");
                    }else{
                        result.setSuccess(true);
                        fPictureService.updatePicStatus(map);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/selectPicture",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult selectPictureByNo(@RequestParam(name = "pictureNo")String picNo,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            List<FPicture> list = fPictureService.selectPictureByPno(picNo);
            if(list.size()<1){
                result.setErrCode("1");
                result.setErrMsg("查询错误");
            }else{
                result.setSuccess(true);
                session.setAttribute("f_picture",list.get(0));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/updatePicture",method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult updatePicture(@RequestParam(name = "pictureText",defaultValue = "")String pictureText,
                                      @RequestParam(name = "img")String file,
                                      @RequestParam(name = "pictureName",defaultValue = "")String pictureName,
                                      HttpServletRequest request,HttpSession session){
        SimpleResult result = new SimpleResult();
        try{
            FPicture fPicture =(FPicture)session.getAttribute("f_picture");
            String picNo = fPicture.getPictureNo();
            FPicture fp = new FPicture();
            int flag;
            if(file.length()==0){
                fp.setPictureNo(picNo);
                fp.setPictureText(pictureText);
                fp.setPictureName(pictureName);
                flag = fPictureService.updatePics(fp);
            }else{
                fp.setPictureImg(file);
                fp.setPictureNo(picNo);
                fp.setPictureText(pictureText);
                fp.setPictureName(pictureName);
                flag = fPictureService.updatePic(fp);
            }
            if(flag<1){
                result.setErrCode("1");
                result.setErrMsg("更新失败");
            }else{
                result.setSuccess(true);
            }
        }catch (Exception e){
         e.printStackTrace();
        }
        return result;
    }

}
