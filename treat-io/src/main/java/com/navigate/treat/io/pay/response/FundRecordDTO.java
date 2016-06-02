package com.navigate.treat.io.pay.response;

import java.math.BigDecimal;
import java.util.Date;

import com.navigate.treat.base.BaseDO;

/**
 * 
 * @author huangshiping
 *
 */
public class FundRecordDTO extends BaseDO{

	/**
     * 自增主键
     */
    private Long fundId;
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
     * 资金变化描述
     */
    private String descriptions;
    /**
     * 消费类型 1 消费  2 增加
     */
    private Integer type;
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
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
    
    
}
