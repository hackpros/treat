/**
 * 
 * UsersController.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.rest.control;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IPayServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.pay.request.AliPayReq;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.MD5;

/**
 * 
 * @author huangshiping 支付回调
 */
@Controller
@RequestMapping(value = "/callback")
public class PayController extends BaseController {
	static final Logger log = Logger.getLogger(PayController.class.getName());
	@Resource
	IPayServiceFront payServiceFront;

	@RequestMapping(value = "/aliPay", method = RequestMethod.GET)
	@ResponseBody
	public String aliPay(@Validated AliPayReq aliPayReq) {

		return payServiceFront.callBack(aliPayReq);
	}

	@RequestMapping(value = "/weiXinPay", method = RequestMethod.GET)
	@ResponseBody
	public String weiXinPay(@Validated HttpServletRequest request) {
		String result = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";

		Document inputdoc = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			inputdoc = builder.build(request.getInputStream());
		} catch (Exception e) {
			logger.error("weixinpay exception!");
			return result;
		}

		if (inputdoc == null) {
			return result;
		}
		Element root_in = inputdoc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = root_in.getChildren();
		Map<String, String> payParams = new HashMap<String, String>();
		String sign = root_in.getChild("sign").getText();
		String totalFee = root_in.getChild("total_fee").getText();
		String outTradeNo = root_in.getChild("out_trade_no").getText();
		for (Element em : list) {
			if (em.getText() != null && !"".equals(em.getName()) && !em.getName().equals("sign")) {
				payParams.put(em.getName(), em.getText());
			}
		}
		String[] keyArray2 = payParams.keySet().toArray(new String[0]);
		Arrays.sort(keyArray2);
		StringBuilder paySb = new StringBuilder();
		for (String key : keyArray2) {
			paySb.append(key).append("=").append(payParams.get(key)).append("&");
		}
		paySb.append("key=").append(Constants.WX_PAY_KEY);
		String paySign = MD5.md5(paySb.toString()).toUpperCase();
		if (paySign.equals(sign)) {
			return payServiceFront.callBack(totalFee, outTradeNo, result);
		}
		return result;
	}
}
