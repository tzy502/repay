<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>添加项目</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container" id = 'form-item-add'>
	<form class="form form-horizontal" >
	<div class="row cl">
		<table class="table table-border table-bordered" id = 'project'>
		<tbody id = 'tbody-project'>
			<tr>
				<th width = '20'>项目名称</th>
				<td width = '80%' colspan='4'><input type="text" class="input-text" value="" placeholder="" id="projectName" name="projectName"></td>
			</tr>
			<tr>
				<th width = '20%'>项目计划类别</th>
				<td width = '40%' colspan='2'><input type="text" class="input-text" value="" placeholder="" id="projectType" name="projectType"></td>
				<td width = '20%'>代码</td>
				<td width = '20%'><input type="text" class="input-text" value="" placeholder="" id="projectTypeId" name="projectTypeId"></td>
			</tr>
			<tr>
				<th width = '20%'>技术管理领域</th>
				<td width = '40%' colspan='2'><input type="text" class="input-text" value="" placeholder="" id="field" name="field"></td>
				<td width = '20%'>代码</td>
				<td width = '20%'><input type="text" class="input-text" value="" placeholder="" id="fieldId" name="fieldId"></td>
			</tr>	
			<tr>
				<th width = '20%'>项目技术来源</th>
				<td width = '40%' colspan='2'><input type="text" class="input-text" value="" placeholder="" id="source" name="source"></td>
				<td width = '20%'>代码</td>
				<td width = '20%'><input type="text" class="input-text" value="" placeholder="" id="sourceId" name="sourceId"></td>
			</tr>	
			<tr>
				<th width = '20%'>开始日期</th>
				<td width = '20%' ><input type="text" onfocus="WdatePicker()" id="startData" class="input-text Wdate" style="width:120px;"></td>
				<td width = '20%' >完成日期</td>
				<td width = '40%' colspan='2'><input type="text" onfocus="WdatePicker()" id="endData" class="input-text Wdate" style="width:120px;"></td>
			</tr>
		</tbody>
	</table>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-2 col-sm-offset-2">
			<input class="btn btn-primary radius" type="button" onclick = "addProject()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>

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

function addProject(){
	layer.msg('添加!'+getCookie("userId"),{icon:1,time:1000});
	var project={
			"userId":getCookie("userId"),
	    	"projectName":document.getElementById("projectName").value,
	    	"projectType":document.getElementById("projectType").value,
	    	"projectTypeId":document.getElementById("projectTypeId").value,
	    	"field":document.getElementById("field").value,
	    	"fieldId":document.getElementById("fieldId").value,
	    	"source":document.getElementById("source").value,
	    	"sourceId":document.getElementById("sourceId").value,
	    	"startDate":document.getElementById("startData").value,
	    	"endDate":document.getElementById("endData").value, 
	}
	     $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/addProject.do",    
	        data: JSON.stringify(project),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){
				layer.msg('添加成功!',{icon:1,time:1000});
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
		});
		var index = parent.layer.getFrameIndex(window.name);
		parent.$('.btn-refresh').click();
		parent.layer.close(index);
 
}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>