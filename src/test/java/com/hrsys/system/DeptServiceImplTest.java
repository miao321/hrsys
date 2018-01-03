package com.hrsys.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.system.entity.Dept;
import com.hrsys.system.service.IDeptService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class DeptServiceImplTest {
	@Autowired
	private IDeptService DeptService;
	@Test
	@Rollback(false)
	public void save() {
		for(int i=0;i<=100;i++) {
			Dept Dept = new Dept();
			Dept.setDeptName("开发");
			
			Dept Dept1 = new Dept();
			Dept1.setDeptName("Java开发");
			
			Dept.getChildDept().add(Dept1);
			
			Dept1.setParentName(Dept);
			
			DeptService.saveOrUpdate(Dept);
			
		}
	}

}
