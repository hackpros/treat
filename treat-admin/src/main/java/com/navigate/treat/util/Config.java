package com.navigate.treat.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Config {

//	private static Log log = LogFactory.getLog(Config.class);
	private static Logger logger =  LogManager.getLogger(Config.class.getName());
	private Config() {

	}

	
	private static Properties props = new Properties();

	static  {
		try {
			String path = Config.class.getClassLoader().getResource("").getPath();
			logger.info("加载路径"+path);
			props.load(new FileInputStream(path+"conf.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private static boolean changeToBoolean(String str) {
		String tmp = str.toLowerCase();
		if (tmp.equals("true")) {
			return true;
		} else if (tmp.equals("false")) {
			return false;
		} else {
			throw new RuntimeException("class not matching.");
		}
	}

	public static boolean getBoolean(String key) {
		String str = Config.getString(key);
		try {
			return Config.changeToBoolean(str);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean getBoolean(String key, boolean defaultValue) {
		String str = Config.getString(key);
		try {
			return Config.changeToBoolean(str);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	private static int changeToInt(String str) throws Exception {
		return Integer.parseInt(str);
	}

	public static int getInt(String key) {
		String str = Config.getString(key);
		try {
			return Config.changeToInt(str);
		} catch (Exception e) {
			return 0;
		}
	}

	public static int getInt(String key, int defaultValue) {
		String str = Config.getString(key);
		try {
			return Config.changeToInt(str);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String getString(String key, String defaultValue) {

		String tmp = getString(key);
		if (tmp == null) {
			tmp = defaultValue;
		}
		logger.debug(key + ": " + tmp);
		return tmp;
	}

	private static String getRealValue(String valueStr) {
		if(valueStr!=null){
		String rtnValue = valueStr;
		while (valueStr.indexOf("${") >= 0 && valueStr.indexOf("}") >= 0) {
			String keyName = valueStr.substring(valueStr.indexOf("{") + 1, valueStr.indexOf("}"));
			rtnValue = getString(keyName, "") + valueStr.substring(valueStr.indexOf("}") + 1);
		}
		return rtnValue;
		}else return null;
	}

	public static String getString(String key) {
		String tmp = getRealValue(props.getProperty(key));
		logger.debug(key + ": " + tmp);
		return tmp;
	}
}
