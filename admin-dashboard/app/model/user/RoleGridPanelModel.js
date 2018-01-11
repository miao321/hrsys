Ext.define('Admin.model.user.RoleGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'string',name: 'roleName'},
		{type: 'string',name: 'remark'},
		{type: 'int',name: 'orderNo'},
		{type: 'string',name: 'createModule'},
		{type: 'string',name: 'createBy'},
		{type: 'date',name: 'createTime'},
		{type: 'string',name: 'updateBy'},
		{type: 'date',name: 'updateTime'},	
    ]
});
