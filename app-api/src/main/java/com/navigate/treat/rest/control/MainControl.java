/**
 * 
 * UsersController.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015-10-30 Created
 */
package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.navigate.treat.api.IMessageServiceFront;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.service.multi.IUsersService;

@Controller
public class MainControl {
	static final Logger log = LogManager.getLogger(MainControl.class);
	@Resource
	IUsersService userService;
	@Resource
	IMessageServiceFront messageServiceFront;

	/**
	 * 测试页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/test")
	@ResponseBody
	public ModelMap test() {
		ModelMap model = new ModelMap();
		model.addAttribute("title", "欢迎使用新版我请客app-service");
		model.addAttribute("version", "2.1");
		UsersQueryHelper e=new UsersQueryHelper();
		PageHelper.startPage(0, 3);
		model.addAttribute("users", userService.selectByExample(e));
		
		log.info("tes log4j2 :{} "," hello log4j2");
		log.debug("tes log4j2 :{} "," hello log4j2");
		log.error("tes log4j2 :{} "," hello log4j2");
		return model;
	}
	/**
	 * 测试页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testTranactional")
	@ResponseBody
	public ModelMap testTranactional() {
		ModelMap model = new ModelMap();
		model.addAttribute("title", "欢迎使用新版我请客app-service");
		model.addAttribute("version", "2.1");
		log.info("tes log4j2 :{} "," hello log4j2");
		log.debug("tes log4j2 :{} "," hello log4j2");
		log.error("tes log4j2 :{} "," hello log4j2");
		messageServiceFront.testTraactional();
		
		return model;
	}
	
}
