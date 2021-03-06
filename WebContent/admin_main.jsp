﻿<%@ page language="java" contentType="text/html; charset=utf-8"
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
<title>发票报销系统</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" >发票报销系统</a> 
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
				<ul class="cl">
					<li>管理员</li>
					<li class="dropDown dropDown_hover">
						<a href="#" class="dropDown_A"><i class='Hui-iconfont'>&#xe60a;</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" title= '修改密码' onclick="changePassword('修改密码','changepassword.jsp','700','300')"><i class='Hui-iconfont'>&#xe63f;</i>修改密码</a></li>
							<li><a href="javascript:;" title= '注销' onclick = 'reset()'><i class='Hui-iconfont'>&#xe726;</i>注销</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-user">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="admin_user.jsp" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-permission">
			<dt><i class="Hui-iconfont">&#xe6e0;</i> 权限管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="aa-userlist.html" data-title="用户管理" href="javascript:void(0)">权限管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-travel">
			<dt><i class="Hui-iconfont">&#xe687;</i> 报销项目管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="item_list.jsp" data-title="总报销项目管理" href="javascript:void(0)">总报销项目管理</a></li>
					<li><a data-href="schoolitem_list.jsp" data-title="学校报销项目管理" href="javascript:void(0)">学校报销项目管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-travel">
			<dt><i class="Hui-iconfont">&#xe687;</i> 项目管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="project_list.jsp" data-title="项目管理" href="javascript:void(0)">项目管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-travel">
			<dt><i class="Hui-iconfont">&#xe687;</i> 预算管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="budget_list.jsp" data-title="预算管理" href="javascript:void(0)">预算管理</a></li>
				</ul>
			</dd>
		</dl>
		
		
		<dl id="menu-travel">
			<dt><i class="Hui-iconfont">&#xe687;</i> 出差报销单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="repay_list.jsp" data-title="出差报销单管理" href="javascript:void(0)">出差报销单管理</a></li>
				</ul>
			</dd>
		</dl>
		
		
		<dl id="menu-travel">
			<dt><i class="Hui-iconfont">&#xe687;</i> 汇总单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="summary_list.jsp" data-title="汇总单管理" href="javascript:void(0)">汇总单管理</a></li>
				</ul>
			</dd>
		</dl>
		
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="用户管理" data-href="admin_user.jsp">用户管理</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="admin_user.jsp"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
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
$(document).ready(function (){
	var userId = getCookie("userId");
	
}) 

function changePassword(title,url,w,h){
	layer_show(title,url,w,h);
}

function reset(){
//注销
	document.cookie="userId=''";
    window.location.href = 'login.jsp';
    /* $.ajax({    
       type: "post",    
       async: true,    
       url: "/repay/reset.do",    
       dataType: "json",   
       contentType: "application/json; charset=utf-8",   
       success: function(data){
       	if(data.msg == "succ"){
       		layer.msg('注销成功!',{icon:1,time:1000});
       		document.cookie="userId=''";
       		window.location.href = 'login.jsp';
       	}
       	else{
       		layer.msg(data.msg,{icon:2,time:1000});
       	}
		},
       error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	}); */
}
</script> 

<!--/此乃百度统计代码，请自行删除-->
</body>
</html>