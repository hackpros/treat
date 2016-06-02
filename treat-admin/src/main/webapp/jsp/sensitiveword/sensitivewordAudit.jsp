<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>敏感词审核</title>
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
		 </script>
    </head>
    <body>
    <div class="demo-content">
    <div class="row">
    <div class="span40">
    <form id="searchForm" class="form-horizontal" tabindex="0" style="margin:50px 20px 20px 20px;"  enctype="multipart/form-data">
    	<table cellpadding="0"   cellspacing="0" border="0" width="100%" height="100%">
    		<!-- <tr class="tr-height">
    			<td class="td-right">约会id：</td>
    			<td >
    				<input name="id" type="text" class="control-text" >
    			</td>
    		</tr> -->
    		<tr class="tr-height">
    			<!-- <td class="td-right">手机号：</td>
    			<td>
    				<input name="mobile" type="text" class="control-text" >
    			</td> -->
    			<td class="td-right">活动类型：</td>
    			<td >
    				<select name="sceneType" id="sceneType" >
    					<option value="">全部</option>
						<option value="1">线上</option>
						<option value="2">线下</option>
						<option value="3">秀场</option>
					</select>
    			</td>
    			<td class="td-right">审核状态：</td>
    			<td >
    				<select name="review" id="review" >
    					<option value="">全部</option>
						<option value="1">未审核</option>
						<option value="2">审核通过</option>
						<option value="3">审核不通过</option>
					</select>
    			</td>
    		</tr>
    		<tr class="tr-height">
    			<td class="td-right">用户id：</td>
    			<td>
    				<input name="userId" type="text" class="control-text" >
    			</td>
    			<td class="td-right">扫描时间：</td>
    			<td colspan="">
    				<input name="release_start_time" type="text" class="calendar" readonly="readonly">
					<span> - </span>
					<input name="release_end_time" type="text" class="calendar" readonly="readonly">
				</td>
    		</tr>
    		<tr>
    			<td colspan="6" style="text-align:center">
	   				<input id="btnSearch" type="submit" class="button button-primary" value="搜   索">&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="btnSearch" type="reset" class="button button-primary" value="重   置">&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
    		</tr>
    	</table>
    </form>
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
	    	    {title:'类型',dataIndex:'sceneType',width:30,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"线上","2":"线下","3":"秀场"})},
	    	    {title:'请客/秀场Id',dataIndex:'sceneId',width:30,elCls : 'center'},
	    	    {title:'用户Id',dataIndex:'userId',width:20,elCls : 'center'},
				{title:'主题/留言',dataIndex:'theme',elCls : 'center'},
				{title:'敏感词',dataIndex:'sensitiveWord',width:60,elCls : 'center'},
				{title:'活动时间',dataIndex:'sceneTime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'扫描时间',dataIndex:'ctime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'审核状态',dataIndex:'review',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未审核","2":"审核通过","3":"审核不通过"})},
				{title:'详情',elCls : 'center',width:40,renderer : function(value,obj){
		             return '<span class="grid-command btn1">查看详情</span>'
		        }},
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/sensitiveWord/getSensitiveActivityList.do',
	    autoLoad:true,
	    pageSize:20,
	      root : 'sensitiveActivityList',
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
					var hrefUrl = '';
					var title = '';
					//{title:'类型',dataIndex:'sceneType',renderer:BUI.Grid.Format.enumRenderer({"1":"线上","2":"线下","3":"秀场"})},
					if(record.sceneType == 1){
						hrefUrl = '${basePath}/jsp/activity/online.jsp?id='+record.sceneId;
						title = '线上请客';
					}
					if(record.sceneType == 2){
						hrefUrl = '${basePath}/jsp/activity/offline.jsp?id='+record.sceneId;
						title = '线下活动';
					}
					if(record.sceneType == 3){
						hrefUrl = '${basePath}/jsp/show/shows.jsp?id='+record.sceneId;
						title = '秀场';
					}
					top.topManager.openPage({
						 id:'',
						 href:hrefUrl,
						 closeable:true,
						 title:title
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
		
		function jqPost(ids, review){
			jQuery.post('${basePath}/sensitiveWord/changeReview4SensitiveActivity.do',{ids:ids,review:review},function(data){
	             if(data){
		             alert("处理成功！");
		             store.load();
		         }
			});
		}	
</script>
</body>
</html> 
