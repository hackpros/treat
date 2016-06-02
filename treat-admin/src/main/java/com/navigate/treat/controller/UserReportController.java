package com.navigate.treat.controller;

import java.util.ArrayList;
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
import com.navigate.treat.po.basic.UserActivities;
import com.navigate.treat.po.basic.UserReport;
import com.navigate.treat.po.basic.UserReportVo;
import com.navigate.treat.po.multi.Users;
import com.navigate.treat.service.UserReportService;
import com.navigate.treat.service.UserService;
@Controller
public class UserReportController {
	@Autowired
	private UserReportService userReportService;
	@Autowired
	private UserService userService;
	//获取举报列表
	@RequestMapping(value = "userReport/getUserReportList.do")
	@ResponseBody
	public Map<String, Object> getUserReportList(HttpServletRequest req, HttpServletResponse resp, UserReportVo userReportVo) {
		if(userReportVo.getMobile() != null && !"".equals(userReportVo.getMobile())){
			List<Users> UsersList = userService.getUserByMobile(userReportVo.getMobile());
			if(UsersList != null && UsersList.size()>0){
				userReportVo.setUserId(UsersList.get(0).getUserId());
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				List<UserActivities> userReportList = new ArrayList<UserActivities>();
				map.put("userReportList", userReportList);
				map.put("total", 0);
				return map;
			}
		}
		List<UserReport> userReportList = userReportService.getUserReportList(userReportVo);
		PageInfo<UserReport> page = new PageInfo<UserReport>(userReportList);
		
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("userReportList", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
}
