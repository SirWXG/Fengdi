package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FService {
    private Integer serviceNo;

    private Integer id;

    private Integer superServiceNo;

    private String serviceName;

    private Integer serviceLevel;

    private String groupCnname;

    private String adminGroupNo;

    private Date createTime;

    private Date updateTime;

    private String serviceUrl;

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuperServiceNo() {
        return superServiceNo;
    }

    public void setSuperServiceNo(Integer superServiceNo) {
        this.superServiceNo = superServiceNo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Integer getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(Integer serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getGroupCnname() {
        return groupCnname;
    }

    public void setGroupCnname(String groupCnname) {
        this.groupCnname = groupCnname == null ? null : groupCnname.trim();
    }

    public String getAdminGroupNo() {
        return adminGroupNo;
    }

    public void setAdminGroupNo(String adminGroupNo) {
        this.adminGroupNo = adminGroupNo == null ? null : adminGroupNo.trim();
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

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }
}