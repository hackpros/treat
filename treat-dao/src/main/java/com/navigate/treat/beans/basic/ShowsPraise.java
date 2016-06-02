/*
 * ShowsPraise.java
 * Copyright(C) 20xx-2015 xxxxxx鍏徃
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-19 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态点赞
 * 
 * @author 鑿犺悵澶ц薄
 * @version 1.0 2016-04-19
 */
public class ShowsPraise implements Serializable {

    /**
     * 主键自增
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 动态ID
     */
    private Long showId;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 发布者Id
     */
    private Long showUserId;
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
    public Long getShowId() {
        return showId;
    }
    public void setShowId(Long showId) {
        this.showId = showId;
    }
    public Date getCtime() {
        return ctime;
    }
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
    public Long getShowUserId() {
        return showUserId;
    }
    public void setShowUserId(Long showUserId) {
        this.showUserId = showUserId;
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
        ShowsPraise other = (ShowsPraise) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShowId() == null ? other.getShowId() == null : this.getShowId().equals(other.getShowId()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getShowUserId() == null ? other.getShowUserId() == null : this.getShowUserId().equals(other.getShowUserId()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShowId() == null) ? 0 : getShowId().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getShowUserId() == null) ? 0 : getShowUserId().hashCode());
        return result;
    }
}