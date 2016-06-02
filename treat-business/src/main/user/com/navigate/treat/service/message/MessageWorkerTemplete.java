package com.navigate.treat.service.message;

import com.navigate.treat.beans.basic.Message;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.exception.ResultCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.service.message.core.ActSignMesssageCore;
import com.navigate.treat.util.SpringUtils;

/**
 * 小助手消息处理
 * @author fwg create by 2016年4月15日 上午10:20:56
 */
public class MessageWorkerTemplete {
	public static IMesssageCore getWorker(Message message) {
		EBizCode bizCode = EBizCode.values()[message.getBizCode()];
		IMesssageCore messsageCore = null;
		switch (bizCode) {
			case REG:
				messsageCore = SpringUtils.getBean("actRegMesssageCore", IMesssageCore.class);
				break;
			case SIGN:
				messsageCore = SpringUtils.getBean("actSignMesssageCore", IMesssageCore.class);
				break;
			case ADOUBT:
				messsageCore = SpringUtils.getBean("actDoubtMesssageCore", IMesssageCore.class);
				break;
			case AINVITE:
				messsageCore = SpringUtils.getBean("actInviteMesssageCore", ActSignMesssageCore.class);
				break;
			default:
				throw new BusinessException(ResultCode.RESOURCE_CODE_ERROR);
		}
		return messsageCore;
	}
	public static IMesssageCore getWorker(EBizCode bizCode) {
		IMesssageCore messsageCore = null;
		switch (bizCode) {
			case REG:
				messsageCore = SpringUtils.getBean("actRegMesssageCore", IMesssageCore.class);
				break;
			case SIGN:
				messsageCore = SpringUtils.getBean("actSignMesssageCore", IMesssageCore.class);
				break;
			case ADOUBT:
				messsageCore = SpringUtils.getBean("actDoubtMesssageCore", IMesssageCore.class);
				break;
			case AINVITE:
				messsageCore = SpringUtils.getBean("actInviteMesssageCore", IMesssageCore.class);
				break;
			default:
				throw new BusinessException(ResultCode.RESOURCE_CODE_ERROR);
		}
		return messsageCore;
	}
}
