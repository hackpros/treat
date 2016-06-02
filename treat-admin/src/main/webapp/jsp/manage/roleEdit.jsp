<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 角色信息编辑</title>
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
     <input name="id" type="hidden" value="${role.id}">
      <h3>基本信息</h3>
      <div class="row">
      	  <div class="control-group span12">
      	   	  <label class="control-label"><s>*</s>角色名称：</label>
	          <div class="controls">
					<input name="roleName" type="text" value="${role.roleName}" title="角色名称" alt="notnull;" maxlength="35">
					<input type="hidden" name="functionCode" >
	          </div>
        </div>
        <div class="control-group span18">
      	      <label class="control-label"><s>*</s>功能菜单：</label>
		          <div class="controls">
					<c:forEach var="functionlist" items="${functionlist }">
							<c:if test="${functionlist.functionCoder2=='00' }">
								<br><input type="checkbox" value="${functionlist.functionCode }" onclick="checkedCode('${functionlist.functionCode}','${functionlist.functionCodel4 }')" 
									name="${functionlist.functionCode}">
								<span class="label-info" style="color: blue;"><b>${functionlist.functionName }</b></span><br>
							</c:if>
							<c:if test="${functionlist.functionCoder2!='00' }">
								&nbsp;&nbsp;
								<input type="checkbox" value="${functionlist.functionCode }" name="${functionlist.functionCodel4 }" onclick="checkedPCode('${functionlist.functionCodel4 }')">
								${functionlist.functionName }&nbsp;&nbsp;
							</c:if>
					</c:forEach>
		           </div>
        </div>
       </div>
      <div class="row">
        <div class="form-actions offset3">
          <button type="button" class="button button-primary" onclick="checkInput();" id="but">保存</button>
          <button type="reset" class="button button-primary" id="resetbut">重置</button>
        </div>
      </div>
    </form>

  </div>
  <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/validate.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
  </script>
  <script type="text/javascript">
    BUI.use('bui/form',function (Form) {
      var form = new Form.HForm({
        srcNode : '#J_Form'
      }).render();
    });
    //提交
    function checkInput() {
    	
		var err = checkForm(document.forms[0]);
		if (!err) {
			return;
		}
		var functionCode="";
    	 $("input[type= 'checkbox']:checked").each(function(){
    	 	 functionCode+=$(this).val()+",";
    	 });
    	 $("input[name=functionCode]").val(functionCode);
    	 
    	 if($("input[name=functionCode]").val()==""){
    	 	alert("请在功能菜单中选中该角色拥有的功能！");
    	 	return false;
    	 }
		if("${role.id}"==0){
			document.submitForm.action = "${basePath}/addRole.do";   
		}else{
			document.submitForm.action = "${basePath}/updateRole.do";   
		}
		document.submitForm.submit();
		$("#but").attr("disabled","disabled");//防止操作者多次点击按钮照成重复提交
	}
	
	$(function(){
		if("${msg}"!=""){
			alert("该角色已存在！");
		}
		
	});
	
	function checkedCode(functionCode,functionCodel4){//全选与反选
		 $("input[name='"+functionCode+"']").click(function() {
              $("input[name='"+functionCodel4+"']").attr("checked",this.checked);
          });
         /* var $subBox = $("input[name='"+functionCodel4+"']");
          $subBox.click(function(){
               $("input[name='"+functionCode+"']").attr("checked",$subBox.length == $("input[name='"+functionCodel4+"']:checked").length ? true : false);
          });*/
	}
	//当子菜单有选中的，那么主菜单也要选中。当主菜单下没有选中的子菜单时，主菜单也不勾选 
	function checkedPCode(functionCodel4){
		$("input[name='"+functionCodel4+"']").click(function() {
			if($("input[name='"+functionCodel4+"']:checked").length>0){
			 	$("input[name='"+functionCodel4+"00']").attr("checked",true);
			}else{ 
				$("input[name='"+functionCodel4+"00']").attr("checked",false);
			}
		});
	} 
	//修改时，默认选中
	$(function (){
		var functionmenu = "${functionmenu}";
		if(functionmenu!=""){
			$("input[type= 'checkbox']").each(function(){
	    	 	  if(functionmenu.indexOf($(this).val())>=0){
					$("input[type= 'checkbox'][value='"+$(this).val()+"']").attr("checked",true);
	    	 	  }
	    	 });
		}
		
		var id = "${role.id}";
		if(id!=""){
			$("#resetbut").attr("disabled","disabled");
		}
	});
  </script>

<body>
</html>  