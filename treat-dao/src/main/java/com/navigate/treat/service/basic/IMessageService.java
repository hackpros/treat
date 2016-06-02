/*
 * UserThirdMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-10 Created
 */
package com.navigate.treat.service.basic;

import com.navigate.treat.base.service.single.IBaseService;
import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EOperation;

/**
 * @author fwg create by 2016年3月25日 下午4:33:45
 */
public interface IMessageService extends IBaseService<Message, MessageQueryHelper> {

	void append( Long fuid, Long tuid, Integer mtype, EBizCode  bizCode, String title, String content,
			EOperation operation) ;
}
