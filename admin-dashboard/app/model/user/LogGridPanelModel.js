Ext.define('Admin.model.user.LogGridPanelModel', {
    extend: 'Admin.model.Base',
    fields: [
		{type: 'int'	,name: 'id'},
		{type: 'string',name: 'userName'},
		{type: 'date',name: 'startTime'},
		{type: 'date',name: 'endTime'}
    ]
});