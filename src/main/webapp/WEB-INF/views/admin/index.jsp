<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	pageContext.setAttribute("context_", context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript" src="<%=context %>/views/Scripts/jquery-1.4.1.js"></script>
	Login ${loginStatus}...<span id="message"></span>
</body>
	<script type="text/javascript">
		var loginStatus = ${loginStatus};
		var captchaStatus = ${captchaStatus};
		
		var context_ = '${context_}';
		
		$(document).ready(function(){
			if(loginStatus == true){
				setTimeout(window.location.href = context_ + "/admin/manager",10000);
			}
			if(loginStatus == false){
				if(captchaStatus == false){
					$("#message").html("验证码错误！");
				}
				setTimeout(window.location.href = context_ + "/admin/login",10000);
			}
		});
	</script>
</html>