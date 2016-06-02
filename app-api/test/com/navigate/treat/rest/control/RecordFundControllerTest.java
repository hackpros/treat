package com.navigate.treat.rest.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
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
import com.alibaba.fastjson.TypeReference;
import com.navigate.treat.base.Pages;
import com.navigate.treat.beans.basic.RecordFund;
import com.navigate.treat.beans.multi.Users;
import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.pay.helper.FundsHelper.ConsumerType;
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.io.useractivity.response.ActCommentUsersRes;
import com.navigate.treat.io.usercenter.response.RecordFundRes;
import com.navigate.treat.service.basic.IRecordFundService;
import com.navigate.treat.service.multi.IUsersService;
import com.navigate.treat.util.Constants;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RecordFundControllerTest extends BaseJunit4Test {
	MockMvc mockMvc;
	@Resource
	IUsersService usersService;
	@Resource
	IRecordFundService recordFundService;
	Users master = new Users();

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		session = new MockHttpSession();
		request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		master.setBirthday(new Date());
		master.setUserId(JedisUtil.incr(UsersHelper.REDISS_USER_KEY));
		master.setNickName("发起者");
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
		UsersReq usersReq = new UsersReq();
		// 验证码
		String captcha = RandomStringUtils.randomNumeric(4);
		JedisUtil.save(master.getMobile() + Constants.SMS_CODE_KEY, 300, captcha);// 保存验证码，过期时间5分钟
		String body = JSON.toJSONString(usersReq);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(get("/users").contentType(MediaType.APPLICATION_JSON).param("mobile", master.getMobile())
						.param("captcha", captcha).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		SID = obj.get("sid").toString();
	}
	@Test
	public void testBrowser() throws Exception {
		String body = "{}";
		HttpHeaders httpHeaders = this.getHttpHeader(SID, body);
		MvcResult result = mockMvc.perform(get("/recordFund").contentType(MediaType.APPLICATION_JSON)
				.param("offset", "1").param("length", "10").headers(httpHeaders)).andDo(MockMvcResultHandlers.print())
				.andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
	@Test
	public void testBrowserPage() throws Exception {
		// 测试分页
		int i = 0;
		for (i = 0; i < 35; i++) {
			RecordFund t = new RecordFund();
			t.setAmount(new BigDecimal(RandomStringUtils.randomNumeric(3)));
			t.setCtime(new Date());
			t.setDescriptions("测试数据" + i);
			t.setOutTradeNo(RandomStringUtils.randomAlphanumeric(10));
			t.setPlusMinus(ConsumerType.INCOME.ordinal());
			t.setType(0);
			t.setUserId(master.getUserId());
			recordFundService.insertSelective(t);
		}
		String body = "{}";
		HttpHeaders httpHeaders = this.getHttpHeader(SID, body);
		MvcResult result = mockMvc.perform(get("/recordFund").contentType(MediaType.APPLICATION_JSON)
				.param("offset", "1").param("length", "10").headers(httpHeaders)).andDo(MockMvcResultHandlers.print())
				.andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		String reponseBody = result.getResponse().getContentAsString();
		JSONObject obj = JSON.parseObject(reponseBody);
		Pages<RecordFundRes> pages = JSON.parseObject(obj.get("page").toString(),
				new TypeReference<Pages<RecordFundRes>>() {
				});
		Assert.assertEquals(pages.getTotal(),34);
		Assert.assertEquals(pages.getLength(),10);
		Assert.assertEquals(pages.getOffset(),1);
		Assert.assertEquals(pages.getRows().size(),10);
	}
}
