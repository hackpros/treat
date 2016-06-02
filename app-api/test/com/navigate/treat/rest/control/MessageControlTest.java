package com.navigate.treat.rest.control;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.navigate.treat.api.IMessageServiceFront;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MessageControlTest  extends BaseJunit4Test {
	MockMvc mockMvc;
	@Resource                               
	IMessageServiceFront 	messageServiceFront;

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
	public void selectTest() {
		fail("Not yet implemented");
	}
	@Test
	public void testExcute() {
		//messageServiceFront.insert(new MessageReq());
	}
}
