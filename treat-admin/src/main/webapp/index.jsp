<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 掌航后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="${basePath}/bui/assets/css/main-min.css" rel="stylesheet" type="text/css" />
 </head>
	<style> 
		.white_content { 
		    display: none; 
		    position: absolute; 
		    top: 25%; 
		    left: 25%; 
		    width: 30%; 
		    height: 30%; 
		    padding: 20px; 
		    border: 5px solid orange; 
		    background-color: white; 
		    z-index:1002; 
		    overflow: auto; 
		} 
	</style>
<body>
  <div class="header">
	<div class="dl-title">
	    <span class="lp-title-port">掌航网络科技有限公司  </span><span class="dl-title-text">后台管理系统</span>
	</div>
	<div class="dl-log">欢迎您，<span class="dl-log-user">${userManager.login_name}</span>
	<a href = "javascript:void(0)" onclick = "showUPDiv()"><font color="red">修改密码</font></a>
	<a href="loginOut.do" title="退出系统" class="dl-log-quit">[退出]</a>
	<div id="fade" ></div> 
	</div>
  </div>
  
	<div class="content">
	   <div class="dl-main-nav">
			<ul id="J_Nav"  class="nav-list ks-clear">
			  <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">首页</div></li>
			</ul>
	   </div>
		<ul id="J_NavContent" class="dl-tab-conten"></ul>
	</div>
	<div id="light" class="white_content">
		<div align="right" style="margin-top:10px auto"><a href=#;  onclick="Lock_CheckForm(this);">[关闭]</a> &nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div class="container" style="width:450px;text-align:center">
			<div class="row">
				<div class="control-group span8">
					<div class="controls">
						<label class=""><font color="red">*</font>&nbsp;原&nbsp;密&nbsp;码：</label>
						<input type="password" name="oldpass" title="原密码"   maxlength="12" id="oldpass">
					</div>
				</div>
			</div><br>
			<div class="row">
				<div class="control-group span8">
					<div class="controls">
						<label class="control-label"><font color="red">*</font>&nbsp;新&nbsp;密&nbsp;码：</label>
						<input type="password" name="newpass" title="新密码"  maxlength="12" id="newpass" >
					</div>
				</div>
			</div><br>
			<div class="row">
				<div class="control-group span8">
					<div class="controls">
						<label class="control-label"><font color="red">*</font>重复密码：</label>
						<input type="password" name="renewpass" title="重复新密码" alt="notnull" maxlength="12"  id="renewpass">
					</div>
				</div>
			</div><br>
			<div class="row">
				<div class="control-group span8">
					<div class="controls">
						<input type="button"  value="确  定" class="button button-primary" onclick="checkInput();">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" 	value="重  置" class="button button-primary" onclick="clearInput();">
					</div>
				</div>
			</div>
		</div>
	</div> 
<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/bui.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/config.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/validate.js"></script>
<script>
	//登陆系统，获取功能菜单
      var config = BUI.use('common/main',function(){
       config = ${config};
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
    //显示修改密码div
 	function showUPDiv(){
 		document.getElementById('light').style.display='block';
 		document.getElementById('fade').style.display='block';
 		clearInput(); 
 	}
 	//提交修改密码申请
    function checkInput() {
		var oldpass = $("#oldpass").val();
		var newpass = $("#newpass").val(); 
		var renewpass = $("#renewpass").val();
		if(oldpass==""){
			alert("原密码不能为空，请输入！");
			return false;
		}
		if(newpass==""){
			alert("新密码不能为空，请输入！");
			return false;
		}
    	if(newpass.length<6){
    		alert("新密码长度不能小于6，请重新输入！");
    		return false;
    	}
		if(renewpass==""){
			alert("重复密码不能为空，请输入！");
			return false;
		}
		 
		$.ajax({
		   type: "POST",
		   url: "${basePath}/updatePassword.do",
		   data: "id=${userManager.id}&pass_word=${userManager.pass_word}&oldpass="+oldpass+"&newpass="+newpass+"&renewpass="+renewpass,
		   success: function(returnMsg){
				if(returnMsg=="1"){
					alert("原密码不正确，请重新输入！");
					return false;
				}
				if(returnMsg=="2"){
					alert("再次新密码不相同，请重新输入！");
					return false;
				}
				if(returnMsg== "3"){
					alert("密码修改成功，请退出重新重新登录！");
					window.location.href="loginOut.do";
				}
				
		   }
		});
	}
	//关闭修改密码div
	function   Lock_CheckForm(theForm){   
		$("#light").hide();
		return   false;   
	}
	//重置原密码和新密码的输入框
   function clearInput(){
   		$("input[name=oldpass]").val("");
		$("input[name=newpass]").val(""); 
		$("input[name=renewpass]").val("");
   } 
  </script>
 </body>
</html>
