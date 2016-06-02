package com.navigate.treat.io.pay.helper;

/**
 * 
 * @author huangshiping
 * 
 */
public class FundsHelper {

	/**
	 * 
	 * 订单类型
	 */
	public enum OrderType {
		OCCUPY, // 占位符
		DEPOSIT, // 担保金
		SUBSIDY;// 补贴
	}

	/**
	 * 
	 * 支付状态
	 */
	public enum PayStatus {
		OCCUPY, // 占位符
		PAY, // 已经支付
		UNPAY, // 未支付
		BACK,// 退回担保金
		OVER;// 结束
	}

	/**
	 * 
	 * 支付类型
	 */
	public enum PayMent {
		OCCUPY, // 占位符
		ALI_PAY, // 支付宝
		WEIXIN_PAY, // 微信
		WITHDRAWFUNDS, // 提现
		BALANCE_PAY, // 余额支付
		BACK,// 退回
		TAKE,// 拿到对方补贴或担保金　
	}

	/**
	 * 
	 * 消费类型
	 */
	public enum ConsumerType {
		OCCUPY, // 占位符
		SPEND, // 花费
		INCOME;// 收入
	}
}
