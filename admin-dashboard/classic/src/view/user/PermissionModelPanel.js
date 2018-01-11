Ext.define('Admin.view.user.PermissionModelPanel',{
	extend:'Ext.container.Container',
	xtype:'permissionModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
	controller:'permissionViewController',
	viewModel:{type:'permissionViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'permissionGridPanel'}]

});