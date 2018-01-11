Ext.define('Admin.view.user.RoleGridPanel',{
	extend:'Ext.grid.Panel',
	xtype:'roleGridPanel',
	title:'角色管理列表',
	id:'roleGridPanel',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ],
    dockedItems: [{
        xtype: 'toolbar',
        items: ['-',{
                xtype: 'button',
                text:'添加',
                iconCls: 'x-fa fa-plus',
                handler : 'openAddWindow'
        },'-',{
            xtype: 'button',
            text:'权限',
            iconCls: 'x-fa fa-plus',
            handler : 'addPermissionWindow'
        } ,'-', {
            xtype:'button',
            iconCls:'x-fa fa-trash',
            text: '批量删除',
				listeners:{
		        click:'deleteRoles'
    		}
        }]
	}],
	//store:Ext.data.StoreManager.lookup('simpsonsStore'), //storeId
	selModel: {
                selType: 'checkboxmodel'
 	},
	bind:'{rolelists}',
	layout:'fit',
	columns:[
		{header:'ID',dataIndex:'id',flex:1},
		{header:'角色名称',dataIndex:'roleName',flex:1},
		{header:'创建模块',dataIndex:'createModule',flex:1},
		{header:'排序号',dataIndex:'orderNo',flex:1},
	//	{xtype: 'rownumberer',width: 40, sortable: false},
		{
            xtype: 'actioncolumn',
            items: [{
        		xtype: 'button',
                iconCls: 'x-fa fa-pencil',
               	tooltip:'编辑',
                handler : 'openEditWindow'
            },{
                xtype: 'button',
                iconCls: 'x-fa fa-trash',
               	tooltip:'删除',
                handler : 'deleteRole'
	        },{
                xtype: 'button',
                iconCls: 'x-fa fa-ban',
                tooltip:'禁用',
              //  handler : 'deleteUser'
	        },{
                xtype: 'button',
                iconCls: 'x-fa fa-unlock',
                tooltip:'启用',
              //  handler : 'deleteUser'
	        }],
            cls: 'content-column',
            width: 120,
            //dataIndex: 'bool',
            text: '操作',
            tooltip: '操作 ',
            flex:1
          }			
	],
	bbar: {
		    xtype: 'pagingtoolbar',//注意以后MVVM中使用新写法,不要使用Ext.create()
            //store: Ext.data.StoreManager.lookup('simpsonsStore'),
           	bind:'{rolelists}',
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
            //layout:'center',
           
            
        	}
});
