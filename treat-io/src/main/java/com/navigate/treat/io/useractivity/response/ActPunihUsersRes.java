package com.navigate.treat.io.useractivity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActPunihUsersRes implements Serializable {
	private static final long serialVersionUID = 8375060075233311471L;
	/**
	 * 活动Id
	 */
	private Long activityId;
	/**
	 * 评论人
	 */
	private Long UserId;;
	/**
	 * 被评论的人
	 */
	private Long punihUserId;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 纬度
	 */
	private String lat;
	/**
	 * 头像
	 */
	private String headIcon;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 皇冠@1:正常|2: 丢失
	 */
	private Integer crown;
	/**
	 * 鸽子
	 */
	private Integer pigeon;
	/**
	 * 土豪
	 */
	private BigDecimal rich;
	
	/**
	 * 最后时间
	 */
	private Date lastLoginTime;
	
	/**
     * 被别人处罚 1未处理:2 处理
     */
    private Integer bePunished;
    /**
     * 处罚别人     1未处理:2 处理
     */
    private Integer punished;
    
    /**
     * 签到@1 未签到 2 签到（默认0）
     */
    private Integer signin;
    /**
	 * 活动是发起的,还是参与的
	 */
	private Integer role;
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Long getPunihUserId() {
		return punihUserId;
	}
	public void setPunihUserId(Long punihUserId) {
		this.punihUserId = punihUserId;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getCrown() {
		return crown;
	}
	public void setCrown(Integer crown) {
		this.crown = crown;
	}
	public Integer getPigeon() {
		return pigeon;
	}
	public void setPigeon(Integer pigeon) {
		this.pigeon = pigeon;
	}
	public BigDecimal getRich() {
		return rich;
	}
	public void setRich(BigDecimal rich) {
		this.rich = rich;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
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
	public Integer getSignin() {
		return signin;
	}
	public void setSignin(Integer signin) {
		this.signin = signin;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	
}
