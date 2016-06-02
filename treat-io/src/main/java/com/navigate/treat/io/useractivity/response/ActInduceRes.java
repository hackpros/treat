package com.navigate.treat.io.useractivity.response;

import java.io.Serializable;

/**
 * 感应成功对用户
 * @author fwg create by 2015年12月8日 下午7:09:28
 */
public class ActInduceRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7418917519329402726L;
	private Long userId;
	private String lng;
	private String lat;
	private String headIcon;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
}
