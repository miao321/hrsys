package com.hrsys.system;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.common.EncryptUtils;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
import com.hrsys.system.service.IPermissionService;
import com.hrsys.system.service.IRoleService;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.service.IUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
//@Transactional
public class PermissionServiceTest {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionService permissionService;
	@Test
	@Rollback(value = false)
	public void save() throws NoSuchAlgorithmException {
			
			Role role = new Role();
			role.setRoleName("ddd");
			Permission permission = new Permission();
			permission.setDescription("权限说明");
			permission.setUrl("user/delete");			
			permission.getRole().add(role);
			
			permissionService.saveOrUpdate(permission);

	}

}
