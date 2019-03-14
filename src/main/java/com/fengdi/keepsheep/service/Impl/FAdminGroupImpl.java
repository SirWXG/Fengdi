package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.mapper.FAdminGroupMapper;
import com.fengdi.keepsheep.mapper.FAuthorizeMapper;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.util.AuthorizeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<AuthorizeUtils> selectAllRoler() {
        List<AuthorizeUtils> a_list = new ArrayList<AuthorizeUtils>();
        List<FAdminGroup> list = fAdminGroupMapper.selectAllRoler();
        for(FAdminGroup group:list){
            AuthorizeUtils utils = new AuthorizeUtils();
            utils.setAuthName(group.getGroupName());
            utils.setAuthName(group.getFounder());
            utils.setAuthNo(group.getAdminGroupNo());
            utils.setCreateTime(group.getCreateTime());
            utils.setUpdateTime(group.getUpdateTime());
            String auth_c = group.getAuthorizeList();
            String []arrays = auth_c.split(",");
            List<FAuthorize> auth_list = fAuthorizeMapper.selectList(arrays);
            utils.setAuth_list(auth_list);
        }
        return a_list;
    }
}
