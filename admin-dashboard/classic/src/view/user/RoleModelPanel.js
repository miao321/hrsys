Ext.define('Admin.view.user.RoleModelPanel',{
	extend:'Ext.container.Container',
	xtype:'roleModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
	controller:'roleViewController',
	viewModel:{type:'roleViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'roleGridPanel'}],
//	html:'角色管理'
});