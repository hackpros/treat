package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.ICommonBiz;
import com.navigate.treat.io.activity.request.ActivitysReq;

@Controller
@RequestMapping(value = "/common")
public class CommonController {
	// private static final Logger logger =
	// LogManager.getLogger("UserController");
	@Resource
	ICommonBiz commonBiz;

	/**
	 * 发送验证码
	 * 
	 * @param mobile
	 */
	@RequestMapping(value = "/sendCatath/{mobile}")
	@ResponseBody
	public void sendCatath(@PathVariable("mobile") String mobile) {
		commonBiz.sensMsg(mobile);
	};

	/**
	 * 用户签到接口
	 * 
	 * @param mobile
	 */
	@RequestMapping(value = "/sign")
	@ResponseBody
	public void sign(ActivitysReq activitysReq) {
		commonBiz.sign(activitysReq);
	};
}
