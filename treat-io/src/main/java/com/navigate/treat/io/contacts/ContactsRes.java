package com.navigate.treat.io.contacts;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户手机的已存在的本地联系人
 * @author fwg create by 2015年12月17日 下午4:41:27
 */
public class ContactsRes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   /**
     * 业务唯一数字ID
     */
    private Long userId;
    
	/**
	 * 通讯录号码
	 */
	private String mobile;
	/**
	 * 好友的备注姓名
	 */
	private String remarkName;
	/**
	 * 状态0: 已注册，1:申请中，2:好友
	 */
	private int status;
	/**
	 * 头象
	 */
	private String headIcon;
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
	 * 昵称
	 */
	private String nickName;
	/**
	 * 性别
	 */
	private Integer sex;
	
	 /**
     * 请客号
     */
    private String treamNum;

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemarkName() {
		return remarkName;
	}
	public void setRemarkName(String remarkName) {
		this.remarkName = remarkName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getHeadIcon() {
		return headIcon;
	}
	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTreamNum() {
		return treamNum;
	}
	public void setTreamNum(String treamNum) {
		this.treamNum = treamNum;
	}
	
	
}
