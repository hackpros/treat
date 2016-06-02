package com.navigate.treat.api;


import com.navigate.treat.io.pay.request.AliPayReq;



/**
 * 
 * @author huangshiping
 *
 */
public interface IPayServiceFront {

	String callBack(AliPayReq aliPayReq);

	String callBack(String totalFee, String outTradeNo,String result);


}
