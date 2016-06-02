/*
 * RecordFund.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-12 Created
 */
package com.navigate.treat.io.usercenter.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资金记录表
 * @author 掌航
 * @version 1.0 2016-04-12
 */
public class RecordFundRes implements Serializable {
	/**
	 * 自增主键
	 */
	private Long id;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 支付方式 1 支付宝 2 微信 3 提现
	 */
	private Integer plusMinus;
	/**
	 * 流水号
	 */
	private String outTradeNo;
	/**
	 * 用户账号
	 */
	private String sellerId;
	/**
	 * 资金变化描述
	 */
	private String descriptions;
	/**
	 * 消费类型 1 消费 2 收入
	 */
	private Integer type;
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Integer getPlusMinus() {
		return plusMinus;
	}
	public void setPlusMinus(Integer plusMinus) {
		this.plusMinus = plusMinus;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId == null ? null : sellerId.trim();
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions == null ? null : descriptions.trim();
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
