package com.navigate.treat.io.speedDating.request;

import com.navigate.treat.base.BaseRequest;

/**
 * 用户礼物查询请求对象
 * @author Administrator
 *
 */
public class SpeedDatingReq extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sortType;
	private Long cityCode;
	private Integer sex;
	private Long bizCategory;
	private Double lng;
	private Double lat;
	
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Long getBizCategory() {
		return bizCategory;
	}
	public void setBizCategory(Long bizCategory) {
		this.bizCategory = bizCategory;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Long getCityCode() {
		return cityCode;
	}
	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getSortType() {
		return sortType;
	}
	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}
	@Override
	public String toString() {
		return "SpeedDatingReq [sortType=" + sortType + ", cityCode="
				+ cityCode + ", sex=" + sex + ", bizCategory=" + bizCategory
				+ ", lng=" + lng + ", lat=" + lat + "]";
	}
	
	
	
}

