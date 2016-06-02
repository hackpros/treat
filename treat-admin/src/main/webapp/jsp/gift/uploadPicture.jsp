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
        //图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          //var MAXWIDTH  = 200; 
          //var MAXHEIGHT = 200;
          var div = document.getElementById('preview');
          if (file.files && file.files[0]){
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
              var width = img.offsetWidth;
              var height = img.offsetHeight;
                var rect = clacImgZoomParam1(img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//              img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              $("#preview").width(width);
              $("#preview").height(height);
              $("#imghead").attr("width", width);
              $("#imghead").attr("height", height);
              $("#width").attr("value", width);
              $("#height").attr("value", height);
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);
          }else{
            //兼容IE
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam1(img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam1( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            return param;
        }
        
        function upload(){ 
	    	if($("#img").val()==""){
	    		alert("请选择图片后再上传！");
	    		return false;
	    	}else{
	  			var url = "${basePath}/gift/uploadGiftPic1.do?id="+$("#id").val();
			   	document.headForm.action = url;
			    document.headForm.submit();  
	    	} 
		} 
		$(document).ready(function(e) {
		    	var id = "";
		    	if(${param.id}){
			    	id = ${param.id};
		    	}
		    	jQuery.post('${basePath}/gift/getGiftInfo.do',{id:id},function(data){
		    	     if(data){
		    	     	 $("#oldImghead").attr("src",data.imageUrl);
			    	 }
				});
		    });
	//display:none
</script>

</head>
<body>
	<form name="headForm" action="" method="post"
		enctype="multipart/form-data" id="headForm">
		<div style="display:none">
			<input id="id" name="id" value="${param.id}" />
		</div>
		<div id="preview1" style="display:block">
			<img id="oldImghead" name="oldImghead" border=1
				src=''></img>
		</div>
		<div id="preview" style="display:block">
			<img id="imghead" name="imghead" width=200 height=200 border=1
				src='<%=request.getContextPath()%>/login/img/123.jpg'></img>
		</div>
		<div>
			宽度：<input id="width" name="width" value="200" />
		</div>
		<div>
			高度：<input id="height" name="height" value="200" />
		</div>
		<input type="file" id="img" name="img" onchange="previewImage(this)" /> <input
			type="button" value="上传" onclick="upload()" />
	</form>
</body>
</html>
