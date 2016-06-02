package com.navigate.treat.api;

import com.navigate.treat.io.user.requeset.UserThirdRegReq;

/**
 * 第三方用户登录接口
 * @author fwg
 */
public interface IUserThirdServiceFront {
	/**
	 * 登录/注册
	 * @param model
	 * @param userThirdRegReq
	 * @return
	 */
	Object login(UserThirdRegReq userThirdRegReq);
	/**
	 * 绑定手机号
	 * @param userThirdRegReq
	 * @return
	 */
	Object bindingMobile(UserThirdRegReq userThirdRegReq);
}
