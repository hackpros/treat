package com.navigate.treat.h5.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.github.sd4324530.fastweixin.message.BaseMsg;

/**
 * 用户详情
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/static")
public class StaticController {
	//private static final Logger log = LogManager.getLogger(StaticController.class);
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(StaticController.class);

	/**
	 * 关于我请客
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/about")
	public String about(Model model) {
		return "/static/about";
	};

	/**
	 * 关于活动规则
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/activityRule")
	public String activityRule(Model model) {
		return "/static/activityrule";
	};

	/**
	 * 用户注册协议
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/prot")
	public String protocol(Model model) {
		return "/static/prot";
	};
	/**
	 * 活动XX说明(担保金和赴约补贴说明)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/explain")
	public String explain(Model model) {
		return "/static/explain";
	};
	
	@RequestMapping(value = "/main")
	public String wx(Model model,String code,String state) {
		
		model.addAttribute("code", code);
		model.addAttribute("state", state);
		LOG.debug("code:{}",code);
		
		//通过code 获取token
		//https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		ApiConfig config = new ApiConfig(CommonController.APP_ID, CommonController.APPSECRET);
		ConfigChangeHandle configChangeHandle = new ConfigChangeHandle();
		config.addHandle(configChangeHandle);
		
		OauthAPI oauthAPI=  new OauthAPI(config);
		OauthGetTokenResponse token=oauthAPI.getToken(code);
		LOG.debug("token:{}",token.toJsonString());
		model.addAttribute("token", token.toJsonString());
		
		//通过openid获取用户信息
		UserAPI userAPI=new UserAPI(config);
		GetUserInfoResponse user=userAPI.getUserInfo(token.getOpenid()) ;
		LOG.debug("userInfo:{}",user.toJsonString());
		model.addAttribute("wxuserinfo", user.toJsonString());
		
		//给公从号发一条消息
		/*MessageAPI messageAPI=new MessageAPI(config);;
		BaseMsg message;
		boolean isToAll;
		messageAPI.sendMessageToUser(message, isToAll, tagId)*/
       		
		return "/static/wxmain";
	}

	protected String getToken() {
		// TODO Auto-generated method stub
		return null;
	};
}
