<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>登录</title>
		<!--CSS -->
		<link rel="stylesheet" type="text/css" href="../theme-neptune/resources/theme-neptune-all_1.css" />
		<link rel="stylesheet" type="text/css" href="../theme-neptune/resources/theme-neptune-all_2.css" />
		<link rel="stylesheet" type="text/css" href="../css/Admin-all_1.css"/>
		<link rel="stylesheet" type="text/css" href="../css/Admin-all_2.css"/>
		<link rel="stylesheet" type="text/css" href="../css/Admin-all_3.css"/>
		<link rel="stylesheet" type="text/css" href="../css/Admin-all.css"/>
		<link rel="stylesheet" type="text/css" href="../css/font-awesome-all.css"/>
		<!--JS -->
		<script  type="text/javascript" src="../js/ext-all.js"></script>

		<script  type="text/javascript">
			Ext.onReady(function(){
				Ext.create('Ext.form.Panel', {				
					    
					    xtype: 'form-login',
					    title: '登录',
					    //defaultButton : 'loginButton',
					    autoComplete: true,
					   // bodyStyle:'padding:5px 5px 0',  
         				buttonAlign:'center' ,  
					    frame:true,
					    width: 415,
					    height:380,
					  	bodyPadding: 20,
					    //bodyMargin:10,
					    defaultType: 'textfield',
					    layout:'absolute',
					    x:550,
					    y:130,
					    items: [{
					    	xtype: 'textfield',
					     	cls: 'auth-textbox',
					        allowBlank: false,
					        fieldLabel: '用户名:',
					        name: 'userName',
                    		bind: '{userName}',
					        height: 30,
                    	//	hideLabel: true,
                    		//iconCls:'x-fa fa-user',
                    		
                    		
                    		
					        emptyText: '请输入用户名',
					        glyph: 'xf007@FontAwesome',
						   // triggers: {
	                       // glyphed: {
	                        //    cls: 'trigger-glyph-noop auth-email-trigger'
	                       // }
                   	      //}
					    }, {
					    	xtype: 'textfield',
					    	cls: 'auth-textbox',
					        allowBlank: false,
					        fieldLabel: '密  码:',
					        name: 'password',
					       // bind:'{password}',
					        emptyText: '请输入密码',
					        inputType: 'password',
					        x:20,
					        y:90
					    }, {
					        xtype: 'checkboxfield',
					        flex : 1,
					         height: 30,
					        fieldLabel: '记住我',
					        name: 'remember',
					        x:20,
					        y:130
					    },
					    	{
			                    xtype: 'button',
			                    reference: 'loginButton',
			                    scale: 'large',
			                    ui: 'soft-green',
			                    iconAlign: 'right',
			                    iconCls: 'x-fa fa-angle-right',
			                    text: 'Login',
			                    formBind: true,
			                    x:20,
			                    y:180,
			                    listeners: {
			                        click: 'onLoginButton'
			                    }
			                },
			                {
			                    xtype: 'button',
			                    reference: 'loginButton',
			                    scale: 'large',
			                    ui: 'soft-green',
			                    iconAlign: 'right',
			                    iconCls: 'x-fa fa-angle-right',
			                    text: 'Register',
			                    formBind: true,
			                    x:20,
			                    y:260,
			                    listeners: {
			                        click: 'onRegisterButton'
			                    }
			                },
					    ],
					   
					   // buttons: [
					  //      { text:'注册' },
					   //     { text:'登录' }
					   // ],
					    defaults: {
					        anchor: '100%',
					        labelWidth: 60
					    },					    				   
				    renderTo: Ext.getBody()
				});		
			});
			onLoginButton:function(btn) {
      		var form = btn.up('form');
			form.getForm().submit({       
				url:'login',
				//waitMsg: '正在上传，请耐心等待....',
					method : 'post', 
					params : { userName:userName,password:password}, 
					success: function(response, options) {
					                var json = Ext.util.JSON.decode(response.responseText);
						            if(json.success){
						            	Ext.Msg.alert('系统提示', json.msg, function() {
						                    window.open('index.jsp','11','location=0,resizable=no,fullscreen=true,titlebar=no,status=no,toolbar=no,menubar=no,left=0,top=0');
						                });
							        }else{
							        	 Ext.Msg.alert('系统提示', json.msg);
							        }
					            }
					failure: function(form, action){
						Ext.Msg.alert('提示', action.result.msg);
				}
			});
		}
		</script>
	</head>
	<body>
		
	</body>
</html>