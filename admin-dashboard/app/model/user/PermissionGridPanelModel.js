Ext.define('Admin.model.user.PermissionGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},	
		{type: 'string',name: 'token'},	
		{type: 'string',name: 'url'},	
		{type: 'string',name: 'description'},
		{type: 'int',name: 'roleId'}	
    ]
});