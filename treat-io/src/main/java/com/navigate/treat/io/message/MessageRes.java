/*
 * Message.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.io.message;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 菠萝大象
 * @version 1.0 2016-04-07
 */
public class MessageRes implements Serializable {
	private Long id;
	/**
	 * 默认为系统发送id
	 */
	private Long fuid;
	/**
	 * 接收用户id
	 */
	private Long tuid;
	/**
	 * 消息类型
	 */
	private Integer mtype;
	/**
	 * 业务编码
	 */
	private Integer bizCode;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 消息内容（可为空）
	 */
	private String content;
	/**
	 * 是否执行
	 */
	private Boolean run;
	/**
	 * 是否已阅
	 */
	private Boolean read;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 添加时间
	 */
	private Date ctime;
	/**
	 * 过期时间
	 */
	private Date overdueTime;
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFuid() {
		return fuid;
	}
	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}
	public Long getTuid() {
		return tuid;
	}
	public void setTuid(Long tuid) {
		this.tuid = tuid;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	public Integer getBizCode() {
		return bizCode;
	}
	public void setBizCode(Integer bizCode) {
		this.bizCode = bizCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
	public Boolean getRun() {
		return run;
	}
	public void setRun(Boolean run) {
		this.run = run;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getOverdueTime() {
		return overdueTime;
	}
	public void setOverdueTime(Date overdueTime) {
		this.overdueTime = overdueTime;
	}
}
