/**
 * context 指定为 项目上下文
 * index 如果定义多组dataGrid，index指定为对应的参数：一组dataGrid包含（datagrid;toorbar;dialog;button）
 * templateUrl 指定为 此次访问操作对应的controller路径
 * crud 指定为  对应的toorbar包含什么操作；crud：增加修改删除; c：增加; u：修改; d：删除;
 */
function DataGridEasyui(context, index, templateUrl, crud) {
	this.context = context;
	this.index = index;
	this.templateUrl = templateUrl;
	this.crud = crud;// 'c','r','u','d','all'
	this.saving =false; //处理中
};


$.extend(DataGridEasyui.prototype, {
	
	/**
	 * 初始化DataGridEasyui
	 * crud按钮的响应操作  增加：add; 修改：edit; 删除:remove;
	 */
	init : function() {
		
		this.dataGrid = $("#dg-" + this.index);
		this.toolBar = $("#toolbar-" + this.index);
		this.dlg = $("#dlg-" + this.index);
		this.dlgBtn = $("#dlg-buttons-" + this.index);
		
		var fns = [ this.proxy(this.add, this,this.toolBar.find(".add")), this.proxy(this.edit, this,this.toolBar.find(".edit")),
					this.proxy(this.remove, this,this.toolBar.find(".remove")) ];

		//toolBar 响应函数
		if (this.crud == 'crud') {
			this.toolBar.find(".add").bind('click', fns[0]);
			this.toolBar.find(".edit").bind('click', fns[1]);
			this.toolBar.find(".remove").bind('click', fns[2]);
		} else if (this.crud == 'c') {
			this.toolBar.find(".add").bind('click', fns[0]);
		} else if (this.crud == 'u') {
			this.toolBar.find(".edit").bind('click', fns[1]);
		} else if (this.crud == 'd') {
			this.toolBar.find(".remove").bind('click', fns[2]);
		}
		
		//dlg-buttons 响应函数 
		if (this.crud == 'crud' || this.crud == 'c' || this.crud == 'u') {
			this.dlgBtn.find('.save').bind('click', this.proxy(this.save, this,this.dlgBtn.find('.save')));
			this.dlgBtn.find('.cancel').bind('click',this.proxy(this.cancel, this,this.dlgBtn.find('.cancel')));
		}
		
		
	},
	
	/**
	 * 改变函数作用域
	 * 
	 * @param fn
	 * @param scope
	 * @returns
	 */
	proxy : function(fn, scope,btn) {
		return function (){
			if(btn.is("[class*='disabled']")){  //禁用了不需要响应事件
				return ;
			}
			return fn.call(scope,arguments[0],btn);
		};
	},
	
	/**
	 * 初始化dialog里面的form表单
	 */
	formInit : function() {
		
	},
	
	/**
	 * toorbar的增加按钮
	 */
	add : function() {
		$('#dlg-' + this.index).dialog('open').dialog('setTitle', '新增');
		this.resetForm(this.dlg.find("form:eq(0)"));
		this.formInit.call(this);
	},
	
	/**
	 * toorbar的修改按钮
	 */
	edit : function() {
		var rows = this.dataGrid.datagrid('getSelections');
		if (!rows || rows.length == 0) {
			$.messager.alert('提示', '请选择记录！');
		} else {
			if (rows.length == 1) {
				this.dlg.dialog('open').dialog('setTitle', '修改');
				this.dlg.find("form").form('clear').form('load', rows[0]);
				this.formLoadData(rows[0]);
			} else {
				$.messager.alert('提示', '请选择单行记录！');
			}
		}
	},
	
	/**
	 * toorbar的删除按钮
	 */
	remove : function() {
		var this_ = this;
		var rows = $('#dg-' + this.index).datagrid('getSelections');
		
		if (!rows || rows.length > 0) {
			$.messager.confirm('确认', '你确定要删除所选的记录吗?', function(r) {
				if (r) {
					$.post(context_ + "/" + this_.getController("logicDelete"), {
						pids : $.map(rows, function(row) {
							return row.pid;
						}).join("::")

					}, function(result) {
						if (result.success) {
							this_.reload.call(this_);
							$.messager.show({ // show
								// tips
								title : '提示',
								msg : result.msg
							});
						} else {
							$.messager.alert('错误', result.msg);
						}
					}, 'json');
				}
			});
		} else {
			$.messager.alert('提示', '请选择记录！');
		}
	},
	
	/**
	 * 重置dialog里面的form表单
	 */
	resetForm:function(form){
		var form =  $(form);
		form.form('clear');
		form[0].reset();
		form.find("[type=hidden]").val("");
	},
	
	/**
	 * form表单加载数据
	 */
	formLoadData:function (data){
		//处理隐藏域
		this.dlg.find("form:eq(0) input[type!=radio][type!=checkbox][name*='.']").each(function(){
			
			var name =  $(this)[0].name;
			
			var value = data[name];
			if(value){
				$(this).val(value);
				return ;
			}
			
			if(name.indexOf(".")!=-1){
				var names = name.split(".");
				value =data ;
				for(var i=0,l = names.length;i<l;i++){
					value = value[names[i]];
					if(!value){
						return ;
					}
				}
				$(this).val(value);
				
			}
		});
		//处理单选多选
		this.dlg.find("form:eq(0) input[type=radio]").each(function(){
			var name =  $(this)[0].name;
			var value  =data[name] ;
			
			if(value){
				if($(this).val() == value){
					$(this)[0].checked="checked";
				}
				return ;
			}
			
			
			if(name.indexOf(".")!=-1){
				var names = name.split(".");
				value = data ;
				for(var i=0,l = names.length;i<l;i++){
					try{
						value = value[names[i]];
					}catch(e){
						return ;
					}
				}
			}else{
				value = data[name];
			}
			if($(this).val() == value){
				$(this)[0].checked="checked";
			}
			
		});
		
		//处理单选多选
		this.dlg.find("form:eq(0) input[type=checkbox]").each(function(){
			var name =  $(this)[0].name;
			var value  =data[name] ;
			var this_ = this ;
			if(value){
				
				$(value).each(function (index ,item ){
					if($(this_).val() == item){
						$(this_)[0].checked="checked";
					}
				});
				
				return ;
			}
			
			
			if(name.indexOf(".")!=-1){
				var names = name.split(".");
				value = data ;
				for(var i=0,l = names.length - 1;i<l;i++){
					try{
						value = value[names[i]];
					}catch(e){
						return ;
					}
					
				}
				
				
				if($.isArray(value)){
					
					for(var i=0,l =value.length ;i <l;i++ ){
						if(value[i][names[names.length-1]]==$(this).val()){
							$(this)[0].checked="checked";
							return ;
						}
					}
					
				}
				
				
			}else{
				value = data[name];
			}
			if($(this).val() == value){
				$(this)[0].checked="checked";
			}
			
		});
		
		this.dlg.find("form:eq(0) select").each(function (){
			var name =  $(this)[0].name;
			var value  =data[name] ;
			
			if(value){
				$(this).val(value);
				return ;
			}
			
			if(name.indexOf(".")!=-1){
				var names = name.split(".");
				value = data ;
				for(var i=0,l = names.length;i<l;i++){
					value = value[names[i]];
					if(!value){
						return ;
					}
				}
			}else{
				value = data[name];
			}
			
			$(this).val(value);
		});
		
	},
	
	reload:function (){
		this.dataGrid.datagrid('reload'); // reload
	},
	
	/**
	 * form 表单验证
	 */
	validateForm:function (form){
		return true;
	},
	
	/**
	 * dlg-buttons 保存按钮
	 */
	save : function() {
		if(this.saving==true){  //避免重复提交
			return ;
		}
		var this_ = this;
		var form = this.dlg.find('form:eq(0)');
		var url;
		if (form[0].pid.value) {
			url = this.getController("doUpdate");
		} else {
			url = this.getController("doSave");
		}
		
		form.form('submit', {
			url : context_ + "/" + url,
			onSubmit : function() {
				
				var validate = $(this).form('validate')&& this_.validateForm(form);
				
				if(validate){
					this_.saving = true;
				}
				
				return validate;
			},
			success : function(result) {
				this_.saving = false ;
				var result ;
				try{
					result = jQuery.parseJSON(result)
				}catch(e){
					$.messager.alert('错误', "服务端出错！"); // show error
					return ;
				}
				if (result.success) {
					this_.dlg.dialog('close');
					this_.reload.call(this_);
					$.messager.show({ // show tips
						title : '提示',
						msg : result.msg
					});
				} else {
					$.messager.alert('错误', result.msg); // show error
				}
			},
			onLoadError:function (){
				this_.saving = false
			}
		});
	},
	
	/**
	 * dlg-buttons 取消按钮
	 */
	cancel : function() {
		this.dlg.dialog('close');
	},
	
	/**
	 * 获取响应方法
	 */
	getController : function(method) {
		return this.templateUrl + "/" + method;
	}
	
})