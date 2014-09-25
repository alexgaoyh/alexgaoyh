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

	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
		<div class="easyui-panel,border:false" style="height:40px;">
			<div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'west',border:false" style="width:500px;">
					Welcome, ${sysmanUser.realName}
				</div>
				<div data-options="region:'east',border:false">
					
				</div>
				<div data-options="region:'center',border:false" style="width:500px;">
					<a href="${pageContext.request.contextPath}/admin/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>
	
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
		<ul id="subMenus" class="easyui-tree" 
			data-options="url:'${pageContext.request.contextPath}/admin/getMenus',
						method:'get',animate:true,
						onClick: function(node){
							openTab(node.text, node.attributes.href);
						}">
			
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
	
		var context_ = '${context_}';

		$(document).ready(function() {
			
		})
		
		
		var mainTabs = $("#main-tabs");
		function openTab(title, url) {
			if (mainTabs.tabs('exists', title)) {
				mainTabs.tabs('select', title);
				var iframeContext = mainTabs.tabs('getTab', title).find("iframe");
				if(iframeContext){
					iframeContext[0].src = context_ + url
				} 
			} else {
				mainTabs.tabs('add', {
					title : title,
					content : createFrame(context_ + url),
					closable : true
				});
			}

		}

		function createFrame(url) {
			var s = '<iframe name="mainFrame" scrolling="auto" frameborder="no" border="0" marginwidth="0" marginheight="0"  allowtransparency="yes" src="'
					+ url + '" style="width:100%;height:99%;"></iframe>';
			return s;
		}
		
	</script>
</html>