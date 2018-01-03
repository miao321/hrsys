package com.hrsys.user;

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
import com.hrsys.system.entity.Role;
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
public class UserServiceTest {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Test
	@Rollback(value = false)
	public void save() throws NoSuchAlgorithmException {
		
			User user = new User();
			user.setUserName("sss");
			user.setPassword(EncryptUtils.encript("123"));
			user.setBirthday(new Date());
			
			Role role = new Role();
			role.setRoleName("Java工程师");
			
			UserRole userRoles = new UserRole();
			userRoles.setUser(user);
			userRoles.setRole(role);
	
			user.getUserRoles().add(userRoles);
			role.getUserRoles().add(userRoles);
			
			userService.saveOrUpdate(user);
		//	roleService.saveOrUpdate(role);
			
			System.out.println(user);
		
		
	}
	
	//@Test
	@Rollback(value=false)
	public void delete() {
		User user = userService.findOne(4L);
		userService.delete(user);
	}
	/*
	@Test
	@Rollback(value=false)
	public void deletes() {
		for(int i=1;i<=100;i++) {
			userService.findOne()
		}
		
	}*/
	//@Test
	@Rollback(value=false)
	public void findOne() {
		
		System.out.println(userService.findOne(5L));
	}
	//@Test
	@Rollback
	public void findAll() {
		System.out.println(userService.findAll());
	}
	

}
