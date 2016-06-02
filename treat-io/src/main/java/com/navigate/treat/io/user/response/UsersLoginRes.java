package com.navigate.treat.io.user.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UsersLoginRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1961310267796064438L;
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
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
		this.backgroundImage = backgroundImage;
	}
	public String getTreamNum() {
		return treamNum;
	}
	public void setTreamNum(String treamNum) {
		this.treamNum = treamNum;
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
		this.userSource = userSource;
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
		this.headIcon = headIcon;
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
		this.photo = photo;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
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
		this.deviceId = deviceId;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
    
	
}
