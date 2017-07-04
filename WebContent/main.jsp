<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>  
<script type="text/javascript" src="js/jquery.min.js"></script> 
<body>
	main
	<div id="a"></div>

<Script language="javascript">   
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
	var userName, userId;
	userName = Request['userName']; 
	userId = Request['userId'];
	document.getElementById("a").innerHTML="userId:"+userId+";userName:"+userName;
</script>  
</body>

</html>