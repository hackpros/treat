package com.navigate.treat.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.navigate.treat.base.io.request.IRequest;
import com.navigate.treat.base.io.request.ReqHttpHeaders;
import com.navigate.treat.exception.ParamValidateException;

/**
 * 用户请求授权认证
 * @author fanwg
 * @date 2013-7-22 上午10:24:08
 * @email renntrabbit@foxmail.com
 */
@Aspect
@Component
public class AuthInterceptor extends BaseInterceptor {
	static final Logger log = Logger.getLogger(AuthInterceptor.class);;

	@Pointcut(value = "execution(* com.navigate.treat.rest.control.*.*(..))")
	public void select() {
	}
	@Before(" select() && args(req)")
	public void beforeRequst(@RequestBody IRequest req) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		ReqHttpHeaders head = new ReqHttpHeaders();
		head.setMav(request.getHeader("m-av"));
		head.setMimei(request.getHeader("m-imei"));
		head.setMsid(request.getHeader("m-sid"));
		head.setMt(request.getHeader("m-t"));
		head.setMv(request.getHeader("m-v"));
		//head.setStamp(Long.parseLong(request.getHeader("m-stamp")));
		head.setSign(request.getHeader("m-sign"));
		super.authenticateTimeStamp(head);
		super.authenticateAuthInfo(head);
		//super.authenticateSign(req, head);
	}
	@Before(" select() && args(req,bindingResult)")
	public void beforeRequstV(IRequest req, BindingResult bindingResult) {
		// 请求参数统一验证
		if (bindingResult.hasErrors()) {
			throw new ParamValidateException(bindingResult.getFieldError().getDefaultMessage());
		}
		// 签名验证
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		ReqHttpHeaders head = new ReqHttpHeaders();
		head.setMav(request.getHeader("m-av"));
		head.setMimei(request.getHeader("m-imei"));
		head.setMsid(request.getHeader("m-sid"));
		head.setMt(request.getHeader("m-t"));
		head.setMv(request.getHeader("m-v"));
		head.setSign(request.getHeader("m-sign"));
		super.authenticateTimeStamp(head);
		super.authenticateAuthInfo(head);
		// super.authenticateSign(req, head);
	}
	@Around("execution(* com.navigate.treat.rest.control.*.*(..))")
	public Object AroundAdviceResponse(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		ModelMap model = null;
		Object object = proceedingJoinPoint.proceed();
		if (object instanceof ModelMap) {
			model = (ModelMap) object;
			model.addAttribute("version", "2.0");
			model.addAttribute("sign", "123456");
		} else {
			return object;
		}
		return model;
	}
}
