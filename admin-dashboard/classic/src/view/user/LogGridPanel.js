Ext.define('Admin.view.user.LogGridPanel',{
	extend:'Ext.grid.Panel',
	xtype:'logGridPanel',
	title:'日志管理列表',
	id:'logGridPanel',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ],
    dockedItems: [{
        xtype: 'toolbar',
        items: ['-', {
            xtype:'button',
            iconCls:'x-fa fa-trash',
            text: '批量删除',
				listeners:{
		        click:'deleteLogs'
    		}
        }]
	}],
	//store:Ext.data.StoreManager.lookup('simpsonsStore'), //storeId
	selModel: {
                selType: 'checkboxmodel'
 	},
	bind:'{loglists}',
	layout:'fit',
	columns:[				
		{header:'ID',dataIndex:'id',flex:1},
		{header:'用户名',dataIndex:'userName'/*text:loginUser*/,flex:1},		
		{header:'操作模块',dataIndex:'module',flex:1},
		{header:'操作内容',dataIndex:'method',flex:1},
		{header:'操作时间',dataIndex:'operationTime',flex:1,renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
	//	{xtype: 'rownumberer',width: 40, sortable: false},
		{
            xtype: 'actioncolumn',
            items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-trash',
                handler : 'deleteLog'
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
           	bind:'{loglists}',
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
           
            
        	}
});