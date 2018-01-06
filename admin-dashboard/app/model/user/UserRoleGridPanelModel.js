Ext.define('Admin.model.user.UserRoleGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'int',name: 'userId'},
		{type: 'int',name: 'roleId'},	
    ]
});