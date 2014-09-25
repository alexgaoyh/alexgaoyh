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
	
	<script type="text/javascript" src="<%=context %>/views/Scripts/easyui_dataGrid_extend.js"></script>
</head>
<body>
	<table id="dg-1" class="easyui-treegrid" title="列表" style="width: 700px; height: 300px"
		data-options="toolbar:'#toolbar-1',idField:'id',treeField:'text',checkOnSelect:true,selectOnCheck:true,fit:true,rownumbers:true,fitColumns:true,url:'${pageContext.request.contextPath}/${moduleName}/getData',method:'get',pagination:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id'" width="10">编码</th>
				<th data-options="field:'text'" width="220">名称</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar-1">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" plain="true">删除</a>
	</div>
	
	<div id="dlg-1" class="easyui-dialog" title="数据参数" style="width: 600px; height: 280px; padding: 10px 20px" closed="true" buttons="#dlg-buttons-1">
		<form method="post">
			<table cellpadding="5">
				<tr><td></td></tr>
				<tr>
					<td><input type="hidden" name="pid" /></td>
				</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-buttons-1">
		<a href="#" class="easyui-linkbutton  save" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" iconCls="icon-cancel">取消</a>
	</div>
	
	<script type="text/javascript">
		var context_ = '${context_}';
		var templateUrl = '${moduleName}';
		
	
		$( function() {
			var dg1 = new DataGridEasyui(context_, 1 , templateUrl, 'crud');
			dg1.init();
		});
	</script>
	
</body>
</html>