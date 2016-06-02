package com.navigate.treat.io.useractivity.request;

import java.io.Serializable;

/**
 * 
 * 活动详情查询对象
 *
 */
public class ActPunihReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5377910124362504815L;

	/**
	 * 活动Id
	 */
	private Long activityId;

	/**
	 * 处罚类型
	 * see UsersHeper.EAppointmentResult
	 */
	private String appointment;

	/**
	 * 受处理人Id
	 */
	private Long tarUserId;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public Long getTarUserId() {
		return tarUserId;
	}

	public void setTarUserId(Long tarUserId) {
		this.tarUserId = tarUserId;
	}

	
	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

}
