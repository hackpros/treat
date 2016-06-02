/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.basic.RecordFundQueryHelper;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.dao.basic.RecordFundMapper;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.pay.helper.FundsHelper.PayMent;
import com.navigate.treat.io.pay.helper.FundsHelper.PayStatus;
import com.navigate.treat.io.pay.response.RecordOrderRes;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.basic.IRecordOrderService;
import com.navigate.treat.service.multi.IUsersService;

@Service
public class RecordFundServiceImpl extends BaseServiceImp<RecordFund, RecordFundQueryHelper>
		implements IRecordFundService {
	RecordFundMapper recordFundMapper;

	@Autowired
	public void setRecordFundMapper(RecordFundMapper recordFundMapper) {
		this.recordFundMapper = recordFundMapper;
		super.setBaseMapper(recordFundMapper);
	}
	
	@Resource
	IRecordOrderService recordOrderService;
	@Resource
	IUsersService usersService;
	
	@Override
	public void reFund(RecordOrderRes recordOrder, Long userId, String orderNum) {
		usersService.addBalance(recordOrder.getAmount(), userId);
		RecordOrder record=new RecordOrder(userId,PayStatus.BACK.ordinal());
		recordOrderService.updateByPrimaryKeySelective(record);
		RecordFund recordFund = new RecordFund(userId, recordOrder.getAmount(), PayMent.BACK.ordinal(), orderNum, null,
				recordOrder.getType() == 1 ? "担保金退款" : "赴约补贴退款", ConsumerType.INCOME.ordinal());
		recordFundMapper.insertSelective(recordFund);
	}
	@Override
	public void append(Long userId, String orderNum,String desc, BigDecimal amount,ConsumerType type) {
		
		RecordFund recordFund = new RecordFund();
		recordFund.setUserId(userId);
		recordFund.setCtime(new Date());
		recordFund.setDescriptions(desc);
		recordFund.setPlusMinus( type.ordinal());
		recordFund.setAmount(amount);
		recordFund.setType(0);
		recordFundMapper.insertSelective(recordFund);
	}
}
