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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
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
<title>项目预算列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 项目预算管理 <span class="c-gray en">&gt;</span> 项目预算列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名称" id="" name="">
		<button type="submit" class="btn btn-success" id="searchItem" name="searchBudget" onclick = "searchItem();"><i class="Hui-iconfont">&#xe665;</i> 搜预算项目</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">  <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">项目预算列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">ID</th>
				<th width="40">项目编号</th>
				<th width="40">总计</th>
				<th width="40">自筹和配套</th>
				<th width="40">向省厅申请</th>
				<th width="40">查看项目预算</th>
				<th width="100">修改</th>
			</tr>
		</thead>
		<tbody id = 'tbody-allBudget'>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/



$(document).ready(function (){
	$('body').on('click','#update',function(event){
		var ss = this.title;
		var st = ss.split(";");
		var params = {
				"projectId":st[1],
		}
		$.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/searchProject.do",  
	        data: JSON.stringify(params),
	        dataType: "json", 
	        contentType: "application/json; charset=utf-8",   
	        error: function(data){  
	        	alert("出错了！！:"+data.msg);
	        } , 
	        success: function(data) { 
	        	//alert(data.isBudget)
	        	if(data.isBudget == 1){
	        		layer_show('修改项目预算','budget_update.jsp?'+st[0],'800','500');
	        	}
	        	else{
	        		layer.msg('报销单已创建，无法修改!',{icon:2,time:1000});
	        	}	 
	        } 
			
		}); 
	}); 
	
	$('body').on('click','#budgetSee',function(event){
		layer_show('查看预算','budget_see.jsp?projectId='+this.title,'800','500');
	}); 
	//加载页面数据
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/loadAllBudget.do",  
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	var str = "";  
    		for(var i = 0; i < data.length; i++){
    			str += "<tr class='text-c'>"+
				"<td>"+(i+1)+"</td>"+
				"<td>"+data[i].projectId+"</td>"+
				"<td>"+data[i].budgetSum+"</td>"+
				"<td>"+data[i].independentFees+"</td>"+
				"<td>"+data[i].applyFees+"</td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'budgetSee' href='javascript:;' title='"+data[i].projectId+"'>"+
					"<i class='Hui-iconfont'>&#xe695;</i>"+
				"</a>"+
				"</td>";
				str+="<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' title='budgetId="+data[i].budgetId+"&projectId="+data[i].projectId+";"+data[i].projectId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
				"</a>"+
				"</td></tr>";
        		}
        	
        	$("#tbody-allBudget").html(str);  
        	 
        }     
    });

})

function searchBudget(){
	var params={
	    	"searchBudget":document.getElementById("searchBudget").value,
	}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/loadBudget.do",  
        data: JSON.stringify(params),
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	var str = "";  
        	for(var i = 0; i < data.length; i++){
    			str += "<tr class='text-c'>"+
				"<td>"+data[i].budgetId+"</td>"+
				"<td>"+data[i].projectId+"</td>"+
				"<td>"+data[i].budgetSum+"</td>"+
				"<td>"+data[i].independentFees+"</td>"+
				"<td>"+data[i].applyFees+"</td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].budgetId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
				"</a>"+
				"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+data[i].budgetId+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
				"</a>"+
				"</td></tr>";
        		}
        	$("#tbody-allBudget").html(str);  
        }
        }
    );
}
</script>
</body>
</html>