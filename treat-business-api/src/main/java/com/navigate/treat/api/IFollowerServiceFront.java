package com.navigate.treat.api;

import com.navigate.treat.base.Pages;
import com.navigate.treat.io.usercenter.request.FollowerReq;

public interface IFollowerServiceFront {
	/**
	 * @param page
	 * @return
	 */
	Object select(Pages<?> page);
	/**
	 * 取消 关注
	 * @param followerReq
	 */
	void delete(FollowerReq followerReq);
	/**
	 * 关注
	 * @param followerReq
	 */
	void insert(FollowerReq followerReq);
}
