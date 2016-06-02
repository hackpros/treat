package com.navigate.treat.io.useractivity.request;

import java.io.Serializable;

public class ActCommentUsersReq  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6256556966785138730L;
	/**
	 * 活动Id
	 */
	private Long activityId;
	/**
	 * 发起者还是参与者
	 */
	private Integer role;
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
}
