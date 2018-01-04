Ext.define('Admin.view.user.LogModelPanel',{
	extend:'Ext.container.Container',
	xtype:'logModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
//	controller:'userViewController',
//	viewModel:{type:'userViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
//	items:[{xtype:'userGridPanel'}]
	html:'日志管理模块'
});