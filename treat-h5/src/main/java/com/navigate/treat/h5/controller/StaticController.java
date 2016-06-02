package com.navigate.treat.h5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户详情
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/static")
public class StaticController {
	//private static final Logger log = LogManager.getLogger(StaticController.class);

	/**
	 * 关于我请客
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/about")
	public String about(Model model) {
		return "/static/about";
	};

	/**
	 * 关于活动规则
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/activityRule")
	public String activityRule(Model model) {
		return "/static/activityrule";
	};

	/**
	 * 用户注册协议
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/prot")
	public String protocol(Model model) {
		return "/static/prot";
	};
	/**
	 * 活动XX说明(担保金和赴约补贴说明)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/explain")
	public String explain(Model model) {
		return "/static/explain";
	};
}
