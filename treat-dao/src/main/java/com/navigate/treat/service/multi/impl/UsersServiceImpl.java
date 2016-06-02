/*
 * UsersMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.service.multi.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.dao.multi.UsersMapper;
import com.navigate.treat.io.user.response.UserHeadRes;
import com.navigate.treat.service.multi.IUsersService;

@Service
public class UsersServiceImpl extends BaseServiceImp<Users, UsersQueryHelper> implements IUsersService {
	UsersMapper usersMapper;

	@Autowired
	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
		super.setBaseMapper(usersMapper);
	}

	@Override
	public UserHeadRes getUserHeads4UserId(Long userId) {
		// TODO Auto-generated method stub
		return usersMapper.getUserHeads4UserId(userId);
	}

	@Override
	public void addBalance(BigDecimal deductions, Long userId) {

		usersMapper.addBalance(deductions, userId);
	}

	@Override
	public void subtractBalance(BigDecimal deductions, Long userId) {
		// TODO Auto-generated method stub
		usersMapper.subtractBalance(deductions, userId);
	}

	@Override
	public BigDecimal getBalance(Long userId) {
		// TODO Auto-generated method stub
		return usersMapper.getBalance(userId) != null ? usersMapper.getBalance(userId) : new BigDecimal("0");
	}

	@Override
	public Date getLastLoginTime(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMobile4UserId(Long userId) {
		return usersMapper.getMobile4UserId(userId);
	}

}
