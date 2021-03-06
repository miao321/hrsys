Ext.define('Admin.view.user.RoleAddForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.roleAddForm',
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
    viewModel: {type: 'roleViewModel'},
    controller: 'roleViewController',
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
        xtype: 'textfield',
        fieldLabel: '角色名',
        name:'roleName',
       	allowBlank:false,  
        emptyText: '请输入角色名'
    }, {
        xtype: 'textfield',
        fieldLabel: '排序号',
        name:'orderNo',
       	allowBlank:false,  
        emptyText: '请输入排序号'
    }, {
        xtype: 'textfield',
        fieldLabel: '创建模块',
        name:'createModule',
       	allowBlank:false,  
        emptyText: '请输入模块名'      
    }, {
        xtype: 'textfield',
        fieldLabel: '创建人',
        name:'createBy',
       	allowBlank:false,  
        emptyText: '请输入创建人'
    }, {
       xtype: 'datefield',
        fieldLabel: '创建时间',
        name:'createTime',
        format: 'Y/m/d H:i:s',
     	allowBlank:false,  
       editable:false,
        emptyText: '请输入创建时间'
    }, {
        xtype: 'textfield',
        fieldLabel: '修改人',
        name:'updateBy',
     	allowBlank:false,  
        emptyText: '请输入修改人'
    }, {
        xtype: 'datefield',
        fieldLabel: '修改时间',
        name:'updateTime',
        format: 'Y/m/d H:i:s',
     	allowBlank:false,  
       editable:false,
        emptyText: '请输入修改时间'
    }, {
        xtype: 'textfield',
        fieldLabel: '备注',
        name:'remark',
       	allowBlank:false,  
        emptyText: '请输入备注'
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