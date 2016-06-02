package com.navigate.treat.io.useractivity.helple;

import com.navigate.treat.gis.GisUtils;

/**
 * 活动相关的处理类
 * @author fwg
 */
public class ActivityHelper {
	// 活动结束时间,开始后3小时
	public static final int ACTIVITIES_FINISH_HOUR = 3;
	// 活动感应周期(毫秒)
	public static final int ACTIVITIES_INTERACTION_CYCLE = 3000000;
	// 活动签到半径(m)
	public static final float ACTIVITIES_SIGN_R = 1000;

	public enum ERole {
		OCCUPY, // 占位的
		MASTER, // 发起者
		FOLLOWER// 参与者
	}

	public enum EInteractionSignin {
		OCCUPY, // 占位的
		NOHAPPEN, // 未签到
		COMPLETE, // 已签到
		FAILURE // 签到失败
	}

	/**
	 * 业务类型
	 * @author fwg create by 2016年4月12日 下午3:06:26
	 */
	public enum EBizCode {
		DEF, // 缺省值
		SIGN, // 签到
		REG, // 活动报名
		ADOUBT, // 未确定报名的活动
		AINVITE// 活动邀请报表
	}

	/**
	 * 操作类型，可操作，不可操作
	 * 
	 * @author fwg create by 2016年4月12日 下午3:06:26
	 */
	public enum EOperation {
		DEF, // 缺省值
		EXCUTE, // 可操作的
		READ, // 不可操作的
	}

	
	/**
	 * 消息类型类型
	 * @author fwg create by 2016年4月12日 下午3:06:26
	 */
	public enum EMType {
		S, // 系统消息
		B, // 业务消息
		P// 点对点消息
	}

	/**
	 * 补贴领取状态
	 * @author fwg create by 2015-11-26
	 */
	public enum ESupplyStatus {
		// 1:未领取,2:维权中,绘权失败,4已领取补贴,
		OCCUPY, // 占位的
		UNSUCCESS, // 未处理
		COMMPLAIT, // 申诉中
		FAILURE, SCUESS // 处理
	}

	/**
	 * @author admin 活动状态
	 */
	public enum ActStatus {
		OCCUPY, // 占位的
		ONGOING, // 活动进行着
		ENDED, // 活动结束
		CLOSE // 活动关闭
	}

	/**
	 * @author admin 报名状态
	 */
	public enum ActRegStatus {
		OCCUPY, // 占位的
		REG, // 报名
		CHECKED // 选中
	}

	/**
	 * 是否在上同的位置
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static boolean sameLocal(double x1, double y1, double x2, double y2) {
		// 签到的们位置与活动位置200M内算签到成功
		float dis = GisUtils.calculateLineDistance(x1, y1, x2, y2);
		return dis <= ACTIVITIES_SIGN_R;
	}
	public static boolean sameLocal(String bizLat, String bizLng, String lat, String lng) {
		return sameLocal(Double.parseDouble(bizLat), Double.parseDouble(bizLng), Double.parseDouble(lat),
				Double.parseDouble(lng));
	}
}
