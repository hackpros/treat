package com.navigate.treat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.api.IFollowerServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.Followers;
import com.navigate.treat.beans.basic.FollowersQueryHelper;
import com.navigate.treat.beans.multi.UsersQueryHelper;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.usercenter.request.FollowerReq;
import com.navigate.treat.io.usercenter.response.FollowerRes;
import com.navigate.treat.service.basic.IFollowersService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.SpringBeanUtils;
import com.navigate.treat.util.UserUtil;

/**
 * @author fwg create by 2016年4月19日 上午11:27:39
 */
@Service
public class FollowerServiceFront implements IFollowerServiceFront {
	@Resource
	IFollowersService followersService;
	@Resource
	IUsersService usersService;

	@Override
	public Pages<FollowerRes> select(Pages<?> page) {
		UsersLoginRes user = UserUtil.getUsers();
		
		PageHelper.startPage(page.getOffset(), page.getLength());
		FollowersQueryHelper e = new FollowersQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId());
		e.setOrderByClause("ctime desc");
		List<Followers> list = followersService.selectByExample(e);
		PageInfo<Followers> pages = new PageInfo<Followers>(list);
		
		List<FollowerRes> followerResList = new ArrayList<FollowerRes>();
		for (Followers followers : pages.getList()) {
			FollowerRes res = new FollowerRes();
			SpringBeanUtils.copyProperties(followers, res);
			followerResList.add(res);
		}
		return new Pages<FollowerRes>(followerResList, pages.getTotal(), page.getOffset(), page.getLength());
	}
	@Override
	public void delete(FollowerReq followerReq) {
		UsersLoginRes user = UserUtil.getUsers();
		FollowersQueryHelper e = new FollowersQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId()).andFollowerUserIdEqualTo(followerReq.getFollowerUserId());
		followersService.deleteByExample(e);
	}
	@Override
	public void insert(FollowerReq followerReq) {
		UsersQueryHelper exp = new UsersQueryHelper();
		if (usersService.countByExample(exp) != 1) {
			throw new BusinessException("用户不存在");
		}
		UsersLoginRes user = UserUtil.getUsers();
		FollowersQueryHelper e = new FollowersQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId()).andFollowerUserIdEqualTo(followerReq.getFollowerUserId());
		if (followersService.countByExample(e) > 0) {
			throw new BusinessException("已关注过了");
		}
		Followers t = new Followers();
		t.setCtime(new Date());
		t.setUserId(user.getUserId());
		t.setFollowerUserId(followerReq.getFollowerUserId());
		followersService.insert(t);
	}
}
