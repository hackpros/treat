package com.navigate.treat.io.user.requeset;

import com.navigate.treat.base.io.request.IRequest;

/**
 * 第三方用户注册请求参数
 * 
 * @author Administrator
 *
 */
public class UserThirdRegReq implements IRequest{
	
	/**
	 *第三方/ID
	 */
	public Long thirdId;

	/**
	 * 手机号
	 */
	// @NotNull(message = "为空")
	private String mobile;
	/**
	 * 密码
	 */
	// @Length(min=8,message = "密码长度不能小于8")
	private String password;
	/**
	 * 验证码
	 */
	private String captcha;

	/**
	 * 刷新凭证
	 */
	private String refreshToken;
	/**
	 * 调用凭证
	 */
	private String accessToken;
	/**
	 * 第三方唯一标
	 */
	private String openId;

	/**
	 * 账号类型@1:微信|2:QQ|3:新浪微博
	 */
	private Integer type;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

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

	public Long getThirdId() {
		return thirdId;
	}

	public void setThirdId(Long thirdId) {
		this.thirdId = thirdId;
	}

	

	
	
}
