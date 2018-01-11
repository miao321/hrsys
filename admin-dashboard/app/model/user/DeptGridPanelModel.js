Ext.define('Admin.model.user.DeptGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'int'	,name: 'deptId'},
		{type: 'string',name: 'deptName'},
		{type: 'int',name: 'deptPhone'},
		{type: 'string',name: 'deptEmail'},	
		{type: 'string',name: 'deptGrade'},
		{type: 'string',name: 'deptOlder'},
		{type: 'string',name: 'deptSign'},
		{type: 'string',name: 'remark'},
		{type: 'string',name: 'createBy'},
		{type: 'date',name: 'createTime'},
		{type: 'string',name: 'updateBy'},
		{type: 'date',name: 'updateTime'},	
    ]
});