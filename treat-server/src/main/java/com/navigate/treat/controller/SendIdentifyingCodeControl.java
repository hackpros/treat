package com.navigate.treat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navigate.treat.api.ICommonBiz;

@Controller
@RequestMapping(value = "/common")
public class SendIdentifyingCodeControl {
	//private static final Logger logger = LogManager.getLogger("UserController");
	@Resource
	ICommonBiz commonBiz;

	@RequestMapping(value = "/sendCatath/{mobile}")
	public void browser(Model model, @PathVariable("mobile") String mobile) {
		commonBiz.sensMsg(mobile);
	};
}
