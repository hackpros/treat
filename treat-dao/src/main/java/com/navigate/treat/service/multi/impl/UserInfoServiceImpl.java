/*
 * UserInfoMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.service.multi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.multi.UserInfo;
import com.navigate.treat.beans.multi.UserInfoQueryHelper;
import com.navigate.treat.dao.multi.UserInfoMapper;
import com.navigate.treat.service.multi.IUserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImp<UserInfo, UserInfoQueryHelper> implements IUserInfoService {
	UserInfoMapper userInfo;

	@Autowired
	public void setUserInfo(UserInfoMapper userInfo) {
		this.userInfo = userInfo;
		super.setBaseMapper(userInfo);
	}


}
