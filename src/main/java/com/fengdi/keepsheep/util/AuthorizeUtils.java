package com.fengdi.keepsheep.util;

import java.util.List;

/**
 * 权限封装类
 * Created by Administrator on 2019/3/14.
 */
public class AuthorizeUtils {

    /**
     * 权限编号
     */
    private long authNo;

    /**
     * 权限对应的角色名
     */
    private String authName;

    /**
     * 权限对应的url
     */
    private String url;

    /**
     * 权限对应的具体信息
     */
    private List<AuthorizeUtils> auth_list;


    public long getAuthNo() {
        return authNo;
    }

    public void setAuthNo(long authNo) {
        this.authNo = authNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public List<AuthorizeUtils> getAuth_list() {
        return auth_list;
    }

    public void setAuth_list(List<AuthorizeUtils> auth_list) {
        this.auth_list = auth_list;
    }
}
