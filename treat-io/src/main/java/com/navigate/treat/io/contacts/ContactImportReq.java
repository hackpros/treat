package com.navigate.treat.io.contacts;

import java.io.Serializable;
import java.util.List;

public class ContactImportReq  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ContactsReq> localMobiles;

	public List<ContactsReq> getLocalMobiles() {
		return localMobiles;
	}
	public void setLocalMobiles(List<ContactsReq> localMobiles) {
		this.localMobiles = localMobiles;
	}
		
}

