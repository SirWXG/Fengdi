package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FTitle {
    private String titleNo;

    private Integer id;

    private String titleName;

    private String titleSequence;

    private String status;

    private String groupCnname;

    private String adminGroupNo;

    private Date createTime;

    private Date updateTime;

    public String getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo == null ? null : titleNo.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public String getTitleSequence() {
        return titleSequence;
    }

    public void setTitleSequence(String titleSequence) {
        this.titleSequence = titleSequence == null ? null : titleSequence.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}