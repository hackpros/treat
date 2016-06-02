<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	/* System.out.println("開始上傳圖片"); 
	String result = new ActionEnter( request, rootPath ).exec();
	System.out.println("返回：" + result); 
	out.write(result); */
	out.write( new ActionEnter( request, rootPath ).exec() ); 
	
%>