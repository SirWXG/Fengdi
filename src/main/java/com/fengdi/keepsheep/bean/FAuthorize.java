package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FAuthorize {
    private Long authorizeNo;

    private Long id;

    private Long superAuthorizeNo;

    private String resourcekey;

    private Integer resourceLevel;

    private String remark;

    private Integer sort;

    private Integer levelkey;

    private Integer delFlag;

    private Date createTime;

    private Date updateTime;

    public Long getAuthorizeNo() {
        return authorizeNo;
    }

    public void setAuthorizeNo(Long authorizeNo) {
        this.authorizeNo = authorizeNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSuperAuthorizeNo() {
        return superAuthorizeNo;
    }

    public void setSuperAuthorizeNo(Long superAuthorizeNo) {
        this.superAuthorizeNo = superAuthorizeNo;
    }

    public String getResourcekey() {
        return resourcekey;
    }

    public void setResourcekey(String resourcekey) {
        this.resourcekey = resourcekey == null ? null : resourcekey.trim();
    }

    public Integer getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevelkey() {
        return levelkey;
    }

    public void setLevelkey(Integer levelkey) {
        this.levelkey = levelkey;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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