package com.navigate.treat.io.version;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author fwg create by  2015年12月16日 下午5:20:47
 *
 */
public class AppVerRes  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7616632602852950008L;
	/**
     * 主键
     */
    private Long id;
    /**
     * 类型
     */
    private String category;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 更新级别
     */
    private String level;
    /**
     * 下载地址
     */
    private String download;
    /**
     * 发布时间
     */
    private Date releaseTime;
    /**
     * 内容
     */
    private String content;
    
    
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
    
    
	
}
