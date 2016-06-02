package com.navigate.treat.io.h5.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分享礼物
 * @author fwg create by 2015年12月12日 上午11:25:56
 */
public class TokenGiftSuccessRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userGiftId;
	private BigDecimal amount;
	private String giftName;
	private String giftImage;
	
	public Long getUserGiftId() {
		return userGiftId;
	}
	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
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
}
