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
		alert('edit');
	},
	
	/**
	 * toorbar的删除按钮
	 */
	remove : function() {
		alert('remove');
	},
	
	/**
	 * 重置dialog里面的form表单
	 */
	resetForm:function(form){
		var form =  $(form);
		form[0].reset();
		form.find("[type=hidden]").val("");
	}
	
})