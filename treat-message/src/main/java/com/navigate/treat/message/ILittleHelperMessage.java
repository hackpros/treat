package com.navigate.treat.message;

import com.navigate.treat.message.bean.ICMessage;

/**
 * 推融云的消息
 * @author fwg create by 2016年4月12日 下午3:19:18
 */
public interface ILittleHelperMessage {
	/**
	 * 
	 */
	void sendMessage(String fromUserId, String[] toUserIds, ICMessage msg);
}
