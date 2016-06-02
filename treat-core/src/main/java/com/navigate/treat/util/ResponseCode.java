package com.navigate.treat.util;


/**
 * author huangshiping
 * 
 * @date:Aug 29, 20153:29:36 PM
 * @version:1.0 状态码管理
 */
public class ResponseCode {
	/**
	 * 系统状态
	 */
	public static final ResponseUtil OK = new ResponseUtil(200, "OK", "成功返回");
	public static final ResponseUtil FAIL_SYS_BAD_REQUEST = new ResponseUtil(201, "FAIL_SYS_BAD_REQUEST", "错误的请求,参数不完整");
	public static final ResponseUtil FAIL_SYS_ILLEGAL_REQUEST = new ResponseUtil(202, "FAIL_SYS_ILLEGAL_REQUEST", "非法请求，签名验证失败");
	public static final ResponseUtil FAIL_SYS_API_NOT_FOUND = new ResponseUtil(203, "FAIL_SYS_API_NOT_FOUND", "访问了不存在的API");
	public static final ResponseUtil FAIL_SYS_API_REJECT = new ResponseUtil(204, "FAIL_SYS_API_REJECT", "访问的API拒绝了对特定用户的请求");
	public static final ResponseUtil FAIL_SYS_EXPIRED_REQUEST = new ResponseUtil(205, "FAIL_SYS_EXPIRED_REQUEST", "请求时间戳已失效");
	public static final ResponseUtil FAIL_SYS_UNAUTHORIZED = new ResponseUtil(206, "FAIL_SYS_UNAUTHORIZED", "app试图访问未授权的api");
	public static final ResponseUtil FAIL_SYS_REQUEST_TIMEOUT = new ResponseUtil(251, "FAIL_SYS_REQUEST_TIMEOUT", "请求超时会话失效");
	public static final ResponseUtil FAIL_SYS_SERVICE_FAULT = new ResponseUtil(252, "FAIL_SYS_SERVICE_FAULT", "后端服务调用失败");
	public static final ResponseUtil FAIL_SYS_SERVICE_NOT_EXIST = new ResponseUtil(253, "FAIL_SYS_SERVICE_NOT_EXIST", "后端服务不存在");
	public static final ResponseUtil FAIL_SYS_INVOKE_API_EXPTION = new ResponseUtil(254, "FAIL_SYS_INVOKE_API_EXPTION", "服务器异常,API调用失败!");
	public static final ResponseUtil FAIL_AUTH_NOT = new ResponseUtil(255, "FAIL_AUTH_NOT", "你没有操作权限");

	/**************************************************************/
	/** 用户类异常业务 */
	public static final ResponseUtil FAIL_USER_IS_EXIST = new ResponseUtil(410, "FAIL_USER_IS_EXIST", "用户已经存在");
	public static final ResponseUtil FAIL_IDENTIFYING_CODE = new ResponseUtil(413, "FAIL_IDENTIFYING_CODE", " 一小时内最多发送3条验证码，请稍后重试");
	public static final ResponseUtil FAIL_IDENTIFYING_LIMIT = new ResponseUtil(413, "FAIL_IDENTIFYING_LIMIT", "每天最多可以发送5条验证码，请明日重试");
	public static final ResponseUtil FAIL_MOBILE_NULL = new ResponseUtil(415, "FAIL_MOBILE_NULL", "请输入要发送的手机号");;
	public static final ResponseUtil OK_IDENTIFYING_CODE = new ResponseUtil(414, "FAIL_USER_IS_EXIST", "验证码发送成功");
	public static final ResponseUtil FAIL_BUSINESS_ERROR = new ResponseUtil(417, "FAIL_BUSINESS_ERROR", " 用户未登录或已登录超时");
	public static final ResponseUtil FAIL_ACTIVITY_NOT_EXITES = new ResponseUtil(15080, "FAIL_ACTIVITY_NOT_EXITES", "活动已不存在");
	public static final ResponseUtil FAIL_ACTIVITY_NO_BEGIN = new ResponseUtil(15081, "FAIL_ACTIVITY_NO_BEGIN", "活动未开始");
	public static final ResponseUtil FAIL_ACTIVITY_FINISHED = new ResponseUtil(15082, "FAIL_ACTIVITY_FINISHED", "活动已结束");

