package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAdminGroup;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */
public interface FAdminGroupService {

    /**
     * 查询所有角色
     * @return
     */
    List<FAdminGroup> selectAllRoler();
}
