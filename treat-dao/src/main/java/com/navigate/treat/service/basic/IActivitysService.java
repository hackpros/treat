/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import java.math.BigDecimal;
import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysQueryHelper;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.activity.response.ActivitysRes;

public interface IActivitysService extends IBaseService<Activitys, ActivitysQueryHelper> {

	/**
	 * 转换活动对象
	 * 
	 * @param activitysReq
	 * @return
	 */
	Activitys transferredActivitys(ActivitysReq activitysReq);

	/**
	 * 获取订单号
	 * 
	 * @param type
	 * @param actId
	 * @return
	 */
	String getOrderNum(String type, Long actId);

	/**
	 * 分页获取进行中的活动按照距离排序
	 * 
	 * @param lat
	 * @param lng
	 * @param offset
	 * @param length
	 * @return
	 */
	List<ActivitysRes> findActivity4Page(String lat, String lng, Integer offset, Integer length);

	/**
	 * 根据活动Id获取活动信息
	 * @param actId
	 * @return
	 */
	ActivitysRes findActivitys4ActId(Long actId);

	/**
	 * 修改浏览次数
	 * @param actId
	 */
	void updateBrowseNum4ActId(Long actId);

	/**
	 * 获取担保金
	 * @param actId
	 * @return
	 */
	BigDecimal getAmountSecured4ActId(Long actId);

}
