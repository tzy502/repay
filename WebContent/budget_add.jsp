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
<title>添加项目预算</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add">
	<table class="table table-border table-bordered" id = 'project'>
		<tbody id = 'tbody-project'>
		</tbody>
	</table>
	<table class="table table-border table-bordered" id = 'budget'>
		<tbody id = 'tbody-budget'>
			<tr>
				<th width = '20'>项目经费预算</th>
				<td width = '40%' colspan='2'>自筹和配套</td>
				<td width = '40%' colspan='2'>向省厅申请</td>
			</tr>	
			<tr>
				<th width = '20%'></th>
				<td width = '40%' colspan='2'><input type='text' placeholder='' id = 'independentFees' class='input-text radius size-S'></td>
				<td width = '40%' colspan='2'><input type='text' placeholder='' id = 'applyFees' class='input-text radius size-S'></td>
			</tr>
		</tbody>
	</table>
	<table class="table table-border table-bordered">
		<tbody>
			<tr>
				<th width = '20%'>项目总经费开支预算</th>
				<th width = '80%'><table class="table table-border table-bordered" >
					<tbody id = 'tbody-itemBudget'>
					</tbody>
					</table>	
				</th>
			</tr>	
		</tbody>
	</table>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick = "addBudget()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
var j = 0;
function GetRequest() {   
	   var url = location.search; 
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}   
var Request = new Object(); 
Request = GetRequest(); 
var projectId;
projectId = Request['projectId']; 
$(document).ready(function (){
	var params = {
			"projectId":projectId,
	}
	$.ajax({    
        type: "post",        
        url: "/repay/searchProject.do", 
        data:JSON.stringify(params),
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	var str = "<tr><th width = '20'>项目名称</th><td width = '80%' colspan='4'>"+data.projectName+"</td></tr>"+
        	"<tr><th width = '20%'>项目计划类别</th><td width = '40%' colspan='2'>"+data.projectType+"</td><td width = '20%'>代码</td><td width = '20%'>"+data.projectTypeId+"</td></tr>"+
        	"<tr><th width = '20%'>技术管理领域</th><td width = '40%' colspan='2'>"+data.field+"</td><td width = '20%'>代码</td><td width = '20%'>"+data.fieldId+"</td></tr>"+
        	"<tr><th width = '20%'>项目技术来源</th><td width = '40%' colspan='2'>"+data.source+"</td><td width = '20%'>代码</td><td width = '20%'>"+data.sourceId+"</td></tr>"+
    		"<tr><th width = '20%'>开始日期</th><td width = '20%' >"+data.startDate+"</td></td><td width = '20%' >完成日期</td><td width = '40%' colspan='2'>"+data.endDate+"</td></td></tr>"+
        	"<input type = 'hidden' value = '"+data.projectId+"' id = 'projectId'>";	
        	$("#tbody-project").html(str);
        }     
    });
	
	$.ajax({    
        type: "post",        
        url: "/repay/loadAllItem.do",  
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	var str = "";  
    		for(var i = 0; i < data.length; i++){
    			j++;
    			//alert("出错了！！:");
    			str+="<tr><th width = '20%'>"+data[i].itemName+"</th>"+
    			"<input type='hidden' value ='"+data[i].itemName+"' id='itemName"+i+"' name = 'itemName"+i+"'>"+
    			"<input type='hidden' value ='"+data[i].itemId+"' id='itemId"+i+"' name = 'itemId"+i+"'>"+
    			"<td width = '60%'><input type='text'  id='item"+i+"'  name = 'item"+i+"' class='input-text radius size-S'></td></tr>";
        	}	
        	$("#tbody-itemBudget").html(str);
        }     
    });
	

})
	function addBudget(){
		var itemBudget = [];
	 	var params={
	 			"projectId":document.getElementById("projectId").value,
		    	"independentFees":document.getElementById("independentFees").value,
		    	"applyFees":document.getElementById("applyFees").value,
		} 
		for(var i = 0; i < j; i++){
			var item = {
					"oItemId":document.getElementById("itemId"+i).value,
					"itemName":document.getElementById("itemName"+i).value,
					"itemBudgetCost":document.getElementById("item"+i).value,
			}
			itemBudget.push(item);
    	}
		params["itemBudget"]=itemBudget;
		//alert(JSON.stringify(params));
	     $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/addBudget.do",    
	        data: JSON.stringify(params),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){
				layer.msg('添加成功!',{icon:1,time:1000});
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
		});
	    var param={
		 			"projectId":document.getElementById("projectId").value,
			    	"isBudget":1,
		} 
	    $.ajax({    
		        type: "post",    
		        async: true,    
		        url: "/repay/applySuccProject.do",    
		        data: JSON.stringify(param),
		        dataType: "json",   
		        contentType: "application/json; charset=utf-8",   
		        success: function(data){

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