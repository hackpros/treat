package com.navigate.treat.util;

public class ResponseUtil {

	private Integer result;// 返回码

	private String msg;// 返回信息

	private String desc;//描述

	public ResponseUtil(Integer result,String msg,String desc){
		this.result = result;
		this.msg = msg;
		this.desc = desc;
	}
	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
