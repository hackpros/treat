package com.navigate.treat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.navigate.treat.po.basic.UserSource;
import com.navigate.treat.po.basic.UserSourceVo;
import com.navigate.treat.service.UserSourceService;


@Controller
public class UserSourceController extends BaseController {
	@Autowired
	private UserSourceService userSourceService;

	//获取用户列表
	@RequestMapping(value = "userSource/getUserSourceList.do")
	@ResponseBody
	public Map<String, Object> getUserSourceList(HttpServletRequest req, HttpServletResponse resp, UserSourceVo userSourceVo) {
		
		List<UserSource> userSourceList = userSourceService.getUserSourceList(userSourceVo);
		PageInfo<UserSource> page = new PageInfo<UserSource>(userSourceList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("userSourceList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	
	@RequestMapping(value = "userSource/addUserSource.do")
	@ResponseBody
	public String addUserSource(HttpServletRequest req, HttpServletResponse resp, UserSource userSource) {
		userSource.setCtime(new Date());
		userSource.setReview(0);
		int result = userSourceService.addUserSource(userSource);
		
		return String.valueOf(result);
	}
	//注销
	@RequestMapping(value = "userSource/logout.do")
	public String logout(HttpServletRequest req, HttpServletResponse resp, UserSource userSource) {
		userSource.setReview(1);
		userSourceService.changeReview(userSource);
		return "jsp/usersource/userSource";
	}
	//激活
	@RequestMapping(value = "userSource/activation.do")
	public String activation(HttpServletRequest req, HttpServletResponse resp, UserSource userSource) {
		userSource.setReview(0);
		userSourceService.changeReview(userSource);
		return "jsp/usersource/userSource";
	}
	//删除
	@RequestMapping(value = "userSource/deleteUserSource.do")
	@ResponseBody
	public String deleteUserSource(HttpServletRequest req, HttpServletResponse resp) {
		String ids = req.getParameter("ids");
		String[] idArr = ids.split(",");
		for(int i=0;i<idArr.length;i++){
			userSourceService.deleteUserSource(Integer.parseInt(idArr[i]));
		}
		return "ok";
	}
}
