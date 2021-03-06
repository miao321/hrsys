Ext.define('Admin.view.authentication.AuthenticationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.authentication',

    //TODO: implement central Facebook OATH handling here

    onFaceBookLogin : function() {
        this.redirectTo('dashboard', true);
    },

    onLoginButton: function(btn) {
        var me = this;
        
        Ext.Ajax.request({
        	url:'login',
        	method:'post',
	        params: {
	                userName: btn.up("form").getForm().findField("userName").getValue(),
	                password: btn.up("form").getForm().findField("password").getValue()
	            },
	            success: function(response, options) {
	            	var json = Ext.util.JSON.decode(response.responseText);
		            if(json.success){
		            	me.redirectTo('dashboard', true);
		            	window.location.reload();//刷新页面
			        }else{
			        	Ext.Msg.alert('登录失败', json.msg);
			        }
	            }
        });
    },

    onLoginAsButton: function() {
        this.redirectTo('login', true);
    },

    onNewAccount:  function() {
        this.redirectTo('register', true);
    },

    onSignupClick:  function() {
        this.redirectTo('dashboard', true);
    },

    onResetClick:  function() {
        this.redirectTo('dashboard', true);
    }
});