Ext.define('Admin.view.user.AddRoleFormPanel',{
	extend:'Ext.form.Panel',
	xtype:'addRoleFormPanel',   //对应NavigationTree store 的 viewType:'user'
	labelAlign: 'left',
	id:'addRoleFormPanel',
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
    items: [
     {
       xtype: "combobox",
       name: "id",
       model:'local',
       fieldLabel: "角色名",
       store: {
       	   autoLoad:true,
       	   fields:[{name:'id',type:'int'},{name:'roleName',type:'string'}],
	       	proxy: {
				type: 'ajax',
				url:'role/findAll.json',
				reader: {
					type: 'json',
					rootProperty: 'lists',
					totalProperty:'totalElements'
				  }
			}
		},
        editable: false,
        valueField: "id",
        displayField: "roleName",
       
        emptyText: "--请选择--",
        queryMode: "local",
        height:40,
		style:'text-align:center;margin-top:20px;'
    }],
    	bbar: {
	        overflowHandler: 'menu',
	        items: ['->',{
	            xtype: 'button',
	            ui: 'soft-green',
	            text: '提交',
	            handler : 'addRole'
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
