package com.navigate.treat.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.navigate.treat.beans.multi.UserInfo;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.cache.JedisClusterUtil;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.cache.RedisException;
import com.navigate.treat.io.user.response.DeviceInfoRes;
import com.navigate.treat.io.user.response.UsersLoginRes;

/**
 * 用户相关操作辅助类
 */
public class UserUtil {
	private static final Logger logger = LogManager.getLogger("UserUtil");

	/**
	 * 获取用户
	 * 
	 * @param cookies
	 * @return
	 */
	public static UsersLoginRes getUsers() {
		String sid = getSid();
		if (!StringUtils.isEmpty(sid)) {
			return getUsers4Sid(getSid());
		}
		return null;
	}

	/**
	 * 保存用户获取sessionId
	 * 
	 * @param users
	 * @return
	 */
	public static String saveSession(UsersLoginRes users) {
		if (users == null) {
			return null;
		}
		String sid = getSid(users.getUserId(), users.getLastLoginTime());
		JedisUtil.save(sid, Constants.EXPIRATIONTIME, users);
		return sid;
	}

	/**
	 * 保存用户获取sessionId
	 * 
	 * @param users
	 * @return
	 */
	public static String saveSession(String sid, UsersLoginRes users) {
		try {
			JedisUtil.save(sid, Constants.EXPIRATIONTIME, users);
		} catch (RedisException e) {
			logger.error("redis 连接异常 ", e);
			return null;
		}
		return sid;
	}

	public static String getSid(Long usersId, Date lastLogingTime) {
		return new StringBuilder().append(usersId).append(lastLogingTime.getTime()).toString();
	}

	public static void upateSession() {
		try {
			String key = getSid();
			if (StringUtils.isEmpty(key)) {
				return;
			}
			boolean exists = JedisUtil.exists(key);
			if (exists) {
				JedisUtil.expire(key, Constants.EXPIRATIONTIME);
				return;
			}
		} catch (RedisException e) {
			logger.error("redis 连接异常", e);
		}
	}

	/*
	 * 清出sessin
	 */
	public static void removeSession() {
		JedisClusterUtil.del(getSid());
	}

	/*
	 * 清出sessin
	 */
	public static void removeSession(String sid) {
		try {
			JedisUtil.del(sid);
		} catch (RedisException e) {
			logger.error("redis 连接异常 ", e);
		}
	}

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取sid
	 * 
	 * @return
	 */
	public static String getSid() {
		return getRequest().getHeader("m-sid");
	}

	public static void upateSession(DeviceInfoRes deviceInfo) {
		String sid = getSid();
		UsersLoginRes usersLoginRes = JedisClusterUtil.getObject(sid, UsersLoginRes.class);
		//usersLoginRes.setDeviceInfo(deviceInfo);
		JedisUtil.save(sid, Constants.EXPIRATIONTIME, usersLoginRes);
	}

	public static void upateSession(Users users, UserInfo userinfo) {
		String sid = getSid();
		UsersLoginRes usersLoginRes = JedisClusterUtil.getObject(sid, UsersLoginRes.class);
		if (users != null)
			SpringBeanUtils.copyProperties(users, usersLoginRes);
		if (userinfo != null)
			SpringBeanUtils.copyProperties(usersLoginRes, userinfo);
		JedisUtil.save(sid, Constants.EXPIRATIONTIME, usersLoginRes);
	}

	/**
	 * 根据sid获取用户
	 * 
	 * @param sid
	 * @return
	 */
	public static UsersLoginRes getUsers4Sid(String sid) {
		return sid == null ? null : JedisUtil.getObject(sid, UsersLoginRes.class);
	}
}
