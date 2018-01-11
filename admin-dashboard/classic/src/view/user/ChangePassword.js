Ext.define('Admin.view.user.ChangePassword', {
    extend: 'Ext.window.Window',
    alias: 'changePassword',
   	xtype:'changePassword',
    autoShow: true,
    modal: true,
    layout: 'fit',
    title:'修改密码',   
    afterRender: function () {
        var me = this;
        me.callParent(arguments);
        me.syncSize();
        Ext.on(me.resizeListeners = {
            resize: me.onViewportResize,
            scope: me,
            buffer: 50
        });
    },
    doDestroy: function () {
        Ext.un(this.resizeListeners);
        this.callParent();
    },
    onViewportResize: function () {
        this.syncSize();
    },
    syncSize: function () {
        var width = Ext.Element.getViewportWidth(),
            height = Ext.Element.getViewportHeight();
        this.setSize(Math.floor(width * 0.2), Math.floor(height * 0.3));
        this.setXY([ Math.floor(width * 0.03), Math.floor(height * 0.03) ]);
    },
    items: [{xtype:'changePasswordFormPanel'}],
});
