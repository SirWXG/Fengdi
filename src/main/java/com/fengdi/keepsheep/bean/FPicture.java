package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FPicture {
    private Integer pictureNo;

    private Long id;

    private String pictureName;

    private String pictureText;

    private Integer pictureArea;

    private String pictureType;

    private String groupCnname;

    private String adminGroupNo;

    private Date createTime;

    private Date updateTime;

    private String pictureImg;

    public Integer getPictureNo() {
        return pictureNo;
    }

    public void setPictureNo(Integer pictureNo) {
        this.pictureNo = pictureNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureText() {
        return pictureText;
    }

    public void setPictureText(String pictureText) {
        this.pictureText = pictureText == null ? null : pictureText.trim();
    }

    public Integer getPictureArea() {
        return pictureArea;
    }

    public void setPictureArea(Integer pictureArea) {
        this.pictureArea = pictureArea;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType == null ? null : pictureType.trim();
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

    public String getPictureImg() {
        return pictureImg;
    }

    public void setPictureImg(String pictureImg) {
        this.pictureImg = pictureImg == null ? null : pictureImg.trim();
    }
}