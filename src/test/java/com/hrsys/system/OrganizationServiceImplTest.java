package com.hrsys.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.system.entity.Organization;
import com.hrsys.system.service.IOrganizationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class OrganizationServiceImplTest {
	@Autowired
	private IOrganizationService organizationService;
	@Test
	@Rollback(false)
	public void save() {
		for(int i=0;i<=100;i++) {
			Organization organization = new Organization();
			organization.setDeptName("Java开发");
			organization.setDeptOlder("老大");
			organization.setDeptGrade("abc");
			organizationService.saveOrUpdate(organization);
			
		}
	}

}
