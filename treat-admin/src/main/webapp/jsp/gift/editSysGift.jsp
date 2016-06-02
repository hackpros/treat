<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	 <head>
	 	<title>编辑系统礼物</title>
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
				    		'${basePath}/gift/updateSysGiftInfo.do',
				    		{id:$("#id").val(),
				    		 bizId:$("#bizId").val(),
				    		 bizName:$("#bizName").val(),
				    		 name:$("#name").val(),
				    		 type:$("#type").val(),
				    		 category:$("#category").val(),
				    		 useWay:$("#useWay").val(),
				    		 amount:$("#amount").val(),
				    		 exchangeCode:$("#exchangeCode").val(),
				    		 businessCode:$("#businessCode").val(),
				    		 period:$("#period").val(),
				    		 descript:$("#descript").val(),
				    		 startTime:$("#startTime").val(),
				    		 endTime:$("#endTime").val(),
				    		 bizImage:$("#bizImage").val(),
				    		},
				    		function(data){
				    	    if(data == "ok"){
				    	    	alert("修改成功");
				    	    }else{
				    	    	alert("修改失败");
				    	    }
					});	
			    }
			    
			    function getGiftInfo(id){
					var id = $("#bizId").val();
					jQuery.post('${basePath}/gift/getGiftInfo.do',{id:id},function(data){
			    	     if(data){
			    	     	$("#bizName").attr("value",data.name);
			    	     	$("#bizImage").attr("value",data.imageUrl);
			    	     	$("#bizImageUrl").attr("src",data.imageUrl);
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
							<s>*</s>商品id：
						</label>
						<div class="controls">
							<input name="bizId" id="bizId" type="text" class="input-normal control-text"  onchange="getGiftInfo()"> 
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>礼物名称：
						</label>
						<div class="controls">
							<input name="bizName" id="bizName" type="text" readonly="readonly" class="input-normal control-text">
						</div>
					</div>
		        </div>
		        <div class="row">
		          	<div class="control-group span8">
						<label class="control-label">
							<s>*</s>活动类别：</label>
						<div class="controls">
							<select name="type" id="type" class="input-normal"> 
				                <option value="1">系统</option>
				                <option value="2">推广</option>
				                <option value="3">运营</option>
				            </select>
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>赠送类型：
						</label>
						<div class="controls">
							<select name="category" id="category" class="input-normal"> 
				                <option value="gift">礼物</option>
				                <option value="allure">魅力值</option>
				            </select>
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>使用方式：
						</label>
						<div class="controls">
							<select name="useWay" id="useWay" class="input-normal"> 
				                <option value="1">不限</option>
				                <option value="2">自用</option>
				                <option value="3">转送</option>
				            </select>
						</div>
					</div>
		        </div>
		       	<div class="row">
		       		<div class="control-group span8">
						<label class="control-label">
							<s>*</s>数量：
						</label>
						<div class="controls">
							<input name="amount" id="amount" type="text" class="input-normal control-text">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>兑换码：
						</label>
						<div class="controls">
							<input name="exchangeCode" id="exchangeCode" type="text" class="input-normal control-text">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>业务范围：
						</label>
						<div class="controls">
							<select name="businessCode" id="businessCode" class="input-normal"> 
				                <option value="reg">注册</option>
				                <option value="invite">邀请</option>
				                <option value="beinvite">被邀请</option>
				                <option value="firstlogin">每日登陆</option>
				                <option value="procure">奖励码</option>
				            </select>
						</div>
					</div>
		        </div>
		       	<div class="row">
		       		<div class="control-group span8">
						<label class="control-label">
							<s>*</s>使用期限：
						</label>
						<div class="controls">
							<input name="period" id="period" type="text" class="input-normal control-text">天
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>起始时间：
						</label>
						<div class="controls">
							<input name="startTime" id="startTime" type="text" class="calendar" readonly="readonly">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>截止时间：
						</label>
						<div class="controls">
							<input name="endTime" id="endTime" type="text" class="calendar" readonly="readonly">
						</div>
					</div>
		        </div>
		       	<div class="row">
		            <div class="control-group span15">
			            <label class="control-label">描述：</label>
			            <div class="controls control-row4">
			              <textarea name="descript" id="descript" class="input-large" type="text"></textarea>
			            </div>
		            </div>
		            <div class="control-group span15">
			            <label class="control-label">图片：</label>
			            <div class="controls control-row4">
			              <textarea name="bizImage" id="bizImage" class="input-large" type="text" style="display:none"></textarea>
			            </div>
			            <img name="bizImageUrl" id="bizImageUrl" src='' style='max-height:100px;'>
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
		    	jQuery.post('${basePath}/gift/getSysGiftInfo.do',{id:id},function(data){
		    	     if(data){
		    	     	 $("#id").attr("value",data.id);
		    	     	 $("#bizId").attr("value",data.bizId);
		    	     	 $("#bizName").attr("value",data.bizName);
		    	     	 $("#name").attr("value",data.name);
		    	     	 $("#type").attr("value",data.type);
		    	    	 $("#category").attr("value",data.category);
		    	    	 $("#useWay").attr("value",data.useWay);
		    	    	 $("#amount").attr("value",data.amount);
		    	    	 $("#exchangeCode").attr("value",data.exchangeCode);
		    	    	 $("#businessCode").attr("value",data.businessCode);
		    	    	 $("#period").attr("value",data.period);
		    	    	 $("#descript").attr("value",data.descript);
		    	    	 $("#startTime").attr("value",BUI.Grid.Format.dateRenderer(data.startTime));
		    	    	 $("#endTime").attr("value",BUI.Grid.Format.dateRenderer(data.endTime));
		    	    	 $("#bizImage").attr("value",data.bizImage);
		    	    	 $("#bizImageUrl").attr("src",data.bizImage);
			    	 }
				});
		    });
		</script>
	<body>
</html>
