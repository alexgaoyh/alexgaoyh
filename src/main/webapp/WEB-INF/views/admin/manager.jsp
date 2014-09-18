<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String context = request.getContextPath();
	pageContext.setAttribute("context_", context);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Manager</title>
	<script type="text/javascript" src="<%=context %>/views/Scripts/jquery-1.4.1.js"></script>
</head>
<body>

	<c:forEach var="leftMenu" items="${sysmanResourceList}">
		<li class="">
			<a href="javascript:;"> 
				<i class="icon-cogs"></i> <span class="title"><c:out value="${leftMenu.name }"></c:out></span> <span class="arrow "></span>
			</a>
			<c:if test="${leftMenu.subResource != null||leftMenu.subResource.length > 0}">
				<ul class="sub-menu">
					<c:forEach var="leftSubMenu" items="${leftMenu.subResource}">
						<li><a href="javaScript:void(0);" onclick="openTab('${leftSubMenu.name }','${leftSubMenu.href }')"> ${leftSubMenu.name } </a></li>
					</c:forEach>

				</ul>
			</c:if>
		</li>
	</c:forEach>
	<a href="<%=context %>/admin/logout"><i class="icon-key"></i> Log Out</a>
</body>
</html>