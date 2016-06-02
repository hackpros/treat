<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 系统功能编辑</title>
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
     <input name="id" type="hidden" value="${functions.id}">
     <input name="oldcode" type="hidden" value="${functions.functionCode }">
      <h3>基本信息</h3>
      <div class="row">
      	  <div class="control-group span12">
      	   <label class="control-label"><s>*</s>功能编码：</label>
	          <div class="controls">
<!-- 				<input name="functionCode" type="text" value="${functions.functionCode}" title="功能代码" alt="notnull;number(6);"> -->
						<select name="code" onchange="showfcSpan(this.value)" id="code">
							<option value="0">一级菜单</option>
							<option value="1">二级菜单</option>
						</select>
					
					<span id="fcSpan" style="display:none">
						<select name="functionCode" value="${functions.functionCode }" id="functioncode">
							 <c:forEach var="list" items="${functionList }">
							 		<option value="${list.functionCode }">${list.functionName }</option>
							 </c:forEach>
						</select>
						<input  type="hidden" name="functionCodehid" value="${functions.functionCode }" >
					</span>
	          </div>
        </div>
        <div class="control-group span12">
	          <label class="control-label"><s>*</s>功能名称：</label>
	          <div class="controls">
				 	<input name="functionName" type="text" value="${functions.functionName}" title="功能名称" alt="notnull;" maxlength="35">
	          </div>
        </div>
       </div>
       <div class="row">
        <div class="control-group span24">
          <label class="control-label"><div id="divLinkUrl">连接地址：</div></label>
          <div class="controls">
            <input name="linkUrl" type="text" value="${functions.linkUrl}" title="连接地址" alt="" maxlength="100" style="width:500px;"><br>
            <font color = "red">注：连接地址直接关联管理系统的页面，请认真填写！（例：user/userlist.jsp）</font>
          </div>
        </div>
        
      </div>
      <div class="row">
        <div class="form-actions offset3">
          <button type="button" class="button button-primary" onclick="checkInput();">保存</button>
          <button type="reset" class="button button-primary">重置</button>
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
		var checkLinkurl = /^[^\u4e00-\u9fa5]{0,}$/; 
    	var linkurl = $("input[name=linkUrl]").val();
    	if(!checkLinkurl.test(linkurl)){
    		alert("连接地址不能输入中文，请重新输入！");
    		return false;
    	}
    	 
		if("${functions.id}"==""){
			document.submitForm.action = "${basePath}/addFunction.do";   
		}else{
			document.submitForm.action = "${basePath}/updateFunction.do";   
		}
		 document.submitForm.submit();
		 $("#but").attr("disabled","disabled");
	}
	$(function(){
		if("${msg}"!=""){
			alert("该功能已存在");
		}
	});
	
	function showfcSpan(obj){
		if(obj == "0"){
			$("#fcSpan").hide();
			$("#divLinkUrl").html("连接地址：");
			$("input[name=linkUrl]").attr("alt","");
		}else{
			$("#fcSpan").show();
			$("#divLinkUrl").html("<s>*</s>连接地址：");
			$("input[name=linkUrl]").attr("alt","notnull");
		}
	}
	
	$(function(){//该函数是为刚进入修改页面而写的，当code=”00“为父节点时不显示一级菜单列表；当code为子节点时，默认选择当前节点是二级菜单，显示当前节点的父节点
		var functioncode = "${functions.functionCode }";
		if(functioncode!=""){
			if(functioncode.substring(4, 6)=="00"){
				showfcSpan(0);
				jQuery("#code").val(0);
			}else{
				showfcSpan(1);
				jQuery("#code").val(1);
				jQuery("#functioncode").val(functioncode.substring(0, 4)+"00");
				
			}
			
		}
	});
  </script>
<body>
</html>  