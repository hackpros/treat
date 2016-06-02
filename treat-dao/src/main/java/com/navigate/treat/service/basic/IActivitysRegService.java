/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.io.activity.response.ActivitysRegRes;

@Service
public interface IActivitysRegService extends IBaseService<ActivitysReg, ActivitysRegQueryHelper> {

	/**
	 * @param actId
	 * @return
	 */
	List<ActivitysRegRes> findActivityReg4ActId(Long actId);

	/**
	 * @param regId
	 * @return
	 */
	ActivitysRegRes selectActivitysReg4Id(Long regId);
	/**
	 * @param actId
	 * @param userId
	 * @return
	 */
	ActivitysRegRes getRegStatus(Long actId, Long userId);

	/**
	 * 查询已报名且未处理的用户
	 * 
	 * @param startDate
	 *            起始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	List<Long> selectDoubt(Date startDate, Date endDate);
	/**
	 * 查询活动参与者是否使用了担保金
	 * @param id
	 * @param userId
	 * @return
	 */
	boolean existAmountSecured(Long id, Long userId);

}
