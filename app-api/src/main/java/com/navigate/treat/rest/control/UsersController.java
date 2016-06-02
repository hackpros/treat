/**
 * 
 * UsersController.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IUsersServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.SystemValidation;
import com.navigate.treat.io.user.requeset.UsersReq;

@Controller
@RequestMapping(value = "/users")
public class UsersController extends BaseController {
	static final Logger log = Logger.getLogger(UsersController.class);
	@Resource
	IUsersServiceFront userServiceFront;

	/**
	 * 登录
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object login(@Validated(value = SystemValidation.LoginValidation.class) UsersReq usersReq,
			BindingResult bindingResult) {
		return userServiceFront.login(usersReq);
	}

	/**
	 * 注册
	 * 
	 * @param usersReq
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object register(@Validated(value = SystemValidation.LoginValidation.class) @RequestBody UsersReq usersReq,
			BindingResult bindingResult) {
		return userServiceFront.register(usersReq);
	}

	/**
	 * 修改登录信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{uid}", method = RequestMethod.PUT)
	@ResponseBody
	public Object modifySimple(@PathVariable("uid") Long userId,
			@Validated(value = SystemValidation.ModifyLoginInfoValidation.class) @RequestBody UsersReq usersReq,
			BindingResult bindingResult) {
		usersReq.setUserId(userId);
		return userServiceFront.modifySimple(usersReq);
	}

	/**
	 * 修改个人信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void modify(@RequestBody UsersReq usersReq) {
		userServiceFront.modify(usersReq);
	}
}
