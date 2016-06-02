package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IAdsServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.ads.request.AdsReq;

@Controller
@RequestMapping(value = "/ads")
public class AdsController extends BaseController {
	@Resource
	IAdsServiceFront adsServiceFront;

	/**
	 * 获取广告
	 * @param adsReq
	 * @return
	 */
	@RequestMapping(value = "/getAds", method = RequestMethod.POST)
	@ResponseBody
	public Object getAds(@RequestBody @Validated AdsReq adsReq) {
		return adsServiceFront.getAds4Postion(adsReq);
	}
}
