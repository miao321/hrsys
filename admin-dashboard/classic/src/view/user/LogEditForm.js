Ext.define('Admin.view.user.LogEditForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.logEditForm',
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
    viewModel: {type: 'logViewModel'},
    controller: 'logViewController',
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
        xtype: 'textfield', //hidden
        fieldLabel: 'id',
        name:'id',
        readOnly:true
    },{
        xtype: 'textfield',
        fieldLabel: '用户名',
        name:'userName'
    }, {
        xtype: 'textfield',
        fieldLabel: '操作模块',
        name:'module'
       
    },{
        xtype: 'textfield',
        fieldLabel: '操作内容',
        name:'method'
             
  }, {
        xtype: 'datefield',
        fieldLabel: '操作时间',
        name:'operationTime',
        format: 'Y/m/d H:i:s'
       	     
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
