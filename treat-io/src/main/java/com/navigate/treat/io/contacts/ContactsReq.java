package com.navigate.treat.io.contacts;

import java.io.Serializable;

/**
 * 用户手机的本地联系人
 * @author fwg create by 2015年12月17日 下午4:41:27
 */
public class ContactsReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 通讯录号码
	 */
	private String mobile;
	/**
	 * 状态 0：通讯录，1:本平台注册了2：创建了好友关系
	 */
	private int status;
	/**
	 * 通讯录号码备注
	 */
	private String remarkName;

	public ContactsReq(String mobile) {
		this.mobile = mobile;
	}
	public ContactsReq(String mobile, int status) {
		this.mobile = mobile;
		this.status = status;
	}
	public ContactsReq() {
	}
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
}
