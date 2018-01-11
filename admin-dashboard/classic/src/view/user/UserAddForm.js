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

    items: [/*{
        xtype: 'textfield', //hidden
        fieldLabel: 'id',
        name:'id',
       readOnly:true
    },*/{
        xtype: 'textfield',
        fieldLabel: '用户名',
        name:'userName',
       	allowBlank:'用户名不能为空',  
        minLength:3,  
        minLengthText:'用户名长度为[3-6]',  
        maxLength:6,  
        maxLength:'用户名长度为[3-6]',
        emptyText: '请输入用户名'
    },{
        xtype: 'textfield',
        fieldLabel: '用户昵称',
        name:'userNickName',
       	allowBlank:'昵称不能为空',  
        minLength:3,  
        minLengthText:'昵称长度为[3-6]',  
        maxLength:6,  
        maxLength:'昵称长度为[3-6]',
        emptyText: '请输入昵称'
    }, {
         xtype: 'textfield',
       	cls: 'auth-textbox',
        fieldLabel: '密码',
        name:'password',
       	allowBlank:'密码不能为空',  
        minLength:6,  
        minLengthText:'密码长度为[6-20]',  
        maxLength:20,  
        maxLength:'密码长度为[6-20]',
        //inputType: 'password',
        emptyText: '请输入密码(6-20位)'
    }, {
        xtype: 'textfield',
        fieldLabel: '年龄',
        name:'age',
       	allowBlank:'年龄不能为空',  
        minLength:2,  
        minLengthText:'年龄长度为[2-3]',  
        maxLength:3,  
        maxLength:'年龄长度为[2-3]',
        emptyText: '请输入年龄'
    }, {
        xtype: 'datefield',
        fieldLabel: '生日',
        name:'birthday',
        format: 'Y/m/d H:i:s',
        editable:false,
        emptyText: '请输入生日'
    }, {
        xtype: 'textfield',
        fieldLabel: '毕业学校',
        name:'college',
       	allowBlank:'毕业学校不能为空',  
        minLength:3,  
        minLengthText:'毕业学校长度为[3-20]',  
        maxLength:20,  
        maxLength:'毕业学校长度为[3-20]',
        emptyText: '请输入毕业学校',
       	regex: /^[\u4e00-\u9fa5]+$/i,
		regexText : "请输入中文"
    }, {
    	xtype: "combobox",
        name: "body",
        fieldLabel: "身体状况",
        store: bodyStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        emptyText: "--请选择--",
        queryMode: "local"
    }, {
       	xtype: "combobox",
        name: "culture",
        fieldLabel: "文化程度",
        store: cultureStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        emptyText: "--请选择--",
        queryMode: "local"
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
     //   height:40,
	//	style:'text-align:center;margin-top:20px;'
	}, {
        xtype: 'textfield',
        fieldLabel: '邮箱地址',
        name:'email',
        emptyText: '请输入邮箱地址',
        regex :/(\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)/,
       	regexText:'请输入正确的邮箱地址'
    }, {
        xtype: 'textfield',
        fieldLabel: '家庭电话',
        name:'familyPhone',
        emptyText: '请输入家庭电话',
       	regex: /(\d{3}-\d{8}|\d{4}-\d{7})/,
		regexText : "输入的家庭号码不符合要求！格式：0511-4405222 或 021-87888822"
    },  {
        xtype: 'textfield',
        fieldLabel: '身份证号',
        name:'idCord',
        emptyText: '请输入身份证号',
       	regex: /(^\d{17}([0-9]|X)$)/,
		regexText : "输入的身份证号码不符合规定！18位号码末位可以为数字或X"
    }, {
       	xtype: "combobox",
        name: "marriage",
        fieldLabel: "婚姻情况",
        store: marriageStore,
        editable: false,
        displayField: "Name",
        valueField: "Value",
        emptyText: "--请选择--",
        queryMode: "local"
    }, {
        xtype: 'textfield',
        fieldLabel: '民族',
        name:'nation',
        emptyText: '请输入民族',
       	regex: /^[\u4e00-\u9fa5]+$/i,
		regexText : "请输入中文"
    }, {
        xtype: 'textfield',
        fieldLabel: '籍贯',
        name:'nativePlace',
        emptyText: '请输入籍贯',
       	regex: /^[\u4e00-\u9fa5]+$/i,
		regexText : "请输入中文"
    }, {
        xtype: 'textfield',
        fieldLabel: '手机号码',
        name:'phone',
        emptyText: '请输入手机号码',
        minLength : 11,  
        minLengthText : '联系人手机长度不得小于11个字符长度',  
        regex : /^1(3|5|8)[0-9]{9}$/,  
        regexText:'请输入正确的电话格式' 
    }, {
         	xtype: "combobox",
            name: "sex",
            fieldLabel: "性别",
            store: genderStore,
            editable: false,
            displayField: "Name",
            valueField: "Value",
            emptyText: "--请选择--",
            queryMode: "local"
    }, {
        xtype: 'textfield',
        fieldLabel: '职工账号',
        name:'userAccount',
        emptyText: '请输入职工账号',
       	regex: /(^\d{16}$)|(^\d{17}$)|(^\d{18}$)|(^\d{19}([0-9])$)/,
		regexText : "输入的职工账号不符合规定！16-19位数字"
    }, {
        xtype: 'textfield',
        fieldLabel: '职工编号',
        name:'userNo',
        emptyText: '请输入职工编号'
    }, {
        xtype: 'textfield',
        fieldLabel: '备注',
        name:'remark',
        emptyText: '请输入备注'
    }],

    bbar: {
        overflowHandler: 'menu',
        items: ['->',{
            xtype: 'button',
            ui: 'soft-green',
            text: '提交',
            handler : 'submitEditSaveForm'
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