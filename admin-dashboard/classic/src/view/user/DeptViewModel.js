Ext.define('Admin.view.user.DeptViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.deptViewModel',//配置到主视图的ViewModel名
    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
	deptlists: {type: 'deptGridPanelStore',autoLoad:true}
    }
});