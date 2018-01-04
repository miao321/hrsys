Ext.define('Admin.view.user.UserViewController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.userViewController',
	requires: [
    	'Ext.grid.column.RowNumberer',
    	'Ext.selection.CheckboxModel'
    ],
	//声明一个按钮事件：
	onShowPreviewButtonClick: function(btn) {
      		alert("Hello");
    }
    ,openAddWindow: function(view, recIndex, cellIndex, item, e, record) {
      		var cfg = Ext.apply({
                xtype: 'userAddWindow',
                items: [Ext.apply({xtype: 'userAddForm'})]
		});
		var win = Ext.create(cfg);
    }
    ,submitAddForm: function(btn) {
      		var form = btn.up('form');
			form.getForm().submit({       
				url:'user/saveOrUpdate',
				//waitMsg: '正在上传，请耐心等待....',
				success: function(form, action){    
					Ext.Msg.alert('提示', action.result.msg,function(){
						btn.up('window').close();
					//	form.getViewModel().getStore('userDataList').reload();
	                   Ext.getCmp('userGridPanel').getStore().reload();
						
					});       
				},       
				failure: function(form, action){
					Ext.Msg.alert('提示', action.result.msg);
				}
			});
    }
    ,openEditWindow: function(view, recIndex, cellIndex, item, e, record) {
    	var cfg = Ext.apply({
                xtype: 'userEditWindow',
                items: [Ext.apply({xtype: 'userEditForm'})]
		});
		var win = Ext.create(cfg);
		
		win.down("form").getForm().loadRecord(record);//加载修改数据到Form
      	
    }
     ,submitEditForm: function(btn) {
      		var form = btn.up('form');
			form.getForm().submit({       
				url:'user/saveOrUpdate',
				//waitMsg: '正在上传，请耐心等待....',
				success: function(form, action){    
					Ext.Msg.alert('提示', action.result.msg,function(){
						btn.up('window').close();
					//	form.getViewModel().getStore('userDataList').reload();
	                    Ext.getCmp('userGridPanel').getStore().reload();
						
					});       
				},       
				failure: function(form, action){
					Ext.Msg.alert('提示', action.result.msg);
				}
			});
	}

     ,deleteUser: function(view, recIndex, cellIndex, item, e, record) {
      		Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！',
      			function(btn, text){
                	if(btn=='yes'){
				Ext.Ajax.request({ 
					url : 'user/delete', 
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
    	
    changePassword: function(view, recIndex, cellIndex, item, e, record) {
      		Ext.MessageBox.confirm('提示', '确定要修改密码嘛？',
      			function(btn, text){
                	if(btn=='yes'){
				Ext.Ajax.request({ 
					url : 'changePassword', 
					method : 'post', 
					params : { id :userId},				
					success: function(response, action) {				
    					var flag=action.result.success;			                		
    					if(flag){
    						window.location='index.jsp';
    					}else{
    						alert("msg:"+action.result.msg);			          						
    					}			                			
    	            },
    				failure: function(response, action){
    					 //var json = Ext.util.JSON.decode(response.responseText);
    					alert("msg:"+action.result.msg);
    					// alert("msg:"+response.msg);
    					}
					});
               		}
            	}
            , this);
    },
    
    updateMessage: function(view, recIndex, cellIndex, item, e, record) {
      		Ext.MessageBox.confirm('提示', '确定要修改密码信息嘛？',
      			function(btn, text){
                	if(btn=='yes'){
				Ext.Ajax.request({ 
					url : 'updateMessage', 
					method : 'post', 
				//	params : { id :userId},				
					success: function(response, action) {				
    					var flag=action.result.success;			                		
    					if(flag){
    						window.location='index.jsp';
    					}else{
    						alert("msg:"+action.result.msg);			          						
    					}			                			
    	            },
    				failure: function(response, action){
    					 //var json = Ext.util.JSON.decode(response.responseText);
    					alert("msg:"+action.result.msg);
    					// alert("msg:"+response.msg);
    					}
					});
               		}
            	}
            , this);
    },
    
    
     	
    deleteUsers: function(btn) {
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
						url : 'user/deleteUsers', 
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
    },
    search: function(view, recIndex, cellIndex, item, e, record) {
		var searchField = this.lookupReference('searchFieldName').getValue();
		var searchValue = this.lookupReference('searchFieldValue').getValue();
		
		var store = Ext.getCmp('userGridPanel').getStore();
		
		Ext.apply(store.proxy.extraParams, {userName:"",password:""});
			
		if(searchField==='userName'){
			Ext.apply(store.proxy.extraParams, {userName:searchValue});
		}
		if(searchField==='password'){
			Ext.apply(store.proxy.extraParams, {password:searchValue});
		}
		
		store.load({params:{start:0, limit:25, page:1}});
		
    }

});