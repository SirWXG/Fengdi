package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FPicture;
import com.fengdi.keepsheep.bean.FPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FPictureMapper {
    int countByExample(FPictureExample example);

    int deleteByExample(FPictureExample example);

    int deleteByPrimaryKey(String pictureNo);

    int insert(FPicture record);

    int insertSelective(FPicture record);

    List<FPicture> selectByExampleWithBLOBs(FPictureExample example);

    List<FPicture> selectByExample(FPictureExample example);

    FPicture selectByPrimaryKey(Integer pictureNo);

    int updateByExampleSelective(@Param("record") FPicture record, @Param("example") FPictureExample example);

    int updateByExampleWithBLOBs(@Param("record") FPicture record, @Param("example") FPictureExample example);

    int updateByExample(@Param("record") FPicture record, @Param("example") FPictureExample example);

    int updateByPrimaryKeySelective(FPicture record);

    int updateByPrimaryKeyWithBLOBs(FPicture record);

    int updateByPrimaryKey(FPicture record);

    List<FPicture> selectPic(@Param(value = "pictureArea") String pictureArea);

    int deletePic(String pictureNo);

    int updatePicStatus(Map<String,Object>map);

    int checkPic();

    List<FPicture> selectPictureByPno(String pictureNo);

    int checkPicNum(FPicture fPicture);
}