package com.navigate.treat.h5.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.view.ViewToolContext;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

/**
 * spring 3.VelocityToolboxView 类只支持1.X的velocitytools，
 * 重写.VelocityToolboxView这个类的createVelocityContext方法， 然后在配置文件里指定使用新的viewClass。
 * @author fanwg
 * @date 2013-8-10 下午04:36:11
 * @email renntrabbit@foxmail.com
 */
public class VelocityToolbox20View extends VelocityToolboxView {
	@Override
	protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {// Create a
		// ChainedContext
		ViewToolContext ctx;
		ctx = new ViewToolContext(getVelocityEngine(), request, response, getServletContext());
		ctx.putAll(model);
		if (this.getToolboxConfigLocation() != null) {
			ToolManager tm = new ToolManager();
			tm.setVelocityEngine(getVelocityEngine());
			tm.configure(getServletContext().getRealPath(getToolboxConfigLocation()));
			if (tm.getToolboxFactory().hasTools(Scope.REQUEST)) {
				ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.REQUEST));
			}
			if (tm.getToolboxFactory().hasTools(Scope.APPLICATION)) {
				ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.APPLICATION));
			}
			if (tm.getToolboxFactory().hasTools(Scope.SESSION)) {
				ctx.addToolbox(tm.getToolboxFactory().createToolbox(Scope.SESSION));
			}
		}
		return ctx;
	}
	/*
	 * @Override protected Context createVelocityContext(Map<String, Object> model,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {// Create a //
	 * ChainedContext ViewToolContext ctx; ctx = new ViewToolContext(getVelocityEngine(), request,
	 * response, getServletContext()); ctx.putAll(model); if (toolboxFactory == null) { ToolManager
	 * toolManager = new ToolManager(); toolManager.setVelocityEngine(getVelocityEngine());
	 * toolManager.configure(getServletContext().getRealPath(getToolboxConfigLocation()));
	 * toolboxFactory = toolManager.getToolboxFactory(); } if (toolboxFactory != null) { if
	 * (toolboxFactory.hasTools(Scope.REQUEST)) {
	 * ctx.addToolbox(toolboxFactory.createToolbox(Scope.REQUEST)); } if
	 * (toolboxFactory.hasTools(Scope.APPLICATION)) {
	 * ctx.addToolbox(toolboxFactory.createToolbox(Scope.APPLICATION)); } if
	 * (toolboxFactory.hasTools(Scope.SESSION)) {
	 * ctx.addToolbox(toolboxFactory.createToolbox(Scope.SESSION)); } } return ctx; }
	 */
}
