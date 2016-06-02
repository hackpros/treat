/*
 * Followers.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.io.usercenter.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.navigate.treat.base.io.request.IRequest;

/**
 * ���ѹ�ע�б�
 * @author 菠萝大象
 * @version 1.0 2016-04-19
 */
public class FollowerReq implements IRequest {
	/**
	 * ��������
	 */
	private Long id;
	/**
	 * �û�Id
	 */
	private Long userId;
	/**
	 * ��˿Id
	 */
	@NotNull(message = "关注对能不空")
	private Long followerUserId;
	/**
	 * ��עʱ��
	 */
	private Date ctime;

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
	public Long getFollowerUserId() {
		return followerUserId;
	}
	public void setFollowerUserId(Long followerUserId) {
		this.followerUserId = followerUserId;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
		FollowerReq other = (FollowerReq) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getFollowerUserId() == null ? other.getFollowerUserId() == null
						: this.getFollowerUserId().equals(other.getFollowerUserId()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getFollowerUserId() == null) ? 0 : getFollowerUserId().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		return result;
	}
}
