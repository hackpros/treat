package com.navigate.treat.base.io.request;

/**
 * 请求的头部
 * 
 * @author Administrator
 *
 */
public class ReqHttpHeaders  {
	
	private String mav;
	private String mimei;
	private String msid;
	private String mt;
	private String mv;
	//渠道
	//来源
	/**
	 * 签名
	 */
	private String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getMav() {
		return mav;
	}

	public void setMav(String mav) {
		this.mav = mav;
	}

	public String getMimei() {
		return mimei;
	}

	public void setMimei(String mimei) {
		this.mimei = mimei;
	}

	public String getMsid() {
		return msid;
	}

	public void setMsid(String msid) {
		this.msid = msid;
	}

	public String getMt() {
		return mt;
	}

	public void setMt(String mt) {
		this.mt = mt;
	}

	public String getMv() {
		return mv;
	}

	public void setMv(String mv) {
		this.mv = mv;
	}

}
