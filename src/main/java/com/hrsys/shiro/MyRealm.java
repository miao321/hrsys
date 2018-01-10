package com.hrsys.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
import com.hrsys.system.service.IPermissionService;
import com.hrsys.system.service.IRoleService;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserRoleService;
import com.hrsys.user.service.IUserService;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private ILoginService loginService;
	@Autowired
	private IPermissionService permissionService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserService userService;
	public String getName() {
		return "myRealm";
	}
	
	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获取输入的的身份信息
		String userName = (String) token.getPrincipal();
		//从数据库中去的传入的信息		
		//模拟差不到这个用户
		User user = loginService.findUser(userName);	
		if(user == null) {
			return null;
		}
		String password = user.getPassword();	
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, this.getName());
		return simpleAuthenticationInfo;
	}

	@SuppressWarnings("unchecked")
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		
		String userName = (String) principal.fromRealm(getName()).iterator().next();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(userName != null) {
			List<UserRole> userRoles = userService.getRoleByUserName(userName);
			for (UserRole userRole : userRoles) {
				info.addRole(userRole.getRole().getRoleName());
			}
			List<String> permissions = userService.getPermissionsByUserName(userName);
			if (permissions != null && !permissions.isEmpty()) {
				for(String each : permissions) {
					info.addStringPermission(each);
					
					System.out.println(each);
				}
			}
		}
		System.out.println("++++++++:"+info);
		return info;
	}
		//User user = (User) principal.fromRealm(this.getName()).iterator().next();
		//Set<Role> roleSet = user.getUserRoles();
	/*	System.out.println("++++:"+principal.getPrimaryPrincipal());
		Object user =  principal.getPrimaryPrincipal();
		System.out.println("AuthenticationInfo+++:"+user);
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		System.out.println(0000);
		User us = loginService.findUser(user.toString());
		System.out.println(us.getUserName());
		
		Set<Permission> permissions = null;
		try {
			//permissions = (Set<Permission>) permissionService.findOne(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (permissions != null) {
			for(Permission permission : permissions) {
				set.add(permission.getUrl());
			}
		}
		
		Set<Role> roles = null;
		try {
			//roles = (Set<Role>) roleService.findOne(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (roles != null) {
			for(Role role : roles) {
				set2.add(role.getRoleName());
			}			
		}
		//查询权限数据  并返回权限数据
		SimpleAuthorizationInfo simpleAuthorizationInfo  =new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(set);
		simpleAuthorizationInfo.addRoles(set2);
		return simpleAuthorizationInfo;
	
	}*/
}
