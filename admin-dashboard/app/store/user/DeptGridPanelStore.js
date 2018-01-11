Ext.define('Admin.store.user.DeptGridPanelStore', {
	extend: 'Ext.data.Store',
	alias: 'store.deptGridPanelStore', // ViewModel中stores type
	model: 'Admin.model.user.DeptGridPanelModel',
	//autoLoad:true,
	pageSize:25,
	proxy: {
		type: 'ajax',
		url:'dept/findPage.json',
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