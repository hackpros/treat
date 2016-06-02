package com.navigate.treat.io.user.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户登录返回对象
 * 
 * @author fwg
 *
 */
public class UsersRegisterRes {

	/**
	 * 用户业务Id
	 */
	private String userId;

	/**
	 * 头像
	 */
	private String headIcon;
	/**
	 * 个性签名
	 */
	private String signature;

	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 余额
	 */
	private BigDecimal balance;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 请客号
	 */
	private String treamNum;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 城市编码
	 */
	private String cityCode;
	/**
	 * 兴趣 @
	 */
	private Short interest;

	/**
	 * 技能
	 */
	private Integer technique;

	/**
	 * 学校
	 */
	private String school;

	/**
	 * 行业@
	 */
	private Short vocation;

	/**
	 * 公司名称
	 */
	private String corpName;
	/**
	 * 皇冠@1:正常|2: 丢失
	 */
	private Short crown;

	/**
	 * 鸽子
	 */
	private Integer pigeon;

	/**
	 * 身高(cm)
	 */
	private Integer height;

	/**
	 * 省份编码
	 */
	private Long provinceCode;

	/**
	 * 魅力值ֵ
	 */
	private Integer allureValue;

	/**
	 * 技能值ֵ
	 */
	private Integer techniqueValue;

	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Short getInterest() {
		return interest;
	}

	public void setInterest(Short interest) {
		this.interest = interest;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Short getVocation() {
		return vocation;
	}

	public void setVocation(Short vocation) {
		this.vocation = vocation;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public Short getCrown() {
		return crown;
	}

	public void setCrown(Short crown) {
		this.crown = crown;
	}

	public Integer getPigeon() {
		return pigeon;
	}

	public void setPigeon(Integer pigeon) {
		this.pigeon = pigeon;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Long getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Long provinceCode) {
		this.provinceCode = provinceCode;
	}

	public Integer getAllureValue() {
		return allureValue;
	}

	public void setAllureValue(Integer allureValue) {
		this.allureValue = allureValue;
	}

	public Integer getTechniqueValue() {
		return techniqueValue;
	}

	public void setTechniqueValue(Integer techniqueValue) {
		this.techniqueValue = techniqueValue;
	}

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

}
