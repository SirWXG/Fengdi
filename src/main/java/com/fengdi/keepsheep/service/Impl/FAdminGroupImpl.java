package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.mapper.FAdminGroupMapper;
import com.fengdi.keepsheep.mapper.FAuthorizeMapper;
import com.fengdi.keepsheep.service.FAdminGroupService;
import com.fengdi.keepsheep.util.AuthorizeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

        return null;
    }

    @Override
    public List<FAdminGroup> selectRolerByAdminNo(String adminNo) {
        return fAdminGroupMapper.selectRolerByAdminNo(adminNo);
    }

    @Override
    public int addGroup(FAdminGroup fAdminGroup) {
        return fAdminGroupMapper.addGroup(fAdminGroup);
    }

    @Override
    public int updateGroup(Map<String, Object> map) {
        return fAdminGroupMapper.updateGroup(map);
    }
}
