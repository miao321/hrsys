Ext.define('Admin.view.user.LogModelPanel',{
	extend:'Ext.container.Container',
	xtype:'logModelPanel',   //对应NavigationTree store 的 viewType:'user'
		requires:[],
	controller:'logViewController',
	viewModel:{type:'logViewModel'},
//	listeners:{hide:'onHideView'},
	layout:'fit',
	items:[{xtype:'logGridPanel'}]

});