/*
 * ShowsPraiseMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.dao.basic;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.ShowsPraise;
import com.navigate.treat.beans.basic.ShowsPraiseQueryHelper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;

public interface ShowsPraiseMapper extends BaseMapper<ShowsPraise, ShowsPraiseQueryHelper> {

	@Select("select userId,count(*) praiseNum from shows_praise where  to_days(ctime) = to_days(now())  GROUP BY userId ORDER BY  praiseNum LIMIT 6;")
	List<ShowsPraiseRes> getPraiseRankList();
}
