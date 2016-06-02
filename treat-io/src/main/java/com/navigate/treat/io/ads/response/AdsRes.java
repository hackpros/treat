/*
 * ActivitysReg.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-07 Created
 */
package com.navigate.treat.io.ads.response;

import java.io.Serializable;
import java.util.Date;

import com.navigate.treat.base.BaseDO;

/**
 * 
 * 
 * @author 菠萝大象
 * @version 1.0 2016-04-07
 */
public class AdsRes extends BaseDO implements Serializable {

	
    private Long adsId;
    /**
     * 图片跳转地址
     */
    private String url;
    /**
     * 位置 1 首页广告 2 商业广告
     */
    private Integer positon;
    /**
     * 图片地址
     */
    private String imgUrl;
    private Date ctime;
    /**
     * 图片标题
     */
    private String title;
    private static final long serialVersionUID = 1L;


    public String getUrl() {
        return url;
    }
    public Long getAdsId() {
		return adsId;
	}
	public void setAdsId(Long adsId) {
		this.adsId = adsId;
	}
	public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    public Integer getPositon() {
        return positon;
    }
    public void setPositon(Integer positon) {
        this.positon = positon;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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



}