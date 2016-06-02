/*
 * UserFriends.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-06 Created
 */
package com.navigate.treat.beans.multi;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author 菠萝大象
 * @version 1.0 2015-11-06
 */
public class UserFriends implements Serializable {

    /**
     * 自增主键
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 好友Id
     */
    private Long fuserId;
    /**
     * 备注姓名
     */
    private String remarkName;
    /**
     * 分组Id
     */
    private Long groupId;
    /**
     * 验证好友状态@ 1 已经添加
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 修改时间
     */
    private Date mtime;
    /**
     * 备注
     */
    private String remark;
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getFuserId() {
        return fuserId;
    }
    public void setFuserId(Long fuserId) {
        this.fuserId = fuserId;
    }
    public String getRemarkName() {
        return remarkName;
    }
    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName == null ? null : remarkName.trim();
    }
    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
    public Date getMtime() {
        return mtime;
    }
    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        UserFriends other = (UserFriends) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFuserId() == null ? other.getFuserId() == null : this.getFuserId().equals(other.getFuserId()))
            && (this.getRemarkName() == null ? other.getRemarkName() == null : this.getRemarkName().equals(other.getRemarkName()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getMtime() == null ? other.getMtime() == null : this.getMtime().equals(other.getMtime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFuserId() == null) ? 0 : getFuserId().hashCode());
        result = prime * result + ((getRemarkName() == null) ? 0 : getRemarkName().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getMtime() == null) ? 0 : getMtime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
	@Override
	public String toString() {
		return "UserFriends [id=" + id + ", userId=" + userId + ", fuserId="
				+ fuserId + ", remarkName=" + remarkName + ", groupId="
				+ groupId + ", status=" + status + ", ctime=" + ctime
				+ ", mtime=" + mtime + ", remark=" + remark + "]";
	}
    
    
}