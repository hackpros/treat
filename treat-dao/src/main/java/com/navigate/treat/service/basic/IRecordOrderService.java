/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import java.util.List;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.beans.basic.RecordOrderQueryHelper;
import com.navigate.treat.io.pay.response.RecordOrderRes;

public interface IRecordOrderService extends IBaseService<RecordOrder, RecordOrderQueryHelper> {
	
	List<RecordOrderRes> getOrderNum(String out_trade_no);
	
	int updateStatusByFollower(Long id, int status);
	
	int updateStatus(String orderNumber, int status);



}
