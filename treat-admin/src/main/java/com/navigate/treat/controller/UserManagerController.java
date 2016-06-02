package com.navigate.treat.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navigate.treat.po.basic.Dept;
import com.navigate.treat.po.basic.Functions;
import com.navigate.treat.po.basic.Role;
import com.navigate.treat.po.basic.RolePermission;
import com.navigate.treat.po.basic.UserManager;
import com.navigate.treat.service.LogService;
import com.navigate.treat.service.UserManagerService;
import com.navigate.treat.util.Md5Util;
import com.navigate.treat.util.SessionUtil;


@Controller
public class UserManagerController extends BaseController {
	private static final Logger logger =  LogManager.getLogger(UserManagerController.class.getName());
	@Autowired
	private UserManagerService userMangerService;
	@Autowired
	private LogService logService;
	/**
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/getUser4LoginName.do")
	public String getUser4LoginName(HttpServletRequest req,
			HttpServletResponse resp) {
		UserManager um = SessionUtil.getUserManager(req);
		if (um == null)
			return "login";
		req.setAttribute("userManager", um);
		return "/jsp/manage/userdetail";
	}

	/**
	 * 
	 * 权限分配改版后，按人分配权限（一对一）
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("用户开始登录-----------------------------------");
		UserManager userManager = SessionUtil.getUserManager(req);
		if (userManager != null)
			return "index";
		String loginName = req.getParameter("login_name");
		String pwd = req.getParameter("pwd");
		if (loginName == null || "".equals(loginName))
			return "login";
		Integer status = 0;
		UserManager um = userMangerService.getUserManager4LoginName(loginName);
		if (um != null) {
			String functionCodes = um.getFunctionCodes();
			if (um.getPass_word().equals(Md5Util.getMd5(pwd))) {
				SessionUtil.saveUserManager(um, req);

				Map<String, Object> rpMap = new HashMap<String, Object>();
				rpMap.put("loginName", loginName);
				rpMap.put("functionCodes", "("+functionCodes+")");
//				List<Functions> rootPermissionList = userMangerService.getRootRolePermission(rpMap);
				List<Functions> rootPermissionList = userMangerService.getRootUserPermission(rpMap);
				
				
				StringBuffer config = new StringBuffer(" [{id:'menu',menu:[");
				for (int i = 0; i < rootPermissionList.size(); i++) {
					if (rootPermissionList.get(i).getFunctionCode()
							.substring(4, 6).equals("00")) {//一级菜单；collapsed:true 默认菜单闭合
						config.append("{text:'"
								+ rootPermissionList.get(i).getFunctionName()
								+ "',collapsed:true,items:[");
					} else {
						if (i + 1 < rootPermissionList.size()) {
							if (rootPermissionList.get(i + 1).getFunctionCode()
									.substring(4, 6).equals("00")) {
								config.append("{id:'"
										+ rootPermissionList.get(i)
												.getFunctionCode()
										+ "',text:'"
										+ rootPermissionList.get(i)
												.getFunctionName()
										+ "',href:'"
										+ rootPermissionList.get(i)
												.getLinkUrl() + "'},] },");
							} else {
								config.append("{id:'"
										+ rootPermissionList.get(i)
												.getFunctionCode()
										+ "',text:'"
										+ rootPermissionList.get(i)
												.getFunctionName()
										+ "',href:'"
										+ rootPermissionList.get(i)
												.getLinkUrl() + "'},");
							}
						}

					}
					if (i == rootPermissionList.size() - 1) {
						config.append("{id:'"
								+ rootPermissionList.get(i).getFunctionCode()
								+ "',text:'"
								+ rootPermissionList.get(i).getFunctionName()
								+ "',href:'"
								+ rootPermissionList.get(i).getLinkUrl()
								+ "'}] },");
					}

				}
				config.append(" ]}]");
				req.getSession().setAttribute("rootPermissionList",
						rootPermissionList);
				req.getSession().setAttribute("config", config);

				// add log
//				String content =  "登陆了“掌航后台管理系统”";
//				userMangerService.saveLog(content,req);
				return "index";
			} else {
				status = 1;//密码错误
			}
		} else {
			status = 2;//用户不存在
		}
		req.setAttribute("status", status);
		logger.debug("用户结束登录-----------------------------------");
		return "login";
	}
	
	/**
	 * 
	 * 按职务分配权限（一对多）
	 * @param req
	 * @param resp
	 * @return
	 */
//	@RequestMapping(value = "/login1.do")
//	public String login1(HttpServletRequest req, HttpServletResponse resp) {
//		UserManager userManager = SessionUtil.getUserManager(req);
//		if (userManager != null)
//			return "index";
//		String loginName = req.getParameter("login_name");
//		String pwd = req.getParameter("pwd");
//		if (loginName == null || "".equals(loginName))
//			return "login";
//		Integer status = 0;
//		UserManager um = userMangerService.getUserManager4LoginName(loginName);
//		if (um != null) {
//			if (um.getPass_word().equals(Md5Util.getMd5(pwd))) {
//				SessionUtil.saveUserManager(um, req);
//
//				Map<String, Object> rpMap = new HashMap<String, Object>();
//				rpMap.put("loginName", loginName);
//				List<Functions> rootPermissionList = userMangerService
//						.getRootRolePermission(rpMap);
//				StringBuffer config = new StringBuffer(" [{id:'menu',menu:[");
//				for (int i = 0; i < rootPermissionList.size(); i++) {
//					if (rootPermissionList.get(i).getFunctionCode()
//							.substring(4, 6).equals("00")) {
//						config.append("{text:'"
//								+ rootPermissionList.get(i).getFunctionName()
//								+ "',collapsed:true,items:[");
//					} else {
//						if (i + 1 < rootPermissionList.size()) {
//							if (rootPermissionList.get(i + 1).getFunctionCode()
//									.substring(4, 6).equals("00")) {
//								config.append("{id:'"
//										+ rootPermissionList.get(i)
//												.getFunctionCode()
//										+ "',text:'"
//										+ rootPermissionList.get(i)
//												.getFunctionName()
//										+ "',href:'"
//										+ rootPermissionList.get(i)
//												.getLinkUrl() + "'},] },");
//							} else {
//								config.append("{id:'"
//										+ rootPermissionList.get(i)
//												.getFunctionCode()
//										+ "',text:'"
//										+ rootPermissionList.get(i)
//												.getFunctionName()
//										+ "',href:'"
//										+ rootPermissionList.get(i)
//												.getLinkUrl() + "'},");
//							}
//						}
//
//					}
//					if (i == rootPermissionList.size() - 1) {
//						config.append("{id:'"
//								+ rootPermissionList.get(i).getFunctionCode()
//								+ "',text:'"
//								+ rootPermissionList.get(i).getFunctionName()
//								+ "',href:'"
//								+ rootPermissionList.get(i).getLinkUrl()
//								+ "'}] },");
//					}
//
//				}
//				config.append(" ]}]");
//				req.getSession().setAttribute("rootPermissionList",
//						rootPermissionList);
//				req.getSession().setAttribute("config", config);
//
//				// add log
//				String content =  "登陆了“掌航后台管理系统”";
//				userMangerService.saveLog(content,req);
//				return "index";
//			} else {
//				status = 1;
//			}
//		} else {
//			status = 2;
//		}
//		req.setAttribute("status", status);
//		return "login";
//	}

