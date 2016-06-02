package com.navigate.treat.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;


import com.navigate.treat.up.HeadVo;

/**
 * author huangshiping
 * @date:Sep 1, 20153:21:13 PM
 * @version:1.0
 */
public class DecryptionUtil {
	private static final Logger logger = LogManager.getLogger("DecryptionUtil");
	public static List<String> M_API = new ArrayList<String>();// 不验证会话的接口
	static {
		// M_API.add("userLogin");
		M_API.add("addUsers");
		M_API.add("userRegister");
		M_API.add("userLogin");
		M_API.add("userRegSetPwd");
		M_API.add("userForgetPassword");
		M_API.add("userMobileRegistered");
		M_API.add("userThirdRegister");
		M_API.add("userThirdLogin");
		// M_API.add("getResource");
		M_API.add("sendIdentifyingCode");
		M_API.add("addIndex");
		M_API.add("appVersion");
		//h5
		M_API.add("shareGiftBrowser");
		M_API.add("takenShareGift");
		M_API.add("onLineParty");
		M_API.add("party");
		M_API.add("userShareInfo");
		M_API.add("showShareInfo");
		M_API.add("sysGiftOne");
		M_API.add("userInviteInfo");
		
		
		
		
	}

	/**
	 * 签名验证
	 * @param body
	 * @param args
	 * @return
	 */
	public static HeadVo verificationSignature(HttpServletRequest request, String body) {
		HeadVo headVo = new HeadVo();
		String sign = request.getHeader("m-sign");
		if (!StringUtils.isEmpty(sign)) {
			headVo = getSign(request, body);
			String createSign = headVo.getSign();
			if (createSign != null) {
				if (sign.equals(createSign)) {
					headVo.setResponseUtil(ResponseCode.OK);
					// UserUtil.upateSession();
					headVo.setValidate(true);
				} else {
					headVo.setResponseUtil(ResponseCode.FAIL_SYS_ILLEGAL_REQUEST);
				}
			} else {
				headVo.setResponseUtil(ResponseCode.FAIL_SYS_REQUEST_TIMEOUT);
			}
		} else {
			headVo.setResponseUtil(ResponseCode.FAIL_SYS_UNAUTHORIZED);
		}
		return headVo;
	}
	/**
	 * 获取签名算法
	 * @param request
	 * @return
	 */
	public static HeadVo getSign(HttpServletRequest request, String body) {
		HeadVo headVo = new HeadVo();
		String api = request.getHeader("m-api");
		String av = request.getHeader("m-av");
		String imei = request.getHeader("m-imei");
		String sid = request.getHeader("m-sid");
		String t = request.getHeader("m-t");
		String v = request.getHeader("m-v");
		headVo.setValidate(false);
		headVo.setApi(api);
		headVo.setAv(av);
		headVo.setV(v);
		headVo.setsId(sid);
		/*
		 * try { body = new String(body.getBytes("iso-8859-1"), "utf-8"); } catch
		 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		 logger.info("request body" + body);
		//headVo.setJsonObject(body);
		if (!M_API.contains(api)) {
			//UsersLoginRes users = UserUtil.getUsers();
			/*if (users == null) {
				return headVo;
			}*/
			//headVo.setUsers(users);
		} else {
			// 如果访问未登录的接口代了SID则干掉
			/*if (headVo.getsId() != null) {
				UserUtil.removeSession();
				headVo.setsId(null);
			}*/
		}
		StringBuilder sb = new StringBuilder();
		sb.append(api).append("&").append(av);
		if (!StringUtils.isEmpty(imei)) {
			sb.append("&").append(imei);
		}
		if (!StringUtils.isEmpty(sid)) {
			sb.append("&").append(sid);
		}
		sb.append("&").append(t).append("&").append(v);
		if (!StringUtils.isEmpty(body)) {
			sb.append("&").append(body);
		}
		logger.info(sb);
		try {
			headVo.setSign(SecurityUtils.HmacSHA1Encrypt(sb.toString(), Constants.SECRET));
			logger.info(headVo.getSign());
			return headVo;
		} catch (Exception e) {
			logger.error("获取签名失败!请检查参数", e);
			return headVo;
		}
	}
}
