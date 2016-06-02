package com.navigate.treat.io.user.response;

import java.io.Serializable;

/**
 * 第三方用户绑定信息返回
 * 
 * @author fwg
 *
 */
public class UserThirdBindInfoRes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6457565745595415874L;
	/**
	 * 第三方唯一标误
	 */
	private String openId;

	/**
	 * 账号类型@1:微信|2:QQ|3:新浪微博
	 */
	private Integer type;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
