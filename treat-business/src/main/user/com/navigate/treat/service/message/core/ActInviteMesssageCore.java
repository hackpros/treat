package com.navigate.treat.service.message.core;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.exception.ParamValidateException;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.message.ILittleHelperMessage;
import com.navigate.treat.message.bean.LHMessage;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.message.IMesssageCore;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.UserUtil;

/**
 * 活动邀请报名
 * @author fwg create by 2016年4月15日 上午11:08:32
 */
@Service
public class ActInviteMesssageCore implements IMesssageCore {
	static final Logger log = LogManager.getLogger(ActInviteMesssageCore.class);
	@Resource
	IMessageService messageService;
	@Resource
	ILittleHelperMessage littleHelperMessage;
	@Resource
	IActivitysService activitysService;
	@Resource
	IActivitysRegService activitysRegService;

	@Override
	public void doExcute(Message message) {
	}
	@Override
	public void doCreateMsg(MessageReq  messageReq) {
		UsersLoginRes user=UserUtil.getUsers();
		// 验证活动是否正确
		Activitys activitys=activitysService.selectByPrimaryKey(new Activitys(messageReq.getActivityId()));
		//活动已结束
		if (activitys.getActTime().before(new Date())){
			throw new ParamValidateException("活动已经结束");
		}
		//活动已存在确信对象的
		ActivitysRegQueryHelper e=new ActivitysRegQueryHelper();
		e.createCriteria().andActIdEqualTo(messageReq.getActivityId()).andRegStatusEqualTo(ActivityHelper.ActRegStatus.CHECKED.ordinal());
		if (activitysRegService.countByExample(e)>1){
			throw new ParamValidateException("活动已经确认报名对象了");
		}
		
		// 验证用户是否正确
		//##########
		
		// 活动3小时内开始未处理报名的发消息
		Message msgMaster = new Message();
		msgMaster.setContent(String.format("[%s]邀请你参与他的活动",user.getNickName()));
		msgMaster.setFuid(Constants.SYS_USERID);
		msgMaster.setTitle("活动邀请");
		msgMaster.setCtime(new Date());
		msgMaster.setIread(false);
		msgMaster.setRun(false);
		msgMaster.setStatus(0);
		msgMaster.setBizCode(ActivityHelper.EBizCode.AINVITE.ordinal());
		msgMaster.setTuid(messageReq.getUserId());
		messageService.insertSelective(msgMaster);
		// 融云推消息未读消息数量
		LHMessage msg = new LHMessage();
		MessageQueryHelper exp = new MessageQueryHelper();
		exp.createCriteria().andTuidEqualTo(messageReq.getUserId()).andIreadEqualTo(false);
		msg.setRow(messageService.countByExample(exp));
		littleHelperMessage.sendMessage(Constants.SYS_USERID.toString(), new String[] { messageReq.getUserId().toString() }, msg);
	}
}
