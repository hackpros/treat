<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>线下约会</title>
		<link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet">
		<link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet">
	     <style type="text/css">
			.tr-height {
			height:40px;
			}
			.td-right{
			text-align: right;
			}
			.td-left{
			text-align: left;
			}
		 </style>
		 <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
		 <script type="text/javascript" src="${basePath}/bui/assets/js/jquery.cityselect.js"></script>
		 <script type="text/javascript">
		 <%-- 
		 	$(document).ready(function(e) {
				jQuery.post('${basePath}/user/getNotAuditedCount4activity.do',function(data){
			    	 if(data){
				    	 $("#notAuditedCount").attr('value',data.notAuditedCount);
			    	 }
				});
			});
			$(function(){
				$(".selectCity").citySelect({
			    	prov:"请选择",
			    	city:"请选择"
				});
			});
		 --%>
		 </script>
		 <script language="javascript"> 
			 setInterval(fetchData,500);
			
			function fetchData(){
				var offsetX=20-$("#grid").offset().left; 
				var offsetY=20-$("#grid").offset().top; 
				var size=8*$('#grid a img').width(); 
				
				$("#grid span a").mouseover(function(event) { 
					var $target=$(event.target); 
					if($target.is('img')) 
					{ 
						$("<img id='tip' src='"+$target.attr("src")+"'>").css({ 
							"height":size, 
							"width":size, 
							"left":event.pageX+offsetX, 
							"top":event.pageY-size, 
						}).appendTo($("#grid")); 
					} 
				}).mouseout(function() { 
					$("#tip").remove(); 
				}); 
			}
		</script> 
		<style type="text/css"> 
			img{ height:auto; width:auto; position:absolute; border:0px;} 
			#grid span a{ position:relative; height:60px; width:60px; list-style:none; float:left; margin:0px; border:0px solid;} 
		</style>
    </head>
    <body>
    <div class="demo-content">
    <div class="row">
    <div class="span40">
    <form id="searchForm" class="form-horizontal" tabindex="0" style="margin:50px 20px 20px 20px;"  enctype="multipart/form-data">
    	<table cellpadding="0"   cellspacing="0" border="0" width="100%" height="100%">
    		<tr class="tr-height">
    			<td class="td-right">约会id：</td>
    			<td >
    				<input name="id" type="text" class="control-text" >
    			</td>
    			<td class="td-right">用户id：</td>
    			<td>
    				<input name="userId" type="text" class="control-text" >
    			</td>
    			<!-- 
    			<td width="70px" align="right">
							省市地区：
				</td>
    			<td>
    				<div class="selectCity">
						<select class="prov" name="provice_name" id="provice_name" value="">
							<option>请选择省</option>
						</select>
						<select class="city" name="city_name" id="city_name" value="">
							<option>请选择市</option>
						</select>
					</div>
    			</td>
    			 -->
    		</tr>
    		<tr class="tr-height">
    			<td class="td-right">手机号：</td>
    			<td>
    				<input name="mobile" type="text" class="control-text" >
    			</td>
    		<!-- 
    			<td class="td-right">用户类型：</td>
    			<td >
    				<select name="user_source" id="user_source" >
    					<option value="">请选择</option>
						<option value="kefu">客服</option>
						<option value="notkefu">非客服</option>
					</select>
    			</td>
    		 -->
    			<td class="td-right">发布时间：</td>
    			<td colspan="">
    				<input name="release_start_time" type="text" class="calendar" readonly="readonly">
					<span> - </span>
					<input name="release_end_time" type="text" class="calendar" readonly="readonly">
				</td>
    		</tr>
    		<tr class="tr-height">
				<td class="td-right">约会状态：</td>
    			<td >
    				<select name="activeState" id="activeState" >
    					<option value="">全部约会</option>
						<option value="1">未激活</option>
						<option value="2">进行中</option>
						<option value="3">已结束</option>
					</select>
    			</td>
    			<td class="td-right">审核状态：</td>
    			<td>
    				<select name="status" id="status" >
    					<option value="">全部约会</option>
						<option value="1">待审核</option>
						<option value="2">审核通过</option>
						<option value="3">审核不通过</option>
					</select>
    			</td>
    		</tr>
    		<tr class="tr-height">
    			<td class="td-right">活动类型：</td>
    			<td >
    				<select name="type" id="type" >
    					<option value="">全部</option>
						<option value="1">约会</option>
						<option value="2">小聚</option>
						<option value="3">大趴</option>
					</select>
    			</td>
    			<td class="td-right">付费方式：</td>
    			<td >
    				<select name="paymentWay" id="paymentWay" >
    					<option value="">全部</option>
						<option value="1">我请</option>
						<option value="2">AA</option>
						<option value="3">男A</option>
					</select>
    			</td>
    			<!-- 
    			<td class="td-right">用户类型：</td>
    			<td >
    				<select name="user_source" id="user_source" >
    					<option value="">请选择</option>
						<option value="kefu">客服</option>
						<option value="notkefu">非客服</option>
					</select>
    			</td>
    			<td class="td-right"><p style="color: red">未审核数：</p></td>
    			<td>
					<input name="notAuditedCount" id="notAuditedCount" type="text" class="control-text" readonly="readonly" style="color: red">
    			</td>
    			 -->
    		</tr>
    		<tr>
    			<td colspan="6" style="text-align:center">
	   				<input id="btnSearch" type="submit" class="button button-primary" value="搜   索">&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnSearch" type="reset" class="button button-primary" value="重   置">&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
    		</tr>
    	</table>
    </form>
    <!-- 
    	<form name="Apointment" action="${basePath}/schedule/uploadApointmentContentExcelFileToTempDirAndReadItsContentTodB.do" enctype="multipart/form-data"  method="post" >
	    	<input type="file" name="file1" id="file1" >
	    	<input type="submit" value="上传"/>
    	</form>
     -->
    </div>
    </div>
    <div class="search-grid-container" >
	    <div id="grid">
	    </div>
    </div>
   </div>
	<script src="${basePath}/bui/assets/js/bui-min.js"></script>
	<script type="text/javascript">
	    var Grid = BUI.Grid,
	    Store = BUI.Data.Store,
	    columns = [
	    	    {title:'约会Id',dataIndex:'id',width:40,elCls : 'center'},
	    	    {title:'用户Id',dataIndex:'userId',width:60,elCls : 'center'},
	    	    {title:'活动类型',dataIndex:'type',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"约会","2":"小聚","3":"大趴"})},
				{title:'付款方式',dataIndex:'paymentWay',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"我请","2":"AA","3":"男A"})},
				{title:'活动主题',dataIndex:'theme',elCls : 'center'},
	    	    <%-- 
	    	    {title:'照片',dataIndex:'photo',elCls : 'center',width:120,renderer : function(value,obj){
		   	    	var url = obj.photo;
		   	    	var photos = "";
		   	    	if(obj.photo!=""){
			   	    	if(url.split(",")[0]!=undefined&&url.split(",")[0]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[0]+"'style='width:50px;height:50px;'>";
			   	    	}
			   	    	 if(url.split(",")[1]!=undefined&&url.split(",")[1]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[1]+"'style='width:50px;height:50px;'>";
			   	    	} 
			   	    	if(url.split(",")[2]!=undefined&&url.split(",")[2]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[2]+"'style='width:50px;height:50px;'>";
			   	    	}
		   	    	}else{
		   	    		photos = "<a><font color='pink'>暂无图片</font>";
		   	    	}
		            return photos;
	      	  }},
				{title:'补充说明',dataIndex:'content',elCls : 'center',renderer : function(value,obj){
	          		if(obj.content != null){
		          		return "<h4><font color='blue'>"+ obj.content +"</font>"
	          		}
	            }},
				{title:'性别',dataIndex:'sex',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"0":"男","1":"女"})},
	    	    --%>
				/* {title:'对象',dataIndex:'partnerForDating',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"3":"不限","1":"男","2":"女"})}, */
				{title:'发布时间',dataIndex:'ctime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'约会时间',dataIndex:'activityTime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'约会地点',dataIndex:'bizAddr',elCls : 'center'},
				{title:'担保金',dataIndex:'guaranteeWay',elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"0":"皇冠","1":"50","2":"100"})},
				{title:'补贴金',dataIndex:'subsidy',elCls : 'center'},
				<%-- 
				{title:'报名数',dataIndex:'enroll_number',width:40,elCls : 'center'},
				{title:'评论数',dataIndex:'comment_number',width:40,elCls : 'center'},
				--%>
				{title:'约会状态',dataIndex:'activeState',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未激活","2":"进行中","3":"结束"})},
				{title:'审核状态',dataIndex:'status',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未审核","2":"审核通过","3":"审审核不通过"})},
				//{title:'发布时间',dataIndex:'ctime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				//{title:'添加评论',dataIndex:'',width:60,elCls : 'center',renderer : function(value,obj){
					//return '<span class="grid-command btn1">添加评论</span>'
					<%--
					var view = "<a href='${basePath}/jsps/data/activity_comment_kf.jsp?id="+obj.id+"&commentary_mobile="+obj.mobile+"' title='添加评论'>添加评论</a>";
					return view;
					--%>
	           //}},
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/activity/getOfflineList.do',
	    autoLoad:true,
	    params : {         //设置请求时的参数
	      id : '${param.id}'
	    },
	    pageSize:10,
	      root : 'offlineList',
	      totalProperty : 'total',
	    }),
	    
	    
	    grid = new Grid.Grid({
	    render:'#grid',
	    loadMask: true,
	    forceFit:true,
	    columns : columns,
	    store: store,
	    plugins : [Grid.Plugins.CheckSelection,Grid.Plugins.AutoFit], //勾选插件、自适应宽度插件
	    // 顶部工具栏
	    bbar : {
			items:[
				{
			    btnCls : 'button button-primary button-small',
			    text : '<i class="icon-plus"></i>审核通过',
				    listeners : {
				      'click' : setQualified
				    }
			    },
			    {
				btnCls : 'button button-primary button-small',
			   	text:'<i class="icon-remove"></i>审核不通过',
				    listeners : {
						'click' : setUnqualified
				    }
		   		}
		   ],
	   	    pagingBar:true
	    }
	    });
	    grid.render();
	    grid.on('cellclick',function(ev){
			var record = ev.record, //点击行的记录
			field = ev.field, //点击对应列的dataIndex
			target = $(ev.domTarget); //点击的元素
			 if(target.hasClass('btn1')){
				if(top.topManager){
					top.topManager.openPage({
						 id:'',
						 href:'${basePath}/jsps/data/activity_comment_kf1.jsp?id='+record.id+'&commentary_mobile='+record.mobile+'&subject='+record.subject+'&content='+record.content,
						 closeable:true,
						 title:'约会添加评论'
					});
				}
			}
		});	     
	    //创建表单，表单中的日历，不需要单独初始化
	    var form = new BUI.Form.HForm({
	    srcNode : '#searchForm'
	    }).render();
	     
	    form.on('beforesubmit',function(ev) {
	    //序列化成对象
	    var obj = form.serializeToObject();
	    obj.start = 0; //返回第一页
	    store.load(obj);
	    return false;
	    });
		//审核合格
		function setQualified(){
			var selections = grid.getSelection();
			if(selections.length<1){
				alert("请至少选择一条待审核信息！");
			}else{
			    var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				jqPost(ids, 2);
			}
		} 
		//审核不合格
		function setUnqualified(){
			var selections = grid.getSelection();
			if(selections.length<1){
				alert("请至少选择一条待审核信息！");
			}else{
			    var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				jqPost(ids, 3);
			}
		} 
		
		function jqPost(ids, status){
			jQuery.post('${basePath}/activity/changeStatus.do',{ids:ids,status:status},function(data){
	             if(data){
		             alert("处理成功！");
		             store.load();
		         }
			});
		}	
</script>
</body>
</html> 
