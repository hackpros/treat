package com.navigate.treat.rest.control;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.web.context.WebApplicationContext;

import com.navigate.treat.util.Constants;
import com.navigate.treat.util.SecurityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext.xml")
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseJunit4Test {
	static final Logger log = LogManager.getLogger(BaseJunit4Test.class);
	// public final String ALICLOUD_SERVICE =
	// "http://rdp2p-bucket.oss-cn-hangzhou.aliyuncs.com";
	protected MockHttpSession session;
	protected MockHttpServletRequest request;
	protected MockHttpServletResponse response;
	protected static final String VERSION = "1.0.0";
	protected String SID = "";
	protected static final String DEF_LNG = "120.137070";
	protected static final String DEF_LAT = "30.271626";

	@Resource
	public WebApplicationContext wac;

	@BeforeClass
	public static void setUpBeforeClass() {
	}

	protected static final char[] number = { 48, 49, 51, 51, 52, 53, 54, 55, 56, 57 };
	private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");

	private static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}
	public static String getTel() {
		int index = getNum(0, telFirst.length - 1);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + thrid;
	}
	public HttpHeaders getHttpHeader(String m_sid, String body) {
		try {
			String m_av = "1";
			String m_imei = "xa-24-11-ss";
			String m_t = String.valueOf(System.currentTimeMillis());
			long stamp = System.currentTimeMillis();
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("m-av", m_av);
			httpHeaders.add("m-imei", m_imei);
			if (m_sid != null)
				httpHeaders.add("m-sid", m_sid);
			httpHeaders.add("m-t", m_t + "");
			httpHeaders.add("m-v", VERSION);
			httpHeaders.add("m-stamp", stamp + "");
			StringBuilder sb = new StringBuilder();
			sb.append(stamp).append("&").append(m_av);
			if (StringUtils.isNotEmpty(m_imei)) {
				sb.append("&").append(m_imei);
			}
			sb.append("&").append(m_sid).append("&").append(m_t).append("&").append(VERSION);
			if (StringUtils.isNotEmpty(body)) {
				sb.append("&").append(body);
			}
			log.info("junit src  sign:{}", sb.toString());
			String m_sign = SecurityUtils.HmacSHA1Encrypt(sb.toString(), Constants.SECRET);
			log.info("jnut sign:{}", m_sign);
			httpHeaders.add("m-sign", m_sign);
			return httpHeaders;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("签名异常..");
		}
	}
}
