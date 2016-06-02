package com.navigate.treat.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.ShowsPraiseRank;
import com.navigate.treat.beans.basic.ShowsPraiseRankQueryHelper;
import com.navigate.treat.dao.basic.ShowsPraiseRankMapper;
import com.navigate.treat.io.show.response.ShowsPraiseRes;
import com.navigate.treat.service.basic.IShowsPraiseRankService;

@Service
public class ShowPraiseRankService extends BaseServiceImp<ShowsPraiseRank, ShowsPraiseRankQueryHelper> implements IShowsPraiseRankService {
	ShowsPraiseRankMapper showsPraiseRankMapper;
	@Autowired
	public void setShowsPraiseRankMapper(ShowsPraiseRankMapper showsPraiseRankMapper) {
		this.showsPraiseRankMapper = showsPraiseRankMapper;
		super.setBaseMapper(baseMapper);
	}
	@Override
	public List<ShowsPraiseRes> getPraiseRankList() {
		// TODO Auto-generated method stub
		return showsPraiseRankMapper.getPraiseRankList();
	}

	

}
