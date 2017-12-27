Ext.define('Admin.model.user.UserGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'string',name: 'userName'},
		{type: 'string',name: 'password'},
		{type: 'date',name: 'birthday'},
		{type: 'int',name: 'age'},
		{type: 'string',name: 'body'},
		{type: 'string',name: 'college'},
		{type: 'string',name: 'culture'},
	//	{type: 'int',name: 'deptId'},
		{type: 'string',name: 'email'},
		{type: 'string',name: 'familyPhone'},
		{type: 'string',name: 'idCord'},
		{type: 'string',name: 'marriage'},
		{type: 'string',name: 'nation'},
		{type: 'string',name: 'nativePlace'},
		{type: 'string',name: 'phone'},
		{type: 'string',name: 'remark'},
		{type: 'string',name: 'sex'},
		{type: 'string',name: 'userAccount'},
		{type: 'string',name: 'userNickName'},
		{type: 'string',name: 'userNo'},
	
    ]
});