package com.navigate.treat.service.message.core;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.ActivitySignQueryHelper;
import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.beans.basic.MessageQueryHelper;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.message.ILittleHelperMessage;
import com.navigate.treat.message.bean.LHMessage;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.message.IMesssageCore;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.UserUtil;

/**
 * 活动签到小助手消息处理类
 * @author fwg create by 2016年4月15日 上午11:08:32
 */
@Component
public class ActSignMesssageCore implements IMesssageCore {
	static final Logger log = LogManager.getLogger(ActSignMesssageCore.class);
	@Resource
	IActivitySignService activitySignService;
	@Resource
	IMessageService messageService;
	@Resource
	ILittleHelperMessage littleHelperMessage;

	@Override
	public void doExcute(Message message) {
	}
	@Override
	public void doCreateMsg(MessageReq messageReq) {
		UsersLoginRes user = UserUtil.getUsers();
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(messageReq.getActivityId());
		e.setOrderByClause("role desc ");
		List<ActivitySign> signs = activitySignService.selectByExample(e);
		if (signs.size() != 2) {
			log.info("签到数据异常 actid={},userid={} ", messageReq.getActivityId(), user.getUserId());
			return;
		}
		Message msgMaster = new Message();
		Message msgFollower = new Message();
		// 一方成功或一方失败
		if (signs.get(0).getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& signs.get(1).getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 签到者--"你已成功签到,对方还在快马加鞭地赶来,请稍后."
			// 另一方--"对方已到达目的地,不要迟到哦."
			if (signs.get(0).getUserId().longValue() == user.getUserId().longValue()) {
				msgMaster.setTuid(signs.get(0).getUserId());
				msgFollower.setTuid(signs.get(1).getUserId());
			} else {
				msgMaster.setTuid(signs.get(1).getUserId());
				msgFollower.setTuid(signs.get(0).getUserId());
			}
			msgMaster.setContent("你已成功签到,对方还在快马加鞭地赶来,请稍后");
			msgMaster.setFuid(Constants.SYS_USERID);
			msgFollower.setContent("对方已到达目的地,不要迟到哦");
			msgFollower.setFuid(Constants.SYS_USERID);
		}
		if (signs.get(0).getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& signs.get(1).getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			if (signs.get(0).getUserId().longValue() == user.getUserId().longValue()) {
				msgMaster.setTuid(signs.get(0).getUserId());
				msgFollower.setTuid(signs.get(1).getUserId());
			} else {
				msgMaster.setTuid(signs.get(1).getUserId());
				msgFollower.setTuid(signs.get(0).getUserId());
			}
			msgMaster.setContent("你已成功签到,对方还在快马加鞭地赶来,请稍后");
			msgMaster.setFuid(Constants.SYS_USERID);
			msgFollower.setContent("对方已到达目的地,不要迟到哦");
			msgFollower.setFuid(Constants.SYS_USERID);
		}
		// 双方成功的
		if (signs.get(0).getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& signs.get(1).getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 先到者--"."
			if (signs.get(0).getUserId().longValue() == user.getUserId().longValue()) {
				msgMaster.setTuid(signs.get(0).getUserId());
				msgFollower.setTuid(signs.get(1).getUserId());
			} else {
				msgMaster.setTuid(signs.get(1).getUserId());
				msgFollower.setTuid(signs.get(0).getUserId());
			}
			msgMaster.setContent("你已成功签到,祝你们玩的愉快");
			msgMaster.setFuid(Constants.SYS_USERID);
			msgFollower.setContent("对方已到达目的地,不要迟到哦");
			msgFollower.setFuid(Constants.SYS_USERID);
		}
		msgMaster.setTitle("活动签到");
		msgMaster.setCtime(new Date());
		msgMaster.setIread(false);
		msgMaster.setRun(false);
		msgMaster.setStatus(0);
		msgMaster.setBizCode(ActivityHelper.EBizCode.SIGN.ordinal());
		msgMaster.setMtype((ActivityHelper.EMType.S.ordinal()));
		msgFollower.setTitle("活动签到");
		msgFollower.setCtime(new Date());
		msgFollower.setIread(false);
		msgFollower.setRun(false);
		msgFollower.setStatus(0);
		msgFollower.setBizCode(ActivityHelper.EBizCode.SIGN.ordinal());
		msgFollower.setMtype((ActivityHelper.EMType.S.ordinal()));
		
		messageService.insertSelective(msgMaster);
		messageService.insertSelective(msgFollower);
		// 融云推消息未读消息数量
		LHMessage msg = new LHMessage();
		MessageQueryHelper exp = new MessageQueryHelper();
		exp.createCriteria().andTuidEqualTo(signs.get(0).getUserId()).andIreadEqualTo(false);
		msg.setRow(messageService.countByExample(exp));
		littleHelperMessage.sendMessage(Constants.SYS_USERID.toString(),
				new String[] { signs.get(0).getUserId().toString() }, msg);
		msg = new LHMessage();
		exp.clear();
		exp.createCriteria().andTuidEqualTo(signs.get(1).getUserId()).andIreadEqualTo(false);
		msg.setRow(messageService.countByExample(exp));
		littleHelperMessage.sendMessage(Constants.SYS_USERID.toString(),
				new String[] { signs.get(1).getUserId().toString() }, msg);
	}
}
