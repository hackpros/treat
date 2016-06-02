package com.navigate.treat.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.navigate.treat.cache.JedisUtil;

/**
 * @author huangshiping
 */
public class StringUtil {
	/**
	 * 一天发验证码最多次数
	 */
	private static final int SEND_CNT_OND_DAY_MAX_NUM = 6;

	/**
	 * 获取短信验证码发送内容
	 * @param code
	 * @return
	 */
	public static String getSmsContent(String code) {
		return "您的验证码:" + code + "。(5分钟内有效)。欢迎来到我请客，”约会交友神器”enjoy!";
	}
	/**
	 * 现在短信发送次数
	 * @param string
	 * @return
	 */
	public static boolean limitSendCnt(String key) {
		Integer count = 0;
		Long time = DateUtil.getFailureTime();
		String value = JedisUtil.get(key);
		if (value != null) {
			count = Integer.parseInt(value);
		} else {
			count = 0;
		}
		JedisUtil.save(key,time.intValue() , count + 1);
		return count < SEND_CNT_OND_DAY_MAX_NUM;
	}
	
	public static String StringFilter(String mobiles) {
		String temp = mobiles.replaceAll(" ", "");
		String regEx = "[`~!@#$%^&*()+=|';'\\[\\].<>/?~！_@#￥%……&*（）——+|【】‘；”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(temp);
		return m.replaceAll("").trim();
	}
	
	public static boolean isCNMobile(String mobiles) {
		if (StringUtils.isEmpty(mobiles)) {
			return false;
		}
		return mobiles.matches("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
	}
	
	public static String getPointPraise(Integer pointPraise) {
		String temp = null;
		if (pointPraise > 9 && pointPraise < 100) {
			temp = pointPraise / 10 + "0+";
		} else if (pointPraise > 99 && pointPraise < 1000) {
			temp = pointPraise / 100 + "00+";
		} else if (pointPraise > 999) {
			int i = pointPraise / 1000;
			int j = pointPraise % 1000 / 100;
			if (j != 0) {
				temp = i + "." + j + "k+";
			} else {
				temp = i + "k+";
			}
		} else {
			temp = pointPraise + "";
		}
		return temp;
	}
	public static void main(String args) {
	}
}
