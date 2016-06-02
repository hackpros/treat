package com.navigate.treat.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navigate.treat.api.IActivitysServiceFront;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.beans.basic.ActivitysQueryHelper;
import com.navigate.treat.beans.basic.ActivitysReg;
import com.navigate.treat.beans.basic.ActivitysRegQueryHelper;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.basic.RecordOrder;
import com.navigate.treat.exception.BusinessException;
import com.navigate.treat.io.activity.request.ActivitysRegReq;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.activity.response.ActivitySimpleRes;
import com.navigate.treat.io.activity.response.ActivitysRegRes;
import com.navigate.treat.io.activity.response.ActivitysRes;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.pay.helper.FundsHelper.OrderType;
import com.navigate.treat.io.pay.helper.FundsHelper.PayMent;
import com.navigate.treat.io.pay.helper.FundsHelper.PayStatus;
import com.navigate.treat.io.pay.response.RecordOrderRes;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActRegStatus;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ActStatus;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.ERole;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IActivitysRegService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.basic.IRecordOrderService;
import com.navigate.treat.service.message.ISendSysMsg;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.BigDecimalUtil;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.DateUtil;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.UserUtil;

/**
 * 活动业务处理
 * 
 * @author huangshiping
 */
@Service
public class ActivitysServiceFront implements IActivitysServiceFront {
	@Resource
	IActivitysService activitysService;
	@Resource
	IRecordOrderService recordOrderService;
	@Resource
	IRecordFundService recordFundService;
	@Resource
	IActivitysRegService activitysRegService;
	@Resource
	IUsersService usersService;
	@Resource
	ISendSysMsg sendSysMsg;
	@Resource
	MessageServiceFront messageServiceFront;
	@Resource
	IActivitySignService activitySignService;
	private static final Logger logger = LogManager.getLogger(ActivitysServiceFront.class.getName());

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Object publishActivitys(ActivitysReq activitysReq) {
		ModelMap model = new ModelMap();
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		activitysReq.setUserId(usersLoginRes.getUserId());
		Activitys activitys = activitysService.transferredActivitys(activitysReq);
		activitysService.insertSelective(activitys);
		BigDecimal spent = BigDecimalUtil.add(activitysReq.getSubsidies(), activitysReq.getAmountSecured());
		model.addAttribute("actId", activitys.getId());
		if (!BigDecimalUtil.gtZero(spent)) {
			return model;
		}
		String orderNum = activitysService.getOrderNum(Constants.TREAT_OFF_LINE, activitys.getId());
		BigDecimal balance = usersService.getBalance(usersLoginRes.getUserId());
		BigDecimal deductions = BigDecimalUtil.sub(balance, spent);
		Integer payStatus = PayStatus.OCCUPY.ordinal();
		Integer actStatus = ActStatus.OCCUPY.ordinal();
		if (BigDecimalUtil.gtZero(deductions)) {
			payStatus = PayStatus.PAY.ordinal();
			actStatus = ActStatus.ONGOING.ordinal();
			usersService.subtractBalance(deductions, usersLoginRes.getUserId());
			model.addAttribute("balance", balance);
			logger.info(new StringBuilder().append(usersLoginRes.getNickName()).append("消费后余额为：").append(deductions));
		} else {
			actStatus = ActStatus.OCCUPY.ordinal();
			payStatus = PayStatus.UNPAY.ordinal();
			model.addAttribute("orderNum", orderNum);
			model.addAttribute("payAmount", spent);
			logger.info(new StringBuilder().append(usersLoginRes.getNickName()).append("余额不足，需要支付宝支付"));
		}
		activitys.setOrderNum(orderNum);
		activitys.setActStatus(actStatus);
		activitys.setMtime(new Date());
		activitysService.updateByPrimaryKeySelective(activitys);
		if (BigDecimalUtil.gtZero(activitysReq.getSubsidies())) {
			createOrder(activitysReq.getSubsidies(), usersLoginRes.getUserId(), orderNum, OrderType.SUBSIDY.ordinal(), payStatus,
					PayMent.BALANCE_PAY.ordinal(), "赴约补贴");
		}
		if (BigDecimalUtil.gtZero(activitysReq.getAmountSecured())) {
			createOrder(activitysReq.getAmountSecured(), usersLoginRes.getUserId(), orderNum, OrderType.DEPOSIT.ordinal(), payStatus,
					PayMent.BALANCE_PAY.ordinal(), "担保金");
		}
		ActivitySign activitySign = new ActivitySign();
		activitySign.setActivityId(activitys.getId());
		activitySign.setUserId(usersLoginRes.getUserId());
		activitySign.setActivityTime(activitys.getActTime());
		activitySign.setCtime(new Date());
		activitySign.setRole(ERole.MASTER.ordinal());
		activitySign.setSupplyAmount(activitys.getSubsidies());
		activitySign.setDepositAmount(activitys.getAmountSecured());
		activitySignService.insertSelective(activitySign);
		return model;
	}

