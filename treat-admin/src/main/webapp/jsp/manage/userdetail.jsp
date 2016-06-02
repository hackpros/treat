<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 详情页</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />   
   <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
 </head>
 
  <script type="text/javascript">
    function subEv(){
     	$('#id').val(1);
		$("#sub").attr("action","/getUser4Id.do");
		$("#sub").submit(); 
      }
  </script> 
 <body>
    <form id = "sub" name="sub" method="post"></form>
    <input id = "id" type="hidden">
  <div class="container">
    <div class="detail-page">
      <h2>个人信息</h2>
      <div class="detail-section">  
        <h3>基本信息</h3>
        <div class="row detail-row">
          <div class="span8">
            <label>登录名：</label><span class="detail-text">${userManager.login_name}</span>
          </div>
          <div class="span8">
            <label>姓名：</label><span class="detail-text">${userManager.username}</span>
          </div>
           <div class="span8">
            <label>性别：</label><span class="detail-text">${userManager.sex}</span>
          </div>
        </div>
        <div class="row detail-row">
          <div class="span8">
            <label>班级：</label><span class="detail-text">${userManager.company}</span>
          </div>
          <div class="span8">
            <label>年龄：</label><span class="detail-text">${userManager.age}</span>
          </div>
           <div class="span8">
            <label>家庭住址：</label><span class="detail-text">${userManager.address}</span>
          </div>
        </div>
      </div>
      <div class="detail-section"> 
        <h3>联系方式</h3>
        <div class="row detail-row">
          <div class="span8">
            <label>电话：</label><span class="detail-text">${userManager.phone}</span>
          </div>
          <div class="span8">
            <label>手机：</label><span class="detail-text">${userManager.moblie}</span>
          </div>
          <div class="span8">
            <label>email：</label><span class="detail-text">${userManager.mail}</span>
          </div>
        </div>
        <div class="row detail-row">
          <div class="span8">
            <label>账户类型：</label><span class="detail-text">
            <c:choose>
            <c:when test="${userManager.type==1}">管理员</c:when>
            <c:otherwise>普通用户</c:otherwise>
            </c:choose>
            </span>
          </div>
          <div class="span8">
            <label>创建时间：</label><span class="detail-text"><fmt:formatDate value="${userManager.ctime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
          </div>
        </div>
      </div> 
    </div>
  </div>

<body>
</html>  
