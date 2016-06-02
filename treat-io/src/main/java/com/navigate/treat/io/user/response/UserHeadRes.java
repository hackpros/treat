package com.navigate.treat.io.user.response;

import java.util.Date;

import com.navigate.treat.base.BaseDO;

/**
 * 用户头部信息
 * 
 * @author fwg create by 2015年12月17日 上午10:49:48
 * 
 */
public class UserHeadRes extends BaseDO {
	/**
	 * 头象
	 */
	private String headIcon;

	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 相册
	 */
	private String photo;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
