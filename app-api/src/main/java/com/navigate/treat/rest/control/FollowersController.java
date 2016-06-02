package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IFollowerServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.io.usercenter.request.FollowerReq;

/**
 * 关注
 * @author fwg create by  2016年4月19日 上午11:05:50
 *
 */
@Controller
@RequestMapping(value = "/followers")
public class FollowersController {

	static final Logger log = Logger.getLogger(FollowersController.class);
	@Resource
	IFollowerServiceFront followerServiceFront;
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object get(Pages<?> page) {
		return followerServiceFront.select(page);
	}
	
	/**
	 * 关注
	 * @param page
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void follow (@RequestBody @Validated FollowerReq followerReq,BindingResult bindingResult) {
		followerServiceFront.insert(followerReq);
	}
	/**
	 * 取消关注
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void cancel (@RequestBody @Validated FollowerReq followerReq,BindingResult bindingResult) {
		followerServiceFront.delete(followerReq);
	}
}
