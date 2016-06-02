package com.navigate.treat.service.message;

import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.io.message.MessageReq;

public interface IMesssageCore {
	/**
	 * 创建消息
	 */
	public void doCreateMsg(MessageReq  messageReq);
	/**
	 * 执行消息
	 */
	public void doExcute(Message message);
}
