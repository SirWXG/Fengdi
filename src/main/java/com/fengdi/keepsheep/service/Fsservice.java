package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FService;

import java.util.List;

public interface Fsservice {

    List<FService> selectByExample();

    int insert(FService record);

    FService selectByPrimaryKey(String announcementNo);

    int deleteByPrimaryKey(String announcementNo);

    int updateByPrimaryKeySelective(FService record);

    int updatestauts(String announcementNo,String status);

    int countByExample();

    List<FService> selectByMhcx(String announcementName);

    List<FService> selectByservicelevel();
}
