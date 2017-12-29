Ext.define('Admin.view.user.ModuleModelPanel',{
	extend:'Ext.container.Container',
	xtype:'moduleModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
//	controller:'moduleViewController',
//	viewModel:{type:'moduleViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
//	items:[{xtype:'userGridPanel'}]
	html:'模块管理'
});