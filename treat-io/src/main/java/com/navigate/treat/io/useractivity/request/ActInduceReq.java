package com.navigate.treat.io.useractivity.request;

import java.io.Serializable;

/**
 * 
 * 用户感应请求对象
 *
 */
public class ActInduceReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 活动Id
	 */
	private Long activityId;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 纬度
	 */
	private String lat;
	/**
	 * 是否第一次进来
	 */
	private int frist;
	
	public int getFrist() {
		return frist;
	}
	public void setFrist(int frist) {
		this.frist = frist;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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
