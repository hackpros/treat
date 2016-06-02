/*
 * ActivitysMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-06 Created
 */
package com.navigate.treat.dao.basic;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysQueryHelper;
import com.navigate.treat.io.activity.response.ActivitysRes;

public interface ActivitysMapper extends BaseMapper<Activitys, ActivitysQueryHelper> {

	@Select("SELECT id actId,userId,theme,treatWay,actTime,amountSecured,subsidies,ctime,bizAddr,bizCategory,bizName,browseNum,bizLat,bizLng FROM activitys"
			+ " WHERE actStatus = 1 and actTime > now() and  userLat > #{0} - 1 and userLat < #{0} + 1 and userLng > #{1} - 1 and userLng < #{1} + 1"
			+ " ORDER BY ACOS(SIN((#{0} * 3.1415) / 180) * SIN((userLat * 3.1415) / 180) + COS((#{0} * 3.1415) / 180) * COS((userLat * 3.1415) / 180)"
			+ " * COS((#{1} * 3.1415) / 180 - (userLng * 3.1415) / 180)) * 6380 ASC LIMIT #{2},#{3}")
	List<ActivitysRes> activitysMapper(String lat, String lng, Integer offset, Integer length);

	@Select("SELECT id actId,userId,theme,treatWay,actTime,amountSecured,subsidies,ctime,bizAddr,bizLat,bizLng,bizCategory,bizName,browseNum,orderNum,briefDesc,bizIcon FROM activitys"
			+ " where id = #{0}")
	ActivitysRes findActivitys4ActId(Long actId);

	@Update("update activitys set browseNum = browseNum + 1 where id = #{0}")
	void updateBrowseNum4ActId(Long actId);

	@Select("SELECT amountSecured FROM activitys where id = #{0}")
	BigDecimal getAmountSecured4ActId(Long actId);
}