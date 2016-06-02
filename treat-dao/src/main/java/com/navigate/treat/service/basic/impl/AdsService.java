package com.navigate.treat.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Ads;
import com.navigate.treat.beans.basic.AdsQueryHelper;
import com.navigate.treat.dao.basic.AdsMapper;
import com.navigate.treat.io.ads.response.AdsRes;
import com.navigate.treat.service.basic.IAdsService;

@Service
public class AdsService extends BaseServiceImp<Ads, AdsQueryHelper>
		implements IAdsService {
	AdsMapper adsMapper;

	@Autowired
	public void setAdsMapper(AdsMapper adsMapper) {
		this.adsMapper = adsMapper;
		super.setBaseMapper(baseMapper);
	}

	@Override
	public List<AdsRes> getAds4Postion(Integer positon) {
		// TODO Auto-generated method stub
		return adsMapper.getAds4Postion(positon);
	}
	
	
}
