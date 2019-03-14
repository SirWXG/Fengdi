package com.fengdi.keepsheep.util;

import com.fengdi.keepsheep.bean.FAuthorize;

import java.util.Date;
import java.util.List;

/**
 * 权限封装类
 * Created by Administrator on 2019/3/14.
 */
public class AuthorizeUtils {

    /**
     * 权限编号
     */
    private String authNo;

    /**
     * 权限对应的角色名
     */
    private String authName;

    /**
     * 权限创建人
     */
    private String founder;

    /**
     * 权限创建时间
     */
    private Date createTime;

    /**
     * 权限更新时间
     */
    private Date updateTime;

    /**
     * 权限对应的具体信息
     */
    private List<FAuthorize> auth_list;

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<FAuthorize> getAuth_list() {
        return auth_list;
    }

    public void setAuth_list(List<FAuthorize> auth_list) {
        this.auth_list = auth_list;
    }
}
