<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 用户管理列表</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />  
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
      <form id="searchForm" class="form-horizontal span30">
        <div class="row">
          <div class="control-group span8">
            <label class="control-label">登录名：</label>
            <div class="controls">
              <input type="text" class="control-text" name="loginName">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">角色：</label>
            <div class="controls" >
              <select id="rolename" name="type">
                <option value="">请选择</option>
              </select>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span8">
            <label class="control-label">性别：</label>
            <div class="controls" >
              <select id="" name="sex">
                <option value="">请选择</option>
                <option value="0">男</option>
                <option value="1">女</option>
              </select>
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">部门：</label>
            <div class="controls" >
              <select id="deptid" name="deptid">
                <option value="">请选择</option>
              </select>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span8">
            <label class="control-label">真实姓名：</label>
            <div class="controls">
              <input type="text" class="control-text" name="username">
            </div>
          </div>
          <div >
            <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
            <button  type="reset" id="btnSearch" class="button button-primary">重置</button>
          </div>
        </div>
      </form>
    </div>
    <div class="search-grid-container">
      <div id="grid"></div>
    </div>
  </div>
<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
<script type="text/javascript">
	BUI.use('common/page');
	//重置密码
	function resetPassword(id){
		 if(confirm("重置后的密码为：123456。您确定要重置密码吗？")){
		 	window.location.href="${basePath}/resetPassword.do?id="+id;
		 }
	}
	//注销
	function logoutUser(id){
		if(confirm("您确定要注销该用户吗？")){
			window.location.href="${basePath}/logoutUser.do?id="+id;
		}
	}
	//获取查询条件中的role
	$(document).ready(function(e) {
    	jQuery.post('${basePath}/getRolelist.do',function(data){
             if(data){
             	var select=$("#rolename");
			    for(var i=0;i<data.length;i++){
		    		var option=document.createElement("option");				        
		    		option.setAttribute("type","option");
			        option.setAttribute("id",data[i].id);
			        option.setAttribute("value", data[i].id);
			        option.appendChild(document.createTextNode(data[i].roleName));
					select.append(option);
					
			    }
             }
		});
		
		jQuery.post('${basePath}/getDeptlist.do',function(data){
             if(data){
             	var select=$("#deptid");
			    for(var i=0;i<data.length;i++){
		    		var option=document.createElement("option");				        
		    		option.setAttribute("type","option");
			        option.setAttribute("id",data[i].id);
			        option.setAttribute("value", data[i].id);
			        option.appendChild(document.createTextNode(data[i].deptname));
					select.append(option);
					
			    }
             }
		});
	});
	
	function activation(id){
		if(confirm("您确定要激活该用户吗？")){
			window.location.href="${basePath}/activationUser.do?id="+id;
		}		
	}
	
	function deleted(id){
		if(confirm("您确定要删除该用户吗？")){
			window.location.href="${basePath}/deleteManageUser.do?id="+id;
		}		
	}
