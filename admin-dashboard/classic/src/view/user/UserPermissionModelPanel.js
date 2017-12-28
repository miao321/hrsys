Ext.define('Admin.view.user.UserPermissionModelPanel',{
	extend:'Ext.container.Container',
	xtype:'userPermissionModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
//	controller:'userViewController',
//	viewModel:{type:'userViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
//	items:[{xtype:'userGridPanel'}]
	html:'用户权限分配模块'
});