package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FPicture;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/15.
 */
public interface FPictureService {

    List<FPicture> selectPic(String pictureArea);

    int insert(FPicture record);

    int deletePic(String pictureNo);

    int updatePicStatus(Map<String,Object> map);

    int checkPic();

    List<FPicture> selectPictureByPno(String pictureNo);

    int checkPicNum(FPicture fPicture);

    int updatePic(FPicture fPicture);

    int updatePics(FPicture fPicture);

    List<FPicture> selectPicByLBANDPTLB();

    int checkPicForNote();

    int checkPicForEmployee();

    int checkPicByProblem();

    int checkPicByHot();

    List<FPicture> selectPicByHot();

    List<FPicture> selectPicByNote();

    List<FPicture> selectPicByProblem();

    List<FPicture> selectPicByEmployee();
}
