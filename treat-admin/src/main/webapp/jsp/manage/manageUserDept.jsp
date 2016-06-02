<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门管理</title>
		<link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet">
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet">
	</head>
	<body>
		<div class="demo-content">
			<div class="row">
				<div class="span16">
					<div id="grid">

					</div>
				</div>
			</div>
			<!-- 初始隐藏 dialog内容 -->
			<div id="content" class="hide">
				<form class="form-horizontal" method="post"  target='frameFile' enctype="multipart/form-data">
					<div class="row">
						<div class="control-group span8">
							<label class="control-label">
								<s>*</s>部门名称：
							</label>
							<div class="controls">
								<input name="deptname" type="text"
									data-rules="{required:true}"
									class="input-normal control-text">
							</div>
						</div>
					</div>
				</form>
				<iframe id='frameFile' name='frameFile' style='display: none;'></iframe>
			</div>

		<script src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
    	<script src="${basePath}/bui/assets/js/bui-min.js"></script>
		<script type="text/javascript">
        BUI.use(['bui/grid','bui/data'],function(Grid,Data){
            var Grid = Grid,
          Store = Data.Store,
          columns = [
            {title:'id',dataIndex:'id',width:10,elCls : 'center'},
      	    {title:'部门',dataIndex:'deptname',width:100,elCls : 'center'},
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
                  url = '${basePath}/addUserDept.do';
                }
                url += '?saveType=' + editType;
 
                //检验
                form.valid();
                if(form.isValid()){
                  form.ajaxSubmit({ //表单异步提交
                    url : url,
                    success : function(data){
                      if(editType == 'add'){
                      	if(data.result==1){
                        	alert("添加成功");
                        	store.load();
                        }else{
                        	alert("部门名称已存在");
                        	store.load();
                        }
                      }else{
	                      if(data.result==1){
	                        	alert("修改成功");
	                        	store.load(); 
	                        }else{
	                        	alert("修改失败");
	                        	store.load();
	                        }
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
            url : '${basePath}/getUserDeptList.do',
            autoLoad:true,
            pageSize:10,
		    root : 'deptlist',
		     totalProperty : 'total',
          }),
          grid = new Grid.Grid({
            render:'#grid',
            columns : columns,
            width : 1000,
            forceFit : true,
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
            store : store,
             bbar : {
		   //items 也可以在此配置
		   // pagingBar:表明包含分页栏
		   pagingBar:true
		   }
          });
 
        grid.render();
 		grid.on('cellclick',function  (ev) {
          var record = ev.record, //点击行的记录
            field = ev.field, //点击对应列的dataIndex
            target = $(ev.domTarget); //点击的元素
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
				 var ids ="";
				for(var i = 0;i<selections.length-1;i++){
					ids += selections[i].id+",";
				}
				ids += selections[selections.length-1].id;
				 jQuery.post('${basePath}/deleteDept.do',{ids:ids},function(data){
		              if(data.result==1){
		             	alert("删除成功");
		             	store.load(); 
		             }else{
		             	alert("id为"+data.result+"的部门正在使用中！");
		             	store.load();
		             }
				});
			}
          
        }          
      });
    </script>
			<!-- script end -->
		</div>
	</body>
</html>
