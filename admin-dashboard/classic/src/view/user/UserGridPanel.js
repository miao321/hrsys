Ext.define('Admin.view.user.UserGridPanel',{
	extend:'Ext.grid.Panel',
	xtype:'userGridPanel',
	title:'用户管理列表',
	id:'userGridPanel',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ],dockedItems: [{
        xtype: 'toolbar',
        items: [{
	        xtype: 'combobox',
	        fieldLabel: '',
	        name: 'searchFieldName',
	        reference:'searchFieldName',
	        store: {
	            proxy: {
	                type: 'memory',
	                reader: 'array'
	            },
	            fields: [ 'key', 'value'],
	            data: [
	                ['用户名', 'userName'],
	                ['密码', 'password']
	            ]
	        },
	        queryMode: 'local',
	        displayField: 'key',
	        valueField: 'value',
	       	value:'userName',
	        allowBlank: false
	    },'-',{
            xtype: 'textfield',
            name:'searchFieldValue',
            reference:'searchFieldValue'
        },'-',{
            text:'快捷查询',
            tooltip:'快捷查询',
            iconCls:'x-fa fa-search',
            handler : 'search'
        },'-',{
            text:'高级查询',
            tooltip:'高级查询',
            iconCls:'x-fa fa-search-plus',
            handler : 'openMoreSearchWindow'
	        },'-',{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                handler : 'openAddWindow'
            }]
	}],
	//store:Ext.data.StoreManager.lookup('simpsonsStore'), //storeId
	selModel: {
                selType: 'checkboxmodel'
 	},
	bind:'{userlists}',
	layout:'fit',
	columns:[
		{header:'ID',dataIndex:'id',flex:1},
		{header:'userName',dataIndex:'userName',flex:1},
		{header:'Password',dataIndex:'password',flex:1},
		{header:'Birthday',dataIndex:'birthday',flex:1,renderer:Ext.util.Format.dateRenderer('Y/m/d H:i:s')},
	//	{xtype: 'rownumberer',width: 40, sortable: false},
		{
            xtype: 'actioncolumn',
            items: [{
        		xtype: 'button',
                iconCls: 'x-fa fa-pencil',
                handler : 'openEditWindow'
            },{
                xtype: 'button',
                iconCls: 'x-fa fa-trash',
                handler : 'deleteUser'
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
           	bind:'{userlists}',
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
            items:[
                '-', {
                xtype:'button',
                text: '批量删除',
					listeners:{
			        click:'deleteUsers'
        		}
            }]
            
        	}
});