	public static final ResponseUtil FAIL_ACT_COMMENT_FULL = new ResponseUtil(15081, "FAIL_ACT_COMMENT_FULL", "你已经评论过了");
	public static final ResponseUtil FAIL_ACT_COMMENT_FAILURE = new ResponseUtil(15082, "FAIL_ACT_COMMENT_FAILURE", "评论失败");
	public static final ResponseUtil FAIL_ACTIVITY_NOT_FINISHED_NO_PUNIH = new ResponseUtil(15083, "FAIL_ACTIVITY_NOT_FINISHED_NO_PUNIH",
			"活动未结束,不能处罚");
	public static final ResponseUtil FAIL_ACTIVITY_NOT_PUNIH_YOURSELF = new ResponseUtil(15084, "FAIL_ACTIVITY_NOT_FINISHED_NO_PUNIH",
			"自己 不能处理自己 ");
	public static final ResponseUtil FAIL_ACTIVITY_PUNIH_STATUS_ERROR = new ResponseUtil(15085, "FAIL_ACTIVITY_PUNIH_STATUS_ERROR",
			"已处理或已完成 ");
	public static final ResponseUtil FAIL_ACTIVITY_TAR_PUNIHED = new ResponseUtil(15086, "FAIL_ACTIVITY_TAR_PUNIHED", "你已经处理了对方");
	public static final ResponseUtil FAIL_ACTIVITY_SRC_NO_SIGNIN = new ResponseUtil(15087, "FAIL_ACTIVITY_SRC_NO_SIGNIN", "你没有签到,不能处罚对方");
	public static final ResponseUtil FAIL_ACTIVITY_TAR_SIGNIN_OVER = new ResponseUtil(15088, "FAIL_ACTIVITY_TAR_SIGNIN_OVER", "对方已签到,不能处理了");
	public static final ResponseUtil FAIL_ACTIVITY_TAR_NO_MASTER = new ResponseUtil(15089, "FAIL_ACTIVITY_TAR_NO_MASTER", "对方不是活动的发起者,不能处理");
	public static final ResponseUtil FAIL_ACTIVITY_SRC_OR_TAR_NO_EXISTS = new ResponseUtil(15090, "FAIL_ACTIVITY_TAR_NO_MASTER",
			"处理者或被处理者不存在");
	public static final ResponseUtil FAIL_ACTIVITY_TAR_NO_BORKE = new ResponseUtil(15091, "FAIL_ACTIVITY_TAR_NO_BORKE", "对方已经签到 不能处理为爽约");
	public static final ResponseUtil FAIL_ACTIVITY_TAR_NO_KEEP = new ResponseUtil(15092, "FAIL_ACTIVITY_TAR_NO_KEEP", "对方未签到 不能处理为赴约");

	public static final ResponseUtil FAIL_FOLLOWER_USER_NOT_EXISTS = new ResponseUtil(15100, "FAIL_FOLLOWER_USER_NOT_EXISTS", "您关注的用户不存在");
	public static final ResponseUtil FAIL_FOLLOWER_SELF = new ResponseUtil(15101, "FAIL_FOLLOWER_SELF", "您关注自己");
	public static final ResponseUtil FAIL_WAS_FOLLOWER = new ResponseUtil(15102, "FAIL_WAS_FOLLOWER", "您已经关注过了");

	public static final ResponseUtil FAIL_APPLY_SPEED_TO_SELF = new ResponseUtil(15094, "FAIL_APPLY_SPEED_TO_SELF", "您不能报名自己的极速约");

	public static final ResponseUtil FAIL_TO_POSITE = new ResponseUtil(15093, "FAIL_TO_POSITE", "定位失败");

