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
<title>项目列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 项目管理 <span class="c-gray en">&gt;</span> 项目列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名称" id="" name="">
		<button type="submit" class="btn btn-success" id="searchItem" name="searchItem" onclick = "searchProject();"><i class="Hui-iconfont">&#xe665;</i> 搜项目</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a  href="javascript:;" onclick="project_add('添加项目','project_add.jsp','800','400')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加项目</a></span>   </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">项目列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">ID</th>
				<th width="40">单位</th>
				<th width="40">项目经费代码</th>
				<th width="40">出差事由</th>
				<th width="40">查看</th>
				<th width="40">状态</th>
				<th width="40">修改</th>
				<th width="40">删除</th>
			</tr>
		</thead>
		<tbody id = 'tbody-allProject'>
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
	$('body').on('click','#update',function(event){
		layer_show('项目编辑','repay_update.jsp?repayId='+this.title,'800','500');
	}); 
	$('body').on('click','#repaySee',function(event){
		layer_show('查看','repay_see.jsp?repayId='+this.title,'800','500');
	}); 
	$('body').on('click','#delete',function(event){
		var repayId = this.title;
		layer.confirm('确认要删除吗？',function(){
			var params={
			    	"repayId":repayId,
			}
			$.ajax({
				type: 'POST',
				url: '/repay/deleteRepay.do',
				data: JSON.stringify(params),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				success: function(data){
					layer.msg('已删除!',{icon:1,time:1000});
					window.location.href = 'user_repay.jsp';
					
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}); 
	//加载页面数据
	var params={
			    	"userId":getCookie("userId"),
			}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/loadAllRepayByUId.do",  
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
				"<td>"+(i+1)+"</td>"+
				"<td>"+data[i].company+"</td>"+
				"<td>"+data[i].projectId+"</td>"+
				"<td>"+data[i].reason+"</td>";
				str+="<td class='td-manage'><a style='text-decoration:none' id = 'repaySee' href='javascript:;'   title='"+data[i].repayId+"'>"+
				"<i class='Hui-iconfont'>&#xe695;</i>"+
				"</a></td>";
				if(data[i].applicationId == null || data[i].applicationId == ''){
					str += "<td>未审核</td>";
					str+="<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].repayId+"'"+
						"<i class='Hui-iconfont'>&#xe6df;</i>"+
					"</a>"+
					"</td>";
					str+="<td class='td-manage'><a style='text-decoration:none' id = 'delete' href='javascript:;'   title='"+data[i].repayId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a></td>";
				}
				else if(data[i].applicationId == '-1'){
					str += "<td>审核未通过</td>";
					str+="<td class='td-manage'>"+
					"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].repayId+"'"+
						"<i class='Hui-iconfont'>&#xe6df;</i>"+
					"</a>"+
					"</td>";
					str+="<td class='td-manage'><a style='text-decoration:none' id = 'delete' href='javascript:;'   title='"+data[i].repayId+"'>"+
						"<i class='Hui-iconfont'>&#xe6e2;</i>"+
					"</a></td>";
				}
				else{
					str += "<td>审核通过</td>";
					str+="<td class='td-manage'>"+
					"<a style='text-decoration:none' "+
						"<i class='Hui-iconfont'>&#xe6dd;</i>"+
					"</a>"+
					"</td>";
					str+="<td class='td-manage'><a style='text-decoration:none'>"+
						"<i class='Hui-iconfont'>&#xe6dd;</i>"+
					"</a></td>";
				}
        	$("#tbody-allProject").html(str);  
    	} 
        }     
    });

})

function searchProject(){
	var params={
	    	"searchProject":document.getElementById("searchProject").value,
	}
	$.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/loadProject.do",  
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
				"<td>"+(i+1)+"</td>"+
				"<td>"+data[i].projectName+"</td>"+
				"<td>"+data[i].projectType+"</td>"+
				"<td>"+data[i].projectTypeId+"</td>"+
				"<td>"+data[i].field+"</td>"+
				"<td>"+data[i].fieldId+"</td>"+
				"<td>"+data[i].source+"</td>"+
				"<td>"+data[i].sourceId+"</td>"+
				"<td>"+data[i].startData+"</td>"+
				"<td>"+data[i].endData+"</td>"+
				"<td class='td-manage'>"+
				"<a style='text-decoration:none' id = 'update' href='javascript:;' title='"+data[i].projectId+"'>"+
					"<i class='Hui-iconfont'>&#xe6df;</i>"+
				"</a>"+
				"<a style='text-decoration:none' id = 'delete' href='javascript:;' title='"+data[i].projectId+"'>"+
					"<i class='Hui-iconfont'>&#xe6e2;</i>"+
				"</a>"+
				"</td></tr>";

        		}
        	$("#tbody-allProject").html(str);  
        	 
        }     
    });
}
</script>
</body>
</html>