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
					     	allowBlank:false,
					        //allowBlank: '用户名不能为空',
					       // minLength:6,  
				           // minLengthText:'用户名长度为[6-20]',  
				           // maxLength:20,  
				           // maxLength:'用户名长度为[6-20]',  
					        fieldLabel: '用户名:',
					        name: 'userName',
					        width:308,
					        height:40,
				        	emptyText: '请输入用户名',
				        	style:'text-align:center;'
				        	
					     
					    }, {
					    	xtype: 'textfield',
					    	cls: 'auth-textbox',
					    	allowBlank:false,
					    	//allowBlank:'密码不能为空',  
				            //minLength:6,  
				            //minLengthText:'密码长度为[6-20]',  
				            //maxLength:20,  
				            //maxLength:'密码长度为[6-20]',
					        fieldLabel: '密码:',
					        name: 'password',
					        width:308,
					        height:40,
					        emptyText: '请输入密码',
					        inputType: 'password',
					        style:'margin-top:20px;font-family:bold;font-size:20px;text-align:center;',					      
					        y:110
					    }, {
					        xtype: 'checkboxfield',
					        flex : 1,
					         height: 30,
					        fieldLabel: '记住我',
					        name: 'remember',
					        style:'margin-top:6px;text-align:center;',
					        x:20,
					        y:150
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
			                    y:40,
			                    listeners: {
			                    	click : function() {
			                    		var form = this.up('form');
			                    		
			                    		form.getForm().submit({       
			                				url:'login',
			                				//waitMsg: '正在上传，请耐心等待....',
			                				method : 'post', 
			                				//params : { userName:userName,password:password}, 
			                				// params:{  
				                              //  userName:Ext.getCmp('userName').getValue(),  //获得filefield中的值  
				                              //  password:Ext.getCmp('password').getValue()  
				                            //},  
				                            
			                				success: function(response, action) {		
			                					var flag=action.result.success;
			                					if(flag){
			                						window.location="index.jsp";
			                					}else{
			                						window.location="login.jsp";
			                						var json = Ext.util.JSON.decode(response.responseText);
			                						Ext.Msg.alert('系统提示', json.msg);
			                					}
			                					//window.location="index.jsp";
			                					 //var json = Ext.decode(response.responseText);
			                	               // var json = Ext.util.JSON.decode(response.responseText);
			                		            //if(json.success){			                		            	
			                		           // 		window.location="index.jsp";	                		              			                		            
			                			       // }else{
			                			       //	 Ext.Msg.alert('系统提示', json.msg);
			                			      //  }
			                	            },
			                				failure: function(response, action){
			                					var json = Ext.util.JSON.decode(response.responseText);
			                					//Ext.Msg.alert('提示', json.msg);
			                				}
			                			});
			                    		
			                    	}
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
			                    //formBind: true,
			                    x:20,
			                    y:50,
			                    listeners: {
			                    	click : function() {
			                    		 window.location='register.jsp';
			                    	}
			                      
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
			
			function onLoginButton(btn) {
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
	            },
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