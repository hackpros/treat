package com.navigate.treat.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.api.IRecordFundServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.basic.RecordFundQueryHelper;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.usercenter.response.RecordFundRes;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.SpringBeanUtils;
import com.navigate.treat.util.UserUtil;

/**
 * @author fwg create by 2016年4月19日 下午3:15:16
 */
@Service
public class RecordFundServiceFront implements IRecordFundServiceFront {
	@Resource
	IRecordFundService recordFundService;
	@Resource
	IUsersService usersService;

	@Override
	public Object select(Pages<?> page) {
		ModelMap map = new ModelMap();
		UsersLoginRes user = UserUtil.getUsers();
		RecordFundQueryHelper e = new RecordFundQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId());
		e.setOrderByClause("ctime desc");
		PageHelper.startPage(page.getOffset(), page.getLength());
		List<RecordFund> list = recordFundService.selectByExample(e);
		PageInfo<RecordFund> pageInfo = new PageInfo<RecordFund>(list);
		List<RecordFundRes> recordFundResList = new ArrayList<RecordFundRes>();
		for (RecordFund recordFund : pageInfo.getList()) {
			RecordFundRes res = new RecordFundRes();
			SpringBeanUtils.copyProperties(recordFund, res);
			recordFundResList.add(res);
		}
		Pages<RecordFundRes> pages = new Pages<RecordFundRes>(recordFundResList, pageInfo.getTotal(), page.getOffset(),
				page.getLength());
		map.put("page", pages);
		// 账户总额
		map.put("balance", usersService.getBalance(user.getUserId()));
		return map;
	}
}
