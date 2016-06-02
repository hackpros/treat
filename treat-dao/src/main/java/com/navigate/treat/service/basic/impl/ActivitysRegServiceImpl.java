/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.dao.basic.ActivitysRegMapper;
import com.navigate.treat.io.activity.response.ActivitysRegRes;
import com.navigate.treat.service.basic.IActivitysRegService;

@Service
public class ActivitysRegServiceImpl extends BaseServiceImp<ActivitysReg, ActivitysRegQueryHelper>
		implements IActivitysRegService {
	ActivitysRegMapper activitysRegMapper;

	@Autowired
	public void setActivitysRegMapper(ActivitysRegMapper activitysRegMapper) {
		this.activitysRegMapper = activitysRegMapper;
		super.setBaseMapper(activitysRegMapper);
	}
	@Override
	public List<ActivitysRegRes> findActivityReg4ActId(Long actId) {
		// TODO Auto-generated method stub
		return activitysRegMapper.findActivityReg4ActId(actId);
	}
	@Override
	public ActivitysRegRes selectActivitysReg4Id(Long regId) {
		return activitysRegMapper.selectActivitysReg4Id(regId);
	}
	
	public ActivitysRegRes getRegStatus(Long actId, Long userId) {
		return activitysRegMapper.getRegStatus(actId, userId);
	}
	
	@Override
	public List<Long> selectDoubt(Date startDate, Date endDate) {
		return activitysRegMapper.selectDoubt(startDate, endDate);
	}
	@Override
	public boolean existAmountSecured(Long id, Long userId) {
		ActivitysRegQueryHelper e=new ActivitysRegQueryHelper();
		e.createCriteria().andActIdEqualTo(id).andUserIdEqualTo(userId).andOrderNumIsNotNull();
		 return  activitysRegMapper.countByExample(e)>0;
	}
	
	

}
