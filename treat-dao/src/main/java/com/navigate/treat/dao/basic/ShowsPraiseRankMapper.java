/*
 * ShowsPraiseRankMapper.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-26 Created
 */
package com.navigate.treat.dao.basic;

import java.util.List;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.ShowsPraiseRank;
import com.navigate.treat.beans.basic.ShowsPraiseRankQueryHelper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;

public interface ShowsPraiseRankMapper extends BaseMapper<ShowsPraiseRank, ShowsPraiseRankQueryHelper> {

	List<ShowsPraiseRes> getPraiseRankList();
}