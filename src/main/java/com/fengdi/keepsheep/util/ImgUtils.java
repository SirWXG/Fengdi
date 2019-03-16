package com.fengdi.keepsheep.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * 图片处理类
 * Created by Administrator on 2019/3/15.
 */
public class ImgUtils {
    public static String getImgs(HttpServletRequest request, CommonsMultipartFile file){
        String filePath = null;
        try {
            //上传后的地址，注意("/upload")是表示文件上传后的目标文件夹
            String realPath = request.getSession().getServletContext().getRealPath("/images");
            System.out.println("打印文件上传的路径" + realPath);
            //获取文件名
            String filename = file.getOriginalFilename();
            //获取文件后缀名
            String extensionname = filename.substring(filename.lastIndexOf(".") + 1);
            //给上传的文件起别名，有很多种方式
            String newFilename = String.valueOf(System.currentTimeMillis()) + "." + extensionname;
            //创建File对象，传入目标路径参数，和新的文件别名
            File dir = new File(realPath, newFilename);
            if (!dir.exists()) {//如果dir代表的文件不存在，则创建它，
                dir.mkdirs();//
            }
            filePath = realPath+"\\"+newFilename;
            //如果存在则直接执行下面操作
            file.transferTo(dir);//将上传的实体文件复制到指定目录upload下
        }catch (Exception e){
            e.printStackTrace();
        }
        return filePath;
    }
}
