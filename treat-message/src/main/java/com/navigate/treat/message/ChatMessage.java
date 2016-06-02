package com.navigate.treat.message;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;

import rongyun.io.rong.ApiHttpClient;
import rongyun.io.rong.models.FormatType;
import rongyun.io.rong.models.SdkHttpResult;
import rongyun.io.rong.models.TxtMessage;
/**
 * 
 * @author ShanHe
 * 聊天通知推送
 *
 */
public class ChatMessage {
	static Logger log = LogManager.getLogger(ChatMessage.class.getName());
		
	private String appKey = "k51hidwq1bhvb";
	private String appSecret = "Pov4sbSnu68c";
	private FormatType format = FormatType.json;
	
	//提醒临时聊天即将销毁
	public SdkHttpResult chatAboutToEnd(String fromUserId, String fromUserName, List<String> toUserIds){
		String content = fromUserName + "与您的临时聊天窗口将在3小时后自动销毁";
		TxtMessage msg = new TxtMessage(content);
		SdkHttpResult shr = null;
		try {
			shr = ApiHttpClient.publishMessage(appKey, appSecret, fromUserId, toUserIds, msg, format);
		} catch (Exception e) {
			log.error("通知：申请添加好友异常", e);
		}
		return shr;
	}
	
}
