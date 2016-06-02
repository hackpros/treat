package com.navigate.treat.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal计算工具类
 * 
 * @author zf
 * @since p2p_cloud_v1.0
 */
public class BigDecimalUtil {
	public static final int DEF_DIV_SCALE = 2; // 默认精确的小数位

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param params
	 *            参数数组
	 * @return 和
	 */
	public static BigDecimal add(Number... params) {
		BigDecimal b = BigDecimal.ZERO;
		for (Number param : params) {
			BigDecimal b2 = new BigDecimal(param.toString());
			b = b.add(b2);
		}
		return b;
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param b1
	 *            被减数
	 * @param b2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(Number b1, Number b2) {
		if (b1 == null) {
			b1 = 0;
		}
		if (b2 == null) {
			b2 = 0;
		}
		return new BigDecimal(b1.toString()).subtract(new BigDecimal(b2.toString()));
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param params
	 *            参数数组
	 * @return 动态参数的积
	 */
	public static BigDecimal mul(Number... params) {
		BigDecimal b1 = BigDecimal.ONE;
		for (Number param : params) {
			BigDecimal b2 = new BigDecimal(param.toString());
			b1 = b1.multiply(b2);
		}
		BigDecimal one = BigDecimal.ONE;
		return b1.divide(one, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的乘法加除法运算。
	 * 
	 * @param dividend
	 *            被除数
	 * @param params
	 *            参数数组
	 * @return 动态参数的积
	 */
	public static BigDecimal mulAndDiv(Number dividend, Number... params) {
		BigDecimal b1 = BigDecimal.ONE;
		for (Number param : params) {
			BigDecimal b2 = new BigDecimal(param.toString());
			b1 = b1.multiply(b2);
		}
		return b1.divide(new BigDecimal(dividend.toString()), DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(Number v1, Number v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param b1
	 *            被除数
	 * @param b2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(Number b1, Number b2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return new BigDecimal(b1.toString()).divide(new BigDecimal(b2.toString()), scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 得到BigDecimal对象负数形式
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static BigDecimal getNegativeNumber(BigDecimal param) {
		return new BigDecimal("-" + param.doubleValue());
	}

	/**
	 * 得到BigDecimal对象
	 * 
	 * @param obj
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static BigDecimal getBigDecimal(Object obj) {
		return new BigDecimal(obj.toString());
	}

	/**
	 * 将金额转成联动方的金额标准备(以分为单位) ..%100　再取整
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static String toUmpayAmount(BigDecimal param) {
		BigDecimal amount = mul(param, new BigDecimal("100.00"));
		return amount.toBigInteger().toString();

	}

	/**
	 * 
	 * BigDecimal==0
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static boolean eqZero(BigDecimal param) {
		int r = param.compareTo(BigDecimal.ZERO); // 和0，Zero比较
		return r == 0;
	}

	/**
	 * 
	 * BigDecimal>0
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static boolean gtZero(BigDecimal param) {
		int r = param.compareTo(BigDecimal.ZERO); // 和0，Zero比较
		return r == 1;
	}

	/**
	 * 
	 * BigDecimal<0
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static boolean ltZero(BigDecimal param) {
		int r = param.compareTo(BigDecimal.ZERO); // 和0，Zero比较
		return r == -1;
	}

	/**
	 * 得到BigDecimal对象相反数
	 * 
	 * @param param
	 * @return BigDecimal
	 * @since p2p_cloud_v1.0
	 */
	public static BigDecimal getOppositeNumber(BigDecimal param) {
		return param.multiply(new BigDecimal("-1"));
	}

	public static String toDefaultScaleString(BigDecimal input) {
		if (input == null)
			return "";
		return input.setScale(DEF_DIV_SCALE, RoundingMode.HALF_UP).toPlainString();
	}

	public static void main(String[] args) {
		//String amount = toUmpayAmount(new BigDecimal("123456789123456789.0001"));

		System.out.println(gtZero(new  BigDecimal("0")));
		System.out.println(gtZero(new  BigDecimal("1")));
		System.out.println(gtZero(new  BigDecimal("-1")));
		System.out.println(getOppositeNumber(new BigDecimal("1.1231")));
		System.out.println(getOppositeNumber(new BigDecimal("0.0000")));
		System.out.println(getOppositeNumber(new BigDecimal("-1.234566")));
	}
}