package com.navigate.treat.rest.control;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.navigate.treat.io.activity.request.ActivitysRegReq;
import com.navigate.treat.io.show.request.ShowsReq;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActControlTest extends BaseJunit4Test {
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
	public void test() throws Exception {
		
		//UserThirdRegReq userThirdRegReq = new UserThirdRegReq();
		//userThirdRegReq.setMobile(getTel());
		//userThirdRegReq.setPassword("123456");
		ShowsReq showsReq = new ShowsReq();
		//showsReq.setLat("30.1222");
		//showsReq.setLng("120.88676");
		//showsReq.setLength(20);
		//showsReq.setOffset(1);
		showsReq.setSex(0);
		ActivitysRegReq activitysRegReq = new ActivitysRegReq();
		activitysRegReq.setActId(80l);
		String body = JSON.toJSONString(activitysRegReq);
		HttpHeaders httpHeaders = this.getHttpHeader(session.getId(), body);
		MvcResult result = mockMvc.perform(
				post("/activity/registrationList").contentType(MediaType.APPLICATION_JSON).content(body).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
	}
	@Test
	public void testSogn() {
		fail("Not yet implemented");
	}
}
