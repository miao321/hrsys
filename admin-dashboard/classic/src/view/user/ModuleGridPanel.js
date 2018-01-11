Ext.define('Admin.view.user.ModuleGridPanel',{
	extend:'Ext.grid.Panel',
	xtype:'moduleGridPanel',
	title:'模块管理列表',
	id:'moduleGridPanel',
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
            },'-', {
            xtype:'button',
            iconCls:'x-fa fa-trash',
            text: '批量删除',
				listeners:{
		        click:'deleteModules'
    		}
        }]
	}],
	//store:Ext.data.StoreManager.lookup('simpsonsStore'), //storeId
	selModel: {
                selType: 'checkboxmodel'
 	},
	bind:'{modulelists}',
	layout:'fit',
	columns:[
		{header:'ID',dataIndex:'id',flex:1},
		{header:'模块名称',dataIndex:'moduleName',flex:1},		
		{header:'父部门',dataIndex:'parentName',flex:1},
		{header:'状态',dataIndex:'state',flex:1},
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
                handler : 'deleteModule'
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
           	bind:'{modulelists}',
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
            
            
        	}
});