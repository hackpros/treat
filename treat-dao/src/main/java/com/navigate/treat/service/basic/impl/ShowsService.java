/*
 * ShowsMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-11 Created
 */
package com.navigate.treat.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Shows;
import com.navigate.treat.beans.basic.ShowsQueryHelper;
import com.navigate.treat.dao.basic.ShowsMapper;
import com.navigate.treat.io.show.request.ShowsReq;
import com.navigate.treat.io.show.response.ShowsRes;
import com.navigate.treat.service.basic.IShowsService;

@Service
public class ShowsService extends BaseServiceImp<Shows, ShowsQueryHelper> implements IShowsService {
	ShowsMapper showsMapper;

	@Autowired
	public void setShowsMapper(ShowsMapper showsMapper) {
		this.showsMapper = showsMapper;
		super.setBaseMapper(showsMapper);
	}

	@Override
	public List<ShowsRes> findShows4Page(ShowsReq showsReq) {

		return showsMapper.findShows4Page(showsReq);
	}

	@Override
	public List<ShowsRes> findShowList4UserId(ShowsReq showsReq) {

		return showsMapper.findShowList4UserId(showsReq);
	}

	
}
