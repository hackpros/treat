package com.navigate.treat.service.message.core;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.message.ILittleHelperMessage;
import com.navigate.treat.message.bean.LHMessage;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.message.IMesssageCore;
import com.navigate.treat.util.Constants;

/**
 * 活动报名未确定的消息处理类
 * @author fwg create by 2016年4月15日 上午11:08:32
 */
@Service
public class ActDoubtMesssageCore implements IMesssageCore {
	static final Logger log = LogManager.getLogger(ActDoubtMesssageCore.class);
	@Resource
	IActivitysRegService activitysRegService;
	@Resource
	IMessageService messageService;
	@Resource
	ILittleHelperMessage littleHelperMessage;

	@Override
	public void doExcute(Message message) {
	}
	@Override
	public void doCreateMsg(MessageReq  messageReq) {
		Date endDate = new Date();
		Date startDate = DateUtils.addHours(endDate, -3);
		// 活动3小时内开始未处理报名的发消息
		List<Long> userIds = activitysRegService.selectDoubt(startDate, endDate);
		Message msgMaster = new Message();
		msgMaster.setContent("您的活动还有参与者没有确认,再过3小时就开始了");
		msgMaster.setFuid(Constants.SYS_USERID);
		msgMaster.setTitle("管理参与者");
		msgMaster.setCtime(new Date());
		msgMaster.setIread(false);
		msgMaster.setRun(false);
		msgMaster.setStatus(0);
		msgMaster.setBizCode(ActivityHelper.EBizCode.ADOUBT.ordinal());
		for (Long uid : userIds) {
			msgMaster.setId(null);
			msgMaster.setTuid(uid);
			messageService.insertSelective(msgMaster);
			// 融云推消息未读消息数量
			LHMessage msg = new LHMessage();
			MessageQueryHelper exp = new MessageQueryHelper();
			exp.createCriteria().andTuidEqualTo(uid).andIreadEqualTo(false);
			msg.setRow(messageService.countByExample(exp));
			littleHelperMessage.sendMessage(Constants.SYS_USERID.toString(), new String[] { uid.toString() }, msg);
		}
	}
}
