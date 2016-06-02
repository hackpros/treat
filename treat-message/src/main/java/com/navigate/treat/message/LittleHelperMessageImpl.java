package com.navigate.treat.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import rongyun.io.rong.ApiHttpClient;
import rongyun.io.rong.models.SdkHttpResult;

import com.navigate.treat.message.bean.ICMessage;


/**
 * 推融云的消息
 * @author fwg create by 2016年4月12日 下午3:19:18
 */
@Service
public class LittleHelperMessageImpl implements ILittleHelperMessage {
	static Logger log = LogManager.getLogger(LittleHelperMessageImpl.class);

	@Override
	public void sendMessage(String fromUserId, String[] toUserIds, ICMessage msg) {
		try {
			SdkHttpResult shr = ApiHttpClient.publishMassMessage(fromUserId, toUserIds, msg);
			log.info(shr.toString());
		} catch (Exception e) {
			log.error("noticeFollowersOnline error", e);
		}
	}
}
