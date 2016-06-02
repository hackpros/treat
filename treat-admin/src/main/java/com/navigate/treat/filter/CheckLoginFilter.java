package com.navigate.treat.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.navigate.treat.po.basic.UserManager;
import com.navigate.treat.util.SessionUtil;

/**
 * @author hsp
 * @version 1.0.0
 * @version 创建时间：Nov 1, 2014 9:15:53 AM
 * 
 */
public class CheckLoginFilter implements Filter{

	private ApplicationContext context;
	public void init(FilterConfig config) throws ServletException {
		context = WebApplicationContextUtils.getWebApplicationContext(config
				.getServletContext());
	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;

		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(contextPath.length());

		/** 请求增加用户对象 * */
		UserManager user = SessionUtil.getUserManager(request);

		if (NEED_LOGIN_URI.contains(uri)) {
			if (user == null) {
				String path = request.getContextPath();
				response.getWriter().write(" <script>parent.location.href='"+path + "/login.jsp' </script>"); 
				response.getWriter().close();
				return;	
			}
		}
		try {
			chain.doFilter(srequest, sresponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public static List<String> NEED_LOGIN_URI = new ArrayList<String>();
	static {
		NEED_LOGIN_URI.add("/");
		
		NEED_LOGIN_URI.add("/index.jsp"); // 显示用户信息
		NEED_LOGIN_URI.add("/jsps/user/userdetail.jsp"); // 显示会员主页
		NEED_LOGIN_URI.add("/jsps/user/usermanagerlist.jsp");
		NEED_LOGIN_URI.add("/jsps/user/usermanagerEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/user/functionEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/user/functionlist.jsp");
		NEED_LOGIN_URI.add("/jsps/user/passwordEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/user/register.jsp");
		NEED_LOGIN_URI.add("/jsps/user/roleEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/user/roleEdit1.jsp");
		NEED_LOGIN_URI.add("/jsps/user/rolelist.jsp");
		
		NEED_LOGIN_URI.add("/jsps/data/activity_comment_kf.jsp");
		NEED_LOGIN_URI.add("/jsps/data/activity_comment_kf1.jsp");
		NEED_LOGIN_URI.add("/jsps/data/activity_invitation.jsp");
		NEED_LOGIN_URI.add("/jsps/data/activity_report.jsp");
		NEED_LOGIN_URI.add("/jsps/data/activity_status.jsp");
		NEED_LOGIN_URI.add("/jsps/data/all_stauts.jsp");
		NEED_LOGIN_URI.add("/jsps/data/all_stauts_detail.jsp");
		NEED_LOGIN_URI.add("/jsps/data/audit4data_report.jsp");
		NEED_LOGIN_URI.add("/jsps/data/audit4manage_subject.jsp");
		NEED_LOGIN_URI.add("/jsps/data/audit4sub_comment.jsp");
		NEED_LOGIN_URI.add("/jsps/data/audit4user_activity.jsp");
		NEED_LOGIN_URI.add("/jsps/data/audit4user_commentary.jsp");
		NEED_LOGIN_URI.add("/jsps/data/commoditylist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/customer_service.jsp");
		NEED_LOGIN_URI.add("/jsps/data/customer_service2.jsp");
		NEED_LOGIN_URI.add("/jsps/data/customer_service3.jsp");
		NEED_LOGIN_URI.add("/jsps/data/data_report.jsp");
		NEED_LOGIN_URI.add("/jsps/data/giftlist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/loginStatistic.jsp");
		NEED_LOGIN_URI.add("/jsps/data/loglist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/manage_subject.jsp");
		NEED_LOGIN_URI.add("/jsps/data/manager_config.jsp");
		NEED_LOGIN_URI.add("/jsps/data/pay_status.jsp");
		NEED_LOGIN_URI.add("/jsps/data/recharge.jsp");
		NEED_LOGIN_URI.add("/jsps/data/schollData.jsp");
		NEED_LOGIN_URI.add("/jsps/data/send_message.jsp");
		NEED_LOGIN_URI.add("/jsps/data/sensitiveWordsEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/data/sensitiveWordslist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/sub_comment.jsp");
		NEED_LOGIN_URI.add("/jsps/data/subject_comment_kf.jsp");
		NEED_LOGIN_URI.add("/jsps/data/subject_comment_kf1.jsp");
		NEED_LOGIN_URI.add("/jsps/data/subject_photo.jsp");
		NEED_LOGIN_URI.add("/jsps/data/subject_set_top.jsp");
		NEED_LOGIN_URI.add("/jsps/data/subjectCount.jsp");
		NEED_LOGIN_URI.add("/jsps/data/uploadPic.jsp");
		NEED_LOGIN_URI.add("/jsps/data/user_activity.jsp");
		NEED_LOGIN_URI.add("/jsps/data/user_commentary.jsp");
		NEED_LOGIN_URI.add("/jsps/data/user_photo.jsp");
		NEED_LOGIN_URI.add("/jsps/data/user_suggestion.jsp");
		NEED_LOGIN_URI.add("/jsps/data/userResourcedatalist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/userResourcelist.jsp");
		NEED_LOGIN_URI.add("/jsps/data/userResourceEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/data/usersActivityCount.jsp");
		NEED_LOGIN_URI.add("/jsps/data/usersCount.jsp");

		
		NEED_LOGIN_URI.add("/jsps/activity/activityBennerlist.jsp");
		NEED_LOGIN_URI.add("/jsps/activity/activityBennerEdit.jsp");
		
		NEED_LOGIN_URI.add("/jsps/invitation/hb_invitation.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/hb_withdraw.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/hb_users.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/hb_invitation1.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/hb_invitation2.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_invitation.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_invitation1.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_invitation2.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_invitation_count.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_invitation_download_count.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_users.jsp");
		NEED_LOGIN_URI.add("/jsps/invitation/jj_withdraw.jsp");
		
		
		NEED_LOGIN_URI.add("/jsps/channel/activityCommentaryTaskSet.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/all_stauts.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/appDownloadCount.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/appDownloadCount1.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/appDownloadEdit.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/appDownloadList.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/appVersionList.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/editKefuActivity.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/infoImport.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/kefuActivity.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/kefuChatList.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/kefudetail.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/kefulist.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/kefuphoto1.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/schedule4kefuActivity.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/schedule4kefuActivityComment.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/schedule4kefuSubject.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/schedule4kefuSubjectComment.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/swapKefuPhoto.jsp");
		NEED_LOGIN_URI.add("/jsps/channel/topic_push.jsp");
		
		NEED_LOGIN_URI.add("/jsps/develop/cache_manage.jsp");
	}

}
