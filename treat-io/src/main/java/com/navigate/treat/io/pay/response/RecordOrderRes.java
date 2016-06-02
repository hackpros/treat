package com.navigate.treat.io.pay.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.navigate.treat.base.BaseDO;

/**
 * 
 * @author huangshiping
 * 
 *         活动响应参数
 */
public class RecordOrderRes extends BaseDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * 支付状态 1 已支付 2 已退款
	 */
	private Integer payStatus;

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
		this.orderNum = orderNum;
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

}
