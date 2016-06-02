package com.navigate.treat.io.show.response;

import java.io.Serializable;
import java.util.Date;

import com.navigate.treat.base.BaseDO;
import com.navigate.treat.io.user.response.UserHeadRes;

/**
 * 
 * @author huangshiping
 * 
 *         活动响应参数
 */
public class ShowsRes extends BaseDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long showId;
	private Long userId;
	private Integer mediaType;
	private String mediaContent;
	private String lng;
	private String lat;
	private Integer status;
	private String title;
	private Integer praiseNum;
	private Boolean praise;
	private Date ctime;
	private UserHeadRes userHeadRes = new UserHeadRes();

	public Long getShowId() {
		return showId;
	}

	public void setShowId(Long showId) {
		this.showId = showId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public UserHeadRes getUserHeadRes() {
		return userHeadRes;
	}

	public void setUserHeadRes(UserHeadRes userHeadRes) {
		this.userHeadRes = userHeadRes;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Boolean getPraise() {
		return praise;
	}

	public void setPraise(Boolean praise) {
		this.praise = praise;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
