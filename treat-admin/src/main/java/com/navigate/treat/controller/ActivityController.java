package com.navigate.treat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

@Controller
public class ActivityController extends BaseController {
	private static final Logger logger = LogManager.getLogger(ActivityController.class);

	@Resource
	/**
	 * 获取线下约会列表
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "activity/getOfflineList.do")
	@ResponseBody
	public Map<String, Object> getOfflineList(HttpServletRequest req, HttpServletResponse resp,
			UserActivitiesVo userActivitiesVo) {
		if (userActivitiesVo.getMobile() != null && !"".equals(userActivitiesVo.getMobile())) {
			List<Users> UsersList = userService.getUserByMobile(userActivitiesVo.getMobile());
			if (UsersList != null && UsersList.size() > 0) {
				userActivitiesVo.setUserId(UsersList.get(0).getUserId());
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				List<UserActivities> OfflineList = new ArrayList<UserActivities>();
				map.put("offlineList", OfflineList);
				map.put("total", 0);
				return map;
			}
		}
		List<UserActivities> offlineList = activityService.getOfflineList(userActivitiesVo);
		PageInfo<UserActivities> page = new PageInfo<UserActivities>(offlineList);
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("offlineList", page.getList());
		mapMod.put("total", page.getTotal());
		logger.info(page.getList().toString());
		return mapMod;
	}
}
