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
	Login ${loginStatus}...
</body>
	<script type="text/javascript">
		var loginStatus = ${loginStatus};
		var context_ = '${context_}';
		
		$(document).ready(function(){
			if(loginStatus == true){
				window.location.href = context_ + "/admin/manager";
			}
			if(loginStatus == false){
				window.location.href = context_ + "/admin/login";
			}
		});
	</script>
</html>