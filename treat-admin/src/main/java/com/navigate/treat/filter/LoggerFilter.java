package com.navigate.treat.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.navigate.treat.util.IpUtil;


public class LoggerFilter implements Filter {

	private ApplicationContext context=null;
//	private static final Logger logger =  LogManager.getLogger("accessLog");
	private static final Logger logger =  LogManager.getLogger(LoggerFilter.class.getName());
	public void init(FilterConfig config) throws ServletException {
		context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
	}
	

	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		
		String accessUrl=request.getRequestURL().toString();
		String fromIp=IpUtil.getIp(request);
		String fromUrl = request.getHeader("referer")==null?"":request.getHeader("referer");
		String[] ipinfo=IpUtil.search(fromIp);
		String country=ipinfo[4];
		String province=ipinfo[5];
		String city=ipinfo[6];
		String area=ipinfo[7];
		String company=ipinfo[8];
		String accessType=request.getHeader("user-agent")==null?"" :request.getHeader("user-agent");
		String userid="";
		
		Cookie[] cookies=request.getCookies(); 
		String cookievalue="";
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("")){
					cookievalue=cookie.getValue();
					break;
				};
			}
		}
		if(!"".equals(cookievalue)){
		}
		
		String loginfo=userid+"|"+fromIp+"|"+country+"|"+province+"|"+city+"|"+area+"|"+company+"|"+accessUrl+"|"+fromUrl+"|"+accessType+"|"+buildOriginalURL(request);
		
		logger.info(loginfo);
		
		chain.doFilter(srequest, sresponse);
		
	}
	
	private String buildOriginalURL(HttpServletRequest request) {
        StringBuffer originalURL = request.getRequestURL();
        Map parameters = request.getParameterMap();
        if (parameters != null && parameters.size() > 0) {
            originalURL.append("?");
            for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
                String key = (String) iter.next();
                String[] values = (String[]) parameters.get(key);
                for (int i = 0; i < values.length; i++) {
                    originalURL.append(key).append("=").append(values[i]).append("&");
                }
            }
        }
        return originalURL.toString();
    }




	public void destroy() {

	}


}
