package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FPicture;
import com.fengdi.keepsheep.mapper.FPictureMapper;
import com.fengdi.keepsheep.service.FPictureService;
import com.fengdi.keepsheep.util.Random2Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/15.
 */

@Service
public class FPictureImpl implements FPictureService {

    @Autowired
    private FPictureMapper fPictureMapper;

    @Override
    public List<FPicture> selectPic(String pictureArea) {
        return fPictureMapper.selectPic(pictureArea);
    }

    @Override
    public int insert(FPicture fp) {
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        FAdmin fAdmin =(FAdmin) session.getAttribute("admin");
        fp.setPictureNo(Random2Utils.buildSn("P"));
        fp.setStatus("no");
        fp.setAdminGroupNo(fAdmin.getAdminNo());
        fp.setGroupCnname(fAdmin.getAdminName());
        fp.setCreateTime(new Date());
        return fPictureMapper.insert(fp);
    }

    @Override
    public int deletePic(String pictureNo) {
        return fPictureMapper.deletePic(pictureNo);
    }

    @Override
    public int updatePicStatus(Map<String, Object> map) {
        return fPictureMapper.updatePicStatus(map);
    }

    @Override
    public int checkPic() {
        return fPictureMapper.checkPic();
    }

    @Override
    public List<FPicture> selectPictureByPno(String pictureNo) {
        return fPictureMapper.selectPictureByPno(pictureNo);
    }

    @Override
    public int checkPicNum(FPicture fPicture) {
        return fPictureMapper.checkPicNum(fPicture);
    }

}
