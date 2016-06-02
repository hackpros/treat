/*
 * Message.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-15 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author 菠萝大象
 * @version 1.0 2016-04-15
 */
public class Message implements Serializable {

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
     * 操作类型
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
    /**
     * 过期时间
     */
    private Date overdueTime;
    /**
     * 参数对应的java类名
     */
    private String javaBean;
    private static final long serialVersionUID = 1L;
    
    public Message(){
    	
    }

	public Message(Long id) {
		this.id = id;
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
    public Date getOverdueTime() {
        return overdueTime;
    }
    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }
    public String getJavaBean() {
        return javaBean;
    }
    public void setJavaBean(String javaBean) {
        this.javaBean = javaBean == null ? null : javaBean.trim();
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Message other = (Message) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFuid() == null ? other.getFuid() == null : this.getFuid().equals(other.getFuid()))
            && (this.getTuid() == null ? other.getTuid() == null : this.getTuid().equals(other.getTuid()))
            && (this.getMtype() == null ? other.getMtype() == null : this.getMtype().equals(other.getMtype()))
            && (this.getBizCode() == null ? other.getBizCode() == null : this.getBizCode().equals(other.getBizCode()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
            && (this.getTargetUrl() == null ? other.getTargetUrl() == null : this.getTargetUrl().equals(other.getTargetUrl()))
            && (this.getArgs() == null ? other.getArgs() == null : this.getArgs().equals(other.getArgs()))
            && (this.getRun() == null ? other.getRun() == null : this.getRun().equals(other.getRun()))
            && (this.getIread() == null ? other.getIread() == null : this.getIread().equals(other.getIread()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getOverdueTime() == null ? other.getOverdueTime() == null : this.getOverdueTime().equals(other.getOverdueTime()))
            && (this.getJavaBean() == null ? other.getJavaBean() == null : this.getJavaBean().equals(other.getJavaBean()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFuid() == null) ? 0 : getFuid().hashCode());
        result = prime * result + ((getTuid() == null) ? 0 : getTuid().hashCode());
        result = prime * result + ((getMtype() == null) ? 0 : getMtype().hashCode());
        result = prime * result + ((getBizCode() == null) ? 0 : getBizCode().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getTargetUrl() == null) ? 0 : getTargetUrl().hashCode());
        result = prime * result + ((getArgs() == null) ? 0 : getArgs().hashCode());
        result = prime * result + ((getRun() == null) ? 0 : getRun().hashCode());
        result = prime * result + ((getIread() == null) ? 0 : getIread().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getOverdueTime() == null) ? 0 : getOverdueTime().hashCode());
        result = prime * result + ((getJavaBean() == null) ? 0 : getJavaBean().hashCode());
        return result;
    }
}