<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	 <head>
	 	<title>banner编辑</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	        <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
	    	<link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
	    	<link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
	   		<link href="${basePath}/bui/assets/css/prettify.css" rel="stylesheet" type="text/css" />
	   		<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
		    <style type="text/css">
			    code {
			      padding: 0px 4px;
			      color: #d14;
			      background-color: #f7f7f9;
			      border: 1px solid #e1e1e8;
			    }
		    </style>
		    <script type="text/javascript">
			    function updateBannerInfo(){
				    jQuery.post(
				    		'${basePath}/banner/updateBannerInfo.do',
				    		{id:$("#id").val(),
					    		 position:$("#position").val(),
					    		 send_url:$("#send_url").val(),
					    		 title:$("#title").val(),
				    		},
				    		function(data){
				    	    if(data == "ok"){
				    	    	alert("修改成功");
				    	    }else{
				    	    	alert("修改失败");
				    	    }
					});	
			    }
		    </script>
	 </head>
	 <body>
	  	 <div class="container">
		    <div class="row">
		      <form id="J_Form" class="form-horizontal span24" method="post" action="${basePath}/banner/updateBannerInfo.do">
		        <div class="row">
		        	<div class="hide">
						<div class="controls">
							<input name="id" id="id" type="text" class="input-normal control-text">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>位置：
						</label>
						<div class="controls">
							<select name="position" id="position" >
								<option value="1">banner</option>
				                <option value="2">广告</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
		          	<div class="control-group span12">
						<label class="control-label">
							<s>*</s>链接地址：
						</label>
						<div class="controls">
							<input name="send_url" id="send_url" type="text" class="input-large control-text">
						</div>
					</div>
		        </div>
		       	<div class="row">
		            <div class="control-group span15">
			            <label class="control-label">标题：</label>
			            <div class="controls control-row4">
			              <textarea name="title" id="title" class="input-large" type="text"></textarea>
			            </div>
		            </div>
		        </div>
		        <div class="row form-actions actions-bar">
		            <div class="span13 offset3 ">
		              <button type="button" class="button button-primary" onclick="updateBannerInfo()">保存</button>
		              <button type="reset" class="button">重置</button>
		            </div>
		        </div>
		      </form>
		      <%--大众点评数据--%>
		      <div id="dzdp" margin="20px">
			    
			  </div>
		    </div>
		    
		
		  </div>
		  
		  <script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
		  <script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
		  <script type="text/javascript" src="${basePath}/bui/assets/js/jquery.cityselect.js"></script>
		  <script type="text/javascript" src="${basePath}/bui/assets/js/prettify.js"></script>
		  <script type="text/javascript">
		    BUI.use('common/page');
		  </script>
		  <script type="text/javascript">
		    $(function () {
		      prettyPrint();
		    });
		  </script> 
		<script type="text/javascript">
		  BUI.use('bui/form',function (Form) {
		    var form = new Form.HForm({
		      srcNode : '#J_Form'
		    });
		
		    form.render();
		  });
		</script>
		<script type="text/javascript">
		    $(document).ready(function(e) {
		    	var id = "";
		    	if(${param.id}){
			    	id = ${param.id};
		    		$("#id").attr("value",id);
		    	}
		    	jQuery.post('${basePath}/banner/getBannerInfo.do',{id:id},function(data){
		    	     if(data){
		    	     	 $("#id").attr("value",data.id);
		    	    	 $("#position").attr("value",data.position);
		    	    	 $("#send_url").attr("value",data.send_url);
		    	    	 $("#title").attr("value",data.title);
			    	 }
				});
		    });
		</script>
	<body>
</html>
