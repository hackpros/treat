package com.navigate.treat.io.speedDating.request;


/**
 * 用户找回密码请求对象
 * 
 * @author Administrator
 *
 */
public class SpeedDatingAddReq {
	/**
	 * 请客方式
	 */
	private Integer bill;
	/**
	 * 请客类型
	 */
	private Long bizCategory;
	/**
	 * 城市编码
	 */
	private String cityCode;
	/**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
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
	public Integer getBill() {
		return bill;
	}
	public void setBill(Integer bill) {
		this.bill = bill;
	}
	public Long getBizCategory() {
		return bizCategory;
	}
	public void setBizCategory(Long bizCategory) {
		this.bizCategory = bizCategory;
	}
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpeedDatingAddReq [bill=" + bill + ", bizCategory="
				+ bizCategory + ", cityCode=" + cityCode + ", lng=" + lng
				+ ", lat=" + lat + "]";
	}
	
	
	
}
