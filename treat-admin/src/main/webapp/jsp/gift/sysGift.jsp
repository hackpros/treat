<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>系统礼物管理</title>
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
			.div span a{display:table-cell;vertical-align:middle;width:200px;height:140px;}
		 </style>
		 
		 <script type="text/javascript">
		 </script>
		 <script language="javascript"> 
			setInterval(fetchData,500);
			function fetchData(){
				var offsetX=20-$("#grid").offset().left; 
				var offsetY=20-$("#grid").offset().top; 
				var width=10*$('#grid a img').width(); 
				var height=10*$('#grid a img').height(); 
				$("#grid span a").mouseover(function(event) { 
					var $target=$(event.target); 
					//alert($target.attr("src"));
					if($target.is('img')) 
					{ 
						$("<img id='tip' src='"+$target.attr("src")+"'>").css({ 
							//"height":height, 
							//"width":width, 
							//"left":event.pageX+offsetX, 
							"top":event.pageY-$('#grid a img').width()*3, 
							"position":"fixed",
							"max-width":400,
							"left":0,
							"top":0,
						}).appendTo($("#grid")); 
					} 
				}).mouseout(function() { 
					$("#tip").remove(); 
				}); 
			}
			
			function goEditPic(id){
				alert(id);
				jQuery.post('${basePath}/gift/goEditPic.do',{id:id});
			}
			function getGiftInfo(id){
				var id = $("#bizId").val();
				jQuery.post('${basePath}/gift/getGiftInfo.do',{id:id},function(data){
		    	     if(data){
		    	     	if(data.category != 9){
		    	     		alert("该礼物不属于系统礼物！");
		    	     	}else{
			    	     	$("#bizName").attr("value",data.name);
			    	     	$("#bizImage").attr("value",data.imageUrl);
			    	     	$("#bizImageUrl").attr("src",data.imageUrl);
		    	     	}
			    	 }
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
	    			<td class="td-right">礼物名称：</td>
	    			<td >
	    				<input name="name" type="text" class="control-text" >
	    			</td>
	    		<tr class="tr-height">
	    			<td class="td-right">上架时间：</td>
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
   <!-- 初始隐藏 dialog内容 -->
	<div id="content" class="hide">
		<form class="form-horizontal" method="post">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>礼物名称：
					</label>
					<div class="controls">
						<input name="name" type="text" data-rules="{required:true}"
							class="input-normal control-text" maxlength="25">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>商品Id：
					</label>
					<div class="controls">
						<input name="bizId" id="bizId" type="text" data-rules="{required:true}" onchange="getGiftInfo()">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>商品名称：
					</label>
					<div class="controls">
						<input name="bizName" id="bizName" type="text"  readonly="readonly">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>活动类别：
					</label>
					<div class="controls">
						<select name="type" id="type" >
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
						<select name="category" id="category" >
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
						<select name="useWay" id="useWay" >
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
						<input name="amount" type="text">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>兑换码：
					</label>
					<div class="controls">
						<input name="exchangeCode" type="text">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>业务范围：
					</label>
					<!-- {"reg":"注册","invite":"邀请","beinvite":"被邀请","firstlogin":"每日登陆","procure":"奖励码"} -->
					<div class="controls">
						<select name="businessCode" id="businessCode" >
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
						<input name="period" type="text">天
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>起始时间：
					</label>
					<div class="controls">
						<input name="startTime" type="text" class="calendar" readonly="readonly">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>截止时间：
					</label>
					<div class="controls">
						<input name="endTime" type="text" class="calendar" readonly="readonly">
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
		</form>
	</div>
   </div>
   <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
	<script src="${basePath}/bui/assets/js/bui-min.js"></script>
	<script type="text/javascript">
        BUI.use(['bui/grid','bui/data'],function(Grid,Data){
            var Grid = Grid,
          Store = Data.Store,
           columns = [
	    	    {title:'礼物Id',dataIndex:'id',width:60,elCls : 'center'},
	    	    {title:'礼物名称',dataIndex:'name',width:80,elCls : 'center'},
				{title:'礼物描述',dataIndex:'descript',elCls : 'center'},
				{title:'活动类别',dataIndex:'type',width:70,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"系统","2":"推广","3":"运营"})},
	    	    {title:'赠送类型',dataIndex:'category',width:70,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"gift":"礼物","allure":"魅力值"})},
	    	    {title:'数量',dataIndex:'amount',width:60,elCls : 'center'},
				{title:'起始时间',dataIndex:'startTime',width:80,elCls : 'center',renderer:BUI.Grid.Format.dateRenderer},
				{title:'截止时间',dataIndex:'endTime',width:80,elCls : 'center',renderer:BUI.Grid.Format.dateRenderer},
				{title:'状态',dataIndex:'status',width:60,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未启用","2":"启用","3":"停用"})},
				{title:'使用期限',dataIndex:'period',width:70,elCls : 'center'},
				{title:'业务范围',dataIndex:'businessCode',elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"reg":"注册","invite":"邀请","beinvite":"被邀请","firstlogin":"每日登陆","procure":"奖励码"})},
				{title:'商品Id',dataIndex:'bizId',width:60,elCls : 'center'},
				{title:'商品名称',dataIndex:'bizName',elCls : 'center'},
				{title:'商品图片',dataIndex:'bizImage',width:120,elCls : 'center',renderer : function(value,obj){
		            if(obj.bizImage != null && obj.bizImage != ""){
		           		return "<a><img src='"+obj.bizImage+"'style='max-height:50px;'></a>";
		            }else{
		            	return "<a><font color='pink'>暂无图片</font></a>";
		            }
	      	 	 }},
				{title:'兑换码',dataIndex:'exchangeCode',width:60,elCls : 'center'},
				{title:'二维码',dataIndex:'qrCode',elCls : 'center'},
				{title:'使用方式',dataIndex:'useWay',width:70,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"不限","2":"自用","3":"转送"})},
				{title:'创建时间',dataIndex:'ctime',width:80,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'修改时间',dataIndex:'mtime',width:80,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
	    	    {title : '操作',elCls : 'center',renderer : function(value,obj){
	            	return '<span class="grid-command btn1">修改</span>'
            	}}
	   		 ];
 
        var editing = new Grid.Plugins.DialogEditing({
            contentId : 'content', //设置隐藏的Dialog内容
            triggerCls : 'btn-edit', //触发显示Dialog的样式
            editor : {
              success : function(){
                var edtor = this,
                  form = edtor.get('form'),
                  editType = editing.get('editType');//add 或者 edit
                  /*
                  url = '${basePath}/gift/getGiftList.do';
                  */ 
                if(editType == 'add'){ //可以根据编辑类型决定url
                  url = '${basePath}/gift/addSysGift.do';
                }else if(editType == 'edit'){
                }
                url += '?saveType=' + editType;
 
                //检验
                form.valid();
                if(form.isValid()){
                  form.ajaxSubmit({ //表单异步提交
                    url : url,
                    success : function(data){
                      if(editType == 'add'){
                      	if(data==1){
                        	alert("添加成功");
                        	store.load();
                        }else{
                        	alert("添加失败");
                        	store.load();
                        }
                      }else{
	                      if(data==1){
	                        	alert("修改成功！");
	                        	store.load();
	                        }else{
	                        	alert("修改失败！");
	                        	store.load();
	                        }
						alert("error");	
                      }
                      //将a 改成 1 测试一下显示错误
                      if(data.hasError){ //返回的数据是 {hasError : fasle,error : 'xxxx',field : 'xxx'},也可以是任意格式的数据如 ： {success : false,'error' : 'xxxxx'}
                        var field = data.field;
                        form.getField(field).showErrors([data.error]); //也可以多个字段的错误信息 例如 errors : [{field : 'a',error: 'addd'},{field : 'a',error: 'addd'}]
                      }else{
                        edtor.accept();
                      }
                      
                    },
                    error : function(){
                      //do something
                    }
                  });
                }
              }
            }
          }),
          store = new Store({
            url :'${basePath}/gift/getSysGiftList.do',
		    autoLoad:true,
		    pageSize:10,
		      root : 'sysGiftList',
		      totalProperty : 'total',
          }),
          grid = new Grid.Grid({
            render:'#grid',
            columns : columns,
            loadMask: true,
            forceFit : true,
            store : store,
            tbar:{ //添加、删除
                items : [{
                  btnCls : 'button button-primary button-small',
                  text : '<i class="icon-plus"></i>添加',
                  listeners : {
                    'click' : addFunction
                  }
                },
                {
                  btnCls : 'button button-primary button-small',
                  text : '<i class="icon-remove"></i>删除',
                  listeners : {
                    'click' : delFunction
                  }
                },
                {
                  btnCls : 'button button-primary button-small',
                  text : '<i class="icon-remove"></i>启用',
                  listeners : {
                    'click' : enableFunction
                  }
                },
                {
                  btnCls : 'button button-primary button-small',
                  text : '<i class="icon-remove"></i>停用',
                  listeners : {
                    'click' : disableFunction
                  }
                }]
            },
            plugins : [editing,Grid.Plugins.CheckSelection],
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
						 href:'${basePath}/jsp/gift/editSysGift.jsp?id='+record.id,
						 closeable:true,
						 title:'系统礼物修改'
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
        //添加记录
        function addFunction(){
          var newData = {b : 0};
          editing.add(newData,'a',0); //添加记录后，直接编辑
        }
        
        function enableFunction(){
        	var selections = grid.getSelection();
            if(selections.length<1){
				alert("请至少选择一条待开启数据！");
			}else{
				var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				var status = 2;
				jQuery.post('${basePath}/gift/changeSysGiftStatus.do',{ids:ids,status:status},function(data){
				   if(data){
		             	alert("已开启");
		             	store.load();
		             }else{
		             	alert("开启失败。");
		             	store.load();
		             }
				});
			}
        }
        
        function disableFunction(){
        	var selections = grid.getSelection();
            if(selections.length<1){
				alert("请至少选择一条待停用数据！");
			}else{
				var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				var status = 3;
				jQuery.post('${basePath}/gift/changeSysGiftStatus.do',{ids:ids,status:status},function(data){
				   if(data){
		             	alert("已停用");
		             	store.load();
		             }else{
		             	alert("停用失败。");
		             	store.load();
		             }
				});
			}
        }
        //删除选中的记录
        function delFunction(){
          var selections = grid.getSelection();
          if(selections.length<1){
				alert("请至少选择一条待删除数据！");
			}else{
				 var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				 jQuery.post('${basePath}/gift/deleteSysGift.do',{ids:ids},function(data){
				   if(data){
		             	alert("已删除");
		             	store.load();
		             }else{
		             	alert("删除失败。");
		             	store.load();
		             }
				});
			}
        }          
      });
    </script>
</body>
</html> 
