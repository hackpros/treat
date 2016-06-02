/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.ShowsPraiseRank;
import com.navigate.treat.beans.basic.ShowsPraiseRankQueryHelper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;

public interface IShowsPraiseRankService extends IBaseService<ShowsPraiseRank, ShowsPraiseRankQueryHelper> {

	List<ShowsPraiseRes> getPraiseRankList();

}
