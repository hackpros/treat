<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片上传本地预览</title>
<style type="text/css">
#preview {
	width: 200px;
	height: 200px;
	border: 1px solid #000;
	overflow: hidden;
}

#imghead {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
}
</style>
<script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
        function upload(){ 
	    	if($("#sensitiveWordFile").val()==""){
	    		alert("请选择图片后再上传！");
	    		return false;
	    	}else{
	  			var url = "${basePath}/sensitiveWord/uploadSensitiveWordFile.do";
			   	document.headForm.action = url;
			    document.headForm.submit();  
	    	} 
		} 
</script>

</head>
<body>
	<form name="headForm" action="" method="post"
		enctype="multipart/form-data" id="headForm">
		<input type="file" id="sensitiveWordFile" name="sensitiveWordFile"/> <input
			type="button" value="上传" onclick="upload()" />
	</form>
</body>
</html>
