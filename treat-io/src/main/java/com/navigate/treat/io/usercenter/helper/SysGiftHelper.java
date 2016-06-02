package com.navigate.treat.io.usercenter.helper;

/**
 * 系统礼相关常量,枚举类
 * @author Administrator
 */
public class SysGiftHelper {
	public static enum ESource {
		// 送礼来源@1:活动2:秀场3:点对点,4:系统赠送'
		OCCUPY, // 占位的
		ACTIVTY, // 活动,
		SHOW, // 秀场
		PERON, // 点对点
		SYSTEM// 系统赠送,
	}

	public static enum ESysGiftStatus {
		// 状态@1:未启用| 2:启用|3:停用
		OCCUPY, // 占位的
		NOTUSING, // 未启用,
		ENABLED, // 启用
		DISABLED, // 停用
		FINISH// 活动已结束,
	}

	// 类型@首次充值,注册,邀请注册
	public enum ESysGiftCategory {
		GIFT, // 送礼
		ALLEUR, // 魅力值
	}

	// 业务范围
	public enum ESysGiftBizCode {
		FIRISTPAY, // 首次充值
		REG, // 注册,
		FIRSTLOGIN, // 首次登录,
		INVITE, // 邀请注册
		BEINVITE, // 被邀请
		PROCURE// 领取礼物
	}

	public static enum EUserStatus {
		// 状态@1:已领取2:转赠:3退回:4:过期,5兑换
		OCCUPY(1), // 未领取
		GIVEME(2), // 领取
		GIVETO(3), // 转赠
		OVERDUE(4), // 4:过期
		CONVERTED(5); // 5兑换
		private int status;

		private EUserStatus(int status) {
			this.status = status;
		}
		public int getStatu() {
			return status;
		}
	}

	// 可转赠
	public static enum EUseWay {
		OCCUPY, // 占位的
		UNLINITE, // 不限
		SELF, // 只能自己用
		OTHER // 只能别人用
	}

	// 活动类型@系统活动@推广活动@运营活动
	public static enum ESysGiftType {
		SYSTEM, // 系统活动
		H5, // 推广活动
		HOLDAY// 运营活动
	}
}
