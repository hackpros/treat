<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>用户详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${basePath}/bui/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/bui/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/bui/assets/css/page-min.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		input{
		    border:0;
		    width:148px;
		    height:30px;
		    font-size:16px;
		    padding:0 5px;
		    line-height:30px;
		}
		.item{
		    padding:3px 5px;
		    cursor:pointer;
		}
		.addbg{
		    background:#87A900;
		}
		.first{
		    border:solid #C3C3D6 1px;
		    width:150px;
		}
		#append{
		    border:solid #87A900 2px;
		    border-top:0;
		    display:none;
		}
		</style>
	</head>
	<body>
		<div class="search-grid-container">
			<div id="grid">
			</div>
		</div>
		<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
		<script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>
		<script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
		<script src="${basePath}/bui/assets/js/acharts.js"></script>
		<script type="text/javascript">
		  		BUI.use(['common/search','bui/overlay'],function (Search,Overlay) {
		   		var male ;
		   		var sexEnum = {"0":"男","1":"女"},
		     		columns = [
		     	  {title:'编号',dataIndex:'userId',width:100,elCls : 'center'},
		          {title:'充值统计',dataIndex:'rechargeCount',width:100,elCls : 'center'},
		          {title:'账户余额',dataIndex:'accountBalance',width:100,elCls : 'center'},
		          {title:'线上活动统计',dataIndex:'onlineCount',width:100,elCls : 'center'},
		          {title:'线下活动统计',dataIndex:'offlineCount',width:100,elCls : 'center'},
		          {title:'感应统计',dataIndex:'interactionCount',width:100,elCls : 'center'},
		          {title:'好友统计',dataIndex:'friendCount',width:100,elCls : 'center'},
		          {title:'魅力值',dataIndex:'charm',width:100,elCls : 'center'},
		          {title:'皇冠',dataIndex:'crown',width:100,elCls : 'center'},
		          {title:'鸽子',dataIndex:'pigeon',width:100,elCls : 'center'},
		        ],
		      store = Search.createStore('${basePath}/user/userCountDetail.do?userId='+${param.userId},{
		      autoLoad:true,
		      pageSize :10,
		      params : {
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		      },
		      root : 'userDetailList',
		      totalProperty : 'total',
		      }),
		      gridCfg = Search.createGridCfg(columns,{
		        tbar : {
		          items : [
		          ]
		        },
		      });
		      
			    var  search = new Search({
			        store : store,
			        gridCfg : gridCfg
			      }),
			      grid = search.get('grid');
			    //监听事件，删除一条记录
			    grid.on('cellclick',function(ev){
			      	var record = ev.record, //点击行的记录
			        field = ev.field, //点击对应列的dataIndex
			        target = $(ev.domTarget); //点击的元素
			         if(target.hasClass('btn1')){
						if(top.topManager){
							top.topManager.openPage({
							     id:'',
							     href:'${basePath}/jsps/data/all_stautus_detail.jsp?mobile='+record.mobile,
							     closeable:true,
							     title:'用户详情'
							});
				        }
			        }
			    });
		  });
		</script>
	<body>
</html>
