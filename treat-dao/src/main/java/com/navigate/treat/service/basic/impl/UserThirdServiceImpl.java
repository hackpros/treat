/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.UserThird;
import com.navigate.treat.beans.basic.UserThirdQueryHelper;
import com.navigate.treat.dao.basic.UserThirdMapper;
import com.navigate.treat.service.basic.IUserThirdService;

@Service
public class UserThirdServiceImpl extends BaseServiceImp<UserThird, UserThirdQueryHelper> implements IUserThirdService {
	UserThirdMapper userThirdMapper;

	@Autowired
	public void setUserThirdMapper(UserThirdMapper userThirdMapper) {
		this.userThirdMapper = userThirdMapper;
		super.setBaseMapper(userThirdMapper);
	}
}
