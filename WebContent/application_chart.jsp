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
<title>柱状图统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 统计管理 <span class="c-gray en">&gt;</span> 柱状图统计 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="f-14 c-error"></div>
	<div id="container" style="min-width:700px;height:400px"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script type="text/javascript">
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
var summaryId,projectId;
summaryId = Request['summaryId'];
projectId = Request['projectId'];
//summaryId = '6';
//projectId = '13';
$(function () {
	var params={
			"summaryId":summaryId,
			"projectId":projectId,
	} 
	//var xData = ["12","121"];  
	
	$.ajax({    
	       type: "post",      
	       url: "/repay/applicationSummary.do",    
	       data: JSON.stringify(params),
	       dataType: "json",   
	       contentType: "application/json; charset=utf-8",   
	       success: function(data){
	    	   var xData = [];
	    	  
	    	   	var itemCost = [];
	    	   	var itemBudgetCost = [];
		       	for(var k = 0; k < data.length; k++){
		       		xData.push(data[k].itemName);	
		       		itemCost.push(data[k].itemCost);
		       		itemBudgetCost.push(data[k].itemBudgetCost);
		       	}
	      		
	       	    $('#container').highcharts({
	       	        chart: {
	       	            type: 'column'
	       	        },
	       	        title: {
	       	            text: '项目预算与申报费用柱形图'
	       	        },
	       	        subtitle: {
	       	            text: ''
	       	        },
	       	        
	       	        tooltip: {
	       	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	       	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	       	                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
	       	            footerFormat: '</table>',
	       	            shared: true,
	       	            useHTML: true
	       	        },
	       	        plotOptions: {
	       	            column: {
	       	                pointPadding: 0.2,
	       	                borderWidth: 0
	       	            }
	       	        },
	       	        xAxis: {
	       	            categories: xData
	       	        },
	       	        yAxis: {
	       	            min: 0,
	       	            title: {
	       	                text: '万元'
	       	            }
	       	        },
	       	        series: [  {
	       	            name: '费用',
	       	            data: itemCost

	       	        }, {
	       	            name: '预算',
	       	            data: itemBudgetCost

	       	        }  ]
	       	    });
			},
	       error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
		});
	

    
	

});	
function application(){	
 	 var params={
 			"summaryId":summaryId,
 			"projectId":projectId,
	} 
	  $.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/applicationSummary.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
        	itemId
			itemName = data[i].itemName;
			itemBudgetCost = data[i].itemBudgetCost;
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	});
}
</script>
</body>
</html>
