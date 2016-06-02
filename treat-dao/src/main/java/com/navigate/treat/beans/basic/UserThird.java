/*
 * UserThird.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;

/**
 * 第三方用户表
 * @author 菠萝大象
 * @version 1.0 2015-11-10
 */
public class UserThird implements Serializable {
	/**
	 * 主键自增
	 */
	private Long id;
	/**
	 * 业务唯一数字
	 */
	private Long userId;
	/**
	 * 调用凭证
	 */
	private String refreshToken;
	/**
	 * 刷新凭证
	 */
	private String accessToken;
	/**
	 * 第三方唯一标误
	 */
	private String openId;
	/**
	 * 账号类型@1:微信|2:QQ|3:新浪微博
	 */
	private Integer type;
	/**
	 * 状态
	 */
	private Integer status;
	private static final long serialVersionUID = 1L;

	public UserThird() {
	}
	public UserThird(Long id) {
		this.id=id;
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
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken == null ? null : refreshToken.trim();
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken == null ? null : accessToken.trim();
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		UserThird other = (UserThird) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getRefreshToken() == null ? other.getRefreshToken() == null
						: this.getRefreshToken().equals(other.getRefreshToken()))
				&& (this.getAccessToken() == null ? other.getAccessToken() == null
						: this.getAccessToken().equals(other.getAccessToken()))
				&& (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getRefreshToken() == null) ? 0 : getRefreshToken().hashCode());
		result = prime * result + ((getAccessToken() == null) ? 0 : getAccessToken().hashCode());
		result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		return result;
	}
}
