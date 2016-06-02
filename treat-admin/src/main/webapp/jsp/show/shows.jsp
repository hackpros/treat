<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>秀场管理</title>
<link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet">
<link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet">
<style type="text/css">
.tr-height {
	height: 40px;
}

.td-right {
	text-align: right;
}

.td-left {
	text-align: left;
}

</style>
<script type="text/javascript"
	src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${basePath}/bui/assets/js/jquery.cityselect.js"></script>
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
				//var offsetX=20-$("#grid").offset().left; 
				//var offsetY=20-$("#grid").offset().top; 
				var width=10*$('#grid a img').width(); 
				var height=10*$('#grid a img').height(); 
				$("#grid span a").mouseover(function(event) { 
					var $target=$(event.target); 
					if($target.is('img')) 
					{ 
						$("<img id='tip' src='"+$target.attr("src")+"'>").css({ 
							//"height":height, 
							//"width":width, 
							//"left":event.pageX+offsetX, 
							//"top":event.pageY-$('#grid a img').width(), 
							"max-width":400,
							"position":"fixed",
							"left":0,
							"top":0,
						}).appendTo($("#grid")); 
					} 
				}).mouseout(function() { 
					$("#tip").remove(); 
				}); 
			}
		</script>
<style type="text/css">
/* img {
	height: auto;
	width: auto;
	position: absolute;
	border: 0px;
}*/

#grid span a {
	position: relative;
	height: 60px;
	width: 60px;
	list-style: none;
	float: left; 
	margin: 0px;
	border: 0px solid;
} 

</style>
</head>
<body>
	<div class="demo-content">
		<div class="row">
			<div class="span40">
				<form id="searchForm" class="form-horizontal" tabindex="0"
					style="margin:50px 20px 20px 20px;" enctype="multipart/form-data">
					<table cellpadding="0" cellspacing="0" border="0" width="100%"
						height="100%">
						<tr class="tr-height">
							<td class="td-right">用户id：</td>
							<td><input name="userId" type="text" class="control-text">
							</td>
							<td class="td-right">秀场id：</td>
							<td><input name="id" type="text" class="control-text">
							</td>
							<td class="td-right">手机号：</td>
							<td><input name="mobile" type="text" class="control-text">
							</td>
						</tr>
						<tr class="tr-height">
							<!-- <td class="td-right">秀场类型：</td>
							<td><select name="type" id="type">
									<option value="">全部</option>
									<option value="0">秀场0</option>
									<option value="1">秀场1</option>
									<option value="2">秀场2</option>
							</select></td> -->
							<td class="td-right">媒体类型：</td>
							<td><select name="mediaType" id="mediaType">
									<option value="">全部</option>
									<option value="1">图片</option>
									<option value="2">视频</option>
							</select></td>
							<td class="td-right">发布时间：</td>
							<td colspan=""><input name="release_start_time" type="text"
								class="calendar" readonly="readonly"> <span> - </span> <input
								name="release_end_time" type="text" class="calendar"
								readonly="readonly"></td>
						</tr>
						<tr class="tr-height">
							<td class="td-right">审核状态：</td>
							<td><select name="status" id="status">
									<option value="">全部</option>
									<option value="1">待审核</option>
									<option value="2">审核通过</option>
									<option value="3">审核不通过</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="6" style="text-align:center"><input
								id="btnSearch" type="submit" class="button button-primary"
								value="搜   索">&nbsp;&nbsp;&nbsp;&nbsp; <input
								id="btnSearch" type="reset" class="button button-primary"
								value="重   置">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="search-grid-container">
			<div id="grid"></div>
		</div>
	</div>
	<script src="${basePath}/bui/assets/js/bui-min.js"></script>
	<script type="text/javascript">
	    var Grid = BUI.Grid,
	    Store = BUI.Data.Store,
	    columns = [
	    	    {title:'秀场Id',dataIndex:'id',width:40,elCls : 'center'},
	    	    {title:'用户Id',dataIndex:'userId',width:60,elCls : 'center'},
	    	    /* {title:'秀场类型',dataIndex:'type',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"0":"秀场0","1":"秀场1","2":"秀场2"})}, */
				{title:'签名',dataIndex:'signature',elCls : 'center'},
				{title:'媒体类型',dataIndex:'mediaType',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"图片","2":"视频"})},
	    	    {title:'媒体内容',dataIndex:'mediaContent',elCls : 'center',renderer : function(value,obj){
		   	    	var url = obj.mediaContent;
		   	    	var photos = "";
		   	    	if(obj.photo!=""){
			   	    	if(url.split(",")[0]!=undefined && url.split(",")[0]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[0]+"'style='max-height:50px;'>";
			   	    	}
			   	    	 if(url.split(",")[1]!=undefined && url.split(",")[1]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[1]+"'style='max-height:50px;'>";
			   	    	} 
			   	    	if(url.split(",")[2]!=undefined && url.split(",")[2]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[2]+"'style='max-height:50px;'>";
			   	    	}
			   	    	if(url.split(",")[3]!=undefined && url.split(",")[3]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[3]+"'style='max-height:50px;'>";
			   	    	}
			   	    	 if(url.split(",")[4]!=undefined && url.split(",")[4]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[4]+"'style='max-height:50px;'>";
			   	    	} 
			   	    	if(url.split(",")[5]!=undefined && url.split(",")[5]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[5]+"'style='max-height:50px;'>";
			   	    	}
			   	    	if(url.split(",")[6]!=undefined && url.split(",")[6]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[6]+"'style='max-height:50px;'>";
			   	    	}
			   	    	 if(url.split(",")[7]!=undefined && url.split(",")[7]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[7]+"'style='max-height:50px;'>";
			   	    	} 
			   	    	if(url.split(",")[8]!=undefined && url.split(",")[8]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[8]+"'style='max-height:50px;'>";
			   	    	}
			   	    	if(url.split(",")[9]!=undefined && url.split(",")[9]!=""){
			   	    		 photos+="<a><img src='"+url.split(",")[9]+"'style='max-height:50px;'>";
			   	    	}
		   	    	}else{
		   	    		photos = "<a><font color='pink'>暂无图片</font>";
		   	    	}
		            return photos;
	      	  }},
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
	    	    --%>
				{title:'发布时间',dataIndex:'ctime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'审核状态',dataIndex:'status',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未审核","2":"审核通过","3":"审核不通过"})},
				<%--
				{title:'添加评论',dataIndex:'',width:60,elCls : 'center',renderer : function(value,obj){
					return '<span class="grid-command btn1">添加评论</span>'
					var view = "<a href='${basePath}/jsps/data/activity_comment_kf.jsp?id="+obj.id+"&commentary_mobile="+obj.mobile+"' title='添加评论'>添加评论</a>";
					return view;
	            }},
				--%>
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/show/getShowList.do',
	    autoLoad:true,
	    params : {         //设置请求时的参数
	      id : '${param.id}'
	    },
	    pageSize:50,
	      root : 'showList',
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
	    //items 也可以在此配置
	    // pagingBar:表明包含分页栏
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
			jQuery.post('${basePath}/show/changeStatus.do',{ids:ids,status:status},function(data){
	             if(data){
		             alert("处理成功！");
		             store.load();
		         }
			});
		}
	</script>
</body>
</html>
