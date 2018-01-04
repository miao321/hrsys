Ext.define('Admin.store.user.UserGridPanelStore', {
	extend: 'Ext.data.Store',
	alias: 'store.userGridPanelStore', // ViewModel中stores type
	model: 'Admin.model.user.UserGridPanelModel',
	//autoLoad:true,
	pageSize:25,
	proxy: {
		type: 'ajax',
		url:'user/findPage.json',
		reader: {
			type: 'json',
			rootProperty: 'content',
			totalProperty:'totalElements'
		},
		simpleSortMode:true  //发送简单排序字段
	},
	remoteSort:true,  //远程（全局）排序
//	autoLoad: 'true',
	sorters: {
		direction: 'DESC',
		property: 'id'
	}
});