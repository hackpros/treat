package com.navigate.treat.h5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共的
 * 
 * @author Administrator
 *
 */
@Controller
public class CommonController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String send() {
		return "/interface";
	};
}
