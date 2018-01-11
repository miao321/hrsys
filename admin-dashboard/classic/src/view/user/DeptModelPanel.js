Ext.define('Admin.view.user.DeptModelPanel',{
	extend:'Ext.container.Container',
	xtype:'deptModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
	controller:'deptViewController',
	viewModel:{type:'deptViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'deptGridPanel'}]
//	html:'组织机构管理'
});