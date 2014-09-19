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
	<link rel="stylesheet" type="text/css" href="<%=context %>/views/admin/jquery-easyui-1.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=context %>/views/admin/jquery-easyui-1.4/themes/icon.css">
	<script type="text/javascript" src="<%=context %>/views/Scripts/jquery-1.4.1.js"></script>
	<script type="text/javascript" src="<%=context %>/views/admin/jquery-easyui-1.4/jquery.min.js"></script>
	<script type="text/javascript" src="<%=context %>/views/admin/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<body  class="easyui-layout">

	<!-- <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div> -->
	
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
		<ul id="subMenus" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/admin/getMenus',method:'get',animate:true">
			
		</ul>  
	</div>
	
	<!-- <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div> -->
	
	<!-- <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div> -->
	
	<div data-options="region:'center',title:'Center'">
		<div id="main-tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
			
		</div>
	</div>
	<a href="<%=context %>/admin/logout"><i class="icon-key"></i> Log Out</a>
</body>
	<script type="text/javascript">

		$(document).ready(function() {
			
		})
		
	</script>
</html>