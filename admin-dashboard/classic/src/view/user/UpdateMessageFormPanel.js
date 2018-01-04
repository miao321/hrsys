Ext.define('Admin.view.user.UpdateMessageFormPanel',{
	extend:'Ext.container.Container',
	xtype:'updateMessageFormPanel',   //对应NavigationTree store 的 viewType:'user'
	labelAlign: 'left',
    //	id:'Form1',
    autoHeight: true,
    width: 513,
    frame: true, 
    items: [
    {
    	cls: 'auth-textbox',
		allowBlank:false,
        xtype: 'textfield',
        fieldLabel: '密码:',
        name:'password',
       	emptyText: '请输入密码',
       	height:40,
		style:'text-align:center;margin-top:20px;'
    	},
    	{
        cls: 'auth-textbox',
		allowBlank:false,
        xtype: 'textfield',
        fieldLabel: '新密码:',
        name:'comfirPassword',
       	emptyText: '请输入新密码',
       	height:40,
		style:'text-align:center;'
    	}],
    	bbar: {
	        overflowHandler: 'menu',
	        items: ['->',{
	            xtype: 'button',
	            ui: 'soft-green',
	            text: '提交',
	            handler : 'updateMessage'
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