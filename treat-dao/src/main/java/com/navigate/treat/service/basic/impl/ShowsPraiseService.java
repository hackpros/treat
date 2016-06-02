package com.navigate.treat.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.ShowsPraise;
import com.navigate.treat.beans.basic.ShowsPraiseQueryHelper;
import com.navigate.treat.dao.basic.ShowsPraiseMapper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;
import com.navigate.treat.service.basic.IShowsPraiseService;

@Service
public class ShowsPraiseService extends BaseServiceImp<ShowsPraise, ShowsPraiseQueryHelper>
		implements IShowsPraiseService {
	ShowsPraiseMapper showsPraiseMapper;

	@Autowired
	public void setShowsPraiseMapper(ShowsPraiseMapper showsPraiseMapper) {
		this.showsPraiseMapper = showsPraiseMapper;
		super.setBaseMapper(showsPraiseMapper);
	}

	@Override
	public List<ShowsPraiseRes> getPraiseRankList() {

		return showsPraiseMapper.getPraiseRankList();
	}
	
	
}
