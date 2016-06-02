package com.navigate.treat.api;

import com.navigate.treat.base.Pages;
import com.navigate.treat.io.activity.request.ActivitysRegReq;
import com.navigate.treat.io.activity.request.ActivitysReq;

public interface IActivitysServiceFront {
	/**
	 * 发布约会
	 * @param activitysReq
	 * @return
	 */
	Object publishActivitys(ActivitysReq activitysReq);
	/**
	 * 查询活动列表
	 * @param activitysReq
	 * @return
	 */
	Object findActivity4Page(ActivitysReq activitysReq);
	/**
	 * 报名
	 * @param activitysRegReq
	 * @return
	 */
	Object registrationActivitys(ActivitysRegReq activitysRegReq);
	/**
	 * 获取报名列表
	 * @param activitysRegReq
	 * @return
	 */
	Object getRegistrationList(ActivitysRegReq activitysRegReq);
	/**
	 * 活动详情页
	 * @param activitysReq
	 * @return
	 */
	Object getActivitysDetails(ActivitysReq activitysReq);
	/**
	 * 取消报名
	 * @param activitysRegReq
	 * @return
	 */
	Object cancelRegistration(ActivitysRegReq activitysRegReq);
	/**
	 * 选中报名
	 * @param activitysRegReq
	 * @return
	 */
	Object checkedRegistration(ActivitysRegReq activitysRegReq);
	/**
	 * 取消活动
	 * @param activitysReq
	 * @return
	 */
	Object cancelActivitys(ActivitysReq activitysReq);
	
	/**我参发起的活动
	 * @param page
	 * @return
	 */
	Pages<?> selectMaster(Pages<?> page);
	
	/**我参与的活动
	 * @param page
	 * @return
	 */
	Pages<?> selectActor(Pages<?> page);
	/**
	 * 活动自然结束后，数居清算
	 */
	void doCleaning();
	
}
