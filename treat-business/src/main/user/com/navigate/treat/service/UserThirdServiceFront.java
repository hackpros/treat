package com.navigate.treat.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.navigate.treat.api.IUserThirdServiceFront;
import com.navigate.treat.beans.basic.UserThird;
import com.navigate.treat.beans.basic.UserThirdQueryHelper;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.user.requeset.UserThirdRegReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.service.basic.IUserThirdService;
import com.navigate.treat.service.multi.IUserInfoService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.SpringBeanUtils;
import com.navigate.treat.util.UserUtil;

/**
 * 第三方用户登录接口
 * @author fwg
 */
@Service
public class UserThirdServiceFront implements IUserThirdServiceFront {
	@Resource
	IUsersService usersService;
	@Resource
	IUserInfoService usersInfoService;
	@Resource
	IUserThirdService userThirdService;

	@Override
	public Object login(UserThirdRegReq userThirdRegReq) {
		ModelMap model = new ModelMap();
		// 查询一下用户一否注册过，未
		UserThirdQueryHelper example = new UserThirdQueryHelper();
		example.createCriteria().andTypeEqualTo(userThirdRegReq.getType())
				.andOpenIdEqualTo(userThirdRegReq.getOpenId());
		List<UserThird> userThirds = userThirdService.selectByExample(example);
		if (userThirds.size() == 0) {
			UserThird userThird = new UserThird();
			SpringBeanUtils.copyProperties(userThirdRegReq, userThird);
			userThird.setUserId(-1L);
			userThirdService.insertSelective(userThird);
			model.addAttribute("data", userThird.getId());
			model.addAttribute("code", "register");
			return model;
		}else{
			if (userThirds.get(0).getUserId()==-1){
				model.addAttribute("data", userThirds.get(0).getId());
				model.addAttribute("code", "register");
				return model;
			}
		}
		UsersQueryHelper e = new UsersQueryHelper();
		e.createCriteria().andUserIdEqualTo(userThirds.get(0).getUserId());
		List<Users> usersList = usersService.selectByExample(e);
		if (usersList.size() == 1) {
			Users users = usersList.get(0);
			// 没有设置人个信息
			if (users.getStatus() == UsersHelper.EStatus.NoPasword.ordinal()) {
				model.addAttribute("data", users.getUserId());
				model.addAttribute("code", "register");
				return model;
			}
			Users updateUsers = new Users();
			updateUsers.setLastLoginTime(new Date());
			UsersQueryHelper exp = new UsersQueryHelper();
			exp.createCriteria().andUserIdEqualTo(users.getUserId());
			usersService.updateByExampleSelective(updateUsers, exp);
			users = usersService.selectByPrimaryKey(users);
			UsersLoginRes usersLoginRes = new UsersLoginRes();
			SpringBeanUtils.copyProperties(users, usersLoginRes);
			String sid = UserUtil.saveSession(usersLoginRes);
			model.addAttribute("sid", sid);
			model.addAttribute("data", usersLoginRes);
		} else {
			throw new BusinessException(ResponseCode.FAIL_USER_DATA_ERROR.getDesc());
		}
		return model;
	}
	@Override
	public Object bindingMobile(UserThirdRegReq userThirdRegReq) {
		// 验证验证吗
		if (!UsersHelper.checkCaptcha(userThirdRegReq.getMobile(), userThirdRegReq.getCaptcha())) {
			throw new BusinessException("用户名或验证码错误");
		}
		//
		// 查询一下用户一否注册过，未
		UserThirdQueryHelper example = new UserThirdQueryHelper();
		example.createCriteria().andIdEqualTo(userThirdRegReq.getThirdId()).andOpenIdEqualTo(userThirdRegReq.getOpenId());
		List<UserThird> userThirds = userThirdService.selectByExample(example);
		if (userThirds.size() != 1) {
			throw new BusinessException(ResponseCode.FAIL_THIRD_BINDED.getDesc());
		}
		// 验证手同号是绑定了其它第三方账号
		if (userThirds.get(0).getUserId()!=-1) {
			throw new BusinessException(ResponseCode.FAIL_USER_DATA_ERROR.getDesc());
		}
		ModelMap model = new ModelMap();
		UsersQueryHelper e = new UsersQueryHelper();
		e.createCriteria().andMobileEqualTo(userThirdRegReq.getMobile());
		List<Users> usersList = usersService.selectByExample(e);
		if (usersList.size()==0){
			
			 Users users = new Users(); 
			 users.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
			 users.setCtime(new Date()); 
			 users.setStatus(UsersHelper.EStatus.NoPasword.ordinal());
			 users.setMobile(userThirdRegReq.getMobile());
			 users.setTreamNum(userThirdRegReq.getMobile());
			 usersService.insertSelective(users);
			// 没有关联就直接关联
			UserThird userThird = new UserThird();
			userThird.setUserId(users.getUserId());
			userThird.setId(userThirdRegReq.getThirdId());
			userThirdService.updateByPrimaryKeySelective(userThird);
			model.addAttribute("data", users.getUserId());
			model.addAttribute("code", "setting");
			
		}else{
			Users users = usersList.get(0);
			//如果 手机号已存右,验证是
			example.clear();
			if (users.getStatus() == UsersHelper.EStatus.Normal.ordinal()) {
				example.createCriteria().andIdEqualTo(users.getUserId()).andOpenIdEqualTo(userThirdRegReq.getOpenId());
				if (userThirdService.countByExample(example)>0){
					throw new BusinessException(ResponseCode.FAIL_THIRD_REGEISTERED.getDesc());
				}
				UserThird userThird = new UserThird();
				userThird.setUserId(users.getUserId());
				userThird.setId(userThirdRegReq.getThirdId());
				userThirdService.updateByPrimaryKeySelective(userThird);
				
				Users updateUsers = new Users();
				updateUsers.setLastLoginTime(new Date());
				UsersQueryHelper exp = new UsersQueryHelper();
				exp.createCriteria().andUserIdEqualTo(users.getUserId());
				usersService.updateByExampleSelective(updateUsers, exp);
				users = usersService.selectByPrimaryKey(users);
				UsersLoginRes usersLoginRes = new UsersLoginRes();
				SpringBeanUtils.copyProperties(users, usersLoginRes);
				String sid = UserUtil.saveSession(usersLoginRes);
				model.addAttribute("sid", sid);
				model.addAttribute("data", usersLoginRes);
				
			}else{
				example.createCriteria().andIdEqualTo(users.getUserId()).andOpenIdEqualTo(userThirdRegReq.getOpenId());
				userThirdService.deleteByExample(example);
				
				UserThird userThird = new UserThird();
				userThird.setUserId(users.getUserId());
				userThird.setId(userThirdRegReq.getThirdId());
				userThirdService.updateByPrimaryKeySelective(userThird);
				model.addAttribute("data", users.getUserId());
				model.addAttribute("code", "setting");
			}
		}
		return model;
	}
}
