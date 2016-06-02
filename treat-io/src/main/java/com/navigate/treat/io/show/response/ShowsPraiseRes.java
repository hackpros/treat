package com.navigate.treat.io.show.response;

import java.io.Serializable;

import com.navigate.treat.base.BaseDO;
import com.navigate.treat.io.user.response.UserHeadRes;

public class ShowsPraiseRes extends BaseDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer praiseNum;
	private Long userId;
	private UserHeadRes userHeadRes = new UserHeadRes();

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserHeadRes getUserHeadRes() {
		return userHeadRes;
	}

	public void setUserHeadRes(UserHeadRes userHeadRes) {
		this.userHeadRes = userHeadRes;
	}

}
