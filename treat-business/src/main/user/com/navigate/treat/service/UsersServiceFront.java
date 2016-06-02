package com.navigate.treat.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.navigate.treat.api.IUsersServiceFront;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.service.multi.IUserInfoService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.SpringBeanUtils;
import com.navigate.treat.util.UserUtil;

@Service
public class UsersServiceFront implements IUsersServiceFront {
	@Resource
	IUsersService usersService;
	@Resource
	IUserInfoService userInfoService;

	private static final Logger logger = LogManager.getLogger("UsersServiceFront");

	@Override
	public Object login(UsersReq usersReq) {
		ModelMap model = new ModelMap();
		// 验证验证吗
		if (!UsersHelper.checkCaptcha(usersReq.getMobile(), usersReq.getCaptcha())) {
			throw new BusinessException("用户名或验证码错误");
		}
		// 用户不存在就直接注册
		UsersQueryHelper example = new UsersQueryHelper();
		example.createCriteria().andMobileEqualTo(usersReq.getMobile());
		List<Users> usersList = usersService.selectByExample(example);
		if (usersList.size() == 1) {
			Users users = usersList.get(0);
			// 没有设置人个信息
			if (users.getStatus() == UsersHelper.EStatus.NoPasword.ordinal()) {
				model.addAttribute("data", users.getUserId());
				model.addAttribute("code", "setting");
				return model;
			}
			Users updateUsers = new Users();
			updateUsers.setLastLoginTime(new Date());
			example.clear();
			example.createCriteria().andMobileEqualTo(usersReq.getMobile());
			usersService.updateByExampleSelective(updateUsers, example);
			users.setLastLoginTime(updateUsers.getLastLoginTime());
			UsersLoginRes usersLoginRes = new UsersLoginRes();
			SpringBeanUtils.copyProperties(users, usersLoginRes);
			// 设置融云token
			// 如果是生产环境
			/*
			 * if (GlobalPropertiesUtil.get("deployment.environment").
			 * equalsIgnoreCase("prouduction")) {
			 * usersLoginRes.setRongYunToken(RongYunTokenUtil.getToken(users.
			 * getUserId().toString()) ); } else if
			 * (GlobalPropertiesUtil.get("deployment.environment").
			 * equalsIgnoreCase("testcase")) {
			 * usersLoginRes.setRongYunToken(RongYunTokenUtil.getToken(users.
			 * getUserId().toString()) ); } else { }
			 */
			String sid = UserUtil.saveSession(usersLoginRes);
			model.addAttribute("sid", sid);
			model.addAttribute("data", usersLoginRes);
			model.addAttribute("code", "index");
		} else if (usersList.size() == 0) {
			// 注册.
			model.addAttribute("data", register(usersReq));
			model.addAttribute("code", "setting");
		} else {
			throw new BusinessException(ResponseCode.FAIL_USER_DATA_ERROR.getDesc());
		}
		return model;
	}

	@Override
	public Object register(UsersReq usersReq) {
		// 验证验证吗
		if (!UsersHelper.checkCaptcha(usersReq.getMobile(), usersReq.getCaptcha())) {
			throw new BusinessException("用户名或验证码错误");
		}
		Users users = new Users();
		users.setMobile(usersReq.getMobile());
		users.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		users.setCtime(new Date());
		users.setStatus(UsersHelper.EStatus.NoPasword.ordinal());
		users.setTreamNum(usersReq.getMobile());
		users.setUserSource(usersReq.getUserSource());
		usersService.insertSelective(users);
		UsersHelper.removeCaptcha(users.getMobile());
		return users.getUserId();
	}

	@Override
	public void modify(UsersReq usersReq) {

		usersReq.setUserId(null);
		UsersLoginRes usersLoginRes = UserUtil.getUsers();

		UsersQueryHelper example = new UsersQueryHelper();
		example.createCriteria().andUserIdEqualTo(usersLoginRes.getUserId());
		List<Users> userList = usersService.selectByExample(example);
		if (userList.size() != 1) {
			throw new BusinessException(ResponseCode.FAIL_USER_NOT_EXITIS.getDesc());
		}
		Users users = userList.get(0);
		SpringBeanUtils.copyProperties(usersReq, users);
		users.setMtime(new Date());

		// users.setBackgroundImage("");
		usersService.updateByPrimaryKeySelective(users);

		SpringBeanUtils.copyProperties(users, usersLoginRes);
		String sid = UserUtil.saveSession(usersLoginRes);
		logger.info("sid:{}", sid);

	}

	@Override
	public Object modifySimple(UsersReq usersReq) {
		UsersQueryHelper example = new UsersQueryHelper();
		example.createCriteria().andUserIdEqualTo(usersReq.getUserId());
		List<Users> userList = usersService.selectByExample(example);
		if (userList.size() != 1) {
			throw new BusinessException(ResponseCode.FAIL_USER_NOT_EXITIS.getDesc());
		}
		Users users = userList.get(0);
		SpringBeanUtils.copyProperties(usersReq, users);
		users.setMtime(new Date());
		users.setStatus(UsersHelper.EStatus.Normal.ordinal());
		users.setLastLoginTime(new Date());
		// users.setBackgroundImage("");
		usersService.updateByPrimaryKeySelective(users);
		UsersLoginRes res = new UsersLoginRes();
		SpringBeanUtils.copyProperties(users, res);
		String sid = UserUtil.saveSession(res);
		ModelMap model = new ModelMap();
		model.addAttribute("sid", sid);
		model.addAttribute("data", res);
		logger.info("sid:{}", sid);
		logger.info("user session:{}", res);

		return model;
	}

	@Override
	public Object registerV1(UsersReq usersReq) {
		
		Users users = new Users();
		users.setMobile(usersReq.getMobile());
		users.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		users.setCtime(new Date());
		users.setStatus(UsersHelper.EStatus.NoPasword.ordinal());
		users.setTreamNum(usersReq.getMobile());
		users.setUserSource(usersReq.getUserSource());
		usersService.insertSelective(users);
		return users.getUserId();
	}

	@Override
	public Object modifyV1(UsersReq usersReq) {
		Users users = new Users();
		SpringBeanUtils.copyProperties(usersReq, users);
		users.setMtime(new Date());
		users.setStatus(UsersHelper.EStatus.Normal.ordinal());
		users.setLastLoginTime(new Date());
		UsersQueryHelper e=new UsersQueryHelper();
		e.createCriteria().andMobileEqualTo(usersReq.getMobile());
		int row=usersService.updateByExampleSelective(users, e);
		return row;
		
	}
}
