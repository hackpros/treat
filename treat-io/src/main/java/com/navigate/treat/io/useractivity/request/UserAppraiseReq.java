/*
 * UserAppraise.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-27 Created
 */
package com.navigate.treat.io.useractivity.request;

import java.io.Serializable;

/**
 * 用户活动评价表
 * @author 菠萝大象
 * @version 1.0 2015-11-27
 */
public class UserAppraiseReq implements Serializable {
	private static final long serialVersionUID = 1999059653812344220L;
	/**
	 * 评价人
	 */
	private Long userId;
	/**
	 * 活动Id
	 */
	private Long activityId;
	/**
	 * 评价类型@
	 */
	private Integer appraiseType[];

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Integer[] getAppraiseType() {
		return appraiseType;
	}
	public void setAppraiseType(Integer[] appraiseType) {
		this.appraiseType = appraiseType;
	}
	
}
