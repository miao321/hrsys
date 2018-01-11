Ext.define('Admin.view.user.ModuleAddForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.moduleAddForm',
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
    viewModel: {type: 'moduleViewModel'},
    controller: 'moduleViewController',
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
        fieldLabel: '父节点ID',
        name:'parentId'
    }, {
        xtype: 'textfield',
        fieldLabel: '父节点名字',
        name:'parentName'
    }, {
        xtype: 'textfield',
        fieldLabel: '模块名',
        name:'moduleName',      
    }, {
        xtype: 'textfield',
        fieldLabel: '层数',
        name:'layerNum',      
    }, {
        xtype: 'textfield',
        fieldLabel: '是否是叶子节点',
        name:'isLaey',      
    }, {
        xtype: 'textfield',
        fieldLabel: '权限标识',
        name:'cpermission',      
    }, {
        xtype: 'textfield',
        fieldLabel: '状态',
        name:'state',      
    }, {
        xtype: 'textfield',
        fieldLabel: '从属',
        name:'belong',      
    }, {
        xtype: 'textfield',
        fieldLabel: '排序号',
        name:'orderNo',      
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