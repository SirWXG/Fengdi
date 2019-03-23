package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.util.AuthorizeUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/13.
 */
public interface FAdminGroupService {

    /**
     * 查询所有角色
     * @return
     */
    List<AuthorizeUtils> selectAllRoler();

    List<FAdminGroup> selectRolerByAdminNo(String adminNo);

    int addGroup(FAdminGroup fAdminGroup);

    int updateGroup(Map<String,Object> map);
}
