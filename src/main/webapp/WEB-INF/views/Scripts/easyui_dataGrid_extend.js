function DataGridEasyui(context, index, templateUrl) {
	this.context = context;
	this.index = index;
	this.templateUrl = templateUrl;
	this.crud = 'all'; // 'c','r','u','d','all'
	this.saving =false; //处理中
};


$.extend(DataGridEasyui.prototype, {
	
	formInit:function(){
		
	},
	
	add : function() {
		$('#dlg-' + this.index).dialog('open').dialog('setTitle', '新增');
		this.resetForm(this.dlg.find("form:eq(0)"));
		this.formInit.call(this);
	}
	
})