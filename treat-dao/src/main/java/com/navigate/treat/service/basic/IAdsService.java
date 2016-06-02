package com.navigate.treat.service.basic;

import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.Ads;
import com.navigate.treat.beans.basic.AdsQueryHelper;
import com.navigate.treat.io.ads.response.AdsRes;

public interface IAdsService extends IBaseService<Ads, AdsQueryHelper> {

	List<AdsRes> getAds4Postion(Integer positon);
}
