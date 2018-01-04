Ext.define('Admin.view.user.OrganizationModelPanel',{
	extend:'Ext.container.Container',
	xtype:'organizationModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
//	controller:'userViewController',
//	viewModel:{type:'userViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
//	items:[{xtype:'userGridPanel'}]
	html:'组织机构管理'
});