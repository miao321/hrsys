Ext.define('Admin.view.user.PermissionAddForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.permissionAddForm',
    requires: [
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.field.Checkbox',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
		'Ext.form.field.Time', 
        'Ext.form.field.Number',
        'Ext.form.field.Hidden',
        'Ext.form.field.Picker',
        'Ext.form.field.TextArea',
        'Ext.form.field.File',
        'Ext.form.field.HtmlEditor'
    ],
//因为Window是独立Create的并不属于UserModelPanel主视图
//所以：必须绑定viewModel才可以刷新Grid数据
//所以：必须绑定ViewController才可以绑定事件
    viewModel: {type: 'permissionViewModel'},
    controller: 'permissionViewController',
    //cls: '',

    layout: {
        type:'vbox',
        align:'stretch'
    },

    bodyPadding: 10,
    scrollable: true,

    defaults: {
        labelWidth: 60,
        labelSeparator: ''
    },

    items: [{
        xtype: 'hidden', //hidden
        fieldLabel: 'id',
        name:'id',
        readOnly:true
    },{
        xtype: 'textfield', //hidden
        fieldLabel: 'token',
        name:'token',
        //readOnly:true
    }, {
        xtype: 'textfield',
        fieldLabel: '资源url',
        name:'url'
    },{
        xtype: 'textfield',
        fieldLabel: '权限说明',
        name:'description'
    }, {
        xtype: 'textfield',
        fieldLabel: '所属角色编号',
        name:'roleId',      
    }],

    bbar: {
        overflowHandler: 'menu',
        items: ['->',{
            xtype: 'button',
            ui: 'soft-green',
            text: '提交',
            handler : 'submitEditForm'
        },{
            xtype: 'button',
            ui: 'soft-red',
            text: '取消',
	        handler :function(bt){
	        	var win = bt.up('window');
		        if (win) {
		            win.close();
		        }
	        }
        },'->']
    }
});
