package com.fengdi.keepsheep.controller;

import com.fengdi.keepsheep.bean.FPicture;
import com.fengdi.keepsheep.service.FPictureService;
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
     * @param session
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/selectPic",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<FPicture> selectPic(@RequestParam(name = "page",defaultValue = "1")Integer page,
                                        @RequestParam(name = "rows",defaultValue = "10")Integer rows,
                                        @RequestParam(name = "pictureArea",defaultValue = "")String pictureArea, HttpSession session) throws UnsupportedEncodingException {
        pictureArea = new String(pictureArea.getBytes("iso-8859-1"),"utf-8");
        System.out.println(pictureArea);
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
                               @RequestParam(name = "img")CommonsMultipartFile file,
                               @RequestParam(name = "pictureArea")String pictureArea,
                               @RequestParam(name = "pictureType")String pictureType,HttpServletRequest request){
        SimpleResult result = new SimpleResult();
        try{
            if(null==request.getSession().getAttribute("admin")){
                result.setErrCode("1");
                result.setMessage("登录信息失效，请重新登录");
            }else{
                String filePath = ImgUtils.getImgs(request,file);
                FPicture fp = new FPicture();
                fp.setPictureImg(filePath);
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
                if("轮播图".equals(list.get(0).getPictureType())){
                    if(fPictureService.checkPicNum(list.get(0))>4&&status.equals("yes")){
                        result.setErrMsg("轮播图最多设置五张，请重新设置");
                    }else{
                        int flag = fPictureService.updatePicStatus(map);
                        if(flag<1){
                            result.setErrMsg("更新信息失败，请重新操作");
                        }else{
                            result.setSuccess(true);
                        }
                    }
                }else{
                    if(status.equals("no")){
                        int flag = fPictureService.updatePicStatus(map);
                        if(flag<1){
                            result.setErrMsg("更新信息失败，请重新操作");
                        }else{
                            result.setSuccess(true);
                        }
                    }else{
                        if(fPictureService.checkPic()>0){
                            result.setErrMsg("平台图片最多设置一张，请重新设置");
                        }else{
                            int flag = fPictureService.updatePicStatus(map);
                            if(flag<1){
                                result.setErrMsg("更新信息失败，请重新操作");
                            }else{
                                result.setSuccess(true);
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
