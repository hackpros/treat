/*
 * ActivitySign.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-20 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动感应
 * 
 * @author 菠萝大象
 * @version 1.0 2016-04-20
 */
public class ActivitySign implements Serializable {

    /**
     * 主键自增
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 活动Id
     */
    private Long activityId;
    /**
     * 活動開始時間
     */
    private Date activityTime;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
    /**
     * 角色@0 发起者 1 参与者
     */
    private Integer role;
    /**
     * 签到@0 未签到 1 签到（默认0）
     */
    private Integer signin;
    /**
     * 簽到時間
     */
    private Date singTime;
    /**
     * 活动补贴
     */
    private BigDecimal supplyAmount;
    /**
     * 是否已领取补贴@0 1:未领取,2已领取补贴
     */
    private Integer supply;
    /**
     * 担保金
     */
    private BigDecimal depositAmount;
    /**
     * 是否已担保金@0 1:未领取,2已领取补贴
     */
    private Integer deposit;
    /**
     * 被别人处罚 1未处理:2 处理
     */
    private Integer bePunished;
    /**
     * 处罚别人     1未处理:2 处理
     */
    private Integer punished;
    
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
    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
    public Date getActivityTime() {
        return activityTime;
    }
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
    public Integer getRole() {
        return role;
    }
    public void setRole(Integer role) {
        this.role = role;
    }
    public Integer getSignin() {
        return signin;
    }
    public void setSignin(Integer signin) {
        this.signin = signin;
    }
    public Date getSingTime() {
        return singTime;
    }
    public void setSingTime(Date singTime) {
        this.singTime = singTime;
    }
    public BigDecimal getSupplyAmount() {
        return supplyAmount;
    }
    public void setSupplyAmount(BigDecimal supplyAmount) {
        this.supplyAmount = supplyAmount;
    }
    public Integer getSupply() {
        return supply;
    }
    public void setSupply(Integer supply) {
        this.supply = supply;
    }
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }
    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }
    public Integer getDeposit() {
        return deposit;
    }
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }
    public Integer getBePunished() {
        return bePunished;
    }
    public void setBePunished(Integer bePunished) {
        this.bePunished = bePunished;
    }
    public Integer getPunished() {
        return punished;
    }
    public void setPunished(Integer punished) {
        this.punished = punished;
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
        ActivitySign other = (ActivitySign) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getActivityTime() == null ? other.getActivityTime() == null : this.getActivityTime().equals(other.getActivityTime()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getSignin() == null ? other.getSignin() == null : this.getSignin().equals(other.getSignin()))
            && (this.getSingTime() == null ? other.getSingTime() == null : this.getSingTime().equals(other.getSingTime()))
            && (this.getSupplyAmount() == null ? other.getSupplyAmount() == null : this.getSupplyAmount().equals(other.getSupplyAmount()))
            && (this.getSupply() == null ? other.getSupply() == null : this.getSupply().equals(other.getSupply()))
            && (this.getDepositAmount() == null ? other.getDepositAmount() == null : this.getDepositAmount().equals(other.getDepositAmount()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getBePunished() == null ? other.getBePunished() == null : this.getBePunished().equals(other.getBePunished()))
            && (this.getPunished() == null ? other.getPunished() == null : this.getPunished().equals(other.getPunished()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityTime() == null) ? 0 : getActivityTime().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getSignin() == null) ? 0 : getSignin().hashCode());
        result = prime * result + ((getSingTime() == null) ? 0 : getSingTime().hashCode());
        result = prime * result + ((getSupplyAmount() == null) ? 0 : getSupplyAmount().hashCode());
        result = prime * result + ((getSupply() == null) ? 0 : getSupply().hashCode());
        result = prime * result + ((getDepositAmount() == null) ? 0 : getDepositAmount().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getBePunished() == null) ? 0 : getBePunished().hashCode());
        result = prime * result + ((getPunished() == null) ? 0 : getPunished().hashCode());
        return result;
    }
}