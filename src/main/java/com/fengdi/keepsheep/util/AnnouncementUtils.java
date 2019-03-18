package com.fengdi.keepsheep.util;

import com.fengdi.keepsheep.bean.FService;

import java.util.Date;
import java.util.List;

/**
 * @author胡大昆
 * @create 2019-03-18 上午 9:47
 **/
public class AnnouncementUtils {
    private String serviceNo;

    private Integer id;

    private String superServiceNo;

    private String serviceName;

    private Integer serviceLevel;

    private String status;

    private String groupCnname;

    private String adminGroupNo;

    private Date createTime;

    private Date updateTime;

    private String serviceUrl;

    private List<FService> s;

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperServiceNo() {
        return superServiceNo;
    }

    public void setSuperServiceNo(String superServiceNo) {
        this.superServiceNo = superServiceNo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(Integer serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroupCnname() {
        return groupCnname;
    }

    public void setGroupCnname(String groupCnname) {
        this.groupCnname = groupCnname;
    }

    public String getAdminGroupNo() {
        return adminGroupNo;
    }

    public void setAdminGroupNo(String adminGroupNo) {
        this.adminGroupNo = adminGroupNo;
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
        this.serviceUrl = serviceUrl;
    }

    public List<FService> getS() {
        return s;
    }

    public void setS(List<FService> s) {
        this.s = s;
    }
}
