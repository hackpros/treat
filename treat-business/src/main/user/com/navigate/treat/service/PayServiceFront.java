package com.navigate.treat.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.api.IPayServiceFront;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.basic.RecordFundQueryHelper;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.io.activity.response.ActivitysRes;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.pay.helper.FundsHelper.PayMent;
import com.navigate.treat.io.pay.helper.FundsHelper.PayStatus;
import com.navigate.treat.io.pay.request.AliPayReq;
import com.navigate.treat.io.pay.response.RecordOrderRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActRegStatus;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActStatus;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.basic.IRecordOrderService;
import com.navigate.treat.service.message.ISendSysMsg;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.SendURL;

/**
 * 支付回调业务处理
 * 
 * @author huangshiping
 * 
 */
@Service
public class PayServiceFront implements IPayServiceFront {
	@Resource
	IActivitysService activitysService;
	@Resource
	IRecordOrderService recordOrderService;
	@Resource
	IRecordFundService recordFundService;
	@Resource
	IActivitysRegService activitysRegService;
	@Resource
	ISendSysMsg sendSysMsg;
	private static final Logger logger = LogManager.getLogger(PayServiceFront.class.getName());

	@Override
	public String callBack(AliPayReq aliPayReq) {

		String reslut = "success";
		String url = Constants.ALIPAY_URL;
		String res = SendURL.sendPost(url + aliPayReq.getNotify_id(), "");
		if (!res.equals("true")) {
			return reslut;
		}

		if (StringUtils.isEmpty(aliPayReq.getTrade_status())) {
			return reslut;
		}

		if (aliPayReq.getOut_trade_no() != null && aliPayReq.getTrade_status().equals(Constants.TRADE_SUCCESS)) {
			return updateOrder(aliPayReq.getTotal_fee(), aliPayReq.getOut_trade_no(), reslut, PayMent.ALI_PAY.ordinal());
		}
		return reslut;
	}

	@Override
	public String callBack(String totalFee, String outTradeNo, String reslut) {
		return updateOrder(totalFee, outTradeNo, reslut, PayMent.WEIXIN_PAY.ordinal());
	}

	private String updateOrder(String totalFee, String outTradeNo, String reslut, Integer payment) {
		logger.info("pay success !!!!");
		RecordFundQueryHelper recordFundExample = new RecordFundQueryHelper();
		recordFundExample.createCriteria().andOutTradeNoEqualTo(outTradeNo);
		int count = recordFundService.countByExample(recordFundExample);
		if (count < 1) {
			return reslut;
		}

		List<RecordOrderRes> recordOrderList = recordOrderService.getOrderNum(outTradeNo);
		if (recordOrderList.isEmpty()) {
			logger.info("out_trade_no" + outTradeNo);
			return reslut;
		}

		try {
			for (RecordOrderRes orderRecordRes : recordOrderList) {
				RecordOrder orderRecord = new RecordOrder(orderRecordRes.getId(), PayStatus.PAY.ordinal());
				recordOrderService.updateByPrimaryKeySelective(orderRecord);
				RecordFund recordFund = new RecordFund(orderRecord.getUserId(), orderRecord.getAmount(), payment,
						orderRecord.getOrderNum(), null, orderRecord.getType() == 1 ? "担保金" : "赴约补贴", ConsumerType.SPEND.ordinal());
				recordFundService.insertSelective(recordFund);
			}

			String[] split = outTradeNo.split("-");
			if (split[0].equals(Constants.TREAT_OFF_LINE)) {
				Activitys activits = new Activitys();
				activits.setId(Long.valueOf(split[1]));
				activits.setActStatus(ActStatus.ONGOING.ordinal());
				activits.setMtime(new Date());
				activitysService.updateByPrimaryKeySelective(activits);
			} else if (split[0].equals(Constants.TREAT_REG)) {
				ActivitysReg activitysReg = new ActivitysReg(Long.valueOf(split[1]), ActRegStatus.REG.ordinal());
				activitysRegService.updateByPrimaryKeySelective(activitysReg);
				ActivitysRes activitysRes = activitysService.findActivitys4ActId(activitysReg.getActId());
				JSONObject json = new JSONObject();
				json.put("regId", split[1]);
				sendSysMsg.sendSysMsg("活动报名", "有人报名了你的活动", EBizCode.REG.ordinal(), activitysRes.getUserId(), json.toJSONString(),
						activitysRes.getActTime());
			}

		} catch (NumberFormatException e) {
			logger.info(" pay fail!!!");
			return reslut;
		}
		return reslut;
	}
}
