package com.navigate.treat.api;

import com.navigate.treat.io.user.requeset.UsersReq;

public interface IUsersServiceFront {
	/**
	 * 登录
	 * @param usersReq
	 * @return
	 */
	Object login(UsersReq usersReq);
	/**
	 * 注册
	 * @param usersReq
	 * @return
	 */
	Object register(UsersReq usersReq);
	/**
	 * 修改登录信息
	 * @param userModifyMobileReq
	 * @return
	 */
	Object modifySimple(UsersReq usersReq);
	/**
	 * 修改个人信息
	 * @param usersReq
	 * @return
	 */
	void modify(UsersReq usersReq);
	
	/**
	 * 1.0同步注册
	 * @param usersReq
	 * @return
	 */
	@Deprecated
	Object registerV1(UsersReq usersReq);
	/**
	 * 1.0同步修改
	 * @param usersReq
	 * @return
	 */
	@Deprecated
	Object modifyV1(UsersReq usersReq);
}
