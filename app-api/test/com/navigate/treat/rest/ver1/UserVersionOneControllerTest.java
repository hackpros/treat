package com.navigate.treat.rest.ver1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Date;

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
import com.navigate.treat.io.user.requeset.UsersReq;
import com.navigate.treat.rest.control.BaseJunit4Test;
import com.navigate.treat.util.SecurityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserVersionOneControllerTest extends BaseJunit4Test {
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
	public void testRegist() throws Exception {
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile(getTel());
		usersReq.setUserSource("appStore");
		String body = JSON.toJSONString(usersReq);
		// 签名验证
		long stamp = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer().append(body);
		sb.append("&stamp=").append(stamp);
		String desSign = SecurityUtils.HmacSHA1Encrypt(sb.toString(), UserVersionOneController.SECRET);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("sign", desSign);
		httpHeaders.add("stamp", stamp + "");
		MvcResult result = mockMvc.perform(post("/vone/register?version=1.0").contentType(MediaType.APPLICATION_JSON)
				.content(body).headers(httpHeaders)).andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
	@Test
	public void testRegister() throws Exception {
		// 先注册用户
		// ##############################################
		UsersReq usersReq = new UsersReq();
		usersReq.setMobile(getTel());
		usersReq.setUserSource("appStore");
		String body = JSON.toJSONString(usersReq);
		// 签名验证
		long stamp = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer().append(body);
		sb.append("&stamp=").append(stamp);
		String desSign = SecurityUtils.HmacSHA1Encrypt(sb.toString(), UserVersionOneController.SECRET);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("sign", desSign);
		httpHeaders.add("stamp", stamp + "");
		MvcResult result = mockMvc.perform(post("/vone/register?version=1.0").contentType(MediaType.APPLICATION_JSON)
				.content(body).headers(httpHeaders)).andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		
		
		// 再修改信息
		// ##############################################
		stamp = System.currentTimeMillis();
		sb.setLength(0);
		usersReq.setSex(0);
		usersReq.setBirthday(new Date());
		usersReq.setHeadIcon("/vone/register?version=1.0");
		usersReq.setNickName("魏则西");
	    body = JSON.toJSONString(usersReq);
		sb = new StringBuffer().append(body);
		sb.append("&stamp=").append(stamp);
		desSign = SecurityUtils.HmacSHA1Encrypt(sb.toString(), UserVersionOneController.SECRET);
		httpHeaders = new HttpHeaders();
		httpHeaders.add("sign", desSign);
		httpHeaders.add("stamp", stamp + "");
		result = mockMvc.perform(post("/vone/modify?version=1.0").contentType(MediaType.APPLICATION_JSON)
				.content(body).headers(httpHeaders)).andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
}
