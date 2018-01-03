package com.hrsys.system;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.system.entity.Role;
import com.hrsys.system.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class RoleServiceImplTest {
	@Autowired
	private IRoleService roleService;
	
	@Test
	@Rollback(false)
	public void save() {
		
		
		Role role = new Role();
		role.setRoleName("Java开发工程师");
		role.setCreateTime(new Date());
		role.setCreateModule("Java开发");
		role.setOrderNo(13);
		roleService.saveOrUpdate(role);
		
	}

}
