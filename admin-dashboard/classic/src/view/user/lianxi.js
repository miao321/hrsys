//定义组合框模板  
var itemTpl = new Ext.XTemplate(  
    '<div class="x-combo-list-item {[xindex % 2 == 0 ? "even" : "odd"]}">',  
    '{#} ：{[this.check(values)]}</div>',  
    {  
        check : function (values) {  
            if(values.value > 2 ){  
                return "<font color=red>"+values.item+"</font>";  
            }else {  
                return "<font color=blue>"+values.item+"</font>";  
            }  
        }  
    }  
);  
//创建数据模型  
Ext.regModel('ItemInfo', {  
    fields: ['item','value']  
});  
  
new Ext.form.Panel({  
   /* title:'在Extjs组件中使用模板',  
    renderTo: Ext.getBody(),  
    bodyPadding: 5,  
    height : 100,  
    frame : true,  
    width : 350,  */
    items : [{  
        xtype : 'combo',  
        //fieldLabel:'邮政编码',  
        displayField:'item',  
        valueField:'value',  
        labelSeparator :'：',//分隔符  
        listConfig : {  
            itemTpl : itemTpl  
        },  
        editable : false,  
        queryMode: 'local',  
        triggerAction: 'all',        		
       	store: {
       	   autoLoad:true,
       	    model : 'ItemInfo',  
       	   fields: ['item','value'],  
	       	proxy: {
				type: 'ajax',
				url:'role/findRolePermission.json',
				reader: {
					type: 'json',
					rootProperty: 'lists',
					totalProperty:'totalElements'
				  }
			}
		},
    }]  
}); 
		
		<h1>自动渲染单根数组</h1>
    <div class="content" id="div4"></div>
   
   	var data = {  
    drinks: ['绿茶', '红酒', '咖啡'],  
};	
	
	
	var tpl = new Ext.XTemplate(  
      '<tr><td>喜好饮品：</td><td>{drinks}</td></tr>',    
);
tpl.overwrite(Ext.get("div1"), data);	
	
	var tp4 = new Ext.XTemplate(
 '喜好饮品：<tpl for="drinks">',
 ' {.}',
  '</tpl>'
);
tp4.overwrite(Ext.get("div4"), data); 