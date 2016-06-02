/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysQueryHelper;
import com.navigate.treat.dao.basic.ActivitysMapper;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.activity.response.ActivitysRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActStatus;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.util.DateUtil;

@Service
public class ActivitysServiceImpl extends BaseServiceImp<Activitys, ActivitysQueryHelper> implements IActivitysService {
	ActivitysMapper activitysMapper;

	@Autowired
	public void setActivitysMapper(ActivitysMapper activitysMapper) {
		this.activitysMapper = activitysMapper;
		super.setBaseMapper(activitysMapper);
	}

	@Override
	public Activitys transferredActivitys(ActivitysReq activitysReq) {

		Activitys activitys = new Activitys();
		activitys.setUserId(activitysReq.getUserId());
		activitys.setActStatus(ActStatus.ONGOING.ordinal());
		activitys.setActTime(activitysReq.getActTime());
		activitys.setAmountSecured(activitysReq.getAmountSecured());
		activitys.setBizAddr(activitysReq.getBizAddr());
		activitys.setBizAvg(activitysReq.getBizAvg());
		activitys.setBizCategory(activitysReq.getBizCategory());
		activitys.setBizIcon(activitysReq.getBizIcon());
		activitys.setBizId(activitysReq.getBizId());
		activitys.setBizLat(activitysReq.getBizLat());
		activitys.setBizLng(activitysReq.getBizLng());
		activitys.setBizName(activitysReq.getBizName());
		activitys.setBizRate(activitysReq.getBizRate());
		activitys.setBriefDesc(activitysReq.getBriefDesc());
		activitys.setCtime(new Date());
		activitys.setSubsidies(activitysReq.getSubsidies());
		activitys.setTheme(activitysReq.getTheme());
		activitys.setTreatWay(activitysReq.getTreatWay());
		activitys.setUserLng(activitysReq.getUserLng());
		activitys.setUserLat(activitysReq.getUserLat());
		return activitys;
	}

	@Override
	public String getOrderNum(String type, Long actId) {
		return new StringBuilder().append(type).append("-").append(actId).append("-").append(DateUtil.getSysTime()).toString();
	}

	@Override
	public List<ActivitysRes> findActivity4Page(String lat, String lng, Integer offset, Integer length) {
		return activitysMapper.activitysMapper(lat, lng, offset, length);
	}

	@Override
	public ActivitysRes findActivitys4ActId(Long actId) {
		return activitysMapper.findActivitys4ActId(actId);
	}

	@Override
	public void updateBrowseNum4ActId(Long actId) {
		activitysMapper.updateBrowseNum4ActId(actId);
	}

	@Override
	public BigDecimal getAmountSecured4ActId(Long actId) {

		return activitysMapper.getAmountSecured4ActId(actId);
	}

}
