package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody UserThirdRegReq userThirdRegReq) {
		return userThirdServiceFront.login(userThirdRegReq);
	};
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Object bindingMobile(@RequestBody UserThirdRegReq userThirdRegReq) {
		return userThirdServiceFront.bindingMobile(userThirdRegReq);
	};
	
}
