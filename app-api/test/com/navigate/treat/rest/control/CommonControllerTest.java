package com.navigate.treat.rest.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.http.HttpServletResponse;

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
import com.navigate.treat.helper.UsersHelper;
import com.navigate.treat.io.activity.request.ActivitysReq;
import com.navigate.treat.io.user.requeset.UsersReq;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CommonControllerTest extends BaseJunit4Test {
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
	public void testSendCatath() throws Exception {
		// 新用户注册
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile(getTel());
		String body = "{}";
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		for (int i=0;i<10;i++){
			
		MvcResult result = mockMvc.perform(get("/common/sendCatath/" + usersReq.getMobile())
				.contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		Assert.assertEquals(UsersHelper.checkCaptcha(usersReq.getMobile(), "1234"), true);
		}
	}
	@Test
	public void testSign() throws Exception {
		// 新用户注册
		// ############################################################
		ActivitysReq latlnt = new ActivitysReq();
		latlnt.setUserLat("130.12131");
		latlnt.setUserLng("130.12131");
		String body = JSON.toJSONString(latlnt);
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc
				.perform(get("/common/sign").contentType(MediaType.APPLICATION_JSON)
						.param("userLat", String.valueOf(latlnt.getUserLat()))
						.param("userLng", String.valueOf(latlnt.getUserLng())).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_CONFLICT);
		Assert.assertTrue(result.getResponse().getContentAsString().indexOf("用户没有登录") != -1);
	}
	
	@Test
	public void testSendCatathProc() throws Exception {
		// 新用户注册
		// ############################################################
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile("15988125024");
		String body = "{}";
		HttpHeaders httpHeaders = this.getHttpHeader("", body);
		MvcResult result = mockMvc.perform(get("/common/sendCatath/" + usersReq.getMobile())
				.contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
}
