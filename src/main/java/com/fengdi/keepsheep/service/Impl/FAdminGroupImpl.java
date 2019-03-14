package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.mapper.FAdminGroupMapper;
import com.fengdi.keepsheep.mapper.FAuthorizeMapper;
import com.fengdi.keepsheep.service.FAdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */

@Service
public class FAdminGroupImpl implements FAdminGroupService {

    @Autowired
    private FAdminGroupMapper fAdminGroupMapper;

    @Autowired
    private FAuthorizeMapper fAuthorizeMapper;

    @Override
    public List<FAdminGroup> selectAllRoler() {
        List<FAdminGroup> list = fAdminGroupMapper.selectAllRoler();
        for(FAdminGroup group:list){
            String auth_c = group.getAuthorizeList();
            String []arrays = auth_c.split(",");
            List<FAuthorize> auth_list = fAuthorizeMapper.selectList(arrays);
            for(FAuthorize auth:auth_list){

            }
        }
        return list;
    }
}
