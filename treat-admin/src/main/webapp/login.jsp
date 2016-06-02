<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>掌航后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/login/css/base.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/login/css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/login/css/bsp.css" />
    <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${basePath}/login/js/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="${basePath}/login/js/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${basePath}/login/css/login.css" />
    <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 0.7, dir: 'right', depth: 10 });
            $('.login').click(function () {
                getVcode();
                if ($('#uid').val() == "" || $('#pwd').val() == "") { 
                $('.tip').html('用户名或密码不可为空！');
                return;
                }else if($("#code").val().toLocaleLowerCase()!= $('#vcode').val().toLocaleLowerCase()){
                $('.tip').html('验证码错误');
                return;
                }else {
                  $("#sub").attr("action","login.do");
		          $("#sub").submit(); 
                }
            })
            checkLogin();
        })
        function getVcode(){
           $.ajax({
                type: "POST",
                url: 'getVcode.do',
                async: false, 
                cache: false,
                success: function (notice) {
                            if (notice != null) {//得到返回的json，并赋值
                               $("#vcode").val(notice);
                            }
                }
            });
				
        }
        function checkLogin(){
           var status = $("#status").val();
            if(status==null || status=="")return;
            if(status==1){
            $('.tip').html('请输入正确的密码！'); 
            }else if(status==2){
            $('.tip').html('该用户不存在！'); 
            }else if(status==0){
              location.href = 'index.jsp';
            }
        }
        function refresh(obj) {
        obj.src = "imageServlet?"+Math.random();
        }
    </script>
</head>
<body>
    <input type = "hidden" id = "status" value = "${status}">
    <input type = "hidden" id = "vcode" >
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>
    <form action="" id = "sub" name = "sub" method="post">
    <div class="row-fluid">
        <h1>杭州掌航后台管理系统</h1>
        <p>
            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="uid" name = "login_name" style="width:200px; height:26px;"/></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password"  id="pwd" name = "pwd" style="width:200px; height:26px;" /></label>
        </p>
        <p class="pcode">
            <label>验证码：<input type="text" id="code" maxlength="5" class="code" style="width:100px; height:24px;" />
            <img src="imageServlet" title="点击更换" class="imgcode" onclick="javascript:refresh(this);" />
            </label>
        </p>
        <p class="tip">&nbsp;</p>
        <hr />
        <input type="button" value=" 登 录 " class="btn btn-primary btn-large login" />
        &nbsp;&nbsp;&nbsp;<input type="button" value=" 取 消 " class="btn btn-large" />
    </div>
    </form>
</body>
</html>
