package com.navigate.treat.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.navigate.treat.exception.SessionException;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.util.UserUtil;

/**
 * 权限拦截器 session登录拦截
 * @author fwg create by 2016年4月27日 上午10:30:21
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOG = LogManager.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			//打印参数
			printRequestInfo(request);
			
			UsersLoginRes res = UserUtil.getUsers();
			if (res == null) {
				throw new SessionException("登录过期，请重新登录");
			}
		}
		return true;
	}
	private void printRequestInfo(HttpServletRequest request) {
		Enumeration<String> names = request.getParameterNames();
		StringBuilder sb = new StringBuilder("请求参数为--");
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String values = request.getParameter(name);
			sb.append(name + ":" + values + ", ");
		}
		LOG.info("请求地址Start: " + request.getRequestURI() + ", " + sb.toString());
	}
}
