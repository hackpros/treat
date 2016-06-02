package com.navigate.treat.io.user.requeset;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.navigate.treat.base.io.request.IRequest;
import com.navigate.treat.io.SystemValidation;

/**
 * 修改个人信息
 * @author Administrator
 */
public class UsersReq implements IRequest {
	// ###附加对象
	/**
	 * 验证码
	 */
	@NotNull(message = "验证码不能为空", groups = SystemValidation.LoginValidation.class)
	@Size(max = 4, min = 4, message = "验证码长度为4位", groups = SystemValidation.LoginValidation.class)
	private String captcha;
	// ##################
	/**
	 * 业务唯一数字ID
	 */
	private Long userId;
	/**
	 * 手机号
	 */
	@NotNull(message = "手机号码不能为空", groups = SystemValidation.LoginValidation.class)
	private String mobile;
	/**
	 * 昵称
	 */
	@NotNull(message = "昵称不能为空", groups = SystemValidation.ModifyLoginInfoValidation.class)
	private String nickName;
	/**
	 * 性别 男 1 女 2
	 */
	@NotNull(message = "性别不能为空", groups = SystemValidation.ModifyLoginInfoValidation.class)
	private Integer sex;
	/**
	 * 背景图
	 */
	private String backgroundImage;
	/**
	 * 请客号
	 */
	private String treamNum;
	/**
	 * 生日
	 */
	@NotNull(message = "生日不能为空", groups = SystemValidation.ModifyLoginInfoValidation.class)
	private Date birthday;
	/**
	 * 身高(cm)
	 */
	private Integer height;
	/**
	 * 头像
	 */
	private String headIcon;
	/**
	 * 相册列表
	 */
	private String photo;
	/**
	 * 签名
	 */
	private String signature;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	/**
	 * 设置号
	 */
	private String deviceId;
	
	/**
     * 用户来源@
     */
    private String userSource;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 纬度
	 */
	private String lat;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public String getTreamNum() {
		return treamNum;
	}
	public void setTreamNum(String treamNum) {
		this.treamNum = treamNum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getUserSource() {
		return userSource;
	}
	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}
	
	
}
