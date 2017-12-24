<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>登录</title>
		<!--CSS -->
		<!-- <link rel="stylesheet" type="text/css" href="theme-neptune\resources\theme-neptune-all_1.css" />
		<link rel="stylesheet" type="text/css" href="theme-neptune\resources\theme-neptune-all_2.css" />
		 --><link rel="stylesheet" type="text/css" href="css/Admin-all_1.css"/>
		<link rel="stylesheet" type="text/css" href="css/Admin-all_2.css"/>
		<link rel="stylesheet" type="text/css" href="css/Admin-all_3.css"/>
		<link rel="stylesheet" type="text/css" href="css/Admin-all.css"/>
		<!--JS -->
		<script  type="text/javascript" src="js/ext-all.js"></script>

		<script  type="text/javascript">
			Ext.onReady(function(){
				Ext.create('Ext.form.Panel', {				
					    extend: 'Ext.form.Panel',
					    xtype: 'form-login',
					    title: '登录',
					    bodyStyle:'padding:5px 5px 0',  
         				buttonAlign:'center' ,  
					    frame:true,
					    width: 320,
					    height:300,
					    bodyPadding: 20,
					    defaultType: 'textfield',
					    layout: {
					        align: 'middle',
					        pack: 'center',
					        //type: 'hbox'
						},
						//width:'100%',
					    items: [{
					        allowBlank: false,
					        fieldLabel: '用户名:',
					        name: 'user',
					        emptyText: '请输入用户名'
					    }, {
					    	
					        allowBlank: false,
					        fieldLabel: '密  码:',
					        name: 'password',
					        emptyText: '请输入密码',
					        inputType: 'password'
					    }, {
					        xtype:'checkbox',
					        fieldLabel: '记住我',
					        name: 'remember'
					    }],
					    buttons: [
					        { text:'注册' },
					        { text:'登录' }
					    ],
					    defaults: {
					        anchor: '100%',
					        labelWidth: 110
					    },					    				   
				    renderTo: Ext.getBody()
				});		
			});
		</script>
	</head>
	<body>
		
	</body>
</html>