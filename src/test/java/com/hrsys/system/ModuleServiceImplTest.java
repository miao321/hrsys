package com.hrsys.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.system.entity.Module;
import com.hrsys.system.service.IModuleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class ModuleServiceImplTest {
	@Autowired
	private IModuleService moduleService;
	
	@Test
	@Rollback(false)
	public void save() {
		for(int i=0;i<=100;i++) {
		Module module = new Module();
		module.setModuleName("角色管理");
		module.setParentName("系统管理");
		module.setState(1);
		moduleService.saveOrUpdate(module);
	}
	}
	

}
