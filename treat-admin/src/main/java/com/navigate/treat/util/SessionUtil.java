package com.navigate.treat.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.navigate.treat.po.basic.UserManager;


public class SessionUtil {

	public final static String  USER_SESSION_KEY = "userManager";
	
	/**
	 * 得到用户
	 * @return
	 */
	public static UserManager getUserManager(HttpServletRequest req){
		Object obj = getSession(req).getAttribute(USER_SESSION_KEY);
		if(obj!=null){
			UserManager user = (UserManager)obj;
			return user;
		}
		return null;
	}

	/**
	 * 得到session
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session;
	}

	/**
	 * 保存用户到session
	 * @param um
	 */
	public static void saveUserManager(UserManager um,HttpServletRequest req) {
		getSession(req).setAttribute(USER_SESSION_KEY, um);
	}

	/**
	 * 清除session
	 * @param req
	 */
	public static void removeSession(HttpServletRequest req) {
		getSession(req).removeAttribute(USER_SESSION_KEY);
	}
	
}
