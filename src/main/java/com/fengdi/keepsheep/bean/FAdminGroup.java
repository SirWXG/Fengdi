package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FAdminGroup {
    private String adminGroupNo;

    private Long id;

    private String groupName;

    private String groupCnname;

    private String adminNo;

    private String founder;

    private String delstatus;

    private Boolean editFlag;

    private Date createTime;

    private Date updateTime;

    private String authorizeList;

    public String getAdminGroupNo() {
        return adminGroupNo;
    }

    public void setAdminGroupNo(String adminGroupNo) {
        this.adminGroupNo = adminGroupNo == null ? null : adminGroupNo.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupCnname() {
        return groupCnname;
    }

    public void setGroupCnname(String groupCnname) {
        this.groupCnname = groupCnname == null ? null : groupCnname.trim();
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo == null ? null : adminNo.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

    public Boolean getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(Boolean editFlag) {
        this.editFlag = editFlag;
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

    public String getAuthorizeList() {
        return authorizeList;
    }

    public void setAuthorizeList(String authorizeList) {
        this.authorizeList = authorizeList == null ? null : authorizeList.trim();
    }
}