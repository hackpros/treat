package com.navigate.treat.io.version;

import com.navigate.treat.io.version.AppVerHelper.EAppCategory;
import com.navigate.treat.io.version.AppVerHelper.ELevel;

/**
 * 获取app的版本信息
 * @author fwg create by 2015年12月16日 下午5:23:02
 */
public class AppVerReq {
	/**
	 * 客户类型
	 * @see AppVerHelper.ELevel
	  */
	private EAppCategory category;
	/**
	 * 更新级别 @see AppVerHelper.ELevel
	 */
	private ELevel level;
	public EAppCategory getCategory() {
		return category;
	}
	public void setCategory(EAppCategory category) {
		this.category = category;
	}
	public ELevel getLevel() {
		return level;
	}
	public void setLevel(ELevel level) {
		this.level = level;
	}
	
	
}
