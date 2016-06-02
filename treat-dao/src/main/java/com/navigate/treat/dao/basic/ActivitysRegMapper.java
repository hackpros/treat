/*
 * ActivitysRegMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.dao.basic;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.io.activity.response.ActivitysRegRes;

public interface ActivitysRegMapper extends BaseMapper<ActivitysReg, ActivitysRegQueryHelper> {
	@Select("select id regId,userId,regStatus,ctime,orderNum from activitys_reg where actId = #{0} and regStatus > 0")
	List<ActivitysRegRes> findActivityReg4ActId(Long actId);

	@Select("select id,userId,regstatus,actId,ctime,orderNum from activitys_reg where id = #{0}")
	ActivitysRegRes selectActivitysReg4Id(Long regId);

	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@Select("select (select userIdform activitys where id =a.actId) as userId  from activitys_reg a   where actTime between #{startDate} and #{endDate}' and   not exists( select 1 from activitys_reg where actId=a.actId and regstatus=2)group by (actId)")
	@Result(column = "userId", javaType = Long.class)
	List<Long> selectDoubt(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Select("select id,userId,regstatus,actId,ctime,orderNum from activitys_reg where actId =#{0} and userId = #{1}")
	ActivitysRegRes getRegStatus(Long actId, Long userId);
}
