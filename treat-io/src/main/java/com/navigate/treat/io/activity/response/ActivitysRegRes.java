/*
 * ActivitysReg.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.io.activity.response;

import java.io.Serializable;

import com.navigate.treat.base.BaseDO;
import com.navigate.treat.io.user.response.UserHeadRes;

/**
 * 
 * 
 * @author 菠萝大象
 * @version 1.0 2016-04-07
 */
public class ActivitysRegRes extends BaseDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 报名Id
	 */
	private Long regId;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 活动Id
	 */
	private Long actId;
	/**
	 * 报名状态 报名 1 选中参与 2
	 */
	private Integer regStatus;

	/**
	 * 订单号
	 */
	private String orderNum;

	private UserHeadRes userHeadres = new UserHeadRes();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public Integer getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(Integer regStatus) {
		this.regStatus = regStatus;
	}

	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}

	public UserHeadRes getUserHeadres() {
		return userHeadres;
	}

	public void setUserHeadres(UserHeadRes userHeadres) {
		this.userHeadres = userHeadres;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

}