package com.navigate.treat.base;

import java.util.List;

public class Pages<T> implements java.io.Serializable {

	private static final long serialVersionUID = 811560197992978164L;

	private int offset;  //偏移量
	private int length;  //查询条数
	private long total;  //总条数
	private List<T> rows;  //list数据集合

	/**
	 * 是否是后一条
	 */
	private boolean lastPage;
	private String nextKeyward;
	public Pages() {

	}
	public Pages(List<T> list, long total, int offset, int length, boolean lastPage, String nextKeyward) {
		this.rows = list;
		this.total = total;
		this.offset = offset;
		this.length = length;
		this.lastPage = lastPage;
		this.nextKeyward = nextKeyward;
		/*
		 * if (length>=0){ this.totalPage=1; return; } this.totalPage = total_ /
		 * length_; if (total_ % length_ > 0) { this.totalPage++; }
		 */
	}
	
	public Pages(List<T> list, long total, int offset, int length, boolean lastPage) {
		this.rows = list;
		this.total = total;
		this.offset = offset;
		this.length = length;
		this.lastPage = lastPage;

		/*
		 * if (length>=0){ this.totalPage=1; return; } this.totalPage = total_ /
		 * length_; if (total_ % length_ > 0) { this.totalPage++; }
		 */
	}

	public Pages(List<T> list, long total, int offset, int length) {
		this.rows = list;
		this.total = total;
		this.offset = offset;
		this.length = length;

	}
	
	/**
	 * @return the nextKeyward
	 */
	public String getNextKeyward() {
		return nextKeyward;
	}

	/**
	 * @param nextKeyward the nextKeyward to set
	 */
	public void setNextKeyward(String nextKeyward) {
		this.nextKeyward = nextKeyward;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}
