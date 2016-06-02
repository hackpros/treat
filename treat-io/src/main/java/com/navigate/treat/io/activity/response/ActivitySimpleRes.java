package com.navigate.treat.io.activity.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的活动列表参数
 * @author fwg create by 2016年5月9日 上午11:47:25
 */
public class ActivitySimpleRes implements Serializable {
	/**
	 * 活动Id
	 */
	private Long actId;
	/**
	 * 发起人头像
	 */
	private String headIcon;
	/**
	 * 
	 */
	private int sex;
	/**
	 * 活动状态 报名中,进行中，已结束，已关闭
	 */
	private String status;
	/**
	 * 商家ID
	 */
	private Long bizId;
	/**
	 * 商家名称
	 */
	private String bizName;
	/**
	 * 商家地址
	 */
	private String bizAddr;
	/**
	 * 请客时间
	 */
	private Date actTime;
	private static final long serialVersionUID = 1L;

	public Long getActId() {
		return actId;
	}
	public void setActId(Long actId) {
		this.actId = actId;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBizId() {
		return bizId;
	}
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	public String getBizAddr() {
		return bizAddr;
	}
	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
}
