Ext.define('Admin.view.user.UpdateMessageFormPanel',{
	extend:'Ext.form.Panel',
	xtype:'updateMessageFormPanel',   //对应NavigationTree store 的 viewType:'user'
	labelAlign: 'left',
    //	id:'Form1',
    autoHeight: true,
    width: 513,
    frame: true, 
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
    },{
        xtype: 'textfield',
        fieldLabel: '昵称',
        name:'userNickName'
    }, {
        xtype: 'textfield',
        fieldLabel: '密码',
        name:'password',
        readOnly:true
    },{
        xtype: 'textfield',
        fieldLabel: '年龄',
        name:'age'
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
        name: "body",
        fieldLabel: "身体状况",
        store: bodyStore,
        editable: false,
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
       // emptyText: "--请选择--",
        queryMode: "local"
       
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
        fieldLabel: '部门号',
    	name:'deptId'
   },{
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
       // emptyText: "--请选择--",
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
       // emptyText: "--请选择--",
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
	            handler : 'updateUserMessage'
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