/*
 * Report.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-27 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报表
 * 
 * @author 掌航
 * @version 1.0 2016-04-27
 */
public class Report implements Serializable {

    private Long id;
    /**
     * 举报类型 1 举报人 2 举报活动 3 举报秀场
     */
    private Integer type;
    /**
     * 举报ID
     */
    private Long reportId;
    /**
     * 描述
     */
    private String desc;
    /**
     * 处理结果 1 未处理 2 已经处理 3 举报被驳回
     */
    private Integer result;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 处理时间
     */
    private Date mtime;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Long getReportId() {
        return reportId;
    }
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
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
        Report other = (Report) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getReportId() == null ? other.getReportId() == null : this.getReportId().equals(other.getReportId()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getReportId() == null) ? 0 : getReportId().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        return result;
    }
}