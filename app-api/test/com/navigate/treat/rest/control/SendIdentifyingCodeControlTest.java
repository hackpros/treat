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

import com.navigate.treat.cache.JedisUtil;
import com.navigate.treat.util.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SendIdentifyingCodeControlTest extends BaseJunit4Test {
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
		String body = getTel();
		HttpHeaders httpHeaders = this.getHttpHeader(session.getId(), body);
		MvcResult result = mockMvc
				.perform(get("/common/sendCatath/"+body).contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
		Assert.assertEquals(JedisUtil.get(body+ Constants.SMS_CODE_KEY),"1234");
	}
}
