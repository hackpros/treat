<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>系统功能信息列表</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />  
 </head>
 <body>
  <div class="demo-content" style="margin-top: 30px;">
    <div class="row">
      <form id="searchForm" class="form-horizontal span24">
        <div class="row">
          <div class="control-group span8">
            <label class="control-label">功能编码：</label>
            <div class="controls">
              <input type="text" class="control-text" name="functionCode">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">功能名称：</label>
            <div class="controls">
              <input type="text" class="control-text" name="functionName">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span9">
            <div class="controls" >
            </div>
          </div>
          <div>
            <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
            <button  type="reset" id="btnSearch" class="button button-primary">重置</button>
          </div>
        </div>
      </form>
    </div>
    <div class="search-grid-container" style="margin-top: 30px;">
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
      	  {title:'功能编码',dataIndex:'functionCode',width:100,elCls : 'center'},
      	  {title:'功能名称',dataIndex:'functionName',width:300,elCls : 'center'},
          {title:'连接地址',dataIndex:'linkUrl',width:300,elCls : 'center'},
          {title:'操作',dataIndex:'',elCls : 'center',width:80,renderer : function(value,obj){
            var editStr =  Search.createLink({ //链接使用 此方式
                id : 'edit' + obj.login_name,
                title : '菜单功能',
                text : '  编辑  ',
                href : '${basePath}/toEditFunction.do?id='+obj.id
              });
            return editStr;
          }}
        ],
      store = Search.createStore('${basePath}/getFunctionList.do',{
      autoLoad:true,
      pageSize :10,
      root : 'functionlist',
      totalProperty : 'total',
      forceFit:true
      }),
      gridCfg = Search.createGridCfg(columns,{
        tbar : {
          	items : [
            {text : '<i class="icon-plus"></i>新建', btnCls : 'button button-primary button-small',handler:function(){addFunction();}},
          ]
        },
         
      });

    var  search = new Search({
        store : store,
        gridCfg : gridCfg 
      }),
      grid = search.get('grid');
     
    //新增用户
    function addFunction(){
       window.location.href ='${basePath}/toEditFunction.do'; 
    }
    
    function delItems(items){
      var ids = [];
      BUI.each(items,function(item){
        ids.push(item.id);
      });

    }
  });
</script>

<body>
</html>  
