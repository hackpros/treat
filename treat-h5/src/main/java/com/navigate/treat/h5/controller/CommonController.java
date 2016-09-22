package com.navigate.treat.h5.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共的
 * 
 * @author Administrator
 *
 */
@Controller
public class CommonController  {
	
	public final static String APP_ID="wxca172b9d7dcfa887";
	public final static String APPSECRET="d4624c36b6795d1d99dcf0547af5443d";

	/**
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/main")
	public String send(Model model) throws UnsupportedEncodingException {
		
		//me//wxca172b9d7dcfa887
		//wy //wx10996b8ed090bd1c  wxe2bba7f91807e5b7
		model.addAttribute("APPID_WECHAT", APP_ID);
		
		String redirect_uri=java.net.URLDecoder.decode("http://wxdev02.jumore.com/static/main.do",   "utf-8");     
		model.addAttribute("redirect_uri", redirect_uri);
		
		return "/main";
	}

	protected String getToken() {
		// TODO Auto-generated method stub
		return null;
	};

}
