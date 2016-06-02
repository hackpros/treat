package com.navigate.treat.up;

import java.io.Serializable;

/**
 * author huangshiping
 * 
 * @date:Aug 29, 201510:18:17 AM
 * @version:1.0
 * 
 */

public class UploadObj implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文件上传后的绝对路径包括文件
	 */
	private String path;
	/**
	 * 相对路径
	 */
	private String relativePath;
	/**
	 * 文件本身的名字
	 */
	private String name;

	/**
	 * 文件类型
	 */
	private String type;
	/**
	 * 截图路径
	 */
	private String sub_img_path;
	private String relativeSubImgPath;
	/**
	 * 缩略图路径
	 */
	private String small_img_path;

	/**
	 * relativeSmallImgPath
	 */
	private String relativeSmallImgPath;

	public UploadObj(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSub_img_path() {
		return sub_img_path;
	}

	public void setSub_img_path(String sub_img_path) {
		this.sub_img_path = sub_img_path.replaceAll("\\\\", "/");
	}

	public String getSmall_img_path() {
		return small_img_path;
	}

	public void setSmall_img_path(String small_img_path) {
		this.small_img_path = small_img_path.replaceAll("\\\\", "/");
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getRelativeSubImgPath() {
		return relativeSubImgPath;
	}

	public void setRelativeSubImgPath(String relativeSubImgPath) {
		this.relativeSubImgPath = relativeSubImgPath.replaceAll("\\\\", "/");
	}

	public String getRelativeSmallImgPath() {
		return relativeSmallImgPath;
	}

	public void setRelativeSmallImgPath(String relativeSmallImgPath) {
		this.relativeSmallImgPath = relativeSmallImgPath.replaceAll("\\\\", "/");
	}

}
