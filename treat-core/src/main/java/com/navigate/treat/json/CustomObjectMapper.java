package com.navigate.treat.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 定制json转化
 * @author fwg create by  2016年3月28日 上午10:41:27
 *
 */
public class CustomObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public CustomObjectMapper() {
		// json序列化时将number类型转成string，保证小数点.00的显示
		// this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true); // 前台来处理
		this.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
		// this.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS,true);
		// 空串不处理
		// this.setSerializationInclusion(Include.NON_NULL);
		// 时间改为毫秒
		this.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
		// 格式化输入出
		this.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
}
