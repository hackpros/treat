<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%response.addHeader("Access-Control-Allow-Origin","*"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>敏感词管理</title>
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
		 
		 <script type="text/javascript">
		 </script>
		 <script language="javascript"> 
			function goEditPic(id){
				alert(id);
				jQuery.post('${basePath}/gift/goEditPic.do',{id:id});
			}
		</script> 
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
							<td class="td-right">敏感词id：</td>
							<td><input name="id" type="text" class="control-text">
							</td>
						</tr>
						<tr class="tr-height">
							<td class="td-right">敏感词：</td>
							<td><input name="sensitiveWord" type="text"
								class="control-text"></td>
						</tr>
						<tr class="tr-height">
							<td class="td-right">上传时间：</td>
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
				<form name="headForm" action="" method="post"
					enctype="multipart/form-data" id="headForm">
					<input type="file" id="sensitiveWordFile" name="sensitiveWordFile" />
					<input type="button" value="上传" onclick="upload()" />
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
						<s>*</s>敏感词：
					</label>
					<div class="controls">
						<input name="sensitiveWord" type="text" data-rules="{required:true}"
							class="input-normal control-text" maxlength="25">
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
	    	    {title:'敏感词Id',dataIndex:'id',width:40,elCls : 'center'},
	    	    {title:'敏感词',dataIndex:'sensitiveWord',elCls : 'center'},
				{title:'上传时间',dataIndex:'ctime',renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
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
                  url = '${basePath}/sensitiveWord/addSensitiveWord.do';
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
            url :'${basePath}/sensitiveWord/getSensitiveWordList.do',
		    autoLoad:true,
		    pageSize:100,
		      root : 'sensitiveWordList',
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
                  text : '<i class="icon-remove"></i>重置缓存',
                  listeners : {
                    'click' : refreshFunction
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
        function refreshFunction(){
			jQuery.post('${basePath}/sensitiveWord/refreshSensitiveWordCache.do',function(data){
				if(data){
					alert("已重新初始化敏感詞緩存");
					store.load();
				}else{
					alert("删除失败。");
					store.load();
				}
			});
		}     
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
					 jQuery.post('${basePath}/sensitiveWord/deleteSensitiveWord.do',{ids:ids},function(data){
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
      

		function upload() {
			if ($("#sensitiveWordFile").val() == "") {
				alert("请选择图片后再上传！");
				return false;
			} else {
				var url = "${basePath}/sensitiveWord/uploadSensitiveWordFile.do";
				document.headForm.action = url;
				document.headForm.submit();
			}
		}
	</script>
</body>
</html> 
