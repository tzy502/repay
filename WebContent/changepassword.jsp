<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>浙江大学城市学院出差报销单</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<div class="loginWraper">

  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="index.html" method="post">
      <div class="row cl">
        <label class="form-label col-xs-4"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-4">
          <input id="oldPassword" name="oldPassword" type="password" placeholder="旧密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-4">
          <input id="password1" name="password1" type="password" placeholder="新密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-4"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-4">
          <input id="password2" name="password2" type="password" placeholder="重复新密码" class="input-text size-L">
        </div>
      </div>



      <div class="row cl">
        <div class="formControls col-xs-4 col-xs-offset-4">
         	<input name="" type="button"  onclick = 'register()' class="btn btn-success radius size-L" value="&nbsp;确&nbsp;&nbsp;&nbsp;&nbsp;认&nbsp;">
         	 <input name="" type="reset"   class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
function getCookie(Name){
	var search = Name + "="//查询检索的值
	   var returnvalue = "";//返回值
	   if (document.cookie.length > 0) {
	     sd = document.cookie.indexOf(search);
	     if (sd!= -1) {
	        sd += search.length;
	        end = document.cookie.indexOf(";", sd);
	        if (end == -1)
	         end = document.cookie.length;
	         //unescape() 函数可对通过 escape() 编码的字符串进行解码。
	        returnvalue=unescape(document.cookie.substring(sd, end))
	      }
	   } 
	   return returnvalue;
}
function register(){
	var password1 = document.getElementById("password1").value;
	var password2 = document.getElementById("password2").value
	if(password1  != password2){
		layer.msg('两次新密码不一致!',{icon:2,time:1000});
		return false;
	}
	var params={
	    	"userId": getCookie("userId"),
	    	"oldPassword":document.getElementById("oldPassword").value,
	    	"newPassword":document.getElementById("password1").value,
	}
	
	     $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/changePassword.do",    
	        data: JSON.stringify(params),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){
	        	if(data.msg == "succ"){
	        		layer.msg('修改密码成功!',{icon:1,time:1000});
	        		var index = parent.layer.getFrameIndex(window.name);
	        		parent.$('.btn-refresh').click();
	        		parent.layer.close(index);
	        	}
	        	else{
	        		layer.msg(data.msg,{icon:2,time:1000});
	        	}
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
		});
	
}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
