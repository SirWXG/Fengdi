package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Fsservice {

    List<FService> selectByExample();

    int insert(FService record);

    FService selectByPrimaryKey(String ServiceNo);

    int deleteByPrimaryKey(String ServiceNo);

    int updateByPrimaryKeySelective(FService record);

    int updatestauts(String serviceNo,String status);

    int updatestauts2(String superServiceNo,String status);

    int countByExample();

    List<FService> selectByMhcx(String announcementName);

    List<FService> selectByservicelevel();

    int deleteBysuperServiceNo(String ServiceNo);

}
