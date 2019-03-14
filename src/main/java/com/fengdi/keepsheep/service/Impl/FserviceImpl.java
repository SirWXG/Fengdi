package com.fengdi.keepsheep.service.Impl;


import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.bean.FServiceExample;
import com.fengdi.keepsheep.mapper.FServiceMapper;
import com.fengdi.keepsheep.service.Fservice;
import com.fengdi.keepsheep.util.Random2Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FserviceImpl implements Fservice {

    @Resource
    private FServiceMapper fserviceMapper;

    @Override
    public List<FService> selectByExample() {
        return fserviceMapper.selectByExample(new FServiceExample());
    }

    @Override
    public int insert(Fservice record) {
        return 0;
    }

    @Override
    public Fservice selectByPrimaryKey(String announcementNo) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String announcementNo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Fservice record) {
        return 0;
    }

    @Override
    public int updatestauts(String announcementNo, String status) {
        return 0;
    }

    @Override
    public int countByExample() {
        return 0;
    }

    @Override
    public List<Fservice> selectByMhcx(String announcementName) {
        return null;
    }
}
