Ext.define('Admin.view.user.UserViewController', {extend:Ext.app.ViewController, alias:'controller.userViewController', onShowPreviewButtonClick:function(btn) {
  alert('Hello');
},


 openAddWindow:function(view, recIndex, cellIndex, item, e, record) {
  var cfg = Ext.apply({xtype:'userAddWindow', items:[Ext.apply({xtype:'userAddForm'})]});
  var win = Ext.create(cfg);
}, submitAddForm:function(btn) {
  var form = btn.up('form');
  form.getForm().submit({url:'user/saveOrUpdate', success:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg, function() {
      btn.up('window').close();
      Ext.getCmp('userGridPanel').getStore().reload();
    });
  }, failure:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg);
  }});
}, openEditWindow:function(view, recIndex, cellIndex, item, e, record) {
  var cfg = Ext.apply({xtype:'userEditWindow', items:[Ext.apply({xtype:'userEditForm'})]});
  var win = Ext.create(cfg);
  win.down('form').getForm().loadRecord(record);
}, submitEditSaveForm:function(btn) {
  var form = btn.up('form');
  form.getForm().submit({url:'user/saveOrUpdate', success:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg, function() {
      btn.up('window').close();
      Ext.getCmp('userGridPanel').getStore().reload();
     // form.getViewModel().getStore('userDataList').reload();
    });
  }, failure:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg);
  }});
}, submitEditForm:function(btn) {
  var form = btn.up('form');
  form.getForm().submit({url:'user/save', success:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg, function() {
      btn.up('window').close();
      Ext.getCmp('userGridPanel').getStore().reload();
     // form.getViewModel().getStore('userDataList').reload();
    });
  }, failure:function(form, action) {
    Ext.Msg.alert('提示', action.result.msg);
  }});
},  deleteUser:function(view, recIndex, cellIndex, item, e, record) {
  Ext.MessageBox.confirm('提示', '确定要进行删除操作吗？数据将无法还原！', function(btn, text) {
    if (btn == 'yes') {
      Ext.Ajax.request({url:'user/delete', method:'post', params:{id:record.get('id')}, success:function(response, options) {
        var json = Ext.util.JSON.decode(response.responseText);
        if (json.success) {
          Ext.Msg.alert('系统提示', json.msg, function() {
            view.getStore().reload();
          });
        } else {
          Ext.Msg.alert('系统提示', json.msg);
        }
      }});
    }
  }, this);
}, deleteUsers:function(btn) {
  var grid = btn.up('gridpanel');
  var selModel = grid.getSelectionModel();
  if (selModel.hasSelection()) {
    Ext.Msg.confirm('警告', '确定要删除吗？', function(button) {
      if (button == 'yes') {
        var selected = selModel.getSelection();
        var selectIds = [];
        Ext.each(selected, function(item) {
          selectIds.push(item.data.id);
        });
        Ext.Ajax.request({url:'user/deleteUsers', method:'post', params:{ids:selectIds}, success:function(response, options) {
          var json = Ext.util.JSON.decode(response.responseText);
          if (json.success) {
            Ext.Msg.alert('操作成功', json.msg, function() {
              grid.getStore().reload();
            });
          } else {
            Ext.Msg.alert('操作失败', json.msg);
          }
        }});
      }
    });
  } else {
    Ext.Msg.alert('错误', '没有任何行被选中，无法进行删除操作！');
  }
}, search:function(view, recIndex, cellIndex, item, e, record) {
  var searchField = this.lookupReference('searchFieldName').getValue();
  var searchValue = this.lookupReference('searchFieldValue').getValue();
  var store = Ext.getCmp('userGridPanel').getStore();
  Ext.apply(store.proxy.extraParams, {userName:'', password:''});
  if (searchField === 'userName') {
    Ext.apply(store.proxy.extraParams, {userName:searchValue});
  }
  if (searchField === 'password') {
    Ext.apply(store.proxy.extraParams, {password:searchValue});
  }
  store.load({params:{start:0, limit:25, page:1}});
},

addRoleWindow:function(view, recIndex, cellIndex, item, e, record) {
  var cfg = Ext.apply({xtype:'addRoleWindow', items:[Ext.apply({xtype:'addRoleFormPanel'})]});
  var win = Ext.create(cfg);
},

updateMessage: function(view, recIndex, cellIndex, item, e, record) {         
    	var cfg = Ext.apply({xtype:'updateMessage',
    	items:[Ext.apply({xtype:'updateMessageFormPanel'})]
    	});
    	var win = Ext.create(cfg);
    //	win.show();  
    	
    		Ext.Ajax.request({ 
			url : 'updateMessage', 
			method : 'post', 
		//	params : { id :userId},				
			success: function(response, options) {				
				var json = Ext.util.JSON.decode(response.responseText);
				if(json.success){						        
					win.down('form').getForm().findField("id").setValue(json.id);
					win.down('form').getForm().findField("userNo").setValue(json.userNo);
					win.down('form').getForm().findField("userName").setValue(json.userName);
					win.down('form').getForm().findField("password").setValue(json.password);
					win.down('form').getForm().findField("userNickName").setValue(json.userNickName);
					win.down('form').getForm().findField("sex").setValue(json.sex);
					win.down('form').getForm().findField("birthday").setValue(json.birthday);
					win.down('form').getForm().findField("age").setValue(json.age);
					win.down('form').getForm().findField("nativePlace").setValue(json.nativePlace);
					win.down('form').getForm().findField("nation").setValue(json.nation);
					win.down('form').getForm().findField("culture").setValue(json.culture);
					win.down('form').getForm().findField("college").setValue(json.college);
					win.down('form').getForm().findField("body").setValue(json.body);
					win.down('form').getForm().findField("marriage").setValue(json.marriage);
					win.down('form').getForm().findField("idCord").setValue(json.idCord);
					win.down('form').getForm().findField("phone").setValue(json.phone);
					win.down('form').getForm().findField("familyPhone").setValue(json.familyPhone);
					win.down('form').getForm().findField("email").setValue(json.email);
					win.down('form').getForm().findField("userAccount").setValue(json.userAccount);
					win.down('form').getForm().findField("deptName").setValue(json.deptName);
					win.down('form').getForm().findField("remark").setValue(json.remark);
				}			                		
				else{
					Ext.Msg.alert("温馨提示:",action.result.msg);			          						
				}			                			
            },
			failure: function(response, action){
				 //var json = Ext.util.JSON.decode(response.responseText);
				Ext.Msg.alert("温馨提示:",action.result.msg);
				// alert("msg:"+response.msg);
				}
        	});       								  
	  }

});
