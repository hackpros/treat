<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>举报管理</title>
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
			
<style type="text/css">
 img {
	height: auto;
	width: auto;
	position: absolute;
	border: 0px;
}

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
							<td>
								<input name="userId" type="text" class="control-text">
							</td>
							<td class="td-right">手机号：</td>
							<td>
								<input name="mobile" type="text" class="control-text">
							</td>
						</tr>
						<tr class="tr-height">
							<td class="td-right">举报类型：</td>
							<td><select name="reporyType" id="reporyType">
									<option value="">全部</option>
									<option value="1">用户</option>
									<option value="5">秀场</option>
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
	    	    {title:'举报Id',dataIndex:'id',width:30,elCls : 'center'},
	    	    {title:'举报者Id',dataIndex:'userId',width:30,elCls : 'center'},
				{title:'举报类型',dataIndex:'reporyType',width:30,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"用户","2":"聊天","3":"动态","4":"活动","5":"秀场"})},
				{title:'被举报Id',dataIndex:'reporyId',width:30,elCls : 'center'},
				{title:'举报内容',dataIndex:'reopryContext',elCls : 'center'},
				{title:'举报时间',dataIndex:'ctime',width:45,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'举报结果',dataIndex:'result',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"0":"未处理","1":"已处理"})},
				{title:'举报详情',elCls : 'center',width:40,renderer : function(value,obj){
		             return '<span class="grid-command btn1">查看详情</span>'
		        }},
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/userReport/getUserReportList.do',
	    autoLoad:true,
	    pageSize:50,
	      root : 'userReportList',
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
				/* {
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
		   		} */
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
					//{"1":"用户","2":"聊天","3":"动态","4":"活动","5":"秀场"}
					if(record.reporyType == 1){
						hrefUrl = '${basePath}/jsp/users/user.jsp?id='+record.reporyId;
						title = '用户';
					}
					if(record.reporyType == 5){
						hrefUrl = '${basePath}/jsp/show/shows.jsp?id='+record.reporyId;
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
				jqPost(ids, 1);
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
				jqPost(ids, 2);
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
