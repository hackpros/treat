package com.navigate.treat.io.useractivity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户感应请求对象
 */
public class ActDetailRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 活动Id
	 */
	private Long treatId;
	/**
	 * 活动时间
	 */
	private Date activityTime;
	/**
	 * 活动类型@0 约会 1 小聚 2 大趴 （默认0）(当线上请) 0 请好友 1 向我要 2 大家抢
	 */
	private Integer type;
	
	/**
     * 请客方式 @
     */
    private Integer treatWay;
	/**
	 * 商家名称
	 */
	private String bizName;
	/**
	 * 商家地址
	 */
	private String bizAddr;
	/**
	 * 补贴
	 */
	private BigDecimal subsidy;
	/**
	 * 状态
	 */
	private int activeState;
	/**
	 * 头像
	 */
	private String headIcon;
	/**
	 * 商家经度
	 */
	private String bizLng;
	/**
	 * 商家纬度
	 */
	private String bizLat;
	/**
	 * 活动是发起的,还是参与的
	 */
	private Integer role;
	/**
	 * 参与者Id
	 */
	private Long followerId;
	/**
	 * 感应信息
	 */
	private ActivityInteractionRes activityInteractionRes;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getTreatId() {
		return treatId;
	}
	public void setTreatId(Long treatId) {
		this.treatId = treatId;
	}
	public Date getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getBizName() {
		return bizName;
	}
	public void setBizName(String bizName) {
		this.bizName = bizName;
	}
	public String getBizAddr() {
		return bizAddr;
	}
	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}
	public BigDecimal getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(BigDecimal subsidy) {
		this.subsidy = subsidy;
	}
	public int getActiveState() {
		return activeState;
	}
	public void setActiveState(int activeState) {
		this.activeState = activeState;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public ActivityInteractionRes getActivityInteractionRes() {
		return activityInteractionRes;
	}
	public void setActivityInteractionRes(ActivityInteractionRes activityInteractionRes) {
		this.activityInteractionRes = activityInteractionRes;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getBizLng() {
		return bizLng;
	}
	public void setBizLng(String bizLng) {
		this.bizLng = bizLng;
	}
	public String getBizLat() {
		return bizLat;
	}
	public void setBizLat(String bizLat) {
		this.bizLat = bizLat;
	}
	
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	
	public Integer getTreatWay() {
		return treatWay;
	}
	public void setTreatWay(Integer treatWay) {
		this.treatWay = treatWay;
	}
	@Override
	public String toString() {
		return "ActDetailRes [userId=" + userId + ", treatId=" + treatId + ", activityTime=" + activityTime + ", type="
				+ type + ", treatWay=" + treatWay + ", bizName=" + bizName + ", bizAddr=" + bizAddr + ", subsidy="
				+ subsidy + ", activeState=" + activeState + ", headIcon=" + headIcon + ", bizLng=" + bizLng
				+ ", bizLat=" + bizLat + ", role=" + role + ", followerId=" + followerId + ", activityInteractionRes="
				+ activityInteractionRes + "]";
	}
	
}
