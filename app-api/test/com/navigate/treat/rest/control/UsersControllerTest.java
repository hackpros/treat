package com.navigate.treat.rest.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
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
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.io.user.response.UsersLoginRes;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UsersControllerTest extends BaseJunit4Test {
	MockMvc mockMvc;
	@Resource
	IUsersService usersService;

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
		// 新用户登录(==注册)
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile(getTel());
		// 验证码
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(usersReq.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		usersReq.setCaptcha(captcha);
		String body = JSON.toJSONString(usersReq);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).param("mobile", usersReq.getMobile())
						.param("captcha", usersReq.getCaptcha()).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		String code = obj.get("code").toString();
		Assert.assertEquals(code, "setting");
		String uid = obj.get("data").toString();
		Assert.assertTrue(uid != null);
		// 再登录一次
		// ############################################################
		// 验证码
		captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(usersReq.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		usersReq.setCaptcha(captcha);
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).param("mobile", usersReq.getMobile())
						.param("captcha", usersReq.getCaptcha()).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
		obj = JSON.parseObject(reponseBody);
		code = obj.get("code").toString();
		Assert.assertEquals(code, "setting");
		uid = obj.get("data").toString();
		Assert.assertTrue(uid != null);
		// 设置基本信息
		// ############################################################
		usersReq = new UsersReq();
		usersReq.setUserId(100L);
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
	}
	@Test
	public void testRegister() throws Exception {
		// 新用户注册
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile(getTel());
		// 验证码
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(usersReq.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		usersReq.setCaptcha(captcha);
		String body = JSON.toJSONString(usersReq);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		Assert.assertTrue(reponseBody.length() > 0);
	}
	@Test
	public void testModify() throws Exception {
		// 设置基本信息
		// ############################################################
		Long uid = 126L;
		String body = "{\"brithday\":828288000000,\"sex\":1,\"userId\":153,\"headIcon\":\"avatar\",\"nickName\":\"小辉\"}";
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(
						put("/users/" + uid).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		UsersLoginRes usersLoginRes = JSON.parseObject(obj.get("data").toString(), UsersLoginRes.class);
		// 验证登录的session
		UsersLoginRes sessionUser = JedisUtil.getObject(SID, UsersLoginRes.class);
		Assert.assertTrue(sessionUser != null);
		Assert.assertEquals(sessionUser.getUserId(), usersLoginRes.getUserId());
	}
	@Test
	public void testLoginAndRegValidation() throws Exception {
		// 新用户注册
		// ############################################################
		UsersReq usersReq = new UsersReq();
		String body = JSON.toJSONString(usersReq);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_CONFLICT);
		// 登录
		// ############################################################
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_CONFLICT);
		// 设置基本信息
		// ############################################################
		Long uid = 126L;
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader("", body);
		result = mockMvc
				.perform(
						put("/users/" + uid).contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_CONFLICT);
	}
	@Test
	public void testModifyInfo() throws Exception {
		Users master = new Users();
		master.setBirthday(new Date());
		master.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		master.setNickName("修改用户信息接口");
		master.setSex(1);
		master.setMobile(getTel());
		master.setBalance(BigDecimal.ZERO);
		master.setLastLoginTime(new Date());
		master.setHeadIcon("def/a2341a21");
		master.setCtime(new Date());
		master.setStatus(UsersHelper.EStatus.Normal.ordinal());
		master.setTreamNum(master.getMobile());
		master.setUserSource("junit");
		usersService.insertSelective(master);
		// 登录
		// ############################################################
		// 验证码
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(master.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		HttpHeaders httpHeaders = this.getHttpHeader("", "{}");
		MvcResult result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).param("mobile", master.getMobile())
						.param("captcha", captcha).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
		
		//修改用户信息
		// ############################################################
		UsersReq usersReq =new UsersReq();
		String body = JSON.toJSONString(usersReq);
		usersReq = new UsersReq();
		usersReq.setNickName("张三");
		body = JSON.toJSONString(usersReq);
		httpHeaders = this.getHttpHeader(SID, body);
		result = mockMvc
				.perform(put("/users/").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		reponseBody = result.getResponse().getContentAsString();
	}
}
