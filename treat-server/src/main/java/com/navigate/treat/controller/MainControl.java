/**
 * 
 * UsersController.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainControl {
	static final Logger log =  LogManager.getLogger(MainControl.class);

	/**
	 * 测试页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test")
	@ResponseBody
	public Model login(Model model) {
		model.addAttribute("title", "欢迎使用新版我请客app-service");
		model.addAttribute("version", "2.1");
		return model;
	}
}
