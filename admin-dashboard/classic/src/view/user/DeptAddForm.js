Ext.define('Admin.view.user.DeptAddForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.deptAddForm',
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
    viewModel: {type: 'deptViewModel'},
    controller: 'deptViewController',
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
        fieldLabel: '部门编号',
        name:'deptId',
        //readOnly:true
    }, {
        xtype: 'textfield',
        fieldLabel: '部门名字',
        name:'deptName'
    },{
        xtype: 'textfield',
        fieldLabel: '部门联系方式',
        name:'deptPhone'
    }, {
        xtype: 'textfield',
        fieldLabel: '部门传真号',
        name:'deptEmail',      
    }, {
        xtype: 'textfield',
        fieldLabel: '部门级别',
        name:'deptGrade',      
    }, {
        xtype: 'textfield',
        fieldLabel: '部门负责人',
        name:'deptOlder',      
    }, {
        xtype: 'textfield',
        fieldLabel: '部门标记',
        name:'deptSign',      
    }, {
        xtype: 'textfield',
        fieldLabel: '创建人',
        name:'createBy'
    }, {
       xtype: 'datefield',
        fieldLabel: '创建时间',
        name:'createTime',
        editable:false,
        format: 'Y/m/d H:i:s'
    }, {
        xtype: 'textfield',
        fieldLabel: '修改人',
        name:'updateBy'
    }, {
        xtype: 'datefield',
        fieldLabel: '修改时间',
        name:'updateTime',
       	editable:false,
        format: 'Y/m/d H:i:s'
    }, {
        xtype: 'textfield',
        fieldLabel: '备注',
        name:'remark'
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