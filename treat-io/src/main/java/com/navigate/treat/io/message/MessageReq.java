/*
 * Message.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.io.message;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.navigate.treat.base.io.request.IRequest;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;

/**
 * @author 菠萝大象
 * @version 1.0 2016-04-07
 */
public class MessageReq implements IRequest {
	// #####附带参数
	// 活动Id
	private Long activityId;
	// 用户Id
	private Long userId;
	/**
	 * 消息业务类型
	 */
	private EBizCode bizCode;
	// ###########
	
	@NotNull(message = "消息执行方向不能为空")
	private MessageHelper.EResult result;
	
	@NotNull(message = "消息对像不能为空")
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
	 * 消息类型，用户显示对应icon
	 */
	private Integer mtype;
	/**
	 *  标题
	 */
	private String title;
	/**
	 * 消息内容（可为空）
	 */
	private String content;
	/**
	 * 操作类型.可操作，不可操作
	 */
	private Integer operation;
	/**
	 * 跳转类型
	 */
	private Integer targetType;
	/**
	 * 跳转地址
	 */
	private String targetUrl;
	/**
	 * 参数
	 */
	private String args;
	/**
	 * 是否执行
	 */
	private Boolean run;
	/**
	 * 是否已阅
	 */
	private Boolean iread;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 添加时间
	 */
	private Date ctime;

	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
	public Integer getOperation() {
		return operation;
	}
	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	public Integer getTargetType() {
		return targetType;
	}
	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl == null ? null : targetUrl.trim();
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args == null ? null : args.trim();
	}
	public Boolean getRun() {
		return run;
	}
	public void setRun(Boolean run) {
		this.run = run;
	}
	public Boolean getIread() {
		return iread;
	}
	public void setIread(Boolean iread) {
		this.iread = iread;
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
	public MessageHelper.EResult getResult() {
		return result;
	}
	public void setResult(MessageHelper.EResult result) {
		this.result = result;
	}
	public EBizCode getBizCode() {
		return bizCode;
	}
	public void setBizCode(EBizCode bizCode) {
		this.bizCode = bizCode;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	
	
}
