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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IActivitysServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.activity.request.ActivitysRegReq;
import com.navigate.treat.io.activity.request.ActivitysReq;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController extends BaseController {
	static final Logger log = Logger.getLogger(ActivityController.class);
	@Resource
	IActivitysServiceFront activitysServiceFront;

	/**
	 * 发布活动
	 * @param activitysReq
	 * @return
	 */
	@RequestMapping(value = "/publishActivity", method = RequestMethod.POST)
	@ResponseBody
	public Object publishActivity(@RequestBody @Validated ActivitysReq activitysReq) {
		return activitysServiceFront.publishActivitys(activitysReq);
	}
	/**
	 * 获取首页列表数据
	 * @param activitysReq
	 * @return
	 */
	@RequestMapping(value = "/getHomeActivityList", method = RequestMethod.POST)
	@ResponseBody
	public Object getHomeActivityList(@RequestBody @Validated ActivitysReq activitysReq) {
		return activitysServiceFront.findActivity4Page(activitysReq);
	}
	/**
	 * 活动详情页
	 * @param activitysReq
	 * @return
	 */
	@RequestMapping(value = "/activitysDetails", method = RequestMethod.POST)
	@ResponseBody
	public Object activitysDetails(@RequestBody @Validated ActivitysReq activitysReq) {
		return activitysServiceFront.getActivitysDetails(activitysReq);
	}
	/**
	 * 活动取消
	 * @param activitysReq
	 * @return
	 */
	@RequestMapping(value = "/cancelActivitys", method = RequestMethod.POST)
	@ResponseBody
	public Object cancelActivitys(@RequestBody @Validated ActivitysReq activitysReq) {
		return activitysServiceFront.cancelActivitys(activitysReq);
	}
	/**
	 * 活动报名
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/registrationActivitys", method = RequestMethod.POST)
	@ResponseBody
	public Object registrationActivitys(@RequestBody @Validated ActivitysRegReq activitysRegReq) {
		return activitysServiceFront.registrationActivitys(activitysRegReq);
	}
	/**
	 * 活动报名管理
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/registrationList", method = RequestMethod.POST)
	@ResponseBody
	public Object getRegistrationList(@RequestBody @Validated ActivitysRegReq activitysRegReq) {
		return activitysServiceFront.getRegistrationList(activitysRegReq);
	}
	/**
	 * 活动报名取消
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/cancelRegistration", method = RequestMethod.POST)
	@ResponseBody
	public Object cancelRegistration(@RequestBody @Validated ActivitysRegReq activitysRegReq) {
		return activitysServiceFront.cancelRegistration(activitysRegReq);
	}
	/**
	 * 活动报名选中
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/checkedRegistration", method = RequestMethod.POST)
	@ResponseBody
	public Object checkedRegistration(@RequestBody @Validated ActivitysRegReq activitysRegReq) {
		return activitysServiceFront.checkedRegistration(activitysRegReq);
	}
	/**
	 * 个人中心-我的活动列表(发起的)
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/master", method = RequestMethod.POST)
	@ResponseBody
	public Pages<?> selectMaster(@RequestBody  Pages<?> page) {
		return activitysServiceFront.selectMaster(page);
	}
	/**
	 *  * 个人中心-我的活动列表(参与的)
	 * @param activitysRegReq
	 * @return
	 */
	@RequestMapping(value = "/actor", method = RequestMethod.POST)
	@ResponseBody
	public Pages<?> selectActor(@RequestBody Pages<?> page) {
		return activitysServiceFront.selectActor(page);
	}
	
}
