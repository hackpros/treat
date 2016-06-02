/*
 * Activitys.java
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
 * @author 掌航
 * @version 1.0 2016-04-12
 */
public class Activitys implements Serializable {
	/**
	 * 主键自增
	 */
	private Long id;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 主题
	 */
	private String theme;
	/**
	 * 请客方式 我请：1 AA 2
	 */
	private Integer treatWay;
	/**
	 * 请客时间
	 */
	private Date actTime;
	/**
	 * 担保金额
	 */
	private BigDecimal amountSecured;
	/**
	 * 赴约补贴
	 */
	private BigDecimal subsidies;
	/**
	 * 简要说明
	 */
	private String briefDesc;
	/**
	 * 修改时间
	 */
	private Date mtime;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 活动状态 进行中 ：1 活动自然结束 2 活动关闭 3
	 */
	private Integer actStatus;
	/**
	 * 商家ID
	 */
	private Long bizId;
	/**
	 * 商家名称
	 */
	private String bizName;
	/**
	 * 商家地址
	 */
	private String bizAddr;
	/**
	 * 商家图片
	 */
	private String bizIcon;
	/**
	 * 商家类别
	 */
	private String bizCategory;
	/**
	 * 商家经度
	 */
	private String bizLng;
	/**
	 * 商家纬度
	 */
	private String bizLat;
	/**
	 * 好评度
	 */
	private String bizRate;
	/**
	 * 人均消费
	 */
	private String bizAvg;
	/**
	 * 浏览次数
	 */
	private Long browseNum;
	/**
	 * 订单号
	 */
	private String orderNum;
	/**
	 * 用户经度
	 */
	private String userLng;
	/**
	 * 用户纬度
	 */
	private String userLat;
	private static final long serialVersionUID = 1L;
	
