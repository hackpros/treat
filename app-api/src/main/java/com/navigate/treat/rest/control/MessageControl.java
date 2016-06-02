/**
 * 
 * MessageControl.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IMessageServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.message.MessageRes;

/**
 * 系统消息
 * 
 * @author fwg create by 2016年4月8日 下午2:42:18
 * 
 * @author fwg create by 2016年4月8日 下午2:42:18
 */
@Controller
@RequestMapping(value = "/message")
public class MessageControl {
	static final Logger log = Logger.getLogger(MessageControl.class);
	@Resource
	IMessageServiceFront messageServiceFront;

	/**
	 * 小助手消息查询
	 * @param userThirdRegReq
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Pages<MessageRes> select(Pages<?> page) {

		return messageServiceFront.getMessage(page);
	}
	/**
	 * 发某一条消息
	 * @param page
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void sendMsg(@RequestBody MessageReq messageReq) {
		messageServiceFront.doCrateMessage(messageReq);
	}
	
	/**
	 * 执行一条消息
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	@ResponseBody
	public void run(@PathVariable Long id,@RequestBody @Validated  MessageReq messageReq,BindingResult bindingResult) {
		messageServiceFront.doRun(id,messageReq);
	}
}