	// ###########################################################333
	/**
	 * 用户类相磁的
	 */
	public static final ResponseUtil FAIL_NO_LOGIN_OR_TIMEOUT = new ResponseUtil(10001, "FAIL_NO_LOGIN_OR_TIMEOUT", "用户未登录或已登录超时");
	public static final ResponseUtil FAIL_USER_NOT_EXITIS = new ResponseUtil(10002, "FAIL_USER_NOT_EXITIS", "用户不存在");
	public static final ResponseUtil FAIL_USERNAM_OR_PWD_ERROR = new ResponseUtil(10003, "FAIL_USERNAM_OR_PWD_ERROR", "密码错误，请重新输入");
	public static final ResponseUtil FAIL_OLD_PASSWORD_ERROR = new ResponseUtil(10017, "FAIL_OLD_PASSWORD_ERROR", "原密码不正确");

	public static final ResponseUtil FAIL_CAPTCHA_ERROR = new ResponseUtil(10004, "FAIL_CAPTCHA_ERROR", " 验证码输入错误，请重新输入");
	public static final ResponseUtil FAIL_REGEISTERED = new ResponseUtil(10005, "FAIL_REGEISTERED", "您的手机号已经注册过了");
	public static final ResponseUtil FAIL_THIRD_REGEISTERED = new ResponseUtil(10005, "FAIL_REGEISTERED", "您的手机已经绑定过同类型的账号了");

	public static final ResponseUtil FAIL_USER_NOT_EXITIS_OR_DATA_ERROR = new ResponseUtil(10006, "FAIL_USER_NOT_EXITIS_OR_DATA_ERROR",
			"您的手机号尚未注册，是否用该手机号码注册");
	public static final ResponseUtil FAIL_CAPTCHA_ISNOT_NULL = new ResponseUtil(10007, "FAIL_CAPTCHA_ISNOT_NULL", "验证码不能为空");
	public static final ResponseUtil FAIL_IS_LOCKED = new ResponseUtil(10008, "FAIL_IS_LOCKED", "账户已锁定");
	public static final ResponseUtil FAIL_STATU_ERROR = new ResponseUtil(10009, "FAIL_STATU_ERROR", "账户状态异常");
	public static final ResponseUtil FAIL_TOO_MANY_ERROR_LONGIN_NUM = new ResponseUtil(10010, "FAIL_TOO_MANY_ERROR_LONGIN_NUM", "密码错误次数太多");
	public static final ResponseUtil FAIL_PARAMETER_ERROR = new ResponseUtil(10011, "FAIL_PARAMETER_ERROR", "传参异常");
	public static final ResponseUtil FAIL_TOKEN_ERROR = new ResponseUtil(10012, "FAIL_TOKEN_ERROR", "token请求异常");
	public static final ResponseUtil FAIL_USER_PWD_READY_SET = new ResponseUtil(10013, "FAIL_USER_PWD_READY_SET", "密码已设置");
	public static final ResponseUtil FAIL_USER_DATA_ERROR = new ResponseUtil(100014, "FAIL_USER_DATA_ERROR", "用户数据异常");
	public static final ResponseUtil FAIL_HAS_INVITED = new ResponseUtil(10015, "FAIL_HAS_INVITED", "该用户已填写过邀请码！");
	public static final ResponseUtil FAIL_IS_FRIEND = new ResponseUtil(10016, "FAIL_IS_FRIEND", "你们已经是好友了！");
	public static final ResponseUtil FAIL_NO_INVITE_SELF = new ResponseUtil(10018, "FAIL_NO_INVITE_SELF", "邀请码不存在！");
	public static final ResponseUtil FAIL_MODI_MOBILE_ERROR = new ResponseUtil(10019, "MODI_MOBILE_ERROR", "更换手机号失败！");
	public static final ResponseUtil FAIL_NO_INVITECODE = new ResponseUtil(10020, "FAIL_NO_INVITECODE", "邀请码不存在！");
	public static final ResponseUtil FAIL_APPLY_FRIEND_TO_SELF = new ResponseUtil(10021, "FAIL_APPLY_FRIEND_TO_SELF", "您不能添加自己为好友");
	public static final ResponseUtil FAIL_THIRD_LOGIN_NOINIT= new ResponseUtil(10022, "FAIL_THIRD_LOGIN_NOINIT", "第三方账号未初始化");
	
	

