/*
 * ActivitySignMapper.java
 * Copyright(C) 20xx-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-04-11 Created
 */
package com.navigate.treat.service.basic.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navigate.treat.base.service.single.BaseServiceImp;
import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.ActivitySignQueryHelper;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.dao.basic.ActivitySignMapper;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EOperation;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IMessageService;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.BigDecimalUtil;
import com.navigate.treat.util.Constants;

/**
 * 活动签到表
 * @author fwg create by 2016年4月12日 上午9:46:55
 */
@Service
public class ActivitySignService extends BaseServiceImp<ActivitySign, ActivitySignQueryHelper>
		implements IActivitySignService {
	ActivitySignMapper activitySignMapper;

	@Autowired
	public void setActivitySignMapper(ActivitySignMapper activitySignMapper) {
		this.activitySignMapper = activitySignMapper;
		super.setBaseMapper(activitySignMapper);
	}

	@Resource
	IUsersService usersService;
	@Resource
	IActivitysRegService activitysRegService;
	@Resource
	IMessageService messageService;
	@Resource
	IRecordFundService recordFundService;

	@Override
	public void doBalance(Activitys activitys) {
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		e.createCriteria().andActivityIdEqualTo(activitys.getId());
		List<ActivitySign> activitySigns = activitySignMapper.selectByExample(e);
		if (activitySigns.size() == 0) {
			return;
		} else if (activitySigns.size() == 1) {
			// 退担保金，退补贴
			doSettlement(activitySigns.get(0), activitys);
		} else if (activitySigns.size() == 2) {
			// 退担保金，退补贴
			doSettlement(activitySigns, activitys);
		} else {
			// doSettlement(activitySigns, activitys);
		}
	}
	/**
	 * 活动担保金，补贴结算
	 * @param activitySign
	 * @param activitys
	 */
	private void doSettlement(ActivitySign activitySign, Activitys activitys) {
		// 发起者
		if (activitySign.getRole() == ActivityHelper.ERole.MASTER.ordinal()) {
			// 退担保金
			doReSecured(activitySign.getUserId(), activitys.getAmountSecured());
			// 退补贴
			doReSubsidy(activitySign.getUserId(), activitys.getSubsidies());
		} else {// 参与者
			// 参与者担保金
			if (activitysRegService.existAmountSecured(activitys.getId(), activitySign.getUserId())) {
				doReSecured(activitySign.getUserId(), activitys.getAmountSecured());
			}
		}
	}
	// 退单担金
	private void doReSecured(Long fuid, BigDecimal amountSecured) {
		if (BigDecimalUtil.gtZero(amountSecured)) {
			// 更新账户余额
			usersService.addBalance(amountSecured, fuid);
			// 资金日志
			recordFundService.append(fuid, null, "退还担保金", amountSecured, ConsumerType.INCOME);
			// 发消息
			messageService.append(Constants.SYS_USERID, fuid, 0, EBizCode.DEF, "活动自然结束", "系统返还担保金", EOperation.READ);
		}
	}
	// 退补贴
	private void doReSubsidy(Long uid, BigDecimal amountSecured) {
		if (BigDecimalUtil.gtZero(amountSecured)) {
			usersService.addBalance(amountSecured, uid);
			// 资金日志
			recordFundService.append(uid, null, "退还活动补贴 ", amountSecured, ConsumerType.INCOME);
			// 发消息
			messageService.append(Constants.SYS_USERID, uid, 0, EBizCode.DEF, "活动自然结束", "系统返还补贴", EOperation.READ);
		}
	}
	/**
	 * 活动担保金，补贴结算
	 * @param activitySign
	 * @param activitys
	 */
	private void doSettlement(List<ActivitySign> activitySigns, Activitys activitys) {
		ActivitySign master = null;
		ActivitySign follower = null;
		if (activitySigns.get(0).getRole() == ActivityHelper.ERole.MASTER.ordinal()) {
			master = activitySigns.get(0);
			follower = activitySigns.get(1);
		} else if (activitySigns.get(0).getRole() == ActivityHelper.ERole.FOLLOWER.ordinal()) {
			follower = activitySigns.get(0);
			master = activitySigns.get(1);
		} else {
			return;
		}
		// 发起者签到成功，参与者失败，退补贴，发起者收参与者担保金
		if (master.getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& follower.getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 退补贴
			doReSubsidy(master.getUserId(), activitys.getSubsidies());
			// 退发起者担保金
			doReSecured(master.getUserId(), activitys.getAmountSecured());
			// 收参与者担保金
			if (activitysRegService.existAmountSecured(activitys.getId(), follower.getUserId())) {
				getTakeSecured(follower.getUserId(), master.getUserId(), activitys.getAmountSecured());
			}
		} else if (master.getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& follower.getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 发起者失败，参与者成功，退补贴，参与者收发起者担保金
			// 退补贴
			doReSubsidy(master.getUserId(), activitys.getSubsidies());
			
			// 退参与者担保金
			if (activitysRegService.existAmountSecured(activitys.getId(), follower.getUserId())) {
				doReSecured(follower.getUserId(), activitys.getAmountSecured());
			}
			// 收发起者担保金
			getTakeSecured(master.getUserId(), follower.getUserId(), activitys.getAmountSecured());
		} else if (master.getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& follower.getSignin() == ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 双方都成功,退双方担保金，参与者领取补贴
			// 收补贴
			getTakeSubsidy(master.getUserId(), follower.getUserId(), activitys.getSubsidies());
			// 退发起者担保金
			doReSecured(master.getUserId(), activitys.getAmountSecured());
			// 退参与者担保金
			if (activitysRegService.existAmountSecured(activitys.getId(), follower.getUserId())) {
				doReSecured(follower.getUserId(), activitys.getAmountSecured());
			}
		} else if (master.getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()
				&& follower.getSignin() != ActivityHelper.EInteractionSignin.COMPLETE.ordinal()) {
			// 发起者，参与者都未成功
			
			// 退发起者补贴
			doReSubsidy(master.getUserId(), activitys.getSubsidies());
			// 退发起者担保金
			doReSecured(master.getUserId(), activitys.getAmountSecured());
			// 退参与者担保金
			if (activitysRegService.existAmountSecured(activitys.getId(), follower.getUserId())) {
				doReSecured(follower.getUserId(), activitys.getAmountSecured());
			}
		}
	}
	// 收担保金
	private void getTakeSecured(Long fuid, Long tuid, BigDecimal amountSecured) {
		if (BigDecimalUtil.gtZero(amountSecured)) {
			usersService.addBalance(amountSecured, tuid);
			// 资金日志
			recordFundService.append(tuid, null, "获得担保金 ", amountSecured, ConsumerType.INCOME);
			recordFundService.append(fuid, null, "扣担保金", amountSecured, ConsumerType.SPEND);
			// 发消息
			messageService.append(Constants.SYS_USERID, tuid, 0, EBizCode.DEF, "活动自然结束", "获得担保金", EOperation.READ);
			messageService.append(Constants.SYS_USERID, fuid, 0, EBizCode.DEF, "活动自然结束", "失去活动补贴", EOperation.READ);
		}
	}
	// 收补贴
	private void getTakeSubsidy(Long fuid, Long tuid, BigDecimal amountSecured) {
		if (BigDecimalUtil.gtZero(amountSecured)) {
			usersService.addBalance(amountSecured, tuid);
			// 资金日志
			recordFundService.append(tuid, null, "获得活动补贴 ", amountSecured, ConsumerType.INCOME);
			recordFundService.append(fuid, null, "扣除活动补贴 ", amountSecured, ConsumerType.SPEND);
			// 发消息
			messageService.append(Constants.SYS_USERID, tuid, 0, EBizCode.DEF, "活动自然结束", "获得活动补贴", EOperation.READ);
			messageService.append(Constants.SYS_USERID, fuid, 0, EBizCode.DEF, "活动自然结束", "失去活动补贴",
					EOperation.READ);
		}
	}
}
