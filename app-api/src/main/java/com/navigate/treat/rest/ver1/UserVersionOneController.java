/**
 * 
 */
package com.navigate.treat.rest.ver1;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.api.IUsersServiceFront;
import com.navigate.treat.base.contorl.BaseController;
import com.navigate.treat.exception.ApplicationException;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.util.SecurityUtils;

/**
 * 我请客1.0同步接口
 * @author fwg create by  2016年5月9日 上午11:04:08
 *
 */
@Controller
@RequestMapping(value = "/vone")
public class UserVersionOneController extends BaseController {
	
	public static final String SECRET = "treat_wqk1.0@hsp&aniu&supper";// 签名密钥
	
	static final Logger log = Logger.getLogger(UserVersionOneController.class);
	@Resource
	IUsersServiceFront userServiceFront;

	/**
	 * 我请客1.0 注册接口
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST,params="version=1.0")
	@ResponseBody
	public Object regist(@RequestBody UsersReq usersReq,@RequestHeader("sign") String sign,@RequestHeader("stamp") String stamp) {
		//签名验证
		StringBuffer sb=new StringBuffer().append(JSONObject.toJSONString(usersReq));
		sb.append("&stamp=").append(stamp);
		String desSign= SecurityUtils.HmacSHA1Encrypt(sb.toString(), SECRET);
		if (!desSign.equals(sign)){
			log.error("des before sign;{}"+sb.toString());
			log.error("des afters sign;{}"+desSign);
			log.error("client input sing:{}"+sign);
			throw new ApplicationException("签名异常");
		}
		return userServiceFront.registerV1(usersReq);
	}

	/**
	 * 我请客1.0修改信息接口
	 * 
	 * @param usersReq
	 */
	@RequestMapping(value="/modify",method = RequestMethod.POST,params="version=1.0")
	@ResponseBody
	public Object modify(@RequestBody UsersReq usersReq,@RequestHeader("sign") String sign,@RequestHeader("stamp") String stamp) {
		//签名验证) {
		StringBuffer sb=new StringBuffer().append(JSONObject.toJSONString(usersReq));
		sb.append("&stamp=").append(stamp);
		String desSign= SecurityUtils.HmacSHA1Encrypt(sb.toString(), SECRET);
		if (!desSign.equals(sign)){
			log.error("des before sign;{}"+sb.toString());
			log.error("des afters sign;{}"+desSign);
			log.error("client input sing:{}"+sign);
			throw new ApplicationException("签名异常");
		}
		
		return userServiceFront.modifyV1(usersReq);
	}

	
}
