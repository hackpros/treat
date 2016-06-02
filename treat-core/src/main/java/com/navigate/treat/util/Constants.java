package com.navigate.treat.util;

/**
 * author huangshiping
 * 
 * @date:Aug 29, 201511:10:39 AM
 * @version:1.0
 * 
 */

public class Constants {
	
	//系统用户。系统送礼
	public final static Long SYS_USERID=1L;
	
	public static final String H5_URL = "h5.url";// h5地址

	public static final String UPLOAD_PATH = "upload.path";// 图片上传的路径

	public static final String UPLOAD_SUFFIX = "upload.suffix";// 图片上传的路径

	public static final String DECRYPT_KEY = "decrypt_key"; // 接口密码

	public static final String MYCAT_SEQ_NEXTVAL = "SELECT MYCAT_SEQ_NEXTVAL('user_seq')";

	public static final String VERIFICATION_CODE_KEY = "ZH_VERIFICATION_CODE";// 验证码key

	public static final String SMS_CODE_KEY = "ZH_SMS_KEY";// 验证码

	public static final String MAC_NAME = "HmacSHA1";

	public static final String ENCODING = "UTF-8";

	public static final String API_KEY_SMS = "059e8b7baf86a15338e3fb7f30bb0ccc";// 云片网key

	public static final String URI_SEND_SMS = "http://yunpian.com/v1/sms/send.json";// 云片发送api

	public static final String SECRET = "zh_req!@#W";// 签名密钥

	public static final String DATA = "data";// 返回数据

	public static final String RESULT = "result";// 返回结果

	public static final String SYSTIME = "systime";// 超时

	public static final String API = "api";// 返回api名称

	public static final String V = "v";// 版本

	public static final String VERSION = "1";// 版本号

	public static final String MSG = "msg";// 返回信息

	public static final String DESC = "desc";// 描述

	public static final String USER_SESSION = "zh.users";// 会话Id

	public static final int EXPIRATIONTIME = 365 * 60 * 60 * 24;// session过期时间

	public static final int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };

	public static final String[] constellationArr = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
			"天蝎座", "射手座", "摩羯座" };

	public static final String SID = "sid";// 返回数据

	public static final String ALIPAY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&partner=2088611277876384&notify_id=";

	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

	public static final String WX_PAY_KEY = "LZF2014WQK20150319SQY0217SS1990N";

	public static final String ALI_IMG_URL = "http://hzzh.oss-cn-hangzhou.aliyuncs.com";

	public static final String TREAT_OFF_LINE = "OL";// 线下请客订单类型

	public static final String TREAT_REG = "TR";// 报名担保金类型

	public static final long DIFFTIME = 3 * 60 * 60 * 1000;

	public static final String PWDERRCNT = "PWDERRCNT";

}
