package com.navigate.treat.service.message.core;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.message.ILittleHelperMessage;
import com.navigate.treat.message.bean.LHMessage;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.message.ISendSysMsg;
import com.navigate.treat.util.Constants;

/**
 * 
 * @author huangshiping 发送小助手消息
 */
@Service
public class SendSysMsg implements ISendSysMsg {
	@Resource
	IMessageService messageService;
	@Resource
	ILittleHelperMessage littleHelperMessage;

	@Override
	public void sendSysMsg(String title, String content, int bizType, Long userId, String args,Date overdueTime) {
		Message message = new Message();
		message.setContent(content);
		message.setTitle(title);
		message.setCtime(new Date());
		message.setIread(false);
		message.setRun(false);
		message.setStatus(0);
		message.setFuid(Constants.SYS_USERID);
		message.setTuid(userId);
		message.setBizCode(bizType);
		message.setMtype((ActivityHelper.EMType.S.ordinal()));
		message.setArgs(args);
		message.setOverdueTime(overdueTime);
		messageService.insertSelective(message);
		LHMessage msg = new LHMessage();
		MessageQueryHelper exp = new MessageQueryHelper();
		exp.createCriteria().andTuidEqualTo(userId).andIreadEqualTo(false);
		msg.setRow(messageService.countByExample(exp));
		littleHelperMessage.sendMessage(Constants.SYS_USERID.toString(), new String[] { userId.toString() }, msg);
	}

}
