package com.navigate.treat.aop;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.navigate.treat.base.io.request.IRequest;
import com.navigate.treat.base.io.request.ReqHttpHeaders;
import com.navigate.treat.exception.AuthException;
import com.navigate.treat.util.Constants;
import com.navigate.treat.util.ResponseCode;
import com.navigate.treat.util.SecurityUtils;

/**
 * @author fanwg
 * @date 2013-7-23 下午07:37:46
 * @email renntrabbit@foxmail.com
 */
public class BaseInterceptor {
	private final Logger log = LogManager.getLogger(this.getClass());

	/**
	 * 验证授权用户/权限
	 */	
	public void authenticateAuthInfo(ReqHttpHeaders head) {
		log.debug("验证授权用户/权限 ....");
	}
	/**
	 * 验证签名
	 * @param req
	 * @param head
	 */
	public void authenticateSign(IRequest req, ReqHttpHeaders head) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("&").append(head.getMav());
		if (StringUtils.isNotEmpty(head.getMimei())) {
			sb.append("&").append(head.getMimei());
		}
		sb.append("&").append(head.getMsid()).append("&").append(head.getMt()).append("&").append(head.getMv());
		String body = JSON.toJSONString(req);
		if (StringUtils.isNotEmpty(body)) {
			sb.append("&").append(body);
		}
		log.info("src  sign:{}", sb.toString());
		String sign = SecurityUtils.HmacSHA1Encrypt(sb.toString(), Constants.SECRET);
		log.info("sign:{}", sign);
		if (StringUtils.isEmpty(sign)) {
			throw new AuthException(ResponseCode.FAIL_SYS_UNAUTHORIZED.getDesc());
		}
		if (!sign.equals(head.getSign())) {
			log.error("sign:{}", head.getSign());
			throw new AuthException(ResponseCode.FAIL_SYS_ILLEGAL_REQUEST.getDesc());
		}
	}
	/**
	 * 验证url时间戳 10分钟有效 600秒
	 * @param iCNNCTAuth
	 * @param cardNo
	 * @param sign
	 * @throws AuthException
	 */
	public void authenticateTimeStamp(ReqHttpHeaders head) {
		log.info("验证url时间戳..");
		/*
		 * if (System.currentTimeMillis() - head.getStamp() > 60000000) { throw new
		 * AuthException(AuthException.ErrorMessageInfo.URL_OVERDUE); }
		 */
	}
}
