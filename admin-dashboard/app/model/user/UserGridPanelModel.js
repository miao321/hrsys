Ext.define('Admin.store.user.UserGridPanelStore', {extend:Ext.data.Store, alias:'store.userGridPanelStore', model:'Admin.model.user.UserGridPanelModel', pageSize:25, proxy:{type:'ajax', url:'user/findUserRole.json', reader:{type:'json', rootProperty:'lists', totalProperty:'totalElements'}, simpleSortMode:true}, remoteSort:true, sorters:{direction:'DESC', property:'id'}});
