Ext.define('Admin.view.user.UserAddForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.userAddForm',
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
    viewModel: {type: 'userViewModel'},
    controller: 'userViewController',
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
        xtype: 'textfield',
        fieldLabel: '用户名',
        name:'userName'
    },{
        xtype: 'textfield',
       	cls: 'auth-textbox',
        fieldLabel: '用户昵称',
        name:'userNickName',
       	
    }, {
        xtype: 'textfield',
        fieldLabel: '密码',
        name:'password',
       	allowBlank:'密码不能为空',  
        minLength:6,  
        minLengthText:'密码长度为[6-20]',  
        maxLength:20,  
        maxLength:'密码长度为[6-20]',
        inputType: 'password',
        emptyText: '请输入密码(6-20位)'
    }, {
        xtype: 'datefield',
        fieldLabel: '生日',
        name:'birthday',
        format: 'Y/m/d H:i:s'
    }, {
        xtype: 'textfield',
        fieldLabel: '毕业学校',
        name:'college'
    }, {
        xtype: 'textfield',
        fieldLabel: '身体状况',
        name:'body'
    }, {
        xtype: 'textfield',
        fieldLabel: '文化程度',
        name:'culture'
    }, {
        xtype: 'textfield',
        fieldLabel: '邮箱地址',
        name:'email'
    }, {
        xtype: 'textfield',
        fieldLabel: '家庭电话',
        name:'familyPhone'
    }, {
        xtype: 'textfield',
        fieldLabel: '邮箱地址',
        name:'email'
    }, {
        xtype: 'textfield',
        fieldLabel: '身份证号',
        name:'idCord'
    }, {
        xtype: 'textfield',
        fieldLabel: '婚姻情况',
        name:'marriage'
    }, {
        xtype: 'textfield',
        fieldLabel: '民族',
        name:'nation'
    }, {
        xtype: 'textfield',
        fieldLabel: '籍贯',
        name:'nativePlace'
    }, {
        xtype: 'textfield',
        fieldLabel: '手机号码',
        name:'phone'
    }, {
        xtype: 'textfield',
        fieldLabel: '备注',
        name:'remark'
    }, {
        xtype: 'textfield',
        fieldLabel: '性别',
        name:'sex'
    }, {
        xtype: 'textfield',
        fieldLabel: '职工账号',
        name:'userAccount'
    }, {
        xtype: 'textfield',
        fieldLabel: '职工编号',
        name:'userNo'
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
