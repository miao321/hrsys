Ext.define('Admin.view.user.RoleModelPanel',{
	extend:'Ext.container.Container',
	xtype:'roleModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
//	controller:'userViewController',
//	viewModel:{type:'userViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'roleGridPanel'}]
	html:'用户管理模块'
});