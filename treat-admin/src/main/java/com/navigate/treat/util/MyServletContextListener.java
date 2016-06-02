package com.navigate.treat.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
//	private static final Logger logger = Logger
//			.getLogger(MyServletContextListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servlet_context = arg0.getServletContext();
		String contextPath = servlet_context.getContextPath();
		servlet_context.setAttribute("contextPath",contextPath);
		String base = servlet_context.getContextPath();
		servlet_context.setAttribute("base",base);
		servlet_context.setAttribute("resouce_base","");
		String buiPath=Config.getString("bui.path");
		String staticServerUpload=Config.getString("resource.upload");
		servlet_context.setAttribute("basePath",buiPath);
		servlet_context.setAttribute("staticServerUpload",staticServerUpload);
	}
}
