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
<title>汇总单审核</title>
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
		<input class="btn btn-primary radius" type="button" onclick = "chart()" value="&nbsp;&nbsp;查看图表&nbsp;&nbsp;">
			<input class="btn btn-primary radius" type="button" onclick = "application()" value="&nbsp;&nbsp;审核通过&nbsp;&nbsp;">
			<input class="btn btn-primary radius" type="button" onclick = "noApplication()" value="&nbsp;&nbsp;审核不通过&nbsp;&nbsp;">
				
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
var summaryId;
summaryId = Request['summaryId'];


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
	var parmas = {
			"summaryId":summaryId,
	}
	$.ajax({    
        type: "post",        
        url: "/repay/searchSummary.do",  
        async: true,  
        data:JSON.stringify(parmas),
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
         	$("#company").val(data.company);
        	$("#projectId").val(data.projectId);
        	$("#billCount").val(data.billCount);
        	$("#workerId").val(data.workerId);
        	$("#userName").val(data.userName);
        	$("#cardNumber").val(data.cardNumber);
        	$("#money").val(data.money); 
        }     
    });
	$.ajax({    
        type: "post",        
        url: "/repay/searchItemCostBySId.do",  
        data:JSON.stringify(parmas),
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
    			str+="<tr><th width = '20%'>"+data[i].itemCostName+"</th>"+
    			"<input type='hidden' value ='"+data[i].itemCostName+"' id='itemCostName"+i+"' name = 'itemCostName"+i+"'>"+
    			"<td width = '60%'><input type='text'  id='itemCost"+i+"' value = '"+data[i].itemCost+"' name = 'itemCost"+i+"' class='input-text radius size-S'></td></tr>";
        	}	
        	$("#tbody-itemCost").html(str);
        }     
    });
})




function application(){
 	var params = {
			"summaryId":summaryId,
			"applicationId":getCookie("userId"),
			"manager":getCookie("userId"),
	}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/summaryApplication.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
			layer.msg('审核成功!',{icon:1,time:1000});
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	});
	
 	var isBudget;
 	var params = {
 			"projectId":document.getElementById("projectId").value,
	}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/searchProject.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
			isBudget = data.isBudget;
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	});
 	
	if(isBudget == 5){
    	isBudget = 7;
    }
    else{
    	isBudget = 6;
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
	        	var index = parent.layer.getFrameIndex(window.name);
	        	parent.$('.btn-refresh').click();
	    		parent.layer.close(index); 
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
	});  
	
	//window.location.href = 'application_chart.jsp?summaryId='+summaryId+'&projectId='+document.getElementById("projectId").value;
/* 	 var params={	
	 		"projectId":document.getElementById("projectId").value,
	 		"summaryId":summaryId,
		} 
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/applicationSummary.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
			layer.msg('添加成功!',{icon:1,time:1000});
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	}); */
}
function noApplication(){
 	var params = {
			"summaryId":summaryId,
			"applicationId":'-1',
			"manager":'-1',
	}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/summaryApplication.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
			layer.msg('审核成功!',{icon:1,time:1000});
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	});
	
 

 	
		
    var params={
	 			"projectId":document.getElementById("projectId").value,
		    	"isBudget":-1,
	} 
    $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/applySuccProject.do",    
	        data: JSON.stringify(params),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){
	        	var index = parent.layer.getFrameIndex(window.name);
	        	parent.$('.btn-refresh').click();
	    		parent.layer.close(index); 
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
	}); 
}
function chart(){
	window.location.href = 'application_chart.jsp?summaryId='+summaryId+'&projectId='+document.getElementById("projectId").value;

}
 
  

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>