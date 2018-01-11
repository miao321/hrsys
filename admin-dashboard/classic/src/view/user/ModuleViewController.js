Ext.define('Admin.view.user.ModuleViewController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.moduleViewController',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ]
    ,openAddWindow: function(view, recIndex, cellIndex, item, e, record) {
      		var cfg = Ext.apply({
                xtype: 'moduleAddWindow',
                items: [Ext.apply({xtype: 'moduleAddForm'})]
		});
		var win = Ext.create(cfg);
    }
    ,submitAddForm: function(btn) {
      		var form = btn.up('form');
			form.getForm().submit({       
				url:'module/saveOrUpdate',
				//waitMsg: '正在上传，请耐心等待....',
				success: function(form, action){    
					Ext.Msg.alert('提示', action.result.msg,function(){
						btn.up('window').close();
					//	form.getViewModel().getStore('userDataList').reload();
	                   Ext.getCmp('moduleGridPanel').getStore().reload();
						
					});       
				},       
				failure: function(form, action){
					Ext.Msg.alert('提示', action.result.msg);
				}
			});
    }
    ,openEditWindow: function(view, recIndex, cellIndex, item, e, record) {
    	var cfg = Ext.apply({
                xtype: 'moduleEditWindow',
                items: [Ext.apply({xtype: 'moduleEditForm'})]
		});
		var win = Ext.create(cfg);
		
		win.down("form").getForm().loadRecord(record);//加载修改数据到Form
      	
    }
     ,submitEditForm: function(btn) {
      		var form = btn.up('form');
			form.getForm().submit({       
				url:'module/saveOrUpdate',
				//waitMsg: '正在上传，请耐心等待....',
				success: function(form, action){    
					Ext.Msg.alert('提示', action.result.msg,function(){
						btn.up('window').close();
						//form.getViewModel().getStore('roleDataList').reload();
	                   Ext.getCmp('moduleGridPanel').getStore().reload();
						
					});       
				},       
				failure: function(form, action){
					Ext.Msg.alert('提示', action.result.msg);
				}
			});
	}

     ,deleteModule: function(view, recIndex, cellIndex, item, e, record) {
      		Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',
      			function(btn, text){
                	if(btn=='yes'){
				Ext.Ajax.request({ 
					url : 'module/delete', 
					method : 'post', 
					params : { id :record.get('id')}, 
					success: function(response, options) {
					                var json = Ext.util.JSON.decode(response.responseText);
						            if(json.success){
						            	Ext.Msg.alert('系统提示', json.msg, function() {
						                    view.getStore().reload();
						                });
							        }else{
							        	 Ext.Msg.alert('系统提示', json.msg);
							        }
					            }
					});
               		}
            	}
            , this);
   
    },
     	
    deleteModules: function(btn) {
      	var grid = btn.up('gridpanel');
		var selModel = grid.getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var selected = selModel.getSelection();
                    var selectIds = []; //要删除的id
                    Ext.each(selected, function (item) {
                        selectIds.push(item.data.id);
                    })
                  	Ext.Ajax.request({ 
						url : 'module/deleteModules', 
						method : 'post', 
						params : { 
							//ids[] :selectIds
							ids :selectIds
						}, 
						success: function(response, options) {
			                var json = Ext.util.JSON.decode(response.responseText);
				            if(json.success){
				            	Ext.Msg.alert('操作成功', json.msg, function() {
				                    grid.getStore().reload();
				                });
					        }else{
					        	 Ext.Msg.alert('操作失败', json.msg);
					        }
			            }
					});

                }
            });
        }
        else {
            Ext.Msg.alert("错误", "没有任何行被选中，无法进行删除操作！");
        }
    }

});
