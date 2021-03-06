Ext.define('Admin.view.user.UserEditForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.userEditForm',
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
        fieldLabel: '昵称',
        name:'userNickName'
    },{
        xtype: 'textfield',
        fieldLabel: '密码',
        name:'password',
        readOnly:true
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
        xtype: "combobox",
        fieldLabel: '身体状况',
        name:'body',
        store: bodyStore,
         
        displayField: "Name",
        valueField: "Value",
        //emptyText: "--请选择--",
        queryMode: "local"
    }, {
        xtype: "combobox",
        fieldLabel: '文化程度',
        name:'culture',
        store: cultureStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        //emptyText: "--请选择--",
        queryMode: "local"
    }, {
        xtype: 'textfield',
        fieldLabel: '邮箱地址',
        name:'email'
    }, {
        xtype: 'textfield',
        fieldLabel: '年龄',
        name:'age'
    }, {
        xtype: "combobox",
       name: "deptName",
       model:'local',
       fieldLabel: "部门名",
       store: {
       	   autoLoad:true,
       	   fields:[{name:'id',type:'int'},{name:'deptName',type:'string'}],
	       	proxy: {
				type: 'ajax',
				url:'dept/findAll.json',
				reader: {
					type: 'json',
					rootProperty: 'lists',
					totalProperty:'totalElements'
				  }
			}
		},
        editable: false,
        valueField: "deptName",
        displayField: "deptName",
       
        emptyText: "--请选择--",
        queryMode: "local",
    }, {
        xtype: 'textfield',
        fieldLabel: '家庭电话',
        name:'familyPhone'
    }, {
        xtype: 'textfield',
        fieldLabel: '身份证号',
        name:'idCord'
    }, {
        xtype: "combobox",
        fieldLabel: '婚姻情况',
        name:'marriage',
        store: marriageStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        //emptyText: "--请选择--",
        queryMode: "local"
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
        xtype: "combobox",
        fieldLabel: '性别',
        name:'sex',
        store: genderStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        //emptyText: "--请选择--",
        queryMode: "local"
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