	/**
	 * 退出登录
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/loginOut.do")
	public String loginOut(HttpServletRequest req, HttpServletResponse resp) {
		SessionUtil.removeSession(req);
		return "login";
	}

	/**
	 * 获取验证码
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getVcode.do")
	public String getVcode(HttpServletRequest req, HttpServletResponse resp) {
		String vcode = req.getSession().getAttribute("validateCode").toString();
		return vcode;
	}

	/**
	 * 注册用户
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/register.do")
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		String returnstr = "";
		UserManager um = new UserManager();
		um.setDeptid(req.getParameter("deptid"));
		um.setType(Integer.parseInt(req.getParameter("type")));
		um.setLogin_name(req.getParameter("login_name"));
		um.setPass_word(Md5Util.getMd5(req.getParameter("pass_word")));
		um.setSex(Integer.parseInt(req.getParameter("sex")));
		um.setUsername(req.getParameter("username"));
		um.setBirthday(req.getParameter("birthday"));
		um.setJob(req.getParameter("job"));
		um.setPhone(req.getParameter("phone"));
		um.setMail(req.getParameter("mail"));
		um.setAddress(req.getParameter("address"));
		um.setCtime(new Date());
		um.setFlag(0);
		List<UserManager> userList = userMangerService.userIsExist(req
				.getParameter("login_name"));
		if (userList.size() > 0) {// login_name已存在
			um.setLogin_name(null);
			um.setPass_word(null);
			req.setAttribute("userManager", um);
			req.setAttribute("msg", userList.size());
			List<Role> typeList = userMangerService.getUserType();
			List<Dept> deptList = userMangerService.getUserDept();
			req.setAttribute("typeList", typeList);
			req.setAttribute("deptList", deptList);
			returnstr = "jsp/manage/usermanagerEdit";
		} else {
			userMangerService.saveUsermanager(um);
			returnstr = "jsp/manage/usermanagerlist";
			// 添加日志表
//			String content =  "注册了系统用户"+ req.getParameter("login_name");
//			userMangerService.saveLog(content,req);
		}

		return returnstr;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/getUserList.do")
	@ResponseBody
	public Map<String, Object> getUserList(HttpServletRequest req,
			HttpServletResponse resp) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));
		String loginName = req.getParameter("loginName");
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String type = req.getParameter("type");
		String deptid = req.getParameter("deptid");
		map.put("start_page", pageSize * limit);
		map.put("end_page", limit);
		if(loginName!=null&&loginName!=""){
			map.put("loginName", "%"+loginName+"%");
		}
		if(username!=null&&username!=""){
			
			map.put("username", "%"+username +"%");
		}
		map.put("sex", sex);
		map.put("type", type);
		map.put("deptid", deptid);
		Map<String, Object> mapMod = new HashMap<String, Object>();
		mapMod.put("userlist", userMangerService.getUserManager4Map(map));
		mapMod.put("total", userMangerService.getUserManagerCountMap(map));
		return mapMod;
	}

	/**
	 * 注销用户信息
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/logoutUser.do")
	public String logoutUser(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Long.parseLong(id));
		map.put("flag", 1);//0:正常1：注销
		userMangerService.logoutUserManager4Id(map);
		//添加日志表
//		String content =  "激活了系统用户，id为" + id;
//		userMangerService.saveLog(content,req);
		return "jsp/manage/usermanagerlist";
	}
	/**
	 * 激活
	 */
	@RequestMapping(value="/activationUser.do")
	public String activationUser(HttpServletRequest req,HttpServletResponse resp){
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Long.parseLong(id));
		map.put("flag", 0);//0:正常1：注销
		userMangerService.logoutUserManager4Id(map);
		// 添加日志表
//		String content =  "激活了系统用户，id为" + id;
//		userMangerService.saveLog(content,req);
		return "jsp/manage/usermanagerlist";		
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/deleteManageUser.do")
	public String deleteManageUser(HttpServletRequest req,HttpServletResponse resp){
		String id = req.getParameter("id");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", Long.parseLong(id));
//		map.put("flag", 0);//0:正常1：注销
		userMangerService.deleteUserManager4Id(map);
		// 添加日志表
//		String content =  "删除了系统用户，id为" + id;
//		userMangerService.saveLog(content,req);
		return "jsp/manage/usermanagerlist";		
	}
	/**
	 * 到修改或添加页面
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/toEditUser.do")
	public String toEditUser(HttpServletRequest req, HttpServletResponse resp) {
		String loginName = req.getParameter("loginName");
		if (loginName != null) {
			UserManager userManger = userMangerService
					.getUserManager4LoginName(loginName);
			req.setAttribute("userManager", userManger);
		} else {
			req.setAttribute("userManager", new UserManager());
		}
		List<Role> typeList = userMangerService.getUserType();
		List<Dept> deptList = userMangerService.getUserDept();
		req.setAttribute("typeList", typeList);
		req.setAttribute("deptList", deptList);
		return "jsp/manage/usermanagerEdit";
	}

	/**
	 * 修改用户信息
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/updateUser.do")
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		UserManager um = new UserManager();
		um.setId(Long.parseLong(req.getParameter("id")));
		um.setAddress(req.getParameter("address"));
		um.setBirthday(req.getParameter("birthday"));
		um.setCtime(new Date());
		um.setDeptid(req.getParameter("deptid"));
		um.setLogin_name(req.getParameter("login_name"));
		um.setMail(req.getParameter("mail"));
		um.setPhone(req.getParameter("phone"));
		um.setSex(Integer.parseInt(req.getParameter("sex")));
		um.setType(Integer.parseInt(req.getParameter("type")));
		um.setUsername(req.getParameter("username"));
		um.setJob(req.getParameter("job"));
		
		userMangerService.updateUser(um);
		req.setAttribute("userManager", um);
		// 添加日志表
//		String content =  "修改了用户信息，id为"+ req.getParameter("id");
//		userMangerService.saveLog(content,req);
//		return "jsps/user/usermanagerlist";
	}

	/**
	 * 获取用户列表
	 */
	@RequestMapping(value = "/getUserTypelist.do")
	@ResponseBody
	public Map<String, Object> getUserType(HttpServletRequest req,
			HttpServletResponse resp) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));
		map.put("start_page", pageSize * limit);
		map.put("end_page", limit);
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("roleList", userMangerService.getUserTypelist(map));
		rMap.put("total", userMangerService.getUserTypeCount(map));
		
		return rMap;
	}

	/**
	 * 角色添加。权限是按照角色来分配的，每个角色都有固定的权限，所以在 添加角色的时候默认给他分配权限，用户只要选择了角色，就拥有了角色 所拥有的权限
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/addRole.do")
	public String addRole(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException {
		int getNexId = userMangerService.getNextId();// 获取下一个roleid
		Role role = new Role();
		role.setId(getNexId);
		role.setRoleName(req.getParameter("roleName"));
		// 判断角色名是否重复
		List<Role> rolelist = userMangerService.roleNameIsExist(req
				.getParameter("roleName"));
		String returnMsg = "";
		if (rolelist.size() > 0) {
			role.setId(0);
			req.setAttribute("role", role);
			req.setAttribute("msg", rolelist.size());
			// 当rolename已存在时，返回到编辑页面，查询出functionlist
			List<Functions> functionlist = userMangerService
					.getFunctionforRoleList();
			req.setAttribute("functionlist", functionlist);
			returnMsg = "jsp/manage/roleEdit";
		} else {
			userMangerService.addRole(role);// 添加角色
			// 添加角色下的功能权限
			String functionCode = req.getParameter("functionCode");
			if(functionCode!=null){
				String[] code = functionCode.split(",");
				RolePermission rp = new RolePermission();
				for (int i = 0; i < code.length; i++) {
					rp.setRoleid(getNexId);
					rp.setFunctionCode(code[i]);
					userMangerService.addRolePermission(rp);
				}
			}
			// add log
//			String content = "添加了用户角色，id为"
//					+ getNexId + "。同时分配了相应的功能权限，功能代码为" + functionCode;
//			userMangerService.saveLog(content,req);
			returnMsg = "jsp/manage/rolelist";
		}

		return returnMsg;
	}

	/**
	 * 到编辑角色页面（获取员工对应角色的权限）
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/toEditRole.do")
	public void toEditRole(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		if (id != null && !id.equals("")) {// 修改页面
			Role role = userMangerService.toEditRole(id);
			req.setAttribute("role", role);
			List<RolePermission> permissionlist = userMangerService
					.getRolePermissionList(role.getId());
			String functionCode = "";
			for (int i = 0; i < permissionlist.size(); i++) {
				functionCode += permissionlist.get(i).getFunctionCode() + ",";
			}
			req.setAttribute("functionmenu", functionCode);
		}
		List<Functions> functionlist = userMangerService
				.getFunctionforRoleList();
		req.setAttribute("functionlist", functionlist);
//		return "jsps/user/roleEdit";
	}
	/**
	 * 到编辑员工权限页面（获取员工个人的权限）
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/toEditUserRole.do")
	public String toEditUserRole(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
//		if (id != null && !id.equals("")) {// 修改页面
//			Role role = userMangerService.toEditRole(id);
//			req.setAttribute("role", role);
//			List<RolePermission> permissionlist = userMangerService
//					.getRolePermissionList(role.getId());
//			String functionCode = "";
//			for (int i = 0; i < permissionlist.size(); i++) {
//				functionCode += permissionlist.get(i).getFunctionCode() + ",";
//			}
//			req.setAttribute("functionmenu", functionCode);
//		}
		UserManager userManger = userMangerService.getUserManager4id(id);
		List<Functions> functionlist = userMangerService.getFunctionforRoleList();
		req.setAttribute("id", userManger.getId());
		req.setAttribute("roleName", userManger.getUsername());
		req.setAttribute("functionlist", functionlist);
		req.setAttribute("functionmenu", userManger.getFunctionCodes());
		return "jsp/manage/roleEdit1";
	}
	/**
	 * 修改角色 判断当前修改的id和role那么是否同时相同，相同则是当前要修改的信息；若不是，则说明当前输入的角色名已存在；
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/updateRole")
	public String updateRole(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("functionCode"));
		Integer id = Integer.parseInt(req.getParameter("id"));
		String roleName = req.getParameter("roleName");
		Role role = new Role();
		role.setId(id);
		role.setRoleName(roleName);
		List<Role> rolelist = userMangerService.roleNameIsExist(req
				.getParameter("roleName"));
		boolean flag = true;
		String returnMsg = "";
		for (Role rlist : rolelist) {
			if (!rlist.getId().equals(id)
					&& rlist.getRoleName().equals(roleName)) {
				flag = false;
			}
		}

		if (!flag) {
			req.setAttribute("msg", rolelist.size());
			returnMsg = "jsp/manage/roleEdit";
		} else {
			userMangerService.updateRole(role);
			// 修改role的权限（1.删除原有的权限；2.重新插入现有权限）
			userMangerService.delRolePermissionList(id);
			String functionCode = req.getParameter("functionCode");
			if(functionCode!=null){
				String[] code = functionCode.split(",");
				RolePermission rp = new RolePermission();
				for (int i = 0; i < code.length; i++) {
					rp.setRoleid(id);
					rp.setFunctionCode(code[i]);
					userMangerService.addRolePermission(rp);
				}
			}
			
			// add log
//			String content = "修改了角色名，id为" + id + "。并修改了功能权限，功能代码为" + functionCode;
//			userMangerService.saveLog(content,req);
//			returnMsg = "jsps/user/rolelist";
		}
		return returnMsg;
	}
	//区别updateRole（修改角色权限），该功能为修改单个员工权限
	@RequestMapping(value = "/updateUserRole")
	public void updateUserRole(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		//String roleName = req.getParameter("roleName");
//		Role role = new Role();
//		role.setId(id);
//		role.setRoleName(roleName);
//		List<Role> rolelist = userMangerService.roleNameIsExist(req
//				.getParameter("roleName"));
//		boolean flag = true;
//		for (Role rlist : rolelist) {
//			if (!rlist.getId().equals(id)
//					&& rlist.getRoleName().equals(roleName)) {
//				flag = false;
//			}
//		}

//		if (!flag) {
//			req.setAttribute("msg", rolelist.size());
//			returnMsg = "jsps/user/roleEdit";
//		} else {
//			userMangerService.updateRole(role);
//			// 修改role的权限（1.删除原有的权限；2.重新插入现有权限）
//			userMangerService.delRolePermissionList(id);
			String functionCodes = req.getParameter("functionCode");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("functionCodes", functionCodes.substring(0, functionCodes.length()-1));
			userMangerService.updateFunctions(map);
//			userMangerService.updateFunction(functions);
//			if(functionCode!=null){
//				String[] code = functionCode.split(",");
//				RolePermission rp = new RolePermission();
//				for (int i = 0; i < code.length; i++) {
//					rp.setRoleid(id);
//					rp.setFunctionCode(code[i]);
//					userMangerService.addRolePermission(rp);
//				}
//			}
			// add log
//			String content = "修改了角色名，id为" + id + "。并修改了功能权限，功能代码为" + functionCodes;
//			userMangerService.saveLog(content,req);
//			returnMsg = "jsps/user/roleEdit1";
//		}
//		return returnMsg;
	}

	/**
	 * 获取系统功能列表
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/getFunctionList.do")
	@ResponseBody
	public Map<String, Object> getFunctionList(HttpServletRequest req,
			HttpServletResponse resp) {
		String functionCode = req.getParameter("functionCode");
		String functionName = req.getParameter("functionName");
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start_page", pageSize * limit);
		map.put("end_page", limit);
		if (functionCode != null && functionCode != "")
			map.put("functionCode", functionCode);
		if (functionName != null && functionName != "")
			map.put("functionName", "%" + functionName + "%");

		Map<String, Object> fMap = new HashMap<String, Object>();
		List<Functions> functionlist = userMangerService.getFunctionList(map);

		fMap.put("functionlist", functionlist);
		fMap.put("total", userMangerService.getFunctionCountList(map));
		return fMap;
	}

	/**
	 * 到编辑系统功能页面
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/toEditFunction.do")
	public String toEditFunction(HttpServletRequest req,
			HttpServletResponse resp) {
		String id = req.getParameter("id");
		if (id != null && !id.equals("")) {
			Functions functions = userMangerService
					.getFunctionForUpdate(Integer.parseInt(id));
			req.setAttribute("functions", functions);
		}

		List<Functions> functionList = userMangerService.getFunction();
		req.setAttribute("functionList", functionList);
		return "jsp/manage/functionEdit";
	}

	/**
	 * 添加系统功能
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/addFunction.do")
	public String addFunction(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String functionCode = "";
		if (code.equals("0")) {// 说明要添加一级菜单
			functionCode = userMangerService.getNextParentFunctionCode()
					.getFunctionCode();
		} else {// 获取某个父节点下的子节点
			String fcode = req.getParameter("functionCode");
			Functions function =userMangerService.getNextChildFunctionCode(fcode.substring(0, 4)+"%");
			if ( function== null) {
				functionCode = req.getParameter("functionCode").substring(0, 4)+ "01";
			} else {
				functionCode = "0"+function.getFunctionCode();
			}
		}

		String functionName = req.getParameter("functionName");
		String linkUrl = req.getParameter("linkUrl");
		Functions functions = new Functions();
		functions.setFunctionCode(functionCode);
		functions.setFunctionName(functionName);
		functions.setLinkUrl(linkUrl);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("functionName", functionName);
		List<Functions> functionlist = userMangerService
				.functionCodeIsExist(map);
		String returnMsg = "";
		if (functionlist!=null&&functionlist.size() > 0) {// function is exist
			functions.setFunctionCode("");
			functions.setFunctionName("");
			req.setAttribute("functions", functions);
			req.setAttribute("msg", functionlist.size());
			
			List<Functions> functionList = userMangerService.getFunction();
			req.setAttribute("functionList", functionList);
			returnMsg = "jsp/manage/functionEdit";
		} else {
			userMangerService.addFunction(functions);
//			String content = "添加了系统功能，名称为"+ functionName;
//			userMangerService.saveLog(content,req);
			returnMsg = "jsp/manage/functionlist";
		}
		return returnMsg;
	}

	/**
	 * 修改function
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/updateFunction.do")
	public String updateFunction(HttpServletRequest req,
			HttpServletResponse resp) {
		String id = req.getParameter("id");
		String code = req.getParameter("code");
		String functionName = req.getParameter("functionName");
		String linkUrl = req.getParameter("linkUrl");
		String oldcode = req.getParameter("oldcode");
		String functionCode = "";
		if(oldcode.substring(0, 2).equals(req.getParameter("functionCode").substring(0, 2))){
			functionCode = oldcode;
		}else{
			if(code.equals("0")){//如果要将当前功能改成以及菜单，获取下一个以00结尾的funcitonCode
				functionCode = userMangerService.getNextParentFunctionCode()
						.getFunctionCode();
			}else{
				String fcode = req.getParameter("functionCode");
				Functions function =userMangerService.getNextChildFunctionCode(fcode.substring(0, 4)+"%");
				if ( function== null) {
					functionCode = req.getParameter("functionCode").substring(0, 4)+ "01";
				} else {
					functionCode = "0"+function.getFunctionCode();
				}
			}
		}
		Functions functions = new Functions();
		functions.setId(Integer.parseInt(id));
		functions.setFunctionCode(functionCode);
		functions.setFunctionName(functionName);
		functions.setLinkUrl(linkUrl);
		userMangerService.updateFunction(functions);
		// add log
//		String content = "修改了系统功能，id为" + id;
//		userMangerService.saveLog(content,req);
		return "jsp/manage/functionlist";
	}

	/**
	 * 日志查询
	 */
	@RequestMapping(value = "/getlogList.do")
	@ResponseBody
	public Map<String, Object> logList(HttpServletRequest req,
			HttpServletResponse resp) {
		String operationContent = req.getParameter("operationContent");
		String createUser = req.getParameter("createUser");
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));

		Map<String, Object> logmap = new HashMap<String, Object>();
		logmap.put("start_page", pageSize * limit);
		logmap.put("end_page", limit);
		if (createUser != null && createUser != "")
			logmap.put("createUser", createUser);
		if (operationContent != null && operationContent != "")
			logmap.put("operationContent", "%" + operationContent + "%");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loglist", logService.logList(logmap));
		map.put("total", logService.logcountList(logmap));
		return map;
	}
	/**
	 * 重置密码
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/resetPassword.do")
	public String resetPassword(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		UserManager userManager = new UserManager();
		userManager.setId(Long.parseLong(id));
		userManager.setPass_word(Md5Util.getMd5("123456"));
		userMangerService.resetPassword(userManager);
		
		// add log
//		String content = "重置了密码，被重置密码的用户id为" + id;
//		userMangerService.saveLog(content,req);
				
		return "jsp/manage/usermanagerlist";
	}
	/**
	 * 修改密码
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/updatePassword.do")
	@ResponseBody
	public String updatePassword(HttpServletRequest req,
			HttpServletResponse resp) {
		UserManager userManager = new UserManager();
		String id = req.getParameter("id");
		String oldpass = req.getParameter("oldpass");
		String newpass = req.getParameter("newpass");
		String renewpass = req.getParameter("renewpass");
		String pass_word = req.getParameter("pass_word");
		String returnMsg = "";
		if (!Md5Util.getMd5(oldpass).equals(pass_word)) {
			returnMsg = "1";
		}
		if (!newpass.equals(renewpass)) {
			returnMsg = "2";
		}
		if (returnMsg.equals("")) {
			userManager.setPass_word(Md5Util.getMd5(newpass));
			userManager.setId(Long.parseLong(id));
			userMangerService.resetPassword(userManager);
			returnMsg = "3";
			// add log
//			String content = "修改了密码，被修改密码的用户id为" + id;
//			userMangerService.saveLog(content,req);
		}
		return returnMsg;

	}
	@RequestMapping(value="/getRolelist.do")
	@ResponseBody
    public  List<Role> getRolelist(HttpServletRequest req,HttpServletResponse resp){
	    List<Role> rolelist = userMangerService.getUserType();
	    req.setAttribute("rolelist", rolelist);
	    return rolelist;
    }   
	
	@RequestMapping(value="/getDeptlist.do")
	@ResponseBody
    public  List<Dept> getDeptlist(HttpServletRequest req,HttpServletResponse resp){
	    List<Dept> deptlist = userMangerService.getUserDept();
	    req.setAttribute("deptlist", deptlist);
	    return deptlist;
    }
	
	@RequestMapping(value="/getUserDeptList.do")
	@ResponseBody
    public  Map<String, Object> getUserDeptList(HttpServletRequest req,HttpServletResponse resp){
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start_page", pageSize * limit);
		map.put("end_page", limit);
		
		List<Dept> deptlist = userMangerService.getUserDeptlist(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("deptlist", deptlist);
		resultMap.put("total", userMangerService.getUserDeptCount(map));
	    return resultMap;
    }
	
	@RequestMapping(value="/getUserRoleList.do")
	@ResponseBody
    public Map<String, Object> getUserRoleList(HttpServletRequest req,HttpServletResponse resp){
		Integer pageSize = Integer.parseInt(req.getParameter("pageIndex"));
		Integer limit = Integer.parseInt(req.getParameter("limit"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start_page", pageSize * limit);
		map.put("end_page", limit);
		
		List<Role> rolelist = userMangerService.getUserTypelist(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rolelist", rolelist);
		resultMap.put("total", userMangerService.getUserTypeCount(map));
	    return resultMap;
    }
	
	@RequestMapping(value="/addUserDept.do")
	@ResponseBody
    public Map<String, Object> addUserDept(HttpServletRequest req,HttpServletResponse resp){
		String deptname = req.getParameter("deptname");
		int flag = userMangerService.deptnameExsit(deptname);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(flag > 0){
			resultMap.put("result", 2);//已存在
		}else{
			userMangerService.addDept(deptname);
			resultMap.put("result", 1);//插入成功
		}
	    return resultMap;
    }
	@RequestMapping(value="/deleteDept.do")
	@ResponseBody
    public Map<String, Object> deleteDept(HttpServletRequest req,HttpServletResponse resp){
		String ids = req.getParameter("ids");
		String[] id = ids.split(",");
		String usedDept = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for(int i=0;i<id.length;i++){
			int deptid = Integer.parseInt(id[i]);
			//manager_user表是否有人在使用该deptid，有的话不允许删除
			int flag = userMangerService.deptExsitManager_user(deptid);
			if(flag > 0){
				usedDept = usedDept + deptid +"   ";
			}else{
				userMangerService.delDept(deptid);
			}
		}
		if("".equals(usedDept)){
			resultMap.put("result", 1);//删除成功
		}else{
			resultMap.put("result", usedDept);
		}
	    return resultMap;
    }
	@RequestMapping(value="/addUserRole.do")
	@ResponseBody
    public Map<String, Object> addUserRole(HttpServletRequest req,HttpServletResponse resp){
		String rolename = req.getParameter("rolename");
		int flag = userMangerService.rolenameExsit(rolename);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(flag > 0){
			resultMap.put("result", 2);//已存在
		}else{
			userMangerService.addRoles(rolename);
			resultMap.put("result", 1);//插入成功
		}
	    return resultMap;
    }
	
	@RequestMapping(value="/deleteRole.do")
	@ResponseBody
    public Map<String, Object> deleteRole(HttpServletRequest req,HttpServletResponse resp){
		String ids = req.getParameter("ids");
		String[] id = ids.split(",");
		String usedRole = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for(int i=0;i<id.length;i++){
			int roleid = Integer.parseInt(id[i]);
			//manager_user表是否有人在使用该deptid，有的话不允许删除
			int flag = userMangerService.roleExsitManager_user(roleid);
			if(flag > 0){
				usedRole = usedRole + roleid +"   ";
			}else{
				userMangerService.delRole(roleid);
			}
		}
		if("".equals(usedRole)){
			resultMap.put("result", 1);//删除成功
		}else{
			resultMap.put("result", usedRole);
		}
	    return resultMap;
    }
}
