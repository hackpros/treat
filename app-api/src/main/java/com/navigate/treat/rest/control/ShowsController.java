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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.api.IShowsServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.io.show.request.ShowsReq;

@Controller
@RequestMapping(value = "/shows")
public class ShowsController extends BaseController {
	static final Logger log = Logger.getLogger(ShowsController.class);
	@Resource
	IShowsServiceFront showsServiceFront;

	/**
	 * 发布秀场
	 * 
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/publishShows", method = RequestMethod.POST)
	@ResponseBody
	public Object publishShows(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.publishShows(showsReq);
	}
	
	/**
	 * 发布秀场
	 * 
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/getHomeShowsList", method = RequestMethod.POST)
	@ResponseBody
	public Object getHomeShowsList(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.getHomeShowsList(showsReq);
	}
	
	/**
	 * 删除秀场
	 * 
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/delShows", method = RequestMethod.POST)
	@ResponseBody
	public Object delShows(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.delShows(showsReq);
	}
	
	/**
	 * 秀场点赞
	 * 
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/showPraise", method = RequestMethod.POST)
	@ResponseBody
	public Object showPraise(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.showPraise(showsReq);
	}
	
	/**
	 * 获取今日之星
	 * 
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/getShowsPaiseRank", method = RequestMethod.POST)
	@ResponseBody
	public Object getShowsPaiseRank(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.getShowsPaiseRank(showsReq);
	}
	
	/**
	 * 检查用户是否发起约会
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/cheakedActStatus", method = RequestMethod.POST)
	@ResponseBody
	public Object cheakedActStatus(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.cheakedActStatus(showsReq);
	}
	
	/**
	 * 邀请对方参加活动
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/invitation", method = RequestMethod.POST)
	@ResponseBody
	public Object invitation(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.invitation(showsReq);
	}
	
	/**
	 * 获取我的动态
	 * @param showsReq
	 * @return
	 */
	@RequestMapping(value = "/getShowList4UserId", method = RequestMethod.POST)
	@ResponseBody
	public Object getShowList4UserId(@RequestBody @Validated ShowsReq showsReq) {

		return showsServiceFront.getShowList4UserId(showsReq);
	}
}
