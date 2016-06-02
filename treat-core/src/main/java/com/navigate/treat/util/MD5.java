package com.navigate.treat.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	private final static char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * Md5加密
	 * 
	 * @param s
	 * @return 字符串
	 */
	public static final String md5(String str) {
		byte[] h = DigestUtils.md5(str);
		StringBuilder resultSb = new StringBuilder();

		for (int i = 0; i < h.length; ++i) {
			int t = h[i] & 0xFF;
			resultSb.append(hexDigits[(t >> 4) & 0x0F]);
			resultSb.append(hexDigits[t & 0x0F]);
		}

		return resultSb.toString();
	}
}
