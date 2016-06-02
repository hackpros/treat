package com.navigate.treat.task;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.navigate.treat.api.IActivitysServiceFront;
import com.navigate.treat.api.IMessageServiceFront;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;

/**
 * @author fwg create by 2015年12月3日 下午3:50:27
 */
@Component
public class ActivityTask {
	private static final Logger log = LogManager.getLogger(ActivityTask.class);
	@Resource
	IMessageServiceFront messageServiceFront;
	@Resource
	IActivitysServiceFront   activitysServiceFront;
	/**
	 * 活动开始前2.5小时
	 */
	@Scheduled(cron = "0 3,32 * * * ? ")
	// 每十分中做一次
	public void actStartBefore() {
		// 当前时间2.5小时－３小时之后面的数
		log.info("活动开始前2.5,推消息..");
		// Date date = new Date();
		// Date startDate = DateUtils.addMinutes(date, 150);
		// Date endDate = DateUtils.addHours(date, 3);
	}
	/**
	 * 活动开始前3小时.未确定报名对象的发消息
	 */
	@Scheduled(cron = "0 3,32 * * * ? ")
	// 每十分中做一次
	public void actDoubtStartBefore() {
		// 当前时间2.5小时－３小时之后面的数
		log.info("活动开始前2.5,推消息..");
		
		MessageReq messageReq=new MessageReq();
		messageReq.setBizCode(ActivityHelper.EBizCode.ADOUBT);
		messageServiceFront.doCrateMessage(messageReq);
	}
	
	/**
	 * 活动自然结束后，担保金，补岾结算
	 * 每日凌晨3点执行
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	// 每十分中做一次
	public void actNaturalEnd() {
		// 当前时间2.5小时－３小时之后面的数
		log.info("活动自然结束数据清算..");
		activitysServiceFront.doCleaning();
		
		
	}
}
