Ext.define('Admin.view.user.PermissionViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.permissionViewModel',//配置到主视图的ViewModel名
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
	permissionlists: {type: 'permissionGridPanelStore',autoLoad:true}
    }
});