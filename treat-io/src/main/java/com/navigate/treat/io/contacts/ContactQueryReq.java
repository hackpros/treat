package com.navigate.treat.io.contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactQueryReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> localMobile = new ArrayList<String>();

	public List<String> getLocalMobile() {
		return localMobile;
	}
	public void setLocalMobile(List<String> localMobile) {
		this.localMobile = localMobile;
	}
}