	@Override
	public Object findActivity4Page(ActivitysReq activitysReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		List<ActivitysRes> list = new ArrayList<>();
		ActivitysQueryHelper e = new ActivitysQueryHelper();
		e.createCriteria().andActStatusEqualTo(ActStatus.ONGOING.ordinal()).andActTimeGreaterThanOrEqualTo(new Date());
		int count = activitysService.countByExample(e);
		if (count > 0) {
			list = activitysService.findActivity4Page(activitysReq.getUserLat(), activitysReq.getUserLng(), activitysReq.getOffset(),
					activitysReq.getLength());
			for (ActivitysRes activitys : list) {
				activitys.setUserHeadres(usersService.getUserHeads4UserId(activitys.getUserId()));
			}
		}
		return new Pages<ActivitysRes>(list, count, activitysReq.getOffset(), activitysReq.getLength(), count <= activitysReq.getOffset()
				+ activitysReq.getLength());
	}

	@Override
	public Object getActivitysDetails(ActivitysReq activitysReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ActivitysRes actRes = activitysService.findActivitys4ActId(activitysReq.getActId());
		if (actRes == null) {
			throw new BusinessException(ResponseCode.FAIL_ACTIVITY_NOT_EXITES.getDesc());
		}
		ActivitysRegQueryHelper regExample = new ActivitysRegQueryHelper();
		regExample.createCriteria().andActIdEqualTo(activitysReq.getActId()).andRegStatusGreaterThan(ActRegStatus.OCCUPY.ordinal());
		ModelMap model = new ModelMap();
		model.put("regNum", activitysRegService.countByExample(regExample));
		regExample.clear();
		ActivitysRegRes actRegRes = activitysRegService.getRegStatus(activitysReq.getActId(), usersLoginRes.getUserId());
		if (actRegRes != null) {
			model.put("regStatus", actRegRes.getRegStatus());
			model.put("regId", actRegRes.getRegId());
		}
		activitysService.updateBrowseNum4ActId(activitysReq.getActId());
		actRes.setUserHeadres(usersService.getUserHeads4UserId(actRes.getUserId()));
		model.put("activitys", actRes);
		return model;
	}

	@Override
	public Object registrationActivitys(ActivitysRegReq activitysRegReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ActivitysRes activitysRes = activitysService.findActivitys4ActId(activitysRegReq.getActId());
		ActivitysReg actReg = new ActivitysReg(activitysRegReq.getActId(), activitysRegReq.getUserId(),
				ActRegStatus.REG.ordinal(), activitysRes.getActTime());
		activitysRegService.insertSelective(actReg);
		ModelMap model = new ModelMap();
		model.put("regId", actReg.getId());
		if (!BigDecimalUtil.gtZero(activitysRes.getAmountSecured())) {
			JSONObject json = new JSONObject();
			json.put("regId", actReg.getId());
			sendSysMsg.sendSysMsg("活动报名", "有人报名了你的活动", EBizCode.REG.ordinal(), activitysRes.getUserId(),
					json.toJSONString(), activitysRes.getActTime());
			return model;
		}
		Integer payStatus = PayStatus.OCCUPY.ordinal();
		BigDecimal balance = usersService.getBalance(usersLoginRes.getUserId());
		BigDecimal deductions = BigDecimalUtil.sub(balance, activitysRes.getAmountSecured());
		String orderNum = activitysService.getOrderNum(Constants.TREAT_REG, actReg.getId());
		if (BigDecimalUtil.gtZero(deductions)) {
			payStatus = PayStatus.PAY.ordinal();
			usersService.subtractBalance(deductions, usersLoginRes.getUserId());
		} else {
			payStatus = PayStatus.UNPAY.ordinal();
			actReg.setRegStatus(ActStatus.OCCUPY.ordinal());
			actReg.setMtime(new Date());
			activitysRegService.updateByPrimaryKeySelective(actReg);
			model.addAttribute("orderNum", orderNum);
		}
		if (payStatus == PayStatus.PAY.ordinal()) {
			JSONObject json = new JSONObject();
			json.put("regId", actReg.getId());
			sendSysMsg.sendSysMsg("活动报名", "有人报名了你的活动", EBizCode.REG.ordinal(), activitysRes.getUserId(),
					json.toJSONString(), activitysRes.getActTime());
		}
		createOrder(activitysRes.getAmountSecured(), usersLoginRes.getUserId(), orderNum, OrderType.DEPOSIT.ordinal(),
				payStatus, PayMent.BALANCE_PAY.ordinal(), "担保金");
		return model;
	}

