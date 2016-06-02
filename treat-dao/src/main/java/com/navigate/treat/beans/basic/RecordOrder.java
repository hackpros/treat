/*
 * RecordOrder.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-06 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单记录表
 * 
 * @author 菠萝大象
 * @version 1.0 2016-04-06
 */
public class RecordOrder implements Serializable {

	/**
	 * 主键自增
	 */
	private Long id;
	/**
	 * 订单类型 担保金 1 赴约补贴 2
	 */
	private Integer type;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 订单号
	 */
	private String orderNum;
	/**
	 * 消费金额
	 */
	private BigDecimal amount;
	/**
	 * 修改时间
	 */
	private Date mtime;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 分配金额
	 */
	private BigDecimal distributeAmount;
	/**
	 * 支付状态 1 已支付 2 已退款,3已完成
	 */
	private Integer payStatus;
	private static final long serialVersionUID = 1L;

	public RecordOrder() {
	}
	
	public RecordOrder(BigDecimal amount, String orderNum, Integer orderType, Long userId, Integer payStatus) {
		this.amount = amount;
		this.orderNum = orderNum;
		this.type = orderType;
		this.userId = userId;
		this.payStatus = payStatus;
		this.ctime = new Date();
	}

	public RecordOrder(Long id, Integer payStatus) {
		this.id = id;
		this.payStatus = payStatus;
		this.mtime = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public BigDecimal getDistributeAmount() {
		return distributeAmount;
	}

	public void setDistributeAmount(BigDecimal distributeAmount) {
		this.distributeAmount = distributeAmount;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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
		RecordOrder other = (RecordOrder) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
				&& (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
				&& (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
				&& (this.getDistributeAmount() == null ? other.getDistributeAmount() == null : this.getDistributeAmount().equals(
						other.getDistributeAmount()))
				&& (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
		result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
		result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		result = prime * result + ((getDistributeAmount() == null) ? 0 : getDistributeAmount().hashCode());
		result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
		return result;
	}
}