<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 修改密码编辑</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
   <link href="${basePath}/bui/assets/css/prettify.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
 </head>
 <body>
  
  <div class="container">
    <form id ="J_Form" class="form-horizontal" name="submitForm">
     <input name="id" type="hidden" value="${userManager.id}">
     <input name="pass_word" type="hidden" value="${userManager.pass_word}">
      <h3>基本信息</h3>
      <div class="row">
      	  <div class="control-group span12">
      	   <label class="control-label"><s>*</s>部门：</label>
	          <div class="controls">
				<select name="deptid"  value="${userManager.deptid}">
					<c:forEach var='dept' items="${deptList}">
						<option value='${dept.id}'>${dept.deptname}</option>
					</c:forEach>
	            </select>
	          </div>
        </div>
        <div class="control-group span12">
	          <label class="control-label"><s>*</s>用户类型：</label>
	          <div class="controls">
				<select name="type"  value="${userManager.type}">
					<c:forEach var='userType' items='${typeList}'>
						<option value='${userType.id}'>${userType.roleName}</option>
					</c:forEach>
	            </select>
	          </div>
        </div>
       </div>
       <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>登录名：</label>
          <div class="controls">
          	<c:if test="${userManager.login_name==null }">
            	<input name="login_name" type="text" value="${userManager.login_name}" title="登陆名" alt="notnull;" maxlength="25">
            </c:if>
            <c:if test="${userManager.login_name!=null}">
            	<input name="login_name" type="text" value="${userManager.login_name}" readonly = "readonly">
            </c:if>
          </div>
        </div>
        <div class="control-group span12">
	          <div class="controls">
				<label class="control-label"><s>*</s>密码：</label>
				<c:if test="${userManager.pass_word==null }">
				<input name="pass_word" type="password" maxlength="12" title="密码" alt="notnull;" >
				</c:if>
	          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>性别：</label>
          <div class="controls">
            <select name="sex" value="${userManager.sex}">
              <option value="0">男</option>
              <option value="1">女</option>
            </select>
          </div>
        </div>
        <div class="control-group12 span12">
          <label class="control-label"><s>*</s>真实姓名：</label>
          <div class="controls">
            	<input name="username" value="${userManager.username}" type="text"  title="真实姓名" alt="notnull;length<=30;">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>出生日期：</label>
          <div class="controls">
            <input name="birthday" value="${userManager.birthday}"  type="text"  title="出生日期" alt="notnull;"  class="calendar" style="width:140px;" >
          </div>
        </div>
       
      </div>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label"><s>*</s>职务：</label>
          <div class="controls">
            <input name="job" value="${userManager.job}"  type="text"  title="职务" alt="notnull" maxlength="25">
          </div>
        </div>
      </div>
      <hr/>
      <h3>联系方式</h3>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label"><s>*</s>联系方式：</label>
          <div class="controls">
            <input name="phone" value="${userManager.phone}" type="text"  title="联系方式" alt="notnull;dhhm;">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label">邮箱：</label>
          <div class="controls">
            <input name = "mail" value="${userManager.mail}" type="text" title="邮箱"  maxlength="25" >
          </div>
        </div>
        
      </div>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label">家庭住址：</label>
          <div class="controls control-row4">
            <input type="text"  name="address" value="${userManager.address}" class="span12 span-width" title="家庭地址" alt="length<=100;" maxlength="100">
          </div>
        </div>
      </div>
      <hr/>
      <div class="row">
        <div class="form-actions offset3">
          <button type="button" class="button button-primary" onclick="checkInput();">保存</button>
          <button type="button" class="button button-primary">重置</button>
        </div>
      </div>
    </form>

  </div>
  <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/validate.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
  </script>
  <script type="text/javascript">
    BUI.use('bui/form',function (Form) {
      var form = new Form.HForm({
        srcNode : '#J_Form'
      }).render();
    });
    
    function checkInput() {
    	
		var err = checkForm(document.forms[0]);
		if (!err) {
			return;
		}
		var checkLoginName = /^[^\u4e00-\u9fa5]{0,}$/; 
    	var loginName = $("input[name=login_name]").val();
    	if(!checkLoginName.test(loginName)){
    		alert("登陆名不能输入中文，请重新输入！");
    		return false;
    	}
    	var checkMail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		var mail = $("input[name=mail]").val();
		if(mail!=""&&!checkMail.test(mail)){
			alert("邮箱格式不正确，请重新输入！");
			return false;
		}
    
		if("${userManager.id}"==""){
			document.submitForm.action = "${basePath}/register.do";   
		}else{
			document.submitForm.action = "${basePath}/updateUser.do";   
		}
		 document.submitForm.submit();
	}
	 
  </script>

<body>
</html>  