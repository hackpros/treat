<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户渠道列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet"
	type="text/css" />
<link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet"
	type="text/css" />
<link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
code {
	padding: 0px 4px;
	color: #d14;
	background-color: #f7f7f9;
	border: 1px solid #e1e1e8;
}
</style>
</head>
<body>
	<div class="demo-content" style="margin-top: 30px;">
		<div class="row">
			<form id="searchForm" class="form-horizontal span24">
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">渠道编码：</label>
						<div class="controls">
							<input type="text" class="control-text" name="code">
						</div>
					</div>
					<div class="control-group span8">
						<label class="control-label">渠道名称：</label>
						<div class="controls">
							<input type="text" class="control-text" name="source">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">状态：</label>
						<div class="controls">
							<select name="review" id="review">
								<option value="">请选择</option>
								<option value="0">正常</option>
								<option value="1">注销</option>
							</select>
						</div>
					</div>
					<div>
						<button type="button" id="btnSearch" class="button button-primary">搜索</button>
						<button type="reset" id="btnSearch" class="button button-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<!-- 初始隐藏 dialog内容 -->
		<div id="content" class="hide">
			<form class="form-horizontal" method="post">
				<div class="row">
					<div class="control-group span8">
						<label class="control-label">
							<s>*</s>渠道编码：
						</label>
						<div class="controls">
							<input name="code" type="text" data-rules="{required:true}"
								class="input-normal control-text" maxlength="25">
						</div>
						<label class="control-label">
							<s>*</s>渠道名称：
						</label>
						<div class="controls">
							<input name="source" type="text" data-rules="{required:true}"
								class="input-normal control-text" maxlength="25">
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="search-grid-container">
			<div id="grid"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript"
		src="${basePath}/bui/assets/js/bui-min.js"></script>
	<script type="text/javascript"
		src="${basePath}/bui/assets/js/config-min.js"></script>
	
	<script type="text/javascript">
        BUI.use(['bui/grid','bui/data'],function(Grid,Data){
        var reviewEnum = {"0":"正常","1":"注销"};
        var Grid = Grid,
        Store = Data.Store,
        columns = [
      	  {title:'渠道ID',dataIndex:'id',width:100,elCls : 'center'},
      	  {title:'渠道',dataIndex:'source',width:150,elCls : 'center'},
      	  {title:'编码',dataIndex:'code',width:100,elCls : 'center'},
          {title:'状态',dataIndex:'review',width:80,renderer:BUI.Grid.Format.enumRenderer(reviewEnum),elCls : 'center'},
          {title:'操作',dataIndex:'',elCls : 'center',width:120,renderer : function(value,obj){
	          if(obj.review==0){
	              var delStr = "<a href='#' onclick='logoutResource("+obj.id+")'>  注销</a>";
	              return delStr ;
	          }else{
	          	 var jhStr = "<a href='#' onclick='activation("+obj.id+")'> 激活</a>";
	          	 return jhStr;
	          }
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
                  url = '${basePath}/userSource/addUserSource.do';
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
            url :'${basePath}/userSource/getUserSourceList.do',
		    autoLoad:true,
		    pageSize:100,
		      root : 'userSourceList',
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
        //删除选中的记录
        function delFunction(){
          var selections = grid.getSelection();
          if(selections.length<1){
				alert("请至少选择一条待删除数据！");
			}else{
				 for(var i = 0;i<selections.length;i++){
					  if(selections[i].review == 0){
					  	alert("不可删除正在使用的渠道,渠道：" + selections[i].id);
					  	return false;
					  }
				  }
				 var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				 jQuery.post('${basePath}/userSource/deleteUserSource.do',{ids:ids},function(data){
				   if(data){
		             	store.load();
		             }else{
		             	alert("删除失败。");
		             	store.load();
		             }
				});
			}
        }          
      });
      
      function logoutResource(id){
			if(confirm("您确定要注销该渠道吗？")){
				window.location.href="${basePath}/userSource/logout.do?id="+id;
			}
		}
		
		function activation(id){
			if(confirm("您确定要激活该渠道吗？")){
				window.location.href="${basePath}/userSource/activation.do?id="+id;
			}
		}
    </script>
<body>
</html>
