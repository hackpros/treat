package com.navigate.treat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.navigate.treat.api.IUserThirdServiceFront;
import com.navigate.treat.io.user.requeset.UserThirdRegReq;

/**
 * 第三方用户
 * @author fwg create by 2016年3月25日 下午4:19:39
 */
@Controller
@RequestMapping(value = "/userThird")
public class UsersThirdController {
	@Resource
	IUserThirdServiceFront userThirdServiceFront;

	@RequestMapping(method = RequestMethod.GET)
	public Model login(Model model, UserThirdRegReq userThirdRegReq) {
		return userThirdServiceFront.login(model, userThirdRegReq);
	};
	@RequestMapping(method = RequestMethod.POST)
	public Model register(Model model, UserThirdRegReq userThirdRegReq) {
		return userThirdServiceFront.register(model, userThirdRegReq);
	};
	@RequestMapping(value = "/isExists", method = RequestMethod.GET)
	public boolean isRegister(Model model, UserThirdRegReq userThirdRegReq) {
		return userThirdServiceFront.isRegister(userThirdRegReq);
	};
}
