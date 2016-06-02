package com.navigate.treat.h5.config;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.velocity.VelocityContext;

/**
 * velicity 自定义系统选项获取函数
 * 
 * @author fanwg
 * @date 2013-8-10 下午02:40:14
 * @email renntrabbit@foxmail.com
 */
public class SelfVmFunc extends VelocityContext {

	public static final long SECOND_IN_MILLIS = 1000;
	public static final long MINUTE_IN_MILLIS = SECOND_IN_MILLIS * 60;
	public static final long HOUR_IN_MILLIS = MINUTE_IN_MILLIS * 60;
	public static final long DAY_IN_MILLIS = HOUR_IN_MILLIS * 24;
	public static final long WEEK_IN_MILLIS = DAY_IN_MILLIS * 7;
	/**
	 * This constant is actually the length of 364 days, not of a year!
	 */
	public static final long YEAR_IN_MILLIS = WEEK_IN_MILLIS * 52;

	private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };
	private final static String[] constellationArr = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座",
			"狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };

	public static final String MATH = "math";

	public boolean containsKey(Object key) {
		return MATH.equals(key) || super.containsKey(key);
	}

	public static class MathUtil {

		public long round(double a) {
			return Math.round(a);
		}

		public double ceil(double a) {
			return Math.ceil(a);
		}
	}

	public static String getOption(String tbName) {

		return "hello " + tbName;
	}

	/**
	 * 用户头像处理
	 * 
	 * @param headIconUrl
	 * @return
	 */
	public static String loadHeadIcon(String prefix, String headIconUrl) {

		if (StringUtils.isEmpty(headIconUrl)) {
			return prefix + "/image/defhaed/def.png";
		}

		int index = headIconUrl.indexOf("/default/");
		if (index != -1) {
			String localHeadIcon = StringUtils.substringAfter(headIconUrl, "/default/");
			// 男头像
			if (localHeadIcon.startsWith("m/")) {
				String no = StringUtils.substringAfter(localHeadIcon, "m/");
				return prefix + "/image/defhead/male_icon" + no + ".png";
			} else if (localHeadIcon.startsWith("f/")) {
				String no = StringUtils.substringAfter(localHeadIcon, "f/");
				return prefix + "/image/defhead/female_icon" + no + ".png";
			} else {

				return prefix + "/image/defhead/def.png";
			}
		} else {
			return headIconUrl;
		}

	}

	/**
	 * 获取年龄
	 * 
	 * @param timestamp
	 * @return
	 */
	public static int getAge(long timestamp) {
		Date date = new Date(timestamp);
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		born.setTime(date);
		int age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
		if (age <= 0 || age >= 100) {
			age = 100;
		}
		return age;

	}

	/**
	 * 获时间区间
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String getDateSection(long timestamp) {

		String defaultStr = "刚刚";
		String suffix = "前";
		if (timestamp == 0) {
			return defaultStr;
		}
		long sub = System.currentTimeMillis() - timestamp;
		if (sub <= 0) {
			return defaultStr;
		} else if (sub < MINUTE_IN_MILLIS) {
			sub = sub / SECOND_IN_MILLIS;
			if (sub == 0) {
				return defaultStr;
			} else {
				return sub + "秒" + suffix;
			}
		} else if (sub < HOUR_IN_MILLIS) {
			sub = sub / MINUTE_IN_MILLIS;
			return sub + "分钟" + suffix;
		} else if (sub < DAY_IN_MILLIS) {
			long hour = sub / HOUR_IN_MILLIS;
			long minite = sub % HOUR_IN_MILLIS / MINUTE_IN_MILLIS;
			if (minite > 0) {
				return hour + "小时" + minite + "分钟" + suffix;
			} else {
				return hour + "小时" + suffix;
			}
		} else if (sub < WEEK_IN_MILLIS) {
			sub = sub / DAY_IN_MILLIS;
			return sub + "天" + suffix;
		} else if (sub < YEAR_IN_MILLIS) {
			sub = sub / WEEK_IN_MILLIS;
			return sub + "周" + suffix;
		} else {
			sub = sub / YEAR_IN_MILLIS;
			return sub + "年" + suffix;
		}

	}

	/**
	 * 获取星府
	 * 
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getConstellation(long timestamp) {
		Calendar born = Calendar.getInstance();
		born.setTime(new Date(timestamp));
		int day = born.get(Calendar.DAY_OF_MONTH);
		int month = born.get(Calendar.MONTH)+1;
		return day < dayArr[month - 1] ? constellationArr[month - 1] : constellationArr[month];
	}

	public static void main(String[] args) throws ParseException {

		Date date = DateUtils.parseDate("2013-01-31 12:12:12", "yyyy-MM-dd HH:ss:mm");
		System.out.println("2013-01-31 12:12:12:      " + getDateSection(date.getTime()));

		date = DateUtils.parseDate("2015-12-31 12:12:12", "yyyy-MM-dd HH:ss:mm");
		System.out.println("2015-12-31 12:12:12:      " + getDateSection(date.getTime()));
		date = DateUtils.parseDate("2014-11-30 12:12:12", "yyyy-MM-dd HH:ss:mm");
		System.out.println("2014-11-30 12:12:12:      " + getDateSection(date.getTime()));

		date = DateUtils.parseDate("2016-01-7 12:12:12", "yyyy-MM-dd HH:ss:mm");
		System.out.println("2016-01-7 12:12:12:       " + getDateSection(date.getTime()));
		date = DateUtils.parseDate("2016-01-11 12:12:12", "yyyy-MM-dd HH:ss:mm");
		System.out.println("2016-01-11 12:12:12:         " + getDateSection(date.getTime()));

	}
}