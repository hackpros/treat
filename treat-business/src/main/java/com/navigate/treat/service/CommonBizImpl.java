package com.navigate.treat.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.api.ICommonBiz;
import com.navigate.treat.beans.basic.ActivitySign;
import com.navigate.treat.beans.basic.ActivitySignQueryHelper;
import com.navigate.treat.beans.basic.Activitys;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.exception.ParamValidateException;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.message.MessageReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.io.useractivity.helple.ActivityHelper;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EBizCode;
import com.navigate.treat.io.useractivity.helple.ActivityHelper.EOperation;
import com.navigate.treat.service.basic.IActivitySignService;
import com.navigate.treat.service.basic.IActivitysService;
import com.navigate.treat.up.GlobalPropertiesUtil;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.SendSms;
import com.navigate.treat.util.StringUtil;
import com.navigate.treat.util.UserUtil;

/**
 * 公供服务类
 * @author fwg create by 2016年3月25日 下午2:44:56
 */
@Service
public class CommonBizImpl implements ICommonBiz {
	private static final Logger logger = LogManager.getLogger("CommonBizImpl");
	@Resource
	IActivitySignService activitySignService;
	@Resource
	IActivitysService activitysService;
	@Resource
	MessageServiceFront messageServiceFront;

	@Override
	public void sensMsg(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			throw new ParamValidateException(ResponseCode.FAIL_MOBILE_NULL.getDesc());
		}
		try {
			String rand = RandomStringUtils.randomNumeric(4);
			// 如果是生产环境
			if (GlobalPropertiesUtil.get("deployment.environment").equalsIgnoreCase("prouduction")) {
				boolean flag = StringUtil.limitSendCnt(Constants.VERIFICATION_CODE_KEY + mobile);// 查看用户是否已经超出发送次数
				if (flag) {
					JSONObject res = SendSms.sendSms(mobile, StringUtil.getSmsContent(rand));
					if (!res.get("code").equals(0)) {
						throw new ParamValidateException(ResponseCode.FAIL_IDENTIFYING_CODE.getDesc());
					} else {
						logger.info("验证码发送成功");
					}
				} else {
					throw new ParamValidateException(ResponseCode.FAIL_IDENTIFYING_LIMIT.getDesc());
				}
			} else if (GlobalPropertiesUtil.get("deployment.environment").equalsIgnoreCase("testcase")) {
				rand = "1234";
			} else {
				rand = "1234";
			}
			JedisUtil.save(mobile + Constants.SMS_CODE_KEY, 300, rand);// 保存验证码，过期时间5分钟
		} catch (Exception e) {
			logger.error("发送验证码异常!", e);
			throw new com.navigate.treat.exception.ApplicationException("发送验证码接口异常");
		}
	}
	@Override
	public void sign(ActivitysReq activitysReq) {
		if (org.apache.commons.lang3.StringUtils.isEmpty(activitysReq.getUserLat())  || org.apache.commons.lang3.StringUtils.isEmpty(activitysReq.getUserLng())) {
			throw new ParamValidateException("坐标不能为空");
		}
		Date date = new Date();
		UsersLoginRes user = UserUtil.getUsers();
		if (user == null) {
			throw new ParamValidateException("用户没有登录");
		}
		ActivitySignQueryHelper e = new ActivitySignQueryHelper();
		Date startTime = DateUtils.addMinutes(date, -90);
		Date endTime = DateUtils.addMinutes(date, +90);
		e.createCriteria().andUserIdEqualTo(user.getUserId()).andActivityTimeBetween(startTime, endTime).andSigninNotEqualTo(ActivityHelper.EInteractionSignin.COMPLETE.ordinal());
		List<ActivitySign> list = activitySignService.selectByExample(e);
		for (ActivitySign activitySign : list) {
			Activitys activitys = activitysService.selectByPrimaryKey(new Activitys(activitySign.getActivityId()));
			if (ActivityHelper.sameLocal(activitys.getBizLat(),activitys.getBizLng(), activitysReq.getUserLat() , activitysReq.getUserLng())) {
				ActivitySign sign = new ActivitySign();
				sign.setId(activitySign.getId());
				sign.setSignin(ActivityHelper.EInteractionSignin.COMPLETE.ordinal());
				sign.setSingTime(date);
				int count=activitySignService.updateByPrimaryKeySelective(sign);
				if (count==0)
					continue;
				
				MessageReq messageReq = new MessageReq();
				
				messageReq.setOperation(EOperation.EXCUTE.ordinal()); 
				messageReq.setActivityId(activitys.getId());
				messageReq.setBizCode(EBizCode.SIGN);
				messageServiceFront.doCrateMessage(messageReq);
			}
		}
	}
}