	@Override
	public Object getRegistrationList(ActivitysRegReq activitysRegReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		List<ActivitysRegRes> list = activitysRegService.findActivityReg4ActId(activitysRegReq.getActId());
		boolean cheakFlag = false;
		String mobile = "";
		if (!list.isEmpty()) {
			for (ActivitysRegRes activitysReg : list) {
				activitysReg.setUserHeadres(usersService.getUserHeads4UserId(activitysReg.getUserId()));
				if (activitysReg.getRegStatus() == ActivityHelper.ActRegStatus.CHECKED.ordinal()) {
					cheakFlag = true;
					mobile = usersService.getMobile4UserId(activitysReg.getUserId());
				}
			}
		}
		ModelMap model = new ModelMap();
		model.addAttribute("actRegList", list);
		model.addAttribute("cheakFlag", cheakFlag);
		model.addAttribute("mobile", mobile);
		return model;
	}

	@Override
	public Object cancelRegistration(ActivitysRegReq activitysRegReq) {
		ModelMap model = new ModelMap();
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ActivitysReg activitysReg = new ActivitysReg(activitysRegReq.getRegId(), ActRegStatus.OCCUPY.ordinal());
		model.addAttribute("status", activitysRegService.updateByPrimaryKeySelective(activitysReg) > 0);
		if (StringUtils.isEmpty(activitysReg.getOrderNum())) {
			return model;
		}
		List<RecordOrderRes> list = recordOrderService.getOrderNum(activitysReg.getOrderNum());
		if (list.isEmpty()) {
			return model;
		}
		RecordOrderRes recordOrder = list.get(0);
		if (recordOrder.getPayStatus() != PayStatus.PAY.ordinal()) {
			return model;
		}
		return model;
	}

	@Override
	public Object checkedRegistration(ActivitysRegReq activitysRegReq) {
		UsersLoginRes usersLoginRes = UserUtil.getUsers();
		if (usersLoginRes == null) {
			throw new BusinessException(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT.getDesc());
		}
		ActivitysRegRes activitysRegRes = activitysRegService.selectActivitysReg4Id(activitysRegReq.getRegId());
		ActivitysRes actRes = activitysService.findActivitys4ActId(activitysRegRes.getActId());
		sendSysMsg.sendSysMsg("你被选中约会对象", getContent(usersLoginRes.getNickName(), actRes.getActTime(), actRes.getBizAddr()),
				EBizCode.REG.ordinal(), activitysRegRes.getUserId(), null, null);
		ActivitySign activitySign = new ActivitySign();
		activitySign.setUserId(usersLoginRes.getUserId());
		activitySign.setActivityId(actRes.getActId());
		activitySign.setActivityTime(actRes.getActTime());
		activitySign.setCtime(new Date());
		activitySign.setRole(ERole.FOLLOWER.ordinal());
		activitySign.setSupplyAmount(actRes.getSubsidies());
		activitySign.setDepositAmount(actRes.getAmountSecured());
		activitySignService.insertSelective(activitySign);
		ActivitysReg activitysReg = new ActivitysReg(activitysRegReq.getRegId(), ActRegStatus.CHECKED.ordinal());
		ModelMap model = new ModelMap();
		Integer status = activitysRegService.updateByPrimaryKeySelective(activitysReg);
		String mobile = "";
		if (status > 0) {
			mobile = usersService.getMobile4UserId(activitysRegRes.getUserId());
		}

		model.addAttribute("mobile", mobile);
		model.addAttribute("status", status > 0);
		return model;
	}

