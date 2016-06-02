/*
 * Followers.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.io.usercenter.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 菠萝大象
 * @version 1.0 2016-04-19
 */
public class FollowerRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 业务唯一数字ID
	 */
	private Long userId;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 性别 男 1 女 2
	 */
	private Integer sex;
	/**
	 * 注册时间
	 */
	private Date ctime;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 头像
	 */
	private String headIcon;
	/**
	 * 签名
	 */
	private String signature;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}	
	
	
	
}
