/*
 * AdsMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-21 Created
 */
package com.navigate.treat.dao.basic;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.navigate.treat.base.mapper.single.BaseMapper;
import com.navigate.treat.beans.basic.Ads;
import com.navigate.treat.beans.basic.AdsQueryHelper;
import com.navigate.treat.io.ads.response.AdsRes;

public interface AdsMapper extends BaseMapper<Ads, AdsQueryHelper> {

	@Select("select url,positon,imgUrl,title from ads where status = 1 and positon =#{0}")
	List<AdsRes> getAds4Postion(Integer positon);
}