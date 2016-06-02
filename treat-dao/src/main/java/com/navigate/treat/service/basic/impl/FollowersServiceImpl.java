/*
 * FollowersMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Followers;
import com.navigate.treat.beans.basic.FollowersQueryHelper;
import com.navigate.treat.dao.basic.FollowersMapper;
import com.navigate.treat.service.basic.IFollowersService;

@Service
public class FollowersServiceImpl extends BaseServiceImp<Followers, FollowersQueryHelper> implements IFollowersService {
	FollowersMapper followersMapper;

	@Autowired
	public void setFollowersMapper(FollowersMapper followersMapper) {
		this.followersMapper = followersMapper;
		super.setBaseMapper(followersMapper);
	}
}
