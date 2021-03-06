﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
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
<title>用户列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户管理 <span class="c-gray en">&gt;</span> 用户列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名称" id="" name="">
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="admin_add('添加用户','user_add.jsp','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span>   </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">用户列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">ID</th>
				<th width="40">用户名</th>
				<th width="40">职位</th>
				<th width="40">手机号</th>
				<th width="40">重置密码</th>
				<th width="40">修改</th>
				<th width="40">删除</th>			
			</tr>
		</thead>
		<tbody id = 'tbody-alluser'>
			<!-- <tr class='text-c'>
				<td>2ss</td>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td class='td-manage'>
					<a style='text-decoration:none' onClick='resetPassword(this,'1')' href='javascript:;' title='重置密码'>
						<i class='Hui-iconfont'>&#xe6f7;</i>
					</a> 
					<a title='编辑' href='javascript:;' onclick='admin_edit('用户编辑','user_update.jsp','2','800','500')' class='ml-5' style='text-decoration:none'>
						<i class='Hui-iconfont'>&#xe6df;</i>
					</a> 
					<a title='删除' href='javascript:;' onclick='admin_del(this,'1')' class='ml-5' style='text-decoration:none'>
						<i class='Hui-iconfont'>&#xe6e2;</i>
					</a>
				</td>
			</tr> -->
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
	$('body').on('click','#reset',function(event){
		var userId = this.title;
		layer.confirm('确认要重置密码吗？',function(index){
			var params={
			    	"userId":userId,
			}
			$.ajax({
				type: 'POST',
				url: '/repay/resetPassword.do',
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				success: function(data){
					layer.msg('已重置!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}); 
	$('body').on('click','#update',function(event){
		//alert(this.title);
		layer_show('用户编辑','user_update.jsp?userId='+this.title,'800','500');
	}); 
	$('body').on('click','#delete',function(event){
		var userId = this.title;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"userId":userId,
			}
			$.ajax({
				type: 'POST',
				url: '/repay/deleteUser.do',
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				success: function(data){
					layer.msg('已删除!',{icon:1,time:1000});
					window.location.href = 'admin_user.jsp';
					
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}); 
	
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/loadAllUser.do",  
        dataType: "json", 
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) { 
        	var str = "";  
    		for(var i = 0; i < data.length; i++){
    			str += "<tr class='text-c'>"+
				"<td>"+data[i].userId+"</td>"+
				"<td>"+data[i].userName+"</td>"+
				"<td>"+data[i].userJob+"</td>"+
				"<td>"+data[i].userPhone+"</td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'reset'  href='javascript:;' title='"+data[i].userId+"''>"+
					"<i class='Hui-iconfont'>&#xe6f7;</i>"+
				"</a></td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].userId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
				"</a></td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+data[i].userId+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
				"</a>"+
				"</td></tr>";

        		}
        	
        	$("#tbody-alluser").html(str);  
        	 
        }     
    });

})





</script>
</body>
</html>