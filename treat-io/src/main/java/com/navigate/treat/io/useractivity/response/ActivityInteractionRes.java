package com.navigate.treat.io.useractivity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 感应的活动各种状态
 * 
 * @author Administrator
 *
 */
public class ActivityInteractionRes  implements Serializable {

	private static final long serialVersionUID = 438888349232090668L;
	
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
     * 经度
     */
    private BigDecimal lng;
    /**
     * 纬度
     */
    private BigDecimal lat;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
    /**
     * 感应结果@0 未感应 1 感应失败 2 感应成功
     */
    private Integer result;
    /**
     * 角色@0 发起者 1 参与者
     */
    private Integer role;
    /**
     * 签到@0 未签到 1 签到（默认0）
     */
    private Integer signin;
    /**
     * 感应时间
     */
    private Date interactionTime;
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
     * 是否已担保金@0 1:未领取,2申诉中, 3处理
     * {@link #EDepositStatus}
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
    /**
     * 参与者人数
     */
    private Integer followerCount ;
    /**
     * 评论次数
     */
    //private Integer commendCount;
    
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
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
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
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
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
	public Date getInteractionTime() {
		return interactionTime;
	}
	public void setInteractionTime(Date interactionTime) {
		this.interactionTime = interactionTime;
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
	public Integer getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(Integer followerCount) {
		this.followerCount = followerCount;
	}
	@Override
	public String toString() {
		return "ActivityInteractionRes [id=" + id + ", userId=" + userId + ", activityId=" + activityId + ", lng="
				+ lng + ", lat=" + lat + ", ctime=" + ctime + ", mtime=" + mtime + ", result=" + result + ", role="
				+ role + ", signin=" + signin + ", interactionTime=" + interactionTime + ", supplyAmount="
				+ supplyAmount + ", supply=" + supply + ", depositAmount=" + depositAmount + ", deposit=" + deposit
				+ ", bePunished=" + bePunished + ", punished=" + punished + ", followerCount=" + followerCount + "]";
	}
    
    

}
