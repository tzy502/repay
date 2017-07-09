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
<title>添加汇总单</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add">
	<table class="table table-border table-bordered" id = 'budget'>
			<tr>
				<th width = '20'>单位（公章）</th>
				<td width = '20%'><input type='text' placeholder='' id = 'company' class='input-text radius size-S'></td>
				<td width = '20%'>经费项目代码</td>
				<td width = '10%'><input type='text' placeholder='' id = 'projectId' class='input-text radius size-S'></td>
				<td width = '20%'>单据张数</td>
				<td width = '10%'><input type='text' placeholder='' id = 'billCount' class='input-text radius size-S'></td>
			</tr>	
	</table>
	
	<table class="table table-border table-bordered" id = 'project'>
		<tbody id = 'tbody-itemCost'>
		</tbody>
	</table>
	
	
	<table class="table table-border table-bordered" id = 'budget'>
		<tbody id = 'tbody-budget'>
			<tr>
				<th width = '15%' >工号</th>
				<th width = '15%' >姓名</th>
				<th width = '45%' >建行卡号</th>
				<th width = '15%' >转卡金额</th>
			</tr>
			<tr>
				<td width = '15%'><input type="text" id = 'workerId' class="input-text radius size-S"></td>	
				<td width = '15%'><input type="text" id = 'userName' class="input-text radius size-S"></td>	
				<td width = '45%'><input type="text" id = 'cardNumber' class="input-text radius size-S"></td>	
				<td width = '15%'><input type="text" id = 'money' class="input-text radius size-S"></td>		
			</tr>
		</tbody>
	</table>
	
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick = "addSummary()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
var projectId,projectName, isBudget;
projectId = Request['projectId'];
projectName = Request['projectName'];
isBudget = Request['isBudget'];
$(document).ready(function (){
    $("#projectId").val(projectId);
})

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

$(document).ready(function (){
	$.ajax({    
        type: "post",        
        url: "/repay/loadAllSchoolItem.do",  
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
    			str+="<tr><th width = '20%'>"+data[i].schoolItemName+"</th>"+
    			"<input type='hidden' value ='"+data[i].schoolItemName+"' id='schoolItemName"+i+"' name = 'schoolItemName"+i+"'>"+
    			"<td width = '60%'><input type='text'  id='schoolItem"+i+"'  name = 'schoolItem"+i+"' class='input-text radius size-S'></td></tr>";
        	}	
        	$("#tbody-itemCost").html(str);
        }     
    });
	

})
	function addSummary(){
		var itemCost = [];
		for(var i = 0; i < j; i++){
			var item = {
					"itemCostName":document.getElementById("schoolItemName"+i).value,
					"itemCost":document.getElementById("schoolItem"+i).value,
			}
			itemCost.push(item);
    	}
	 	 var params={
	 			"userId":getCookie("userId"),
	 			"projectId":document.getElementById("projectId").value,
		    	"billCount":document.getElementById("billCount").value,
		    	"company":document.getElementById("company").value,
		    	"workerId":document.getElementById("workerId").value,
		    	"workerName":document.getElementById("userName").value,
		    	"cardNumber":document.getElementById("cardNumber").value,
		    	"money":document.getElementById("money").value,
		    	"manager":"",
		    	"applicationId":"",
		} 
		
		params["itemCost"]=itemCost; 
		alert(JSON.stringify(params));
		  $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/addSummary.do",    
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
		  
		  if(isBudget == 2){
		    	isBudget = 4;
		    }
		    else{
		    	isBudget = 3;
		    }	
		    var params={
			 			"projectId":document.getElementById("projectId").value,
				    	"isBudget":isBudget,
			} 
		    $.ajax({    
			        type: "post",    
			        async: true,    
			        url: "/repay/applySuccProject.do",    
			        data: JSON.stringify(params),
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