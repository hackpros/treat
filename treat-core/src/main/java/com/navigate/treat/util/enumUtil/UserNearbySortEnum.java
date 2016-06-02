package com.navigate.treat.util.enumUtil;

public enum UserNearbySortEnum {
	SORT_BY_DISTANCE("按距离排序", 1), SORT_BY_TIME("按最后登录时间排序", 2);
	// 成员变量
	private String name;
	private int index;
	     
	// 构造方法
	private UserNearbySortEnum (String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("ASC:" + EnumUtil.ASC.name + EnumUtil.ASC.index);
//		System.out.println("DESC" + EnumUtil.DESC.name + EnumUtil.DESC.index);
//	}

}
