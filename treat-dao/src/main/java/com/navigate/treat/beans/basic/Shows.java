/*
 * Shows.java
 * Copyright(C) 20xx-2015 掌航科技网络公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-26 Created
 */
package com.navigate.treat.beans.basic;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态
 * 
 * @author 掌航
 * @version 1.0 2016-04-26
 */
public class Shows implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 媒体类型@
     */
    private Integer mediaType;
    /**
     * 内容
     */
    private String mediaContent;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 状态 0 正常 1 屏蔽
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date ctime;
    private String title;
    /**
     * 1 男 2 女
     */
    private Integer sex;
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
    public Integer getMediaType() {
        return mediaType;
    }
    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }
    public String getMediaContent() {
        return mediaContent;
    }
    public void setMediaContent(String mediaContent) {
        this.mediaContent = mediaContent == null ? null : mediaContent.trim();
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
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
        Shows other = (Shows) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMediaType() == null ? other.getMediaType() == null : this.getMediaType().equals(other.getMediaType()))
            && (this.getMediaContent() == null ? other.getMediaContent() == null : this.getMediaContent().equals(other.getMediaContent()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMediaType() == null) ? 0 : getMediaType().hashCode());
        result = prime * result + ((getMediaContent() == null) ? 0 : getMediaContent().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        return result;
    }
}