	public Activitys(){
		
	}
    public Activitys(Long id){
    	this.id=id;
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
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme == null ? null : theme.trim();
	}
	public Integer getTreatWay() {
		return treatWay;
	}
	public void setTreatWay(Integer treatWay) {
		this.treatWay = treatWay;
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	public BigDecimal getAmountSecured() {
		return amountSecured;
	}
	public void setAmountSecured(BigDecimal amountSecured) {
		this.amountSecured = amountSecured;
	}
	public BigDecimal getSubsidies() {
		return subsidies;
	}
	public void setSubsidies(BigDecimal subsidies) {
		this.subsidies = subsidies;
	}
	public String getBriefDesc() {
		return briefDesc;
	}
	public void setBriefDesc(String briefDesc) {
		this.briefDesc = briefDesc == null ? null : briefDesc.trim();
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
	public Integer getActStatus() {
		return actStatus;
	}
	public void setActStatus(Integer actStatus) {
		this.actStatus = actStatus;
	}
	public Long getBizId() {
		return bizId;
	}
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName == null ? null : bizName.trim();
	}
	public String getBizAddr() {
		return bizAddr;
	}
	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr == null ? null : bizAddr.trim();
	}
	public String getBizIcon() {
		return bizIcon;
	}
	public void setBizIcon(String bizIcon) {
		this.bizIcon = bizIcon == null ? null : bizIcon.trim();
	}
	public String getBizCategory() {
		return bizCategory;
	}
	public void setBizCategory(String bizCategory) {
		this.bizCategory = bizCategory == null ? null : bizCategory.trim();
	}
	public String getBizLng() {
		return bizLng;
	}
	public void setBizLng(String bizLng) {
		this.bizLng = bizLng == null ? null : bizLng.trim();
	}
	public String getBizLat() {
		return bizLat;
	}
	public void setBizLat(String bizLat) {
		this.bizLat = bizLat == null ? null : bizLat.trim();
	}
	public String getBizRate() {
		return bizRate;
	}
	public void setBizRate(String bizRate) {
		this.bizRate = bizRate == null ? null : bizRate.trim();
	}
	public String getBizAvg() {
		return bizAvg;
	}
	public void setBizAvg(String bizAvg) {
		this.bizAvg = bizAvg == null ? null : bizAvg.trim();
	}
	public Long getBrowseNum() {
		return browseNum;
	}
	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}
	public String getUserLng() {
		return userLng;
	}
	public void setUserLng(String userLng) {
		this.userLng = userLng == null ? null : userLng.trim();
	}
	public String getUserLat() {
		return userLat;
	}
	public void setUserLat(String userLat) {
		this.userLat = userLat == null ? null : userLat.trim();
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
		Activitys other = (Activitys) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
				&& (this.getTreatWay() == null ? other.getTreatWay() == null
						: this.getTreatWay().equals(other.getTreatWay()))
				&& (this.getActTime() == null ? other.getActTime() == null
						: this.getActTime().equals(other.getActTime()))
				&& (this.getAmountSecured() == null ? other.getAmountSecured() == null
						: this.getAmountSecured().equals(other.getAmountSecured()))
				&& (this.getSubsidies() == null ? other.getSubsidies() == null
						: this.getSubsidies().equals(other.getSubsidies()))
				&& (this.getBriefDesc() == null ? other.getBriefDesc() == null
						: this.getBriefDesc().equals(other.getBriefDesc()))
				&& (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
				&& (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
				&& (this.getActStatus() == null ? other.getActStatus() == null
						: this.getActStatus().equals(other.getActStatus()))
				&& (this.getBizId() == null ? other.getBizId() == null : this.getBizId().equals(other.getBizId()))
				&& (this.getBizName() == null ? other.getBizName() == null
						: this.getBizName().equals(other.getBizName()))
				&& (this.getBizAddr() == null ? other.getBizAddr() == null
						: this.getBizAddr().equals(other.getBizAddr()))
				&& (this.getBizIcon() == null ? other.getBizIcon() == null
						: this.getBizIcon().equals(other.getBizIcon()))
				&& (this.getBizCategory() == null ? other.getBizCategory() == null
						: this.getBizCategory().equals(other.getBizCategory()))
				&& (this.getBizLng() == null ? other.getBizLng() == null : this.getBizLng().equals(other.getBizLng()))
				&& (this.getBizLat() == null ? other.getBizLat() == null : this.getBizLat().equals(other.getBizLat()))
				&& (this.getBizRate() == null ? other.getBizRate() == null
						: this.getBizRate().equals(other.getBizRate()))
				&& (this.getBizAvg() == null ? other.getBizAvg() == null : this.getBizAvg().equals(other.getBizAvg()))
				&& (this.getBrowseNum() == null ? other.getBrowseNum() == null
						: this.getBrowseNum().equals(other.getBrowseNum()))
				&& (this.getOrderNum() == null ? other.getOrderNum() == null
						: this.getOrderNum().equals(other.getOrderNum()))
				&& (this.getUserLng() == null ? other.getUserLng() == null
						: this.getUserLng().equals(other.getUserLng()))
				&& (this.getUserLat() == null ? other.getUserLat() == null
						: this.getUserLat().equals(other.getUserLat()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
		result = prime * result + ((getTreatWay() == null) ? 0 : getTreatWay().hashCode());
		result = prime * result + ((getActTime() == null) ? 0 : getActTime().hashCode());
		result = prime * result + ((getAmountSecured() == null) ? 0 : getAmountSecured().hashCode());
		result = prime * result + ((getSubsidies() == null) ? 0 : getSubsidies().hashCode());
		result = prime * result + ((getBriefDesc() == null) ? 0 : getBriefDesc().hashCode());
		result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
		result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
		result = prime * result + ((getActStatus() == null) ? 0 : getActStatus().hashCode());
		result = prime * result + ((getBizId() == null) ? 0 : getBizId().hashCode());
		result = prime * result + ((getBizName() == null) ? 0 : getBizName().hashCode());
		result = prime * result + ((getBizAddr() == null) ? 0 : getBizAddr().hashCode());
		result = prime * result + ((getBizIcon() == null) ? 0 : getBizIcon().hashCode());
		result = prime * result + ((getBizCategory() == null) ? 0 : getBizCategory().hashCode());
		result = prime * result + ((getBizLng() == null) ? 0 : getBizLng().hashCode());
		result = prime * result + ((getBizLat() == null) ? 0 : getBizLat().hashCode());
		result = prime * result + ((getBizRate() == null) ? 0 : getBizRate().hashCode());
		result = prime * result + ((getBizAvg() == null) ? 0 : getBizAvg().hashCode());
		result = prime * result + ((getBrowseNum() == null) ? 0 : getBrowseNum().hashCode());
		result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
		result = prime * result + ((getUserLng() == null) ? 0 : getUserLng().hashCode());
		result = prime * result + ((getUserLat() == null) ? 0 : getUserLat().hashCode());
		return result;
	}
}
