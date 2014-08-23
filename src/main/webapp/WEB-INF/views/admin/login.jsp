<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生网校</title>


</head>
<body>
	<div class="container" style="margin-top: 100px">
		<form action="${pageContext.request.contextPath}/admin/doLogin" method="post" class="well"
			style="width: 220px; margin: 0px auto;">
			<h3>网校后台登录入口</h3>
			<s:if test="#request.error!=null">
			<div class="control-group ">
				<div class="alert alert-error span2">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<s:property value="#request.error" />
				</div>
			</div>
		</s:if>
			<label>用户名:</label> 
			<input type="text" name="username" value="${username}"	style="height: 30px" class="span3" /> 
			<label>密码：</label> <input type="password" name="password" style="height: 30px" class="span3" />
			<button type="submit" class="btn btn-primary">登陆系统</button>
		</form>
	</div>
	

</body>
</html>