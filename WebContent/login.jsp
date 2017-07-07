<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>  
<script type="text/javascript" src="js/jquery.min.js"></script> 
<body>
<h2>登录</h2>
	userId:<input type="text" name="userId" id="userId"/>
	<p>
	password:<input type="password" name="password" id="password"/>
	<p>
	 <input type="submit" value="登录" onclick="ajaxTest();"/>  
	 <div id="result"></div> 
<script type="text/javascript">

function ajaxTest() { 
	var params={
	    	"userId":document.getElementById("userId").value,
	    	"password":document.getElementById("password").value,
	}
    $.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/login.do",    
  		data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        error: function(data){  
        	alert("出错了！！:"+data.msg);
        } , 
        success: function(data) {  
        	/* alert("success:"+data.msg);   */
            $("#result").html(data.msg) ;   
            if (data.msg == "true") {//根据返回值进行跳转
            	alert("登陆成功！！");
                window.location.href = 'main.jsp?userName='+data.userName+'&userId='+data.userId;
            }
            else{
            	alert(data.msg);
            }
        }     
    }); 
}  
</script>
</body>
</html>
