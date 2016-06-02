<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 表格跟弹出框联动</title>
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
  
  <div class="container">
     <form id ="J_Form" action="/zh_bank/register.do" class="form-horizontal" method="post">
      <!--    -->
      <h3>基本信息</h3>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>登录名：</label>
          <div class="controls">
            <input name="login_name" type="text" class="control-text" data-rules="{required:true}">
          </div>
        </div>
        <div class="control-group span12">
          <label class="control-label"><s>*</s>密码：</label>
          <div class="controls">
            <input name="pass_word" type="password" class="control-text" data-rules="{required:true}">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label">性别：</label>
          <div class="controls">
            <select name="sex">
              <option value="0">男</option>
              <option value="1">女</option>
            </select>
          </div>
        </div>
        <div class="control-group12 span12">
          <label class="control-label">公司：</label>
          <div class="controls">
            <input name="company" type="text" class="control-text">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>真实姓名：</label>
          <div class="controls">
            <input name="username" type="text" class="span8 span-width control-text"  data-rules="{required:true}">
          </div>
        </div>
        <div class="control-group span12">
          <label class="control-label"><s>*</s>职务：</label>
          <div class="controls">
            <input name="depart" type="text" class="span8 span-width control-text"  data-rules="{required:true}">
          </div>
        </div>
      </div>
       <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>年龄：</label>
          <div class="controls">
            <input name="age" type="text" class="span8 span-width control-text"  data-rules="{required:true}">
          </div>
        </div>
         <div class="control-group span12">
          <label class="control-label"><s>*</s>用户类型：</label>
           <div class="controls">
            <select name="type">
              <option value="0">普通用户</option>
              <option value="1">管理员</option>
            </select>
          </div>
        </div>
      </div>
      <hr/>
      <h3>联系方式</h3>
      <div class="row">
        <div class="control-group span12">
          <label class="control-label"><s>*</s>手机：</label>
          <div class="controls">
            <input name="moblie" type="text" class=" control-text  span8 span-width" data-rules="{required:true}">
          </div>
        </div>
        <div class="control-group span12">
          <label class="control-label">电话：</label>
          <div class="controls bui-form-group" data-rules="{dateRange:true}" >
            <input name="phone" type="text" class=" control-text  span8 span-width" >
          </div>
        </div>
      </div>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label"><s>*</s>邮箱：</label>
          <div class="controls">
            <input type="mail" class="control-text span8 span-width" >
          </div>
        </div>
        
      </div>
      <div class="row">
        <div class="control-group span24">
          <label class="control-label">地址：</label>
          <div class="controls control-row4">
            <textarea name="address" id="" class="span8 span-width"></textarea>
          </div>
        </div>
      </div>
      <hr/>
      
      <div class="row">
        <div class="form-actions offset3">
          <button type="submit" class="button button-primary">保存</button>
          <button type="reset" class="button">重置</button>
        </div>
      </div>
    </form>
  </div>
  <script type="text/javascript" src="${basePath}/bui/assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="${basePath}/bui/assets/js/bui-min.js"></script>

  <script type="text/javascript" src="${basePath}/bui/assets/js/config-min.js"></script>
<script type="text/javascript">
  BUI.use(['bui/grid','bui/data','bui/form'],function (Grid,Data,Form) {

     

    var form = new Form.HForm({
      srcNode : '#J_Form'
    });
    form.render();
    var field = form.getField('eduation');
    form.on('beforesubmit',function(){
      var records = store.getResult();
      field.set('value',BUI.JSON.stringify(records));
    });
  });
</script>

<body>
</html> 