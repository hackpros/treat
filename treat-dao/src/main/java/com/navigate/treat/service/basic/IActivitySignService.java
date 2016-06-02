/*
 * ActivitySignMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-11 Created
 */
package com.navigate.treat.service.basic;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.ActivitySignQueryHelper;
import com.navigate.treat.beans.basic.Activitys;

/**
 * 活动签到表
 * @author fwg create by 2016年4月12日 上午9:46:55
 */
public interface IActivitySignService extends IBaseService<ActivitySign, ActivitySignQueryHelper> {
	/**
	 * 活动数据结算
	 * @param id 活动ID
	 * @param masteUid 发起者Id
	 */
	void doBalance(Activitys activitys);

			
}
