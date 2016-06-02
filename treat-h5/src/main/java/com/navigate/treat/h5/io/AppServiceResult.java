package com.navigate.treat.h5.io;

/*
 * appService 返回对象
 */
public class AppServiceResult<T> implements IH5Response  {

	private static final long serialVersionUID = 1L;
	
	private String api;
	private String v;
	private String result;
	private String msg;// 返回信息
	private String desc;// 描述
	private T data;
	private String sid;
	private long systime;
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public long getSystime() {
		return systime;
	}
	public void setSystime(long systime) {
		this.systime = systime;
	}
	@Override
	public String toString() {
		return "AppServiceResult [api=" + api + ", v=" + v + ", result=" + result + ", msg=" + msg + ", desc=" + desc
				+ ", data=" + data + ", sid=" + sid + ", systime=" + systime + "]";
	}
	
	
	
}
