Ext.define('Admin.view.user.DeptGridPanel',{
	extend:'Ext.grid.Panel',
	xtype:'deptGridPanel',
	title:'部门管理列表',
	id:'deptGridPanel',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ],
    dockedItems: [{
        xtype: 'toolbar',
        items: ['-',{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text:'添加',
                handler : 'openAddWindow'
            },'-', {
            xtype:'button',
            iconCls:'x-fa fa-trash',
            text: '批量删除',
				listeners:{
		        click:'deleteDepts'
    		}
        }]
	}],
	//store:Ext.data.StoreManager.lookup('simpsonsStore'), //storeId
	selModel: {
                selType: 'checkboxmodel'
 	},
	bind:'{deptlists}',
	layout:'fit',
	columns:[
		{header:'ID',dataIndex:'id',flex:1},
		{header:'部门名称',dataIndex:'deptName',flex:1},		
		{header:'部门负责人',dataIndex:'deptOlder',flex:1},
		{header:'部门联系电话',dataIndex:'deptPhone',flex:1},
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
                handler : 'deleteDept'
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
            bind:'{deptlists}',
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
            
            
        	}
});