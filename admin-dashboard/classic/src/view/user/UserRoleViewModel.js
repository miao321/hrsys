Ext.define('Admin.view.user.UserRoleViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.userRoleViewModel',//配置到主视图的ViewModel名
    requires: [
        'Ext.data.Store',
        'Ext.data.proxy.Memory',
        'Ext.data.field.Integer',
        'Ext.data.field.String',
        'Ext.data.field.Date',
        'Ext.data.field.Boolean',
        'Ext.data.reader.Json'
    ],
    stores: {
		userRolelists: {type: 'userRoleGridPanelStore',autoLoad:true}
    }
});


select new UserRoleQueryDTO(userName,roleName,deptName)
from User u left outer join fetch u.UserRole ur 
                           left outer join fetch u.Role r
					
from User u left join u.UserRole ur left join ur.Role r where u.id=ur.userId and r.id=ur.roleId

from User u left join fetch u.roles where u.account = ?

select u.userName, u.deptName,r.roleName from User u,User ur,Role r where u.id in(ur.userId) and r.id in(ur.roleId)