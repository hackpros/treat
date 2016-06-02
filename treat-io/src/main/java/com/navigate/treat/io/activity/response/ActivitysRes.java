package com.navigate.treat.io.activity.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.navigate.treat.base.BaseDO;
import com.navigate.treat.io.user.response.UserHeadRes;

/**
 * 
 * @author huangshiping
 * 
 *         活动响应参数
 */
public class ActivitysRes extends BaseDO implements Serializable {
	/**
	 * 活动Id
	 */
	private Long actId;
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
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 活动状态 进行中 ：1 活动结束 2 活动关闭
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

	private String orderNum;

	/**
	 * 用户经度
	 */
	private String userLng;
	/**
	 * 用户纬度
	 */
	private String userLat;
	private UserHeadRes userHeadres = new UserHeadRes();
	private static final long serialVersionUID = 1L;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
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
		this.theme = theme;
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
		this.briefDesc = briefDesc;
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
		this.bizName = bizName;
	}

	public String getBizAddr() {
		return bizAddr;
	}

	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}

	public String getBizIcon() {
		return bizIcon;
	}

	public void setBizIcon(String bizIcon) {
		this.bizIcon = bizIcon;
	}

	public String getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(String bizCategory) {
		this.bizCategory = bizCategory;
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

	public String getBizRate() {
		return bizRate;
	}

	public void setBizRate(String bizRate) {
		this.bizRate = bizRate;
	}

	public String getBizAvg() {
		return bizAvg;
	}

	public void setBizAvg(String bizAvg) {
		this.bizAvg = bizAvg;
	}

	public UserHeadRes getUserHeadres() {
		return userHeadres;
	}

	public void setUserHeadres(UserHeadRes userHeadres) {
		this.userHeadres = userHeadres;
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
		this.orderNum = orderNum;
	}

	public String getUserLng() {
		return userLng;
	}

	public void setUserLng(String userLng) {
		this.userLng = userLng;
	}

	public String getUserLat() {
		return userLat;
	}

	public void setUserLat(String userLat) {
		this.userLat = userLat;
	}

}
