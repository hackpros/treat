/*
 * UserFriendsMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.service.multi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.multi.UserFriends;
import com.navigate.treat.beans.multi.UserFriendsQueryHelper;
import com.navigate.treat.dao.multi.UserFriendsMapper;
import com.navigate.treat.service.multi.IUserFriendsService;

@Service
public class UserFriendsServiceImpl extends BaseServiceImp<UserFriends, UserFriendsQueryHelper>
		implements IUserFriendsService {
	UserFriendsMapper userFriendsMapper;

	@Autowired
	public void setUserFriendsMapper(UserFriendsMapper userFriendsMapper) {
		this.userFriendsMapper = userFriendsMapper;
		super.setBaseMapper(userFriendsMapper);
	}
}
