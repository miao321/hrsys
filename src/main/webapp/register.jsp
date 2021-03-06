<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>登录</title>
		<!--CSS -->
		<link rel="stylesheet" type="text/css" href="classic/resources/Admin-all_1.css" />
		<link rel="stylesheet" type="text/css" href="classic/resources/Admin-all_2.css" />
		<link rel="stylesheet" type="text/css" href="classic/resources/Admin-all_3.css" />
		<!--JS -->
		<script  type="text/javascript" src="js/ext-all.js"></script>

		<script  type="text/javascript">
			Ext.onReady(function(){
				Ext.create('Ext.form.Panel', {				
					    title: '登录',
					    //defaultButton : 'loginButton',
					    autoComplete: true,
					  	//bodyStyle:'padding:5px 5px 0',  
         				buttonAlign:'center' ,  
					    frame:true,
					    width: 415,
					    height:380,
					  	bodyPadding:20,
					    //bodyMargin:20,
					    defaultType: 'textfield',
					    layout:'absolute',
					    x:550,
					    y:130,
					    items: [{
					    	xtype: 'textfield',
					     	cls: 'auth-textbox',
					        allowBlank: '用户名不能为空',
					        minLength:6,  
				            minLengthText:'用户名长度为[6-20]',  
				            maxLength:20,  
				            maxLength:'用户名长度为[6-20]',  
					        fieldLabel: '用户名:',
					        name: 'userName',
					        width:308,
					        height:40,
				        	emptyText: '请输入用户名',
				        	style:'text-align:center;'
				        	
					     
					    }, {
					    	xtype: 'textfield',
					    	cls: 'auth-textbox',
					    	allowBlank:'密码不能为空',  
				            minLength:6,  
				            minLengthText:'密码长度为[6-20]',  
				            maxLength:20,  
				            maxLength:'密码长度为[6-20]',
					        fieldLabel: '密码:',
					        name: 'password',
					        width:308,
					        height:40,
					        emptyText: '请输入密码',
					        inputType: 'password',
					        style:'margin-top:20px;font-family:bold;font-size:20px;text-align:center;',
					        //x:20,
					        y:110
					    }, 
					    	{
			                    xtype: 'button',
			                    reference: 'loginButton',
			                    scale: 'large',
			                    ui: 'soft-green',
			                    iconAlign: 'right',
			                    iconCls: 'x-fa fa-angle-right',
			                    text: '注册',
			                    formBind: true,
			                    x:20,
			                    y:40,
			                    listeners: {
			                        click: 'onLoginButton'
			                    }
			                },			                
					    ],
					    defaults: {
					        anchor: '100%',
					        labelWidth: 60
					    },					    				   
				    renderTo: Ext.getBody()
				});		
			});
		</script>
	</head>
	<body>
		
	</body>
</html>