Ext.define('Admin.model.user.ModuleGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'string',name: 'parentId'},
		{type: 'string',name: 'parentName'},
		{type: 'string',name: 'moduleName'},	
		{type: 'int',name: 'layerNum'},
		{type: 'int',name: 'isLaey'},
		{type: 'string',name: 'cpermission'},
		{type: 'int',name: 'state'},
		{type: 'string',name: 'belong'},
		{type: 'string',name: 'remark'},
		{type: 'int',name: 'orderNo'},
		{type: 'string',name: 'createBy'},
		{type: 'date',name: 'createTime'},
		{type: 'string',name: 'updateBy'},
		{type: 'date',name: 'updateTime'},	
    ]
});