	@Override
	public Object cancelActivitys(ActivitysReq activitysReq) {
		ModelMap model = new ModelMap();
		ActivitysRes activitysRes = activitysService.findActivitys4ActId(activitysReq.getActId());
		if (activitysRes == null) {
			throw new BusinessException(ResponseCode.FAIL_ACTIVITY_NOT_EXITES.getDesc());
		}
		Activitys activitys = new Activitys();
		activitys.setId(activitysReq.getActId());
		activitys.setMtime(new Date());
		activitys.setActStatus(ActStatus.CLOSE.ordinal());
		model.addAttribute("status", activitysService.updateByPrimaryKeySelective(activitys) > 0);
		if (StringUtils.isEmpty(activitysRes.getOrderNum())) {
			return model;
		}
		List<RecordOrderRes> orderList = recordOrderService.getOrderNum(activitysRes.getOrderNum());
		// 退回发起者担保金
		for (RecordOrderRes recordOrder : orderList) {
			if (recordOrder.getPayStatus() != PayStatus.PAY.ordinal()) {
				continue;
			}
			recordFundService.reFund(recordOrder, activitysRes.getUserId(), activitysRes.getOrderNum());
		}
		// 退回报名者担保金
		List<ActivitysRegRes> regList = activitysRegService.findActivityReg4ActId(activitysReq.getActId());
		if (regList.isEmpty()) {
			return model;
		}
		for (ActivitysRegRes activitysRegRes : regList) {
			if (StringUtils.isEmpty(activitysRegRes.getOrderNum())) {
				continue;
			}
			List<RecordOrderRes> list = recordOrderService.getOrderNum(activitysRegRes.getOrderNum());
			if (list.isEmpty()) {
				continue;
			}
			RecordOrderRes recordOrder = list.get(0);
			if (recordOrder.getPayStatus() != PayStatus.PAY.ordinal()) {
				continue;
			}
			recordFundService.reFund(recordOrder, activitysRegRes.getUserId(), activitysRegRes.getOrderNum());
		}
		return model;
	}

	/**
	 * 创建订单
	 * 
	 * @param amount
	 * @param userId
	 * @param orderNum
	 * @param orderType
	 * @param payStatus
	 * @param payMent
	 * @param desc
	 */
	public void createOrder(BigDecimal amount, Long userId, String orderNum, Integer orderType, Integer payStatus, Integer payMent,
			String desc) {
		RecordOrder recordOrder = new RecordOrder(amount, orderNum, orderType, userId, payStatus);
		recordOrderService.insertSelective(recordOrder);
		if (payStatus != PayStatus.PAY.ordinal()) {
			return;
		}
		RecordFund recordFund = new RecordFund(userId, amount, payMent, orderNum, null, desc, ConsumerType.SPEND.ordinal());
		recordFundService.insertSelective(recordFund);
	}

	private String getContent(String nickName, Date actTime, String bizAddr) {
		return new StringBuffer().append("你已经成为").append(nickName).append("选中的约会对象,").append(DateUtil.DateChangeStr(actTime)).append("在")
				.append(bizAddr).append(",你将与").append(nickName).append("进行一场浪漫的约会.望准时赴约").toString();
	}

