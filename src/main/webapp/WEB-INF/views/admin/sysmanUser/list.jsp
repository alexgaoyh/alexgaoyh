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
	<table id="dg-1" class="easyui-datagrid" title="列表" style="width: 700px; height: 300px"
		data-options="toolbar:'#toolbar-1',checkOnSelect:true,selectOnCheck:true,fit:true,rownumbers:true,fitColumns:true,url:'${pageContext.request.contextPath}/${moduleName}/getData',method:'get',pagination:true,method:'get'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'pid',width:80">编码</th>
				<th data-options="field:'userName',width:80">用户名</th>
				<th data-options="field:'realName',width:80">真实姓名</th>
				<th data-options="field:'email',width:80">电子邮件</th>
				<th data-options="field:'phone',width:80">电话</th>
				<th data-options="field:'position',width:80">职务</th>
				<th data-options="field:'positonDesc',width:80">职务说明</th>
				<th data-options="field:'status',width:80">状态</th>
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
				<tr><td>如用户未更改密码，默认密码为admin</td></tr>
				<tr>
					<td><input type="hidden" name="pid" /><input type="hidden" name ="relRolePids" id ="relRolePids"  /></td>
				</tr>
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td><input class="easyui-textbox" type="text" name="realName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>电子邮件:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>职务:</td>
	    			<td><input class="easyui-textbox" type="text" name="position" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>职务说明:</td>
	    			<td><input class="easyui-textbox" type="text" name="positonDesc" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>状态:</td>
	    			<td>
						<select name="status">
							<option value="1">正常</option>
							<option value="2">禁用</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>角色:</td>
	    			<td>
	    				<table class="table-info-form">
							<c:forEach var="sysmanRole" items="${sysmanRoleList}">
								<tr >
									<td class="info-label">${sysmanRole.name }</td>
									<td class="info-controller"> <input id="${sysmanRole.pid }" value ="${sysmanRole.pid }"  type ="checkbox" name ="roles.pid" onclick="relRoleChange();" />  </td>
								</tr>
							</c:forEach>
						</table>
					</td>
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
		
		//checkbox数据操作,选中即将值复制到input中
		function relRoleChange(){
			$("#relRolePids").val();
			var rolePid = [];
			$("input[name='roles.pid']:checkbox:checked").each(function(){ 
				rolePid.push($(this).val());
			})
			$("#relRolePids").val(rolePid.join(","));
		}
	
		$( function() {
			var dg1 = new DataGridEasyui(context_, 1 , templateUrl, 'crud');
			
			$.extend(dg1, {
				//重写formInit方法，对form表单的某些特殊业务功能进行操作处理
				formInit:function(){
					DataGridEasyui.prototype.formInit.call(this);
					$("input[name='roles.pid']").each(function(){
						 $(this).removeAttr("checked");
					});
					
				} ,
				//重写formLoadData方法，在form表单加载数据的时候，对表单进行操作处理
				formLoadData:function (data){
					DataGridEasyui.prototype.formLoadData.call(this,data);
					
					//更新操作,将之前数据重新放置input
					var rolePids = [];
					$.map(data.roles,function (n){
						rolePids.push(n.pid);
					})
					$('#relRolePids').val(rolePids.join(","));
					//jquery 控制 checkbox 数据回显
					$("input[name='roles.pid']").each(function(){
						for(var i = 0; i < data.roles.length; i++){
							if($(this).val() == data.roles[i].pid){
								 $(this).attr("checked", "checked");
							}
						}
					})

				},
				
			});
			
			dg1.init();
		});
	</script>
	
</body>
</html>