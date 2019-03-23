package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.mapper.FAuthorizeMapper;
import com.fengdi.keepsheep.service.FAuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */

@Service
public class FAuthorizeImpl implements FAuthorizeService{

    @Autowired
    private FAuthorizeMapper fAuthorizeMapper;

    @Override
    public List<FAuthorize> selectList(String array[]) {
        List<FAuthorize> list = fAuthorizeMapper.selectList(array);
        return list;
    }

    @Override
    public List<FAuthorize> selectAuthByFirst(String array[]) {
        List<FAuthorize> f_authc = fAuthorizeMapper.selectAuthByFirst(array);
        return f_authc;
    }

    @Override
    public List<FAuthorize> selectListAuth(String[] array) {
        return fAuthorizeMapper.selectListAuth(array);
    }

    @Override
    public List<FAuthorize> selectFirst() {
        return fAuthorizeMapper.selectFirst();
    }

    @Override
    public List<FAuthorize> selectAuthBySecond(String superAuthorizeNo) {
        return fAuthorizeMapper.selectAuthBySecond(superAuthorizeNo);
    }
}
