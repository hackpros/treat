package com.navigate.treat.util.enumUtil;

public enum SpeedDatingSortEnum {
	SORT_BY_TIME("按时间", 2), SORT_BY_DISTANCE("按距离", 1);
	// 成员变量
	private String name;
	private int index;
	     
	// 构造方法
	private SpeedDatingSortEnum (String name, int index) {
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
