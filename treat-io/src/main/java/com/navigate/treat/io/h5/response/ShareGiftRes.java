package com.navigate.treat.io.h5.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分享礼物领取成功返回值
 * @author fwg create by 2015年12月12日 上午11:25:56
 */
public class ShareGiftRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long actId;
	private Long userId;
	private String headIcon;
	private Long userGiftId;
	private BigDecimal amount;
	private String giftName;
	private String giftImage;
	  /**
     * 昵称
     */
    private String nickName;

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
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public String getGiftImage() {
		return giftImage;
	}
	public void setGiftImage(String giftImage) {
		this.giftImage = giftImage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getUserGiftId() {
		return userGiftId;
	}
	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "ShareGiftRes [actId=" + actId + ", userId=" + userId + ", headIcon=" + headIcon + ", userGiftId="
				+ userGiftId + ", amount=" + amount + ", giftName=" + giftName + ", giftImage=" + giftImage
				+ ", nickName=" + nickName + "]";
	}
	
	
}