</script>
<script type="text/javascript">
  BUI.use(['common/search','bui/overlay'],function (Search,Overlay) {
    
    var sexEnum = {"0":"男","1":"女"};
    var flagEnum = {"0":"正常","1":"注销"};
      columns = [
      	  {title:'部门',dataIndex:'deptname',width:100,elCls : 'center'},
      	  {title:'角色',dataIndex:'rolename',width:150,elCls : 'center'},
          {title:'登录名',dataIndex:'login_name',width:100,elCls : 'center'},
          {title:'真实名称',dataIndex:'username',width:150,elCls : 'center'},
          {title:'联系电话',dataIndex:'phone',width:100,elCls : 'center'},
          {title:'性别',dataIndex:'sex',width:80,renderer:BUI.Grid.Format.enumRenderer(sexEnum),elCls : 'center'},
          {title:'年龄',dataIndex:'birthday',width:80,elCls : 'center'},
          {title:'注册时间',dataIndex:'ctime',width:150,renderer:BUI.Grid.Format.datetimeRenderer,elCls : 'center'},
          {title:'用户状态',dataIndex:'flag',width:80,renderer:BUI.Grid.Format.enumRenderer(flagEnum),elCls : 'center'},
          {title:'操作',dataIndex:'',elCls : 'center',width:200,renderer : function(value,obj){
	        if(obj.flag == 0){
	          	 var editStr =  Search.createLink({ //链接使用 此方式
	                id : 'edit' + obj.login_name,
	                title : '用户信息',
	                text : '编辑资料  ',
	                href : '${basePath}/toEditUser.do?loginName='+obj.login_name
	              });
	              var editStr1 =  Search.createLink({ //链接使用 此方式
	                id : 'edit' + obj.login_name,
	                title : '用户信息',
	                text : '权限管理  ',
	                href : '${basePath}/toEditUserRole.do?id='+obj.id
	              });
	              cancelStr = "   <a href='#' onclick='logoutUser("+obj.id+")' title='用户信息'>注销</a>";
	              resetStr = "   <a href='#' onclick='resetPassword("+obj.id+")' title='用户信息'>重置密码</a>";
	              return editStr + editStr1 + cancelStr + resetStr;
	          }else{
	          	  jhStr = "   <a href='#' onclick='activation("+obj.id+")' title='用户信息'>  激活  </a>";
	          	  delStr = "   <a href='#' onclick='deleted("+obj.id+")' title='用户信息'>  删除  </a>";
	          	  return jhStr + delStr;
	          }
            
          }}
        ],
      store = Search.createStore('${basePath}/getUserList.do',{
      autoLoad:true,
      pageSize :10,
      params : {
            
      },
      root : 'userlist',
      totalProperty : 'total',
      }),
      gridCfg = Search.createGridCfg(columns,{
        tbar : {
          items : [
            {text : '<i class="icon-plus"></i>新建用户', btnCls : 'button button-primary button-small',handler:function(){addUser();}},
            {text : '<i class="icon-plus"></i>角色管理', btnCls : 'button button-primary button-small',handler:function(){manageUserRole();}},
            {text : '<i class="icon-plus"></i>部门管理', btnCls : 'button button-primary button-small',handler:function(){manageUserDept();}},
          ]
        },
         
      });

    var  search = new Search({
        store : store,
        gridCfg : gridCfg
      }),
      grid = search.get('grid');
    //删除操作
    function delFunction(){
      var selections = grid.getSelection();
      if(selections==""){
      	BUI.Message.Alert("请选择要删除的用户！");
      }
      delItems(selections);
      
    }
      
    //新增用户
    function addUser(){
       window.location.href ='${basePath}/toEditUser.do'; 
    }
    function manageUserRole(){
	   top.topManager.openPage({
		  id : '',
		  href : 'jsp/manage/manageUserRole.jsp',
		  title : '角色管理'
		}); 
    }
    function manageUserDept(){
       top.topManager.openPage({
	    id : '',
	    href : 'jsp/manage/manageUserDept.jsp',
	    title : '部门管理'
	  }); 
    }
    function delItems(items){
      var ids = [];
      BUI.each(items,function(item){
        ids.push(item.id);
      });

      if(ids.length){
        BUI.Message.Confirm('确认要删除选中的记录么？',function(){
          $.ajax({
            url : '${basePath}/delUser.do?ids='+ids,
            dataType : 'json',
            success : function(data){
              if(data){ //删除成功
                BUI.Message.Alert('删除成功！');
                search.load();
              }else{ //删除失败
                BUI.Message.Alert('删除失败！');
              }
            }
        });
        },'question');
      }
    }

    //监听事件，删除一条记录
    grid.on('cellclick',function(ev){
      var sender = $(ev.domTarget); //点击的Dom
      if(sender.hasClass('btn-del')){
        var record = ev.record;
        delItems([record]);
      }
    });
  });
  
 $(function(){
	if("${msg}" == 1){
		alert("该信息已注销，不能编辑");
	}
 });
  
 
</script>

<body>
</html>  
