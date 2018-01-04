Ext.define('Admin.view.user.UserModelPanel',{
	extend:'Ext.container.Container',
	xtype:'userModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
	controller:'userViewController',
	viewModel:{type:'userViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'userGridPanel'}]
//	html:'用户管理模块'
});