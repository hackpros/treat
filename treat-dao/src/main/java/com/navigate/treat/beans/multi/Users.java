/*
 * Users.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.beans.multi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表
 * 
 * @author 掌航
 * @version 1.0 2016-04-19
 */
public class Users implements Serializable {

    /**
     * 业务唯一数字ID
     */
    private Long userId;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别 男 1  女 2
     */
    private Integer sex;
    /**
     * 注册时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
    /**
     * 状态 正常
     */
    private Integer status;
    /**
     * 背景图
     */
    private String backgroundImage;
    /**
     * 请客号
     */
    private String treamNum;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 用户来源@
     */
    private String userSource;
    /**
     * 身高(cm)
     */
    private Integer height;
    /**
     * 头像
     */
    private String headIcon;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 相册列表
     */
    private String photo;
    /**
     * 签名
     */
    private String signature;
    /**
     * 余额
     */
    private BigDecimal balance;
    private String deviceId;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getBackgroundImage() {
        return backgroundImage;
    }
    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage == null ? null : backgroundImage.trim();
    }
    public String getTreamNum() {
        return treamNum;
    }
    public void setTreamNum(String treamNum) {
        this.treamNum = treamNum == null ? null : treamNum.trim();
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getUserSource() {
        return userSource;
    }
    public void setUserSource(String userSource) {
        this.userSource = userSource == null ? null : userSource.trim();
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public String getHeadIcon() {
        return headIcon;
    }
    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon == null ? null : headIcon.trim();
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBackgroundImage() == null ? other.getBackgroundImage() == null : this.getBackgroundImage().equals(other.getBackgroundImage()))
            && (this.getTreamNum() == null ? other.getTreamNum() == null : this.getTreamNum().equals(other.getTreamNum()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getUserSource() == null ? other.getUserSource() == null : this.getUserSource().equals(other.getUserSource()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getHeadIcon() == null ? other.getHeadIcon() == null : this.getHeadIcon().equals(other.getHeadIcon()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()))
            && (this.getSignature() == null ? other.getSignature() == null : this.getSignature().equals(other.getSignature()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBackgroundImage() == null) ? 0 : getBackgroundImage().hashCode());
        result = prime * result + ((getTreamNum() == null) ? 0 : getTreamNum().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getUserSource() == null) ? 0 : getUserSource().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getHeadIcon() == null) ? 0 : getHeadIcon().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        result = prime * result + ((getSignature() == null) ? 0 : getSignature().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        return result;
    }
}