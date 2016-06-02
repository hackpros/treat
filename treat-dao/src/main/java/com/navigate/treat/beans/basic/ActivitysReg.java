/*
 * ActivitysReg.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-20 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 菠萝大象
 * @version 1.0 2016-04-20
 */
public class ActivitysReg implements Serializable {
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 活动ID
	 */
	private Long actId;
	private Date ctime;
	private Date mtime;
	/**
	 * 报名状态 报名 1 选中参与 2
	 */
	private Integer regStatus;
	/**
	 * 订单号
	 */
	private String orderNum;
	private Date actTime;
	private static final long serialVersionUID = 1L;

	public ActivitysReg(Long actId, Long userId, Integer regStatus, Date actTime) {
		this.actId = actId;
		this.userId = userId;
		this.regStatus = regStatus;
		this.ctime = new Date();
		this.actTime = actTime;
	}
	public ActivitysReg(Long regId, Integer regStatus) {
		this.id = regId;
		this.regStatus = regStatus;
		this.mtime = new Date();
	}
	public ActivitysReg() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Integer getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(Integer regStatus) {
		this.regStatus = regStatus;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
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
		ActivitysReg other = (ActivitysReg) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getActId() == null ? other.getActId() == null : this.getActId().equals(other.getActId()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
				&& (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
				&& (this.getRegStatus() == null ? other.getRegStatus() == null
						: this.getRegStatus().equals(other.getRegStatus()))
				&& (this.getOrderNum() == null ? other.getOrderNum() == null
						: this.getOrderNum().equals(other.getOrderNum()))
				&& (this.getActTime() == null ? other.getActTime() == null
						: this.getActTime().equals(other.getActTime()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getActId() == null) ? 0 : getActId().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
		result = prime * result + ((getRegStatus() == null) ? 0 : getRegStatus().hashCode());
		result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
		result = prime * result + ((getActTime() == null) ? 0 : getActTime().hashCode());
		return result;
	}
}
