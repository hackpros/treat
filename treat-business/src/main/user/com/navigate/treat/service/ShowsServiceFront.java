package com.navigate.treat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.navigate.treat.api.IShowsServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysQueryHelper;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.beans.basic.Shows;
import com.navigate.treat.beans.basic.ShowsPraise;
import com.navigate.treat.beans.basic.ShowsPraiseQueryHelper;
import com.navigate.treat.beans.basic.ShowsQueryHelper;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.io.show.request.ShowsReq;
import com.navigate.treat.io.show.response.ShowsPraiseRes;
import com.navigate.treat.io.show.response.ShowsRes;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActRegStatus;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.service.basic.IShowsPraiseService;
import com.navigate.treat.service.basic.IShowsService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.UserUtil;

@Service
public class ShowsServiceFront implements IShowsServiceFront {
	@Resource
	IShowsService showsService;
	@Resource
	IUsersService usersService;
	@Resource
	IShowsPraiseService showsPraiseService;
	@Resource
	IActivitysService activitysService;
	@Resource
	IActivitysRegService activitysRegService;

	@Override
	public Object publishShows(ShowsReq showsReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		Shows shows = new Shows();
		shows.setCtime(new Date());
		shows.setLat(showsReq.getLat());
		shows.setLng(showsReq.getLng());
		shows.setMediaContent(showsReq.getMediaContent());
		shows.setMediaType(showsReq.getMediaType());
		shows.setTitle(showsReq.getTitle());
		shows.setUserId(usersLoginRes.getUserId());
		shows.setSex(usersLoginRes.getSex());
		showsService.insertSelective(shows);
		return new ModelMap().put("showId", shows.getId());
	}

	@Override
	public Object getHomeShowsList(ShowsReq showsReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		List<ShowsRes> list = new ArrayList<>();
		ShowsQueryHelper e = new ShowsQueryHelper();
		e.createCriteria().andStatusEqualTo(0);
		int count = showsService.countByExample(e);
		if (count > 0) {
			list = showsService.findShows4Page(showsReq);
			for (ShowsRes showRes : list) {
				showRes.setUserHeadRes(usersService.getUserHeads4UserId(showRes.getUserId()));
				ShowsPraiseQueryHelper showExample = new ShowsPraiseQueryHelper();
				showExample.createCriteria().andShowIdEqualTo(showRes.getShowId());
				showRes.setPraiseNum(showsPraiseService.countByExample(showExample));
				showExample.clear();
				showExample.createCriteria().andShowIdEqualTo(showRes.getShowId()).andUserIdEqualTo(usersLoginRes.getUserId());
				showRes.setPraise(showsPraiseService.countByExample(showExample) > 0);
			}
		}
		return new Pages<ShowsRes>(list, count, showsReq.getOffset(), showsReq.getLength(), count <= showsReq.getOffset()
				+ showsReq.getLength());
	}

	@Override
	public Object delShows(ShowsReq showsReq) {

		Shows shows = new Shows();
		shows.setId(showsReq.getShowId());
		return new ModelMap().addAttribute("status", showsService.deleteByPrimaryKey(shows) > 0);
	}

	@Override
	public Object showPraise(ShowsReq showsReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ShowsPraiseQueryHelper showExample = new ShowsPraiseQueryHelper();
		showExample.createCriteria().andShowIdEqualTo(showsReq.getShowId()).andUserIdEqualTo(usersLoginRes.getUserId());
		Integer count = showsPraiseService.countByExample(showExample);
		if (count > 0) {
			throw new BusinessException(ResponseCode.FAIL_SHOW_PRAISE.getDesc());
		}
		ShowsPraise showsPraise = new ShowsPraise();
		showsPraise.setCtime(new Date());
		showsPraise.setShowId(showsReq.getShowId());
		showsPraise.setUserId(usersLoginRes.getUserId());
		showsPraise.setShowUserId(showsReq.getUserId());
		return new ModelMap().addAttribute("status", showsPraiseService.insertSelective(showsPraise) > 0);
	}

	@Override
	public Object getShowsPaiseRank(ShowsReq showsReq) {

		List<ShowsPraiseRes> list = showsPraiseService.getPraiseRankList();
		if (!list.isEmpty()) {
			for (ShowsPraiseRes showsPraise : list) {
				showsPraise.setUserHeadRes(usersService.getUserHeads4UserId(showsPraise.getUserId()));
			}
		}
		return new ModelMap().addAttribute("praiseRankList", list);
	}

	@Override
	public Object cheakedActStatus(ShowsReq showsReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ActivitysQueryHelper e = new ActivitysQueryHelper();
		e.createCriteria().andUserIdEqualTo(usersLoginRes.getUserId()).andActStatusEqualTo(1).andActTimeGreaterThan(new Date());
		List<Activitys> list = activitysService.selectByExample(e);
		if (list.isEmpty()) {
			return new ModelMap().addAttribute("status", false);
		}

		for (Activitys activitys : list) {
			ActivitysRegQueryHelper reg = new ActivitysRegQueryHelper();
			reg.createCriteria().andActIdEqualTo(activitys.getId()).andRegStatusEqualTo(ActRegStatus.CHECKED.ordinal());
			int count = activitysRegService.countByExample(reg);
			if (count > 0) {
				return new ModelMap().addAttribute("status", true);
			}
		}
		return new ModelMap().addAttribute("status", false);
	}

	@Override
	public Object invitation(ShowsReq showsReq) {

		return null;
	}

	@Override
	public Object getShowList4UserId(ShowsReq showsReq) {

		List<ShowsRes> list = new ArrayList<>();
		Long userId = showsReq.getUserId();
		ShowsQueryHelper e = new ShowsQueryHelper();
		e.createCriteria().andStatusEqualTo(0).andUserIdEqualTo(userId);
		int count = showsService.countByExample(e);
		if (count > 0) {
			list = showsService.findShowList4UserId(showsReq);
			for (ShowsRes showRes : list) {
				showRes.setUserHeadRes(usersService.getUserHeads4UserId(showRes.getUserId()));
				ShowsPraiseQueryHelper showExample = new ShowsPraiseQueryHelper();
				showExample.createCriteria().andShowIdEqualTo(showRes.getShowId());
				showRes.setPraiseNum(showsPraiseService.countByExample(showExample));
				showExample.clear();
				showExample.createCriteria().andShowIdEqualTo(showRes.getShowId()).andUserIdEqualTo(userId);
			}
		}
		return new Pages<ShowsRes>(list, count, showsReq.getOffset(), showsReq.getLength(), count <= showsReq.getOffset()
				+ showsReq.getLength());
	}

	
}
