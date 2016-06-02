package com.navigate.treat.service.message;

import java.util.Date;


public interface ISendSysMsg {

	/**
	 * 发送小助手消息
	 * @param title 消息主题
	 * @param content 消息内容
	 * @param bizType 消息类型
	 * @param userId 发送者ID
	 * @param args 处理参数
	 * @param overdueTime 过期时间
	 */
	public void sendSysMsg(String title, String content, int bizType, Long userId, String args, Date overdueTime);
}
