/**
 * 
 * UsersController.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.navigate.treat.api.IUsersServiceFront;
import com.navigate.treat.io.user.requeset.UserModifyMobileReq;
import com.navigate.treat.io.user.requeset.UsersReq;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
	static final Logger log =  LogManager.getLogger(UsersController.class);
	@Resource
	IUsersServiceFront userServiceFront;

	/**
	 * 登录/注册
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Object login(Model model, UsersReq usersReq) {
		return userServiceFront.login(model,usersReq);
	}
	/**
	 * 注册
	 * @param usersReq
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Object register(UsersReq usersReq) {
		
		return userServiceFront.register(usersReq);
	}
	/**
	 * 修改信息
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Object modify(UserModifyMobileReq userModifyMobileReq) {
		return userServiceFront.modify(userModifyMobileReq);
	}
	
}
