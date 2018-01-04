Ext.define('Admin.view.dashboard.Dashboard', {
    extend: 'Ext.Container',
    xtype: 'admindashboard',

    controller: 'dashboard',
    viewModel: {
        type: 'dashboard'
    },

    cls: 'dashboard',
    scrollable: true,

    defaults: {
        shadow: true
    },

    items: [{
        xtype: 'weather',
        userCls: 'big-40 small-100 dashboard-item last-in-row'
    }]
});
