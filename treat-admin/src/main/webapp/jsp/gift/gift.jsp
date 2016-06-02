<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>礼物管理</title>
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
			
			function goEditPic(id){
				alert(id);
				jQuery.post('${basePath}/gift/goEditPic.do',{id:id});
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
	    			<td class="td-right">礼物id：</td>
	    			<td >
	    				<input name="id" type="text" class="control-text" >
	    			</td>
	    		</tr>
	    		<tr class="tr-height">
	    			<td class="td-right">礼物名称：</td>
	    			<td >
	    				<input name="name" type="text" class="control-text" >
	    			</td>
	    		</tr>
	    		<tr class="tr-height">
	    			<td class="td-right">商品类型：</td>
	    			<td >
	    				<select name="category" id="category" >
	    					<option value="">全部</option>
							<option value="1">饮料</option>
			                <option value="2">酒水</option>
			                <option value="3">日用</option>
			                <option value="4">零食</option>
			                <option value="5">特殊</option>
			                <option value="9">系统</option>
						</select>
	    			</td>
	    			<td class="td-right">热门选择：</td>
	    			<td >
	    				<select name="hotGift" id="hotGift" >
	    					<option value="">全部</option>
							<option value="1">热门</option>
							<option value="0">非热门</option>
						</select>
	    			</td>
	    			<td class="td-right">新品选择：</td>
	    			<td >
	    				<select name="newGift" id="newGift" >
	    					<option value="">全部</option>
							<option value="1">新品</option>
							<option value="0">非新品</option>
						</select>
	    			</td>
	    		</tr>
	    		<tr class="tr-height">
	    			<td class="td-right">上架时间：</td>
	    			<td colspan="">
	    				<input name="release_start_time" type="text" class="calendar" readonly="readonly">
						<span> - </span>
						<input name="release_end_time" type="text" class="calendar" readonly="readonly">
					</td>
	    		</tr>
	    		<tr class="tr-height">
	    			<td class="td-right">上架状态：</td>
	    			<td>
	    				<select name="status" id="status" >
	    					<option value="">全部</option>
							<option value="1">未上架</option>
							<option value="2">上架中</option>
							<option value="3">已下架</option>
						</select>
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
						<s>*</s>商品名称：
					</label>
					<div class="controls">
						<input name="name" type="text" data-rules="{required:true}"
							class="input-normal control-text" maxlength="25">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>礼物单位：
					</label>
					<div class="controls">
						<input name="unit" type="text" data-rules="{required:true}" >
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>价格：
					</label>
					<div class="controls">
						<input name="price" type="text"
							data-rules="{required:true,number : true}"
							class="input-normal control-text" maxlength="5">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>礼物类型：
					</label>
					<div class="controls">
						<select name="category" id="category" >
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
						<select name="hotGift" id="hotGift" >
							<option value="0">非热门</option>
							<option value="1">热门</option>
						</select>
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label">
						<s>*</s>是否新品：
					</label>
					<div class="controls">
						<select name="newGift" id="newGift" >
							<option value="0">非新品</option>
							<option value="1">新品</option>
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
	    	    {title:'礼物Id',dataIndex:'id',width:40,elCls : 'center'},
	    	    {title:'礼物名称',dataIndex:'name',elCls : 'center'},
	    	    {title:'礼物单位',dataIndex:'unit',elCls : 'center'},
				{title:'礼物描述',dataIndex:'description',elCls : 'center'},
				{title:'礼物图片',dataIndex:'imageUrl',elCls : 'center',renderer : function(value,obj){
		            if(obj.imageUrl != null && obj.imageUrl != ""){
		           		return "<a><img src='"+obj.imageUrl+"'style='max-height:50px;'>";
		            }else{
		            	return "<a><font color='pink'>暂无图片</font>";
		            }
	      	 	 }},
				{title:'礼物价格',dataIndex:'price',elCls : 'center'},
				{title:'上架时间',dataIndex:'ctime',renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'更新时间',dataIndex:'mtime',renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
				{title:'上架状态',dataIndex:'status',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"未上架","2":"上架中","3":"已下架"})},
	    	    {title:'礼物类型',dataIndex:'category',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"1":"饮料","2":"酒水","3":"日用","4":"零食","5":"特殊","9":"系统"})},
	    	    {title:'热门',dataIndex:'hotGift',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"false":"否","true":"是"})},
	    	    {title:'新品',dataIndex:'newGift',width:40,elCls : 'center',renderer:BUI.Grid.Format.enumRenderer({"false":"否","true":"是"})},
	    	    {title:'销售量',dataIndex:'sellCount',width:40},
	    	    {title : '操作',elCls : 'center',renderer : function(value,obj){
	            	//return '<a href="<%=request.getContextPath()%>/gift/goEditPic.do?id='+obj.id+'" text-align="center">编辑图片</a>'
	            	//return '<a href="<%=request.getContextPath()%>/news.do?method=edit">编辑新闻</a>'
	            	//return '<button class="button button-mini button-success" style="margin:8px;border:1px" onclick="goEditPic('+obj.id+')">编辑图片</button>';
	            	return '<span class="grid-command btn2">编辑图片</span>'
            	}},
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
                  url = '${basePath}/gift/addGift.do';
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
            url :'${basePath}/gift/getGiftList.do',
		    autoLoad:true,
		    pageSize:10,
		      root : 'giftList',
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
                  text : '<i class="icon-ok"></i>上架',
                  listeners : {
                    'click' : enableFunction
                  }
                },
                {
                  btnCls : 'button button-primary button-small',
                  text : '<i class="icon-remove"></i>下架',
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
						 href:'${basePath}/jsp/gift/editGift.jsp?id='+record.id,
						 closeable:true,
						 title:'礼物修改'
					});
				}
			 }
			 if(target.hasClass('btn2')){
				if(top.topManager){
					top.topManager.openPage({
						 id:'',
						 href:'${basePath}/jsp/gift/uploadPicture.jsp?id='+record.id,
						 closeable:true,
						 title:'图片编辑'
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
				jQuery.post('${basePath}/gift/changeGiftStatus.do',{ids:ids,status:status},function(data){
				   if(data){
		             	alert("已上架");
		             	store.load();
		             }else{
		             	alert("上架失败。");
		             	store.load();
		             }
				});
			}
        }
        
        function disableFunction(){
            var selections = grid.getSelection();
            if(selections.length<1){
				alert("请至少选择一条待开启数据！");
			}else{
				var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				var status = 3;
				jQuery.post('${basePath}/gift/changeGiftStatus.do',{ids:ids,status:status},function(data){
				   if(data){
		             	alert("已下架");
		             	store.load();
		             }else{
		             	alert("下架失败。");
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
				 jQuery.post('${basePath}/gift/deleteGift.do',{ids:ids},function(data){
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
