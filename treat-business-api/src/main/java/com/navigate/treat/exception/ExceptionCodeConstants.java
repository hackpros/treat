package com.navigate.treat.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionCodeConstants {
	private static Map<String, String> EXCEPTION_CODE_CONSTANTS_MAP = new HashMap<String, String>();

	/**
	 * 获取code对应的文本描述
	 * @param code exception的code
	 * @return
	 */
	public static String getMessage(String code) {
		return EXCEPTION_CODE_CONSTANTS_MAP.get(code);
	}
	/**
	 * 初始化代码库
	 * @param map
	 */
	public static void init(Map<String, String> map) {
		EXCEPTION_CODE_CONSTANTS_MAP = map;
	}

	/**
	 * 后期根据数据库中获取数据
	 */
	static {
		EXCEPTION_CODE_CONSTANTS_MAP.put(ResultCode.RESOURCE_TYPE_ERROR, " 资源类型错误");
		EXCEPTION_CODE_CONSTANTS_MAP.put(ResultCode.RESOURCE_TYPE_ERROR, "借款协议不存在或未启用");
	}
}
