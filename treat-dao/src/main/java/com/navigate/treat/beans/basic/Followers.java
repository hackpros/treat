/*
 * Followers.java
 * Copyright(C) 20xx-2015 xxxxxx鍏徃
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * 好友关注列表
 * 
 * @author 鑿犺悵澶ц薄
 * @version 1.0 2016-04-19
 */
public class Followers implements Serializable {

    /**
     * 主键自增
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 粉丝Id
     */
    private Long followerUserId;
    /**
     * 关注时间
     */
    private Date ctime;
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
    public Long getFollowerUserId() {
        return followerUserId;
    }
    public void setFollowerUserId(Long followerUserId) {
        this.followerUserId = followerUserId;
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
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
        Followers other = (Followers) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFollowerUserId() == null ? other.getFollowerUserId() == null : this.getFollowerUserId().equals(other.getFollowerUserId()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFollowerUserId() == null) ? 0 : getFollowerUserId().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        return result;
    }
}