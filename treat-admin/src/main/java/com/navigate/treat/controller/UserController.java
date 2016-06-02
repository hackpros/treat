package com.navigate.treat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.navigate.treat.po.multi.UserDetailVo;
import com.navigate.treat.po.multi.UserInfo;
import com.navigate.treat.po.multi.Users;
import com.navigate.treat.po.multi.UsersVo;
import com.navigate.treat.service.ActivityInteractionService;
import com.navigate.treat.service.ActivityService;
import com.navigate.treat.service.FundRecordService;
import com.navigate.treat.service.UserFriendsService;
import com.navigate.treat.service.UserInfoService;
import com.navigate.treat.service.UserService;

@Controller
public class UserController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(UserController.class.getName());
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private FundRecordService fundRecordService;
	@Autowired
	private ActivityInteractionService activityInteractionService;
	@Autowired
	private UserFriendsService userFriendsService;
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 获取用户列表
	 * @param req
	 * @param resp
	 * @return
	 */
	// @RequestMapping(value = "user/getUserList1.do")
	// @ResponseBody
	// public Map<String, Object> getUserList(HttpServletRequest req, HttpServletResponse resp) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
	// Integer limit = Integer.parseInt(req.getParameter("limit"));
	//
	// String mobile = req.getParameter("mobile");
	// String nickname = req.getParameter("nickname");
	// String ctime = req.getParameter("ctime");
	//// String provincecode = req.getParameter("provincecode");
	//// String citycode = req.getParameter("citycode");
	// String sex = req.getParameter("sex");
	// String usersource = req.getParameter("usersource");
	// String status = req.getParameter("status");
	//
	// map.put("start", pageSize * limit);
	// map.put("size", limit);
	//
	// map.put("mobile", mobile);
	// map.put("nickname", nickname);
	// map.put("ctime", ctime);
	//// map.put("provincecode", provincecode);
	//// map.put("citycode", citycode);
	// map.put("sex", sex);
	// map.put("usersource", usersource);
	// map.put("status", status);
	//
	// Map<String, Object> mapMod = new HashMap<String, Object>();
	// mapMod.put("userlist", userService.getUserList(map));
	// mapMod.put("total", userService.getUserListCount(map));
	// return mapMod;
	// }
	// 获取用户列表
	@RequestMapping(value = "user/getUserList.do")
	@ResponseBody
	public Map<String, Object> getUserList1(HttpServletRequest req, HttpServletResponse resp, UsersVo usersVo) {
		logger.debug(usersVo.toString());
		List<Users> userList = userService.getUserList(usersVo);
		PageInfo<Users> page = new PageInfo<Users>(userList);
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("userlist", page.getList());
		mapMod.put("total", page.getTotal());
		return mapMod;
	}
	// 获取用户统计详情
	@RequestMapping(value = "user/userCountDetail.do")
	@ResponseBody
	public Map<String, Object> userCountDetail(HttpServletRequest req, HttpServletResponse resp, UsersVo usersVo) {
		Long userId = usersVo.getUserId();
		List<Users> userList = userService.getUserByUserId(userId);
		List<UserInfo> userInfoList = userInfoService.getUserInfoByUserId(usersVo);
		int friendCount = userFriendsService.getFriendCountByUserId(usersVo);
		int interactionCount = activityInteractionService.getInteractionCountByUserId(usersVo);
		int onlineCount = activityService.getOnlineCountByUserId(usersVo);
		int offlineCount = activityService.getOfflineCountByUserId(usersVo);
		double rechargeCount = fundRecordService.getRechargeCountByUserId(usersVo);
		UserDetailVo userDetail = new UserDetailVo();
		userDetail.setUserId(userId);
		userDetail.setRechargeCount(rechargeCount);
		if (userInfoList != null && userInfoList.size() > 0) {
			userDetail.setAccountBalance(userInfoList.get(0).getBalance());
			userDetail.setCharm(userInfoList.get(0).getAllureValue());
		}
		userDetail.setOnlineCount(onlineCount);
		userDetail.setOfflineCount(offlineCount);
		userDetail.setInteractionCount(interactionCount);
		userDetail.setFriendCount(friendCount);
		if (userList != null && userList.size() > 0) {
			userDetail.setCrown(userList.get(0).getCrown());
			userDetail.setPigeon(userList.get(0).getPigeon());
		}
		List<UserDetailVo> list = new ArrayList<UserDetailVo>();
		list.add(userDetail);
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("userDetailList", list);
		mapMod.put("total", 1);
		return mapMod;
	}
	// 更改用户审核状态
	@RequestMapping(value = "user/changeStatus.do")
	@ResponseBody
	public String changeStatus(HttpServletRequest req, HttpServletResponse resp) {
		String userIds = req.getParameter("userIds");
		int status = Integer.parseInt(req.getParameter("status"));
		String[] userIdList = userIds.split(",");
		for (int i = 0; i < userIdList.length; i++) {
			userService.changeStatus(userIdList[i], status);
		}
		// Map<String, Object> mapMod = new HashMap<String, Object>();
		return "ok";
	}
}
