package com.fengdi.keepsheep.service.Impl;


import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.bean.FServiceExample;
import com.fengdi.keepsheep.mapper.FServiceMapper;
import com.fengdi.keepsheep.service.Fsservice;
import com.fengdi.keepsheep.util.Random2Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FsserviceImpl implements Fsservice {

    @Resource
    private FServiceMapper fserviceMapper;

    @Override
    public List<FService> selectByExample() {
        return fserviceMapper.selectByExample(new FServiceExample());
    }

    @Override
    public int insert(FService record) {
        record.setServiceNo(Random2Utils.buildSn("SHP"));
        return fserviceMapper.insert(record);
    }

    @Override
    public FService selectByPrimaryKey(String announcementNo) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String announcementNo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(FService record) {
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
    public List<FService> selectByMhcx(String announcementName) {
        return null;
    }

    @Override
    public List<FService> selectByservicelevel() {
        return fserviceMapper.selectByservicelevel();
    }
}
