/*
 * MessageMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.api.IMessageServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.exception.ParamValidateException;
import com.navigate.treat.io.message.MessageHelper;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.message.MessageRes;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EOperation;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.message.MessageWorkerTemplete;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.SpringBeanUtils;
import com.navigate.treat.util.UserUtil;

/**
 * 小助手消息
 * @author fwg create by 2016年4月8日 下午2:16:13
 */
@Service
public class MessageServiceFront implements IMessageServiceFront {
	static final Logger log = LogManager.getLogger(MessageServiceFront.class);
	@Resource
	IMessageService messageService;
	@Resource
	IActivitySignService activitySignService;

	@Override
	public Pages<MessageRes> getMessage(Pages<?> page) {
		UsersLoginRes user = UserUtil.getUsers();
		MessageQueryHelper example = new MessageQueryHelper();
		example.createCriteria().andTuidEqualTo(user.getUserId());
		example.setOrderByClause("run desc ,ctime asc ");
		PageHelper.startPage(page.getOffset(), page.getLength());
		List<Message> list = messageService.selectByExample(example);
		PageInfo<Message> pages = new PageInfo<Message>(list);
		List<MessageRes> messageResList = new ArrayList<MessageRes>();
		for (Message message : pages.getList()) {
			MessageRes res = new MessageRes();
			SpringBeanUtils.copyProperties(message, res);
			messageResList.add(res);
		}
		return new Pages<MessageRes>(messageResList, page.getTotal(), page.getOffset(), page.getLength());
	}
	@Override
	public void doRun(Long id, MessageReq messageReq) {
		if (messageReq.getOperation() == EOperation.READ.ordinal()) {
			throw new ParamValidateException("本消息是只读消息");
		}
		
		UsersLoginRes user = UserUtil.getUsers();
		Message message = messageService.selectByPrimaryKey(new Message(id));
		if (message.getTuid().longValue() != user.getUserId().longValue()) {
			throw new ParamValidateException(ResponseCode.FAIL_SYS_BAD_REQUEST.getDesc());
		}
		if (message.getRun().booleanValue() == false) {
			throw new ParamValidateException("本消息已经处理");
		}
		// 过期时间检查
		if (message.getOverdueTime() != null) {
			if (message.getOverdueTime().after(new Date())) {
				throw new BusinessException("消息已经过期");
			}
		}
		if (messageReq.getResult() == MessageHelper.EResult.AGREE) {
			// 执行消息
			MessageWorkerTemplete.getWorker(message).doExcute(message);
		}
		// 更新消息执行状态
		message = new Message(id);
		message.setRun(true);
		messageService.updateByPrimaryKey(message);
	}
	@Override
	public void doCrateMessage(MessageReq messageReq) {
		if (messageReq.getOperation() == EOperation.READ.ordinal()) {
			doCrateReadMessage(messageReq);
		} else if (messageReq.getOperation() == EOperation.EXCUTE.ordinal()) {
			MessageWorkerTemplete.getWorker(messageReq.getBizCode()).doCreateMsg(messageReq);
		}
	}
	/**
	 * 退
	 */
	private void doCrateReadMessage(MessageReq msgMaster){
		Message msg = new Message();
		SpringBeanUtils.copyProperties(msgMaster, msg);
		msg.setBizCode(ActivityHelper.EBizCode.DEF.ordinal());
		messageService.insertSelective(msg);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void testTraactional() {
		Message msgMaster = new Message();
		msgMaster.setContent("事务测试");
		msgMaster.setFuid(Constants.SYS_USERID);
		msgMaster.setTitle("管理参与者");
		msgMaster.setCtime(new Date());
		msgMaster.setIread(false);
		msgMaster.setRun(false);
		msgMaster.setStatus(0);
		msgMaster.setBizCode(ActivityHelper.EBizCode.ADOUBT.ordinal());
		msgMaster.setId(null);
		msgMaster.setTuid(12L);
		msgMaster.setMtype(1);
		msgMaster.setOverdueTime(new Date());
		long count = messageService.insertSelective(msgMaster);
		if (count > 0)
			throw new BusinessException("本消息已经处理");
		msgMaster = new Message();
		msgMaster.setContent("事务测试");
		msgMaster.setFuid(Constants.SYS_USERID);
		msgMaster.setTitle("管理参与者");
		msgMaster.setCtime(new Date());
		msgMaster.setIread(false);
		msgMaster.setRun(false);
		msgMaster.setStatus(0);
		msgMaster.setBizCode(ActivityHelper.EBizCode.ADOUBT.ordinal());
		msgMaster.setId(null);
		msgMaster.setTuid(12L);
		messageService.insertSelective(msgMaster);
	}
}
