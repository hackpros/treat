/*
 * RecordFund.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-12 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资金记录表
 * @author 掌航
 * @version 1.0 2016-04-12
 */
public class RecordFund implements Serializable {
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

	public RecordFund() {
	}
	public RecordFund(Long userId, BigDecimal amount, Integer plusMinus, String orderNum, String sellerId,
			String descriptions, Integer type) {
		this.userId = userId;
		this.amount = amount;
		this.plusMinus = plusMinus;
		this.outTradeNo = orderNum;
		this.sellerId = sellerId;
		this.descriptions = descriptions;
		this.type = type;
		this.ctime = new Date();
	}
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
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		RecordFund other = (RecordFund) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
				&& (this.getPlusMinus() == null ? other.getPlusMinus() == null
						: this.getPlusMinus().equals(other.getPlusMinus()))
				&& (this.getOutTradeNo() == null ? other.getOutTradeNo() == null
						: this.getOutTradeNo().equals(other.getOutTradeNo()))
				&& (this.getSellerId() == null ? other.getSellerId() == null
						: this.getSellerId().equals(other.getSellerId()))
				&& (this.getDescriptions() == null ? other.getDescriptions() == null
						: this.getDescriptions().equals(other.getDescriptions()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		result = prime * result + ((getPlusMinus() == null) ? 0 : getPlusMinus().hashCode());
		result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());
		result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
		result = prime * result + ((getDescriptions() == null) ? 0 : getDescriptions().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		return result;
	}
}
