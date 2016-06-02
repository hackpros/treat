package com.navigate.treat.io.useractivity.response;

import java.io.Serializable;

/**
 * 
 * 用户活动首页
 *
 */
public class ActIndexRes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566712104850270834L;
	/**
	 * 活动好评
	 */
	private int actGoodCommented;
	/**
	 * 级别
	 */
	private int level;

	public int getActGoodCommented() {
		return actGoodCommented;
	}

	public void setActGoodCommented(int actGoodCommented) {
		this.actGoodCommented = actGoodCommented;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
