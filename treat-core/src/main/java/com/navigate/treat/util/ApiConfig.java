package com.navigate.treat.util;

import java.util.Map;

public class ApiConfig {

	private  Map<String,Object> map ;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	public  Object getApi(String apiName){
		
		return map.get(apiName);
		
	}
	
}
