package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FAuthorize;

import java.util.List;

/**
 * Created by Administrator on 2019/3/13.
 */
public interface FAuthorizeService {

    /**
     * 查询角色对应的权限
     * @param array
     * @return
     */
    List<FAuthorize> selectList(String array[]);

    List<FAuthorize> selectAuthByFirst(String array[]);

    List<FAuthorize> selectListAuth(String array[]);

    List<FAuthorize> selectFirst();

    List<FAuthorize> selectAuthBySecond(String superAuthorizeNo);
}
