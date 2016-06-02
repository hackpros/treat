/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.dao.basic.MessageMapper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EOperation;
import com.navigate.treat.service.basic.IMessageService;

/**
 * @author fwg create by 2016年3月25日 下午4:33:45
 */
@Service
public class MessageServiceImpl extends BaseServiceImp<Message, MessageQueryHelper> implements IMessageService {
	MessageMapper messageMapper;

	@Autowired
	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
		super.setBaseMapper(messageMapper);
	}
	@Override
	public void append(Long fuid, Long tuid, Integer mtype, EBizCode bizCode, String title, String content,
			EOperation operation) {
		Message t = new Message();
		t.setFuid(fuid);
		t.setTuid(tuid);
		t.setMtype(mtype);
		t.setBizCode(bizCode.ordinal());
		t.setTitle(title);
		t.setContent(content);
		t.setOperation(operation.ordinal());
		t.setCtime(new Date());
		t.setIread(false);
		t.setRun(false);
		t.setStatus(0);
		t.setOverdueTime(new Date());
		messageMapper.insert(t);
	}
}
