/*
 * MessageMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.api;

import com.navigate.treat.base.Pages;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.message.MessageRes;

public interface IMessageServiceFront {
	/**
	 * 获取小助手消息内容
	 * @param page
	 * @return
	 */
	Pages<MessageRes> getMessage(Pages<?> page);
	/**
	 * 执行消息
	 * @param id
	 * @return
	 */
	void doRun(Long id, MessageReq messageReq);
	/**
	 * 发消息
	 * @param doubt 消息业务类型
	 */
	void doCrateMessage(MessageReq messageReq);
	/**
	 * 测试方法
	 */
	void testTraactional();
	
}
