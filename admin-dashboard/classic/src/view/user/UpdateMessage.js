Ext.define('Admin.view.user.UpdateMessage', {
    extend: 'Ext.window.Window',
    alias: 'updateMessage',
   	xtype:'updateMessage',
    autoShow: true,
    modal: true,
    title:'修改个人信息',
    layout: 'fit',
    //items:[],
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
        this.setSize(Math.floor(width * 0.6), Math.floor(height * 0.6));
        this.setXY([ Math.floor(width * 0.05), Math.floor(height * 0.05) ]);
    },
   	items: [{xtype:'updateMessageFormPanel'}],
});
	
