package com.fengdi.keepsheep.bean;

import java.util.Date;

public class FAdmin {
    private String adminNo;

    private Long id;

    private String nickname;

    private String adminName;

    private String cardid;

    private String loginName;

    private String pwd;

    private String salt;

    private String mobileNo;

    private Boolean isLoginMobile;

    private Boolean adminLevel;

    private String email;

    private String loginIp;

    private Date loginTime;

    private String status;

    private String parentAdminNo;

    private String groupNo;

    private Date createTime;

    private Date updateTime;

    private String merchantNo;

    private String foundName;

    private Double score;

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo == null ? null : adminNo.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public Boolean getIsLoginMobile() {
        return isLoginMobile;
    }

    public void setIsLoginMobile(Boolean isLoginMobile) {
        this.isLoginMobile = isLoginMobile;
    }

    public Boolean getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Boolean adminLevel) {
        this.adminLevel = adminLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getParentAdminNo() {
        return parentAdminNo;
    }

    public void setParentAdminNo(String parentAdminNo) {
        this.parentAdminNo = parentAdminNo == null ? null : parentAdminNo.trim();
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo == null ? null : groupNo.trim();
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

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getFoundName() {
        return foundName;
    }

    public void setFoundName(String foundName) {
        this.foundName = foundName == null ? null : foundName.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "FAdmin{" +
                "adminNo='" + adminNo + '\'' +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                ", adminName='" + adminName + '\'' +
                ", cardid='" + cardid + '\'' +
                ", loginName='" + loginName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", isLoginMobile=" + isLoginMobile +
                ", adminLevel=" + adminLevel +
                ", email='" + email + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", status='" + status + '\'' +
                ", parentAdminNo='" + parentAdminNo + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", merchantNo='" + merchantNo + '\'' +
                ", foundName='" + foundName + '\'' +
                ", score=" + score +
                '}';
    }
}