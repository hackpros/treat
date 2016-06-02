<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	 <head>
	 	<title>礼物编辑</title>
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
			    function updateGiftInfo(){
				    jQuery.post(
				    		'${basePath}/gift/updateGiftInfo.do',
				    		{id:$("#id").val(),
				    		 name:$("#name").val(),
				    		 category:$("#category").val(),
				    		 description:$("#description").val(),
				    		 price:$("#price").val(),
				    		 status:$("#status").val(),
				    		 newGift:$("#newGift").val(),
				    		 hotGift:$("#hotGift").val(),
				    		 unit:$("#unit").val(),
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
		      <form id="J_Form" class="form-horizontal span24" method="post" action="${basePath}/gift/updateGiftInfo.do">
		        <div class="row">
		        	<div class="hide">
						<div class="controls">
							<input name="id" id="id" type="text" class="input-normal control-text">
						</div>
					</div>
		          	<div class="control-group span8">
						<label class="control-label">
							<s>*</s>礼物名称：
						</label>
						<div class="controls">
							<input name="name" id="name" type="text" class="input-normal control-text">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>单位：
						</label>
						<div class="controls">
							<input name="unit" id="unit" type="text" class="input-normal control-text">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>价格：
						</label>
						<div class="controls">
							<input name="price" id="price" type="text" class="input-normal control-text">
						</div>
					</div>
		          	<!-- <div class="control-group span8">
						<label class="control-label">
							<s>*</s>上架状态：</label>
						<div class="controls">
							<select name="status" id="status" class="input-normal"> 
				                <option value="0">未上架</option>
				                <option value="1">上架中</option>
				                <option value="2">已下架</option>
				            </select>
						</div>
					</div> -->
		        </div>
		        <div class="row">
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>类型：
						</label>
						<div class="controls">
							<select name="category" id="category" class="input-normal"> 
				                <option value="1">饮料</option>
				                <option value="2">酒水</option>
				                <option value="3">日用</option>
				                <option value="4">零食</option>
				                <option value="5">特殊</option>
				                <option value="9">系统</option>
				            </select>
						</div>
					</div>
		          	<div class="control-group span8">
						<label class="control-label">
							<s>*</s>是否热门：
						</label>
						<div class="controls">
							<select name="hotGift" id="hotGift" class="input-normal"> 
				                <option value="0">否</option>
				                <option value="1">是</option>
				            </select>
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>是否新品：</label>
						<div class="controls">
							<select name="newGift" id="newGift" class="input-normal"> 
				                <option value="0">否</option>
				                <option value="1">是</option>
				            </select>
						</div>
					</div>
		        </div>
		       	<div class="row">
		            <div class="control-group span15">
			            <label class="control-label">描述：</label>
			            <div class="controls control-row4">
			              <textarea name="description" id="description" class="input-large" type="text"></textarea>
			            </div>
		            </div>
		        </div>
		        <div class="row form-actions actions-bar">
		            <div class="span13 offset3 ">
		              <button type="button" class="button button-primary" onclick="updateGiftInfo()">保存</button>
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
		    	jQuery.post('${basePath}/gift/getGiftInfo.do',{id:id},function(data){
		    	     if(data){
		    	     	 $("#id").attr("value",data.id);
		    	    	 $("#name").attr("value",data.name);
		    	    	 $("#category").attr("value",data.category);
		    	    	 $("#description").attr("value",data.description);
		    	    	 $("#price").attr("value",data.price);
		    	    	 $("#status").attr("value",data.status);
		    	    	 if(data.newGift == true){
		    	    	 	$("#newGift").attr("value",1);
		    	    	 }else if(data.newGift == false){
		    	    	 	$("#newGift").attr("value",0);
		    	    	 }
		    	    	 if(data.hotGift == true){
		    	    	 	$("#hotGift").attr("value",1);
		    	    	 }else if(data.newGift == false){
		    	    	 	$("#hotGift").attr("value",0);
		    	    	 }
		    	    	 $("#unit").attr("value",BUI.Grid.Format.dateRenderer(data.unit));
			    	 }
				});
		    });
		</script>
	<body>
</html>
