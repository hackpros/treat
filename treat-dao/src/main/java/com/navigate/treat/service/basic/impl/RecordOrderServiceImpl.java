/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.beans.basic.RecordOrderQueryHelper;
import com.navigate.treat.dao.basic.RecordOrderMapper;
import com.navigate.treat.io.pay.response.RecordOrderRes;
import com.navigate.treat.service.basic.IRecordOrderService;

@Service
public class RecordOrderServiceImpl extends BaseServiceImp<RecordOrder, RecordOrderQueryHelper> implements IRecordOrderService {
	RecordOrderMapper recordOrderMapper;

	@Autowired
	public void setRecordOrderMapper(RecordOrderMapper recordOrderMapper) {
		this.recordOrderMapper = recordOrderMapper;
		super.setBaseMapper(recordOrderMapper);
	}

	@Override
	public List<RecordOrderRes> getOrderNum(String out_trade_no) {
		return recordOrderMapper.getOrderNum(out_trade_no);
	}

	@Override
	public int updateStatusByFollower(Long id,int status) {
		return recordOrderMapper.updateStatusByFollower(id,status);
	}

	@Override
	public int updateStatus(String orderNumber,int status) {
		return recordOrderMapper.updateStatus(orderNumber, status);
		
	}

}
