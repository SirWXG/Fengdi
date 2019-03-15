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
    public FService selectByPrimaryKey(String ServiceNo) {
        return fserviceMapper.selectByPrimaryKey(ServiceNo);
    }

    @Override
    public int deleteByPrimaryKey(String ServiceNo) {
        return fserviceMapper.deleteByPrimaryKey(ServiceNo);
    }

    @Override
    public int updateByPrimaryKeySelective(FService record) {
        return fserviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updatestauts(String serviceNo, String status) {
        return fserviceMapper.updatestauts(serviceNo,status);
    }

    @Override
    public int updatestauts2(String superServiceNo, String status) {
        return fserviceMapper.updatestauts2(superServiceNo,status);
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

    @Override
    public int deleteBysuperServiceNo(String ServiceNo) {
        return fserviceMapper.deleteBysuperServiceNo(ServiceNo);
    }
}
