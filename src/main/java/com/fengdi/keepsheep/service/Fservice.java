package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FService;

import java.util.List;

public interface Fservice {

    List<FService> selectByExample();

    int insert(Fservice record);

    Fservice selectByPrimaryKey(String announcementNo);

    int deleteByPrimaryKey(String announcementNo);

    int updateByPrimaryKeySelective(Fservice record);

    int updatestauts(String announcementNo,String status);

    int countByExample();

    List<Fservice> selectByMhcx(String announcementName);
}
