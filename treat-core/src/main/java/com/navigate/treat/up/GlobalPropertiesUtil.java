package com.navigate.treat.up;

import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;

/**
 * 所有的配置文件信息获取
 * @author fwg
 */
public final class GlobalPropertiesUtil {
	private static final String DEFAULT_RESULT_CODE_PROPERTIES_FILE = "global.properties";
	private static Properties resultCode = new Properties();
	private static final Logger logger = LogManager.getLogger(GlobalPropertiesUtil.class);
	private static boolean isLoad;

	private static boolean init() {
		boolean ret = false;
		InputStream fis = null;
		try {
			// 构造时获取到项目的物理根目录
			fis = GlobalPropertiesUtil.class.getClassLoader().getResourceAsStream(DEFAULT_RESULT_CODE_PROPERTIES_FILE);
			if (fis == null) {
				logger.error("{}-文件未找到。", DEFAULT_RESULT_CODE_PROPERTIES_FILE);
			}
			if (fis != null) {
				resultCode.load(fis);
				isLoad = true;
				ret = true;
			}
		} catch (Exception e) {
			logger.error("GlobalPropertiesUtil-初始化异常", e);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				logger.error("GlobalPropertiesUtil-初始化异常", e);
			}
		}
		return ret;
	}
	public static String get(String key) {
		try {
			if (!isLoad) {
				init();
			}
			String ret = resultCode.getProperty(key);
			if (ret == null) {
				return key;
			}
			// return new String(ret.getBytes("ISO-8859-1"), "utf-8");
			return ret;
		} catch (Exception e) {
			logger.error("GlobalPropertiesUtil-字符转换异常", e);
		}
		return "";
	}
}
