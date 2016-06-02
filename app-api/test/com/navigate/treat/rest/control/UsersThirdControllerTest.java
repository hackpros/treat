package com.navigate.treat.rest.control;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.user.requeset.UserThirdRegReq;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.util.Constants;

/**
 * 第三方登录注册
 * @author fwg create by 2016年4月1日 上午9:37:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UsersThirdControllerTest extends BaseJunit4Test {
	MockMvc mockMvc;

	@BeforeClass
	public static void BeforeClass() {
	}
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		session = new MockHttpSession();
		request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	@Test
	public void testLogin() throws Exception {
		// 第三方户记登录(注册)
		// ############################################################
		UserThirdRegReq userThirdRegReq = new UserThirdRegReq();
		userThirdRegReq.setOpenId("Test OenId_" + RandomStringUtils.randomAlphabetic(20));
		userThirdRegReq.setRefreshToken("refreshToken_" + RandomStringUtils.randomAlphabetic(10));
		userThirdRegReq.setAccessToken("accessToken_" + RandomStringUtils.randomAlphabetic(10));
		userThirdRegReq.setType(Integer.parseInt(RandomStringUtils.randomNumeric(1)) + 1);
		String body = JSON.toJSONString(userThirdRegReq);
		HttpHeaders httpHeaders = this.getHttpHeader(null, body);
		MvcResult result = mockMvc
				.perform(post("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		Assert.assertEquals(obj.get("code"), "register");
		Long thirdId = Long.parseLong(obj.get("data").toString());
		Assert.assertTrue(thirdId > 0);
		// 第三方用户绑定手机号
		// ############################################################
		// ############################################################
		UserThirdRegReq userThirdbind = new UserThirdRegReq();
		userThirdbind.setMobile(getTel());
		userThirdbind.setThirdId(thirdId);
		userThirdbind.setOpenId(userThirdRegReq.getOpenId());
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(userThirdbind.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		userThirdbind.setCaptcha(captcha);
		body = JSON.toJSONString(userThirdbind);
		httpHeaders = this.getHttpHeader(null, body);
		result = mockMvc
				.perform(put("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		Assert.assertEquals(obj.get("code"), "setting");
		Long uid = Long.parseLong(obj.get("data").toString());
		// 设置基本信息
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setUserId(uid);
		usersReq.setHeadIcon("test");
		usersReq.setBirthday(new Date());
		usersReq.setSex(UsersHelper.ESex.FEMALE.ordinal()); // 默认女
		usersReq.setNickName(UsersHelper.getRandomNick());
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(
						put("/users/" + uid).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		UsersLoginRes usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		UsersLoginRes sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
		// 第三方用户记登录
		// ############################################################
		body = JSON.toJSONString(userThirdRegReq);
		httpHeaders = this.getHttpHeader(null, body);
		result = mockMvc
				.perform(post("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
	}
	@Test
	public void testLoginScuess() throws Exception {
		// 第三方户记登录(注册)
		// ############################################################
		UserThirdRegReq userThirdRegReq = new UserThirdRegReq();
		userThirdRegReq.setOpenId("Test OenId_" + RandomStringUtils.randomAlphabetic(20));
		userThirdRegReq.setRefreshToken("refreshToken_" + RandomStringUtils.randomAlphabetic(10));
		userThirdRegReq.setAccessToken("accessToken_" + RandomStringUtils.randomAlphabetic(10));
		userThirdRegReq.setType(Integer.parseInt(RandomStringUtils.randomNumeric(1)) + 1);
		String body = JSON.toJSONString(userThirdRegReq);
		HttpHeaders httpHeaders = this.getHttpHeader(null, body);
		MvcResult result = mockMvc
				.perform(post("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		Assert.assertEquals(obj.get("code"), "register");
		Long thirdId = Long.parseLong(obj.get("data").toString());
		Assert.assertTrue(thirdId > 0);
		// 绑定手机
		// ############################################################
		UserThirdRegReq userThirdReg = new UserThirdRegReq();
		userThirdReg.setMobile(getTel());
		userThirdReg.setThirdId(thirdId);
		userThirdReg.setOpenId(userThirdRegReq.getOpenId());
		userThirdReg.setType(userThirdRegReq.getType());
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(userThirdReg.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		userThirdReg.setCaptcha(captcha);
		body = JSON.toJSONString(userThirdReg);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(put("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		Assert.assertEquals(obj.get("code"), "setting");
		Long uid = Long.parseLong(obj.get("data").toString());
		Assert.assertTrue(uid > 0);
		// 设置基本信息
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setUserId(uid);
		usersReq.setHeadIcon("test");
		usersReq.setBirthday(new Date());
		usersReq.setSex(UsersHelper.ESex.FEMALE.ordinal()); // 默认女
		usersReq.setNickName(UsersHelper.getRandomNick());
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(
						put("/users/" + uid).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		UsersLoginRes usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		UsersLoginRes sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
		// 第三方户记登录
		// ############################################################
		body = JSON.toJSONString(userThirdRegReq);
		httpHeaders = this.getHttpHeader(null, body);
		result = mockMvc
				.perform(post("/userThird").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
	}
	@Test
	public void testBindingMobile() {
		fail("Not yet implemented");
	}
}