	public static final ResponseUtil FAIL_THIRD_ON_REGISTER = new ResponseUtil(10501, "FAIL_THIRD_ON_REGISTER", "第三方用户未注册");
	public static final ResponseUtil FAIL_THIRD_BINDED = new ResponseUtil(10502, "FAIL_THIRD_BINDED", "该第三方账号已经被绑定了");
	public static final ResponseUtil FAIL_THIRD_READY_REG = new ResponseUtil(10503, "FAIL_THIRD_READY_REG", "该第三方账号已经注册");
	public static final ResponseUtil FAIL_SHOW_PRAISE = new ResponseUtil(10504, "FAIL_SHOW_PRAISE", "你已经点过赞了");


	// ###########################################################
	// 系统礼品
	public static final ResponseUtil FAIL_SYSGIFT_NOT_EXISTS = new ResponseUtil(17001, "FAIL_SYSGIFT_NOT_EXISTS", "奖励码不存在");
	public static final ResponseUtil FAIL_SYSGIFT_NO_ENABLE = new ResponseUtil(17002, "FAIL_SYSGIFT_NO_ENABLE", "活动未开启");
	public static final ResponseUtil FAIL_SYSGIFT_DISABLED = new ResponseUtil(17003, "FAIL_SYSGIFT_DISABLED", "活动已关闭");
	public static final ResponseUtil FAIL_SYSGIFT_FINISH = new ResponseUtil(17004, "FAIL_SYSGIFT_FINISH", "活动已结束");
	public static final ResponseUtil FAIL_SYSGIFT_LEAD_END = new ResponseUtil(17005, "FAIL_SYSGIFT_LEAD_END", "礼品领完");
	// 我的礼品
	public static final ResponseUtil FAIL_SYSGIFTUSER_NOT_EXISTS = new ResponseUtil(17006, "FAIL_SYSGIFTUSER_NOT_EXISTS", "礼品不存在");
	public static final ResponseUtil FAIL_SYSGIFTUSER_NO_EXCHANGE = new ResponseUtil(17007, "FAIL_SYSGIFTUSER_NO_EXCHANGE", "该礼品不能兑换");
	public static final ResponseUtil FAIL_SYSGIFT_HAS = new ResponseUtil(17008, "FAIL_SYSGIFT_HAS", "亲.你已经领取过了,机会留给别人吧!");
	public static final ResponseUtil FAIL_INVITE_HAS = new ResponseUtil(17009, "FAIL_INVITE_HAS", "你已经领取过这个礼物了!");
	public static final ResponseUtil FAIL_USERGIFT_EVALUATED = new ResponseUtil(17010, "FAIL_USERGIFT_EVALUATED", "你已经评价过了");
	public static final ResponseUtil FAIL_USERGIFT_NO_HAS = new ResponseUtil(17011, "FAIL_USERGIFT_NO_HAS", "对方收取后才可评论");
	public static final ResponseUtil FAIL_SYSGIFT_NO_START = new ResponseUtil(17012, "FAIL_SYSGIFT_NO_START", "活动未开始");
	public static final ResponseUtil FAIL_SYSGIFT_AT_END = new ResponseUtil(17013, "FAIL_SYSGIFT_AT_END", "活动已结束");

	// h5礼物大家抢
	public static final ResponseUtil H5_GIFT_AT_END = new ResponseUtil(39901, "H5_GIFT_END", "亲.你来晚了,礼物已经抢完了");
	public static final ResponseUtil H5_GIFT_HAS = FAIL_SYSGIFT_HAS;

}
