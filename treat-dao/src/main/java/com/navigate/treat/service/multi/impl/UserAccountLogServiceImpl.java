/*
 * UserAccountLogMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.service.multi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.multi.UserAccountLog;
import com.navigate.treat.beans.multi.UserAccountLogQueryHelper;
import com.navigate.treat.dao.multi.UserAccountLogMapper;
import com.navigate.treat.service.multi.IUserAccountLogService;

@Service
public class UserAccountLogServiceImpl extends BaseServiceImp<UserAccountLog, UserAccountLogQueryHelper>
		implements IUserAccountLogService {
	UserAccountLogMapper userAccountLogMapper;

	@Autowired
	public void setUserAccountLogMapper(UserAccountLogMapper userAccountLogMapper) {
		this.userAccountLogMapper = userAccountLogMapper;
		super.setBaseMapper(userAccountLogMapper);
	}
}
