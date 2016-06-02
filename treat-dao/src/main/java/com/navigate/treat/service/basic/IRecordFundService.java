/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import java.math.BigDecimal;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.basic.RecordFundQueryHelper;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.pay.response.RecordOrderRes;

public interface IRecordFundService extends IBaseService<RecordFund, RecordFundQueryHelper> {
	
	void reFund(RecordOrderRes recordOrder, Long userId, String orderNum);
	
	void append(Long userId, String orderNum, String desc, BigDecimal amount, ConsumerType type);

}
