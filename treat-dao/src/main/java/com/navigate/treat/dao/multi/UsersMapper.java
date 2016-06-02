/*
 * UsersMapper.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.dao.multi;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.io.user.response.UserHeadRes;

public interface UsersMapper extends BaseMapper<Users, UsersQueryHelper> {

	@Update("update users set balance = balance + #{0} where userId = #{1}")
	void addBalance(BigDecimal deductions, Long userId);

	@Update("update users set balance = balance - #{0} where userId = #{1}")
	void subtractBalance(BigDecimal deductions, Long userId);

	@Select("select balance from userInfo where userId = #{0}")
	BigDecimal getBalance(Long userId);

	@Select("select headIcon,sex,birthday,nickName,photo from users where userId = #{0}")
	UserHeadRes getUserHeads4UserId(Long userId);

	@Select("select mobile from users where userId = #{0}")
	String getMobile4UserId(Long userId);
}