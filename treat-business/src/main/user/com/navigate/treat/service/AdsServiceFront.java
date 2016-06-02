package com.navigate.treat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.navigate.treat.api.IAdsServiceFront;
import com.navigate.treat.io.ads.request.AdsReq;
import com.navigate.treat.service.basic.IAdsService;

@Service
public class AdsServiceFront implements IAdsServiceFront {

	@Resource
	private IAdsService adsService;

	@Override
	public Object getAds4Postion(AdsReq adsReq) {
		return new ModelMap().addAttribute("adsList", adsService.getAds4Postion(adsReq.getPositon()));
	}

}
