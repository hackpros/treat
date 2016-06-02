<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 角色管理列表</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />  
 </head>
 <body>
  <div class="demo-content" >
    <div class="row">
      <form id="searchForm" class="form-horizontal span24">
      </form>
    </div>
    <div class="search-grid-container" style="margin-top:50px;">
      <div id="grid"></div>
    </div>
  </div>
<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
<script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
<script type="text/javascript">
  BUI.use('common/page');
</script>
<script type="text/javascript">
  BUI.use(['common/search','bui/overlay'],function (Search,Overlay) {
      columns = [
      	   {title:'角色编号',dataIndex:'id',elCls : 'center',width:100},
      	  {title:'角色名称',dataIndex:'roleName',width:600,elCls : 'center'},
          {title:'操作',dataIndex:'',elCls : 'center',width:80,renderer : function(value,obj){
            var editStr =  Search.createLink({ //链接使用 此方式
                id : 'edit' + obj.login_name,
                title : '菜单功能',
                text : '  编辑  ',
                href : '${basePath}/toEditRole.do?id='+obj.id
              });
            return editStr;
          }}
        ],
      store = Search.createStore('${basePath}/getUserTypelist.do',{
      autoLoad:true,
      pageSize :10,
      root : 'roleList',
      totalProperty : 'total',
      forceFit:true
      }),
      gridCfg = Search.createGridCfg(columns,{
        tbar : {
          	items : [
            {text : '<i class="icon-plus"></i>新建', btnCls : 'button button-primary button-small',handler:function(){addRole();}},
          ]
        },
         
      });

    var  search = new Search({
        store : store,
        gridCfg : gridCfg 
      }),
      grid = search.get('grid');
     
    //新增角色
	function addRole(){
		window.location.href ='${basePath}/toEditRole.do'; 
	}
    
  });
</script>

<body>
</html>  
