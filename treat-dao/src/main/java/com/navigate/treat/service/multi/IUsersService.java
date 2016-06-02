/*
 * UsersMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.service.multi;

import java.math.BigDecimal;
import java.util.Date;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.io.user.response.UserHeadRes;

public interface IUsersService extends IBaseService<Users, UsersQueryHelper> {
	UserHeadRes getUserHeads4UserId(Long userId);
	/**
	 * 获取最后登录时间
	 * @param userId
	 * @return
	 */
	Date getLastLoginTime(Long userId);
	void addBalance(BigDecimal deductions, Long userId);
	void subtractBalance(BigDecimal deductions, Long userId);
	BigDecimal getBalance(Long userId);
	String getMobile4UserId(Long userId);
}