	@Override
	public Pages<?> selectMaster(Pages<?> page) {
		UsersLoginRes user = UserUtil.getUsers();
		PageHelper.startPage(page.getOffset(), page.getLength());
		ActivitysQueryHelper e = new ActivitysQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId()).andActStatusGreaterThan(ActStatus.OCCUPY.ordinal());
		e.setOrderByClause("ctime desc");
		List<Activitys> list = activitysService.selectByExample(e);
		PageInfo<Activitys> pages = new PageInfo<Activitys>(list);
		List<ActivitySimpleRes> activitysResList = new ArrayList<ActivitySimpleRes>();
		Date now = new Date();
		ActivitysRegQueryHelper exp = new ActivitysRegQueryHelper();
		for (Activitys activitys : pages.getList()) {
			ActivitySimpleRes res = new ActivitySimpleRes();
			res.setActId(activitys.getId());
			res.setActTime(activitys.getActTime());
			res.setBizAddr(activitys.getBizAddr());
			res.setBizName(activitys.getBizName());
			res.setHeadIcon(user.getHeadIcon());
			res.setSex(user.getSex());
			if (activitys.getActStatus() == ActStatus.CLOSE.ordinal()) {
				res.setStatus("活动关闭");
			} else if (activitys.getActStatus() == ActStatus.ENDED.ordinal()) {
				res.setStatus("已结束");
			} else if (activitys.getActStatus() == ActStatus.ONGOING.ordinal()) {
				// 进行中
				if (activitys.getActTime().before(DateUtils.addMinutes(now, -90))) {
					exp.clear();
					exp.createCriteria().andActIdEqualTo(activitys.getId())
							.andRegStatusEqualTo(ActRegStatus.CHECKED.ordinal());
					if (activitysRegService.countByExample(exp) > 0) {
						res.setStatus("进行中");
					}else{
						res.setStatus("报名中");
					}
				} else if (activitys.getActTime().before(DateUtils.addMinutes(now, 90))) {
					res.setStatus("正在进行");
				} else {
					res.setStatus("已结束");
				}
			}
			activitysResList.add(res);
		}
		return new Pages<ActivitySimpleRes>(activitysResList, pages.getTotal(), page.getOffset(), page.getLength());
	}

	@Override
	public Pages<?> selectActor(Pages<?> page) {
		UsersLoginRes user = UserUtil.getUsers();
		// 我报名的活ID
		PageHelper.startPage(page.getOffset(), page.getLength());
		ActivitysRegQueryHelper e = new ActivitysRegQueryHelper();
		e.createCriteria().andUserIdEqualTo(user.getUserId());
		e.setOrderByClause(" actTime desc ");
		List<ActivitysReg> list = activitysRegService.selectByExample(e);
		PageInfo<ActivitysReg> pages = new PageInfo<ActivitysReg>(list);
		List<Long> actIdList = new ArrayList<Long>();
		for (ActivitysReg activitysReg : pages.getList()) {
			actIdList.add(activitysReg.getActId());
		}
		if (actIdList.isEmpty()) {
			return new Pages<ActivitySimpleRes>(new ArrayList<ActivitySimpleRes>(), 0, page.getOffset(), page.getLength());
		}
		ActivitysQueryHelper exp = new ActivitysQueryHelper();
		exp.createCriteria().andIdIn(actIdList);
		e.setOrderByClause("ctime desc");
		List<Activitys> activitysList = activitysService.selectByExample(exp);
		List<ActivitySimpleRes> activitysResList = new ArrayList<ActivitySimpleRes>();
		Date now = new Date();
		ActivitysRegQueryHelper  activitysRegQueryHelper= new ActivitysRegQueryHelper();
		for (Activitys activitys : activitysList) {
			ActivitySimpleRes res = new ActivitySimpleRes();
			res.setActId(activitys.getId());
			res.setActTime(activitys.getActTime());
			res.setBizAddr(activitys.getBizAddr());
			res.setBizName(activitys.getBizName());
			res.setHeadIcon(user.getHeadIcon());
			res.setSex(user.getSex());
			if (activitys.getActStatus() == ActStatus.CLOSE.ordinal()) {
				res.setStatus("活动关闭");
			} else if (activitys.getActStatus() == ActStatus.ENDED.ordinal()) {
				res.setStatus("已结束");
			} else if (activitys.getActStatus() == ActStatus.ONGOING.ordinal()) {
				// 进行中
				if (activitys.getActTime().before(DateUtils.addMinutes(now, -90))) {
					activitysRegQueryHelper.clear();
					activitysRegQueryHelper.createCriteria().andActIdEqualTo(activitys.getId())
							.andRegStatusEqualTo(ActRegStatus.CHECKED.ordinal());
					if (activitysRegService.countByExample(activitysRegQueryHelper) > 0) {
						res.setStatus("进行中");
					}else{
						res.setStatus("报名中");
					}
				} else if (activitys.getActTime().before(DateUtils.addMinutes(now, 90))) {
					res.setStatus("正在进行");
				} else {
					res.setStatus("已结束");
				}
			}
			activitysResList.add(res);
		}
		return new Pages<ActivitySimpleRes>(activitysResList, pages.getTotal(), page.getOffset(), page.getLength());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void doCleaning() {
		Date endDate = DateUtils.addHours(new Date(), -3);
		ActivitysQueryHelper exp = new ActivitysQueryHelper();
		exp.createCriteria().andActStatusEqualTo(ActivityHelper.ActStatus.ONGOING.ordinal())
				.andActTimeLessThan(endDate);
		List<Activitys> activitysList = activitysService.selectByExample(exp);
		for (Activitys activitys : activitysList) {
			// 活动数据结算
			activitySignService.doBalance(activitys);
			// 更新参与者
			recordOrderService.updateStatusByFollower(activitys.getId(), PayStatus.OVER.ordinal());
			// 更新发起者
			recordOrderService.updateStatus(activitys.getOrderNum(), PayStatus.OVER.ordinal());
			Activitys t = new Activitys();
			t.setId(activitys.getId());
			t.setMtime(new Date());
			t.setActStatus(ActivityHelper.ActStatus.ENDED.ordinal());
			int row = activitysService.updateByPrimaryKeySelective(t);
			Assert.assertEquals(row, 1);
		}
	}
}
