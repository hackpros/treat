/*
 * UserFollower.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-12 Created
 */
package com.navigate.treat.base;

import java.io.Serializable;

/**
 * 分页查询请求对象
 * 
 * @author 菠萝大象
 * @version 1.0 2015-11-12
 */
public class BaseRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5405867850353264830L;
	/**
	 * 查询多少条
	 */
	private int length;
	/**
	 * 依稀量。 每几条开始查询
	 */
	private int offset;
	/**
	 * 查询下一页关键字
	 */
	private String nextKeyward;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getNextKeyward() {
		return nextKeyward;
	}

	public void setNextKeyward(String nextKeyward) {
		this.nextKeyward = nextKeyward;
	}

}