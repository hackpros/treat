package com.navigate.treat.io.useractivity.request;

import com.navigate.treat.base.BaseRequest;

/**
 * 
 * 活动详情查询对象
 *
 */
public class ActDetailReq extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5377910124362504815L;

	private String status;
	
	private Long userId;

	public enum EActStatus {

		
		FINSIHED, // 结束
		DOING, // 进行中
		UNSTART;//为开始
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
