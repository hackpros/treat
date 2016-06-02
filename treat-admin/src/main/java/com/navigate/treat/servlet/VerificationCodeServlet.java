package com.navigate.treat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.navigate.treat.util.ValidateCodeUtil;

/**
 * @author hsp
 * @version 1.0.0
 * @version 创建时间：Oct 31, 2014 4:20:34 PM
 * 
 */
public class VerificationCodeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
		resp.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);
		ValidateCodeUtil randomValidateCode = new ValidateCodeUtil();
	        try {
	            randomValidateCode.getRandcode(req, resp);//输出图片方法
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	public VerificationCodeServlet() {
		super();
	}

	private ApplicationContext context;

	public void init() throws ServletException {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(this
					.getServletContext());
		}
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}


}
