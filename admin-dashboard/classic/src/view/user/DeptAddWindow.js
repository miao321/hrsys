Ext.define('Admin.view.user.DeptAddWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.deptAddWindow',
   	xtype:'deptAddWindow',
    autoShow: true,
    modal: true,
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
    }
});