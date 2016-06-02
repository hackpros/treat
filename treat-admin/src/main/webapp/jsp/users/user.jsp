<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="utf-8">
    <title>搜索页</title>
	    <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet">
	    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet">
	    <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
		 <script type="text/javascript" src="${basePath}/bui/assets/js/jquery.cityselect.js"></script>
		 <script type="text/javascript">
		 	<%-- 
		 	$(document).ready(function(e) {
				jQuery.post('${basePath}/user/getNotAuditedCount4users.do',function(data){
			    	 if(data){
				    	 $("#notAuditedCount").attr('value',data.notAuditedCount);
			    	 }
				});
			});
		 	--%>
		 	
			$(function(){
				$(".selectCity").citySelect({
			    	prov:"请选择",
			    	city:"请选择"
				});
			});
			function getReview1(){
				var review = $("#review").val();
				if(review == 1){
					$("#nicknameReview").attr("class","");
					$("#photoReview").attr("class","");
					$("#signReview").attr("class","");
				}else{
					$("#nicknameReview").attr("class","hide");
					$("#photoReview").attr("class","hide");
					$("#signReview").attr("class","hide");
				}
			}
			function getReview(){
				var review = $("#review").val();
				if(review == 1){
					$("#s1").attr("class","");
				}else{
					$("#s1").attr("class","hide");
				}
			}
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
    <div class="span30"> 
    
    <form id="searchForm" class="form-horizontal" tabindex="0" style="margin-left: 50px;" enctype="multipart/form-data">
    	<br>
    	<table border="0">
    		<tr style="line-height:40px;">
    			<td width="100px" align="right">
							用户id：
				</td>
    			<td>
					<input type="text" class="control-text" name="userId">
    			</td>
    			<td width="70px" align="right">
							手 机 号：
				</td>
    			<td>
					<input type="text" class="control-text" name="mobile">
    			</td>
    			<!-- 
    			<td width="70px" align="right">
							省市地区：
				</td>
    			<td>
    				<div class="selectCity">
						<select class="prov" name="provice_name" value="">
							
						</select>
						<select class="city" name="city_name" value="">
							
						</select>
					</div>
    			</td>
    			 -->
    			
    		</tr>
    		<tr style="line-height:40px;">
    			<td width="70px" align="right">
							用户昵称：
				</td>
    			<td>
					<input type="text" class="control-text" name="nickName">
    			</td>
    			<td width="70px" align="right">
							注册时间：
				</td>
    			<td>
					<input name="regist_start_time" type="text" class="calendar">
					<span> - </span>
					<input name="regist_end_time" type="text" class="calendar">
    			</td>
    			<!-- 
    			<td width="70px" align="right">
							年龄范围：
				</td>
    			<td>
					<input name="start_age" type="number" class="input-small" />-
					<input name="end_age" type="number" class="input-small" />
    			</td>
    			 -->
    		</tr>
    		<tr style="line-height:40px;">
    			<td width="70px" align="right">
							用户性别：
				</td>
    			<td>
					<select name="sex" id="sex" class="input-small">
						<option value="">请选择</option>
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
    			</td>
    			<!-- 
    			<td width="70px" align="right">
							个性签名：
				</td>
    			<td>
					<input type="text" class="control-text" name="user_sign">
    			</td>
    			<td width="70px" align="right"><p style="color: red">未审核数：</p></td>
    			<td>
					<input name="notAuditedCount" id="notAuditedCount" type="text" class="control-text" readonly="readonly" style="color: red">
    			</td>
    			 -->
    		</tr>
    		<tr style="line-height:40px;">
    			<td width="100px" align="right">
							是否通过审核：
				</td>
    			<td>
					<select name="status" id="status" class="input-normal" onchange="getReview()">
						<option value="">全部</option>
						<option value="0">待审核</option>
						<option value="1">审核通过</option>
						<option value="2">审核不通过</option>
					</select>
					<label id="s1" class="hide"><input type="hidden" id="hide" value="" name="unqualifiedReviews"></label>
					<%-- 
	    				<label id="nicknameReview" class="checkbox hide"><input name="nicknameReview" type="checkbox" value="1" onchange="getValue(this.name)">昵称不合格</label> 
			            <label id="photoReview" class="checkbox hide"><input name="photoReview" type="checkbox" value="1" onchange="getValue(this.name)">照片不合格</label> 
			            <label id="signReview" class="checkbox hide"><input name="signReview" type="checkbox" value="1" onchange="getValue(this.name)">签名不合格</label>
			            <label id="nicknameReview" class="hide"><input name="nicknameReview" type="checkbox" value="1" onchange="getValue(this.name)">昵称不合格</label>
			            <label id="photoReview" class="hide"><input name="photoReview" type="checkbox" value="1" onchange="getValue(this.name)">照片不合格</label>
			            <label id="signReview" class="hide"><input name="signReview" type="checkbox" value="1" onchange="getValue(this.name)">签名不合格</label>
					--%>
    			</td>
    			<td colspan="2">
    			</td>
	   		</tr>
    		<%-- 
		   		<tr style="line-height:40px;">
		   			<td width="100px" align="right">按审核时间排序：</td>
					<td>
						<select name="isAudit" id="isAudit" class="input-small">
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
		   			</td>
		  				<td width="70px" align="right">审核时间：</td>
		   			<td colspan="2">
						<input name="otime1" type="text" class="calendar">
						<span> - </span>
						<input name="otime2" type="text" class="calendar">
		   			</td>
		   		</tr>
    		--%>
    		<tr>
    			<td colspan="6" align="center">
    				<button id="btnSearch" type="submit" class="button button-primary">搜 索</button>
    				<button id="btnSearch" type="reset" class="button button-primary">重 置</button>
    			</td>
    		</tr>
    	</table>
    </form>
    </div>
    </div>
    <div class="search-grid-container">
    	<div id="grid">
   		</div>
    </div>
    </div><div align="center"> 
    </div></body>
    <script src=" ${basePath}/bui/assets/js/acharts.js"></script>
    <script src="${basePath}/bui/assets/js/bui-min.js"></script>
    <script src="${basePath}/bui/assets/js/tip.js"></script>
   <script type="text/javascript">
		function exportExcel(){
			var start_time = $("input[name=start_time]").val();
			var end_time = $("input[name=end_time]").val();
			if(confirm("导出excel只按注册时间段导出，未选中注册时间将导出所有信息！")){
				location.href='${basePath}/user/exportUserRegistCount.do?start_time='+start_time+'&end_time='+end_time;
			}
		}
	   BUI.use('common/page');
	</script>
	<script type="text/javascript">
	    var Grid = BUI.Grid,
	    Store = BUI.Data.Store,
	    columns = [
	    	  {title:'用户id',dataIndex:'userId',width:50,elCls : 'center',renderer : function(value,obj){
	             return '<span class="grid-command btn3">' + obj.userId + '</span>'
	          }},
	      	  {title:'手机号',dataIndex:'mobile',width:110,elCls : 'center'},
	      	  {title:'昵称',dataIndex:'nickName',width:100,elCls : 'center'},
	          {title:'个性签名',dataIndex:'signature',width:150,elCls : 'center'},
	          {title:'生日',dataIndex:'birthday',width:80,renderer:BUI.Grid.Format.dateRenderer,elCls : 'center'},
	          {title:'性别',dataIndex:'sex',width:60,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"男","2":"女"})},
	          {title:'皇冠',dataIndex:'crown',width:60,elCls : 'center'},
	          {title:'鸽子',dataIndex:'pigeon',width:60,elCls : 'center'},
	          //{title:'省份',dataIndex:'provice_code',width:60,elCls : 'center'},
	          //{title:'城市',dataIndex:'city_code',width:60,elCls : 'center'},
	          {title:'渠道',dataIndex:'userSource',width:100,elCls : 'center'},
	          {title:'注册时间',dataIndex:'ctime',width:80,renderer:BUI.Grid.Format.dateRenderer,elCls : 'center'},
	          {title:'最近登录时间',dataIndex:'lastLoginTime',width:80,renderer:BUI.Grid.Format.dateRenderer,elCls : 'center'},
	          //{title:'诚意金',dataIndex:'credit_balance',width:60,elCls : 'center'},
	          {title:'状态',dataIndex:'status',width:80,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"0":"待审核","1":"审核通过","2":"审核不通过"})},
	          {title:'用户详情',elCls : 'center',width:80,renderer : function(value,obj){
	             return '<span class="grid-command btn2">用户详情</span>'
	          }},
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/user/getUserList.do',
	    autoLoad:true,
	    params : {         //设置请求时的参数
	      userId : '${param.id}'
	    },
	    pageSize:50,
	     root : 'userlist',
	      totalProperty : 'total',
	    }),
	    
	    grid = new Grid.Grid({
	    render:'#grid',
	    loadMask: true,
	    forceFit:false,
	    columns : columns,
	    store: store,
	    plugins : [Grid.Plugins.CheckSelection,Grid.Plugins.AutoFit],  
	    
	    
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
	    grid.on('cellclick',function  (ev) {
	      var record = ev.record, //点击行的记录
	        field = ev.field, //点击对应列的dataIndex
	        target = $(ev.domTarget); //点击的元素
	         if(target.hasClass('btn2')){
				if(top.topManager){
					top.topManager.openPage({
					     id:'',
					     href:'${basePath}/jsp/users/userCountDetail.jsp?userId='+record.userId,
					     closeable:true,
					     title:'用户统计详情'
					});
		        }
	        }
	        if(target.hasClass('btn3')){
				if(top.topManager){
					top.topManager.openPage({
					     id:'',
					     href:'${basePath}/jsp/users/userInfoDetail.jsp?userId='+record.userId,
					     closeable:true,
					     title:'用户信息详情'
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
			    var userIds ="";
				for(var i = 0;i<selections.length-1;i++){
					userIds += selections[i].userId+",";
				}
				userIds += selections[selections.length-1].userId;
				jqPost(userIds, 1);
			}
		} 
		//审核不合格
		function setUnqualified(){
			var selections = grid.getSelection();
			if(selections.length<1){
				alert("请至少选择一条待审核信息！");
			}else{
			    var userIds ="";
				for(var i = 0;i<selections.length-1;i++){
					userIds += selections[i].userId+",";
				}
				userIds += selections[selections.length-1].userId;
				jqPost(userIds, 2);
			}
		} 
		
		function jqPost(userIds, status){
			jQuery.post('${basePath}/user/changeStatus.do',{userIds:userIds,status:status},function(data){
	             if(data){
		             alert("处理成功！");
		             store.load();
		         }
			});
		}	
	</script>
</html> 
