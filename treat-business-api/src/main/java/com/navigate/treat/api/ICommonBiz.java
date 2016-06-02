package com.navigate.treat.api;

import com.navigate.treat.io.activity.request.ActivitysReq;

public interface ICommonBiz {
	/**
	 * 发送验证码
	 * @param mobile
	 */
	void sensMsg(String mobile);
	/**
	 * 签到
	 * @param latlnt
	 */
	void sign(ActivitysReq activitysReq);

}
