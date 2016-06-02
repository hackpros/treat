package com.navigate.treat.helper;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.DigestUtils;

import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.cache.RedisException;
import com.navigate.treat.up.GlobalPropertiesUtil;
import com.navigate.treat.util.Constants;

public final class UsersHelper {
	/**
	 * 用户表全局主Id
	 */
	public final static String REDISS_USER_KEY = "usre.userId";

	public final static String USERS_RANDM_NICK_KEY = "users.nick";
	public final static String USERS_DEFAULT_HEADINCO_TEPLETE = "default/{0}/{1}";
	public final static int USERS_DEFAULT_HEADINCO_MAX_COUNT = 7;
	
	/**
	 * 头象存在的阿里云地址
	 */
	public final static String ALI_OSSURL = "ali.ossurl";

	public final static String[] NICK_CHAHE = GlobalPropertiesUtil.get(USERS_RANDM_NICK_KEY).split(",");
	/**
	 * 用户没有坐标的时候，默认坐标
	 */
	public static final String DEF_LNG = "120.20000";
	public static final String DEF_LAT = "30.26667";

	/**
	 * 获取随机的昵称贷
	 */
	public static String getRandomNick() {
		try {
			return NICK_CHAHE[RandomUtils.nextInt(0,NICK_CHAHE.length)];
		} catch (Exception e) {
			e.printStackTrace();
			return "今天我请客";
		}
	}

	/**
	 * 密码加密
	 */
	public static String md5DigestAsHex(String password, String salt) {
		return DigestUtils.md5DigestAsHex((password + salt).getBytes());
	}

	/**
	 * 验证验证码是否正确
	 * 
	 * @param captcha
	 *            ：用户输入的验证码
	 * @return　true/false
	 */
	public static boolean checkCaptcha(String mobile, String captcha) {
		
		try {
			String value = JedisUtil.get(mobile + Constants.SMS_CODE_KEY);
			boolean result = captcha.equals(value);
			if (result) {
			//	UsersHeper.removeCaptcha(mobile);
			}
			return result;
		} catch (RedisException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 验证成功移出验证码
	 * 
	 * @param mobile
	 */
	public static void removeCaptcha(String mobile) {
		JedisUtil.del(mobile + Constants.SMS_CODE_KEY);
	}

	public enum EStatus {
		Occupy, // 占位用的，下标零，默认点位，业务从１开始
		Normal, // 正常
		NoPasword, // 注册未设置密码状态
		AuditNoPass// 审核不通过
	}

	/*
	 * 约会结果
	 */
	public enum EAppointmentResult {
		KEEP, // 赴约
		BROKE, // 爽约
		BEFORESTART//活动开始前的处理
	}

	/*
	 * 默认头像
	 */
	public enum ESex {
		OCCUPY, // 占位用的，下标零，默认点位，业务从１开始
		MALE, // 男
		FEMALE; // 女
		public static String getDefHeadIcon(int sex, String no) {
			String headIcon = "{0}/resources/image/defhead/{1}_icon{2}.png";
			return headIcon;
		}

		public static String getSexFlag(int sex) {
			if (sex == MALE.ordinal()) {
				return "m";
			} else {
				return "f";
			}
		}
	}

	public class UsersConstants {
		/**
		 * 登录密码错误3次将显示验证码
		 */
		public static final int MAX_LOGIN_NUM_ERROR_CHECK_CHECK_CAPTCHA = 3;
		/**
		 * 登录错误锁定号
		 */
		public static final int MAX_LOGIN_NUM_ERROR_LOCK_NUM = 5;
		/**
		 * 最大锁定分钟数　15分钟
		 */
		public static final int MAX_LOCK_MINUTE = 15;
	}

	public static void main(String[] args) {
		// System.out.println(UsersHeper.md5DigestAsHex("e10adc3949ba59abbe56e057f20f883e",
		// "uF8Q"));
		String p = DigestUtils.md5DigestAsHex("123456".getBytes());
		System.out.println(p);
		System.out.println(UsersHelper.md5DigestAsHex(p, "iHbp"));
	}
}
