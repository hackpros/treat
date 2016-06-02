<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.addHeader("Access-Control-Allow-Origin", "*");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>资金管理</title>
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
							<td><input name="userId" type="text" class="control-text"></td>
							<td class="td-right">手机号：</td>
							<td><input name="mobile" type="text" class="control-text"></td>
						</tr>
						<tr class="tr-height">
							<td class="td-right">支付方式：</td>
							<td><select name="plusMinus" id="plusMinus">
									<option value="">全部</option>
									<option value="1">支付宝</option>
									<option value="2">微信</option>
									<option value="3">提现</option>
									<!-- <option value="4">我请客账户</option> -->
							</select></td>
							<td class="td-right">操作时间：</td>
							<td colspan=""><input name="release_start_time" type="text"
								class="calendar" readonly="readonly"> <span> - </span> <input
								name="release_end_time" type="text" class="calendar"
								readonly="readonly"></td>
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
	    	  {title:'编号',dataIndex:'id',width:30,elCls : 'center'},
	          {title:'用户id',dataIndex:'userId',width:30,elCls : 'center'},
	          {title:'出入',dataIndex:'type',width:30,renderer:BUI.Grid.Format.enumRenderer({"1":"+","2":"-"}),elCls : 'center'},
	          {title:'金额',dataIndex:'amount',width:30,elCls : 'center'},
	          {title:'支付方式',dataIndex:'plusMinus',width:50,renderer:BUI.Grid.Format.enumRenderer({"1":"支付宝","2":"微信","3":"提现","null":"我请客账户"}),elCls : 'center'},
	          {title:'流水号',dataIndex:'outTradeNo',width:100,elCls : 'center'},
	          {title:'用户账号',dataIndex:'sellerId',width:100,elCls : 'center'},
	          {title:'描述',dataIndex:'description',width:100,elCls : 'center'},
	          {title:'申请时间',dataIndex:'ctime',width:140,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
	          
	          //{title : '操作',elCls : 'center',renderer : function(value,obj){
      	  		//return '<span class="grid-command btn1">本次用户详情</span>'
      	  		//}
	      	  //}
	    ];
	    
	    var store = new Store({
	    url :'${basePath}/fund/getFundRecordList.do',
	    autoLoad:true,
	    pageSize:50,
	      root : 'fundRecordList',
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
