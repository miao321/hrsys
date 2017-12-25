package com.hrsys.employ;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.service.IEmployJobService;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class EmployJobServiceTest {

	@Autowired
	private IEmployJobService employJobService;
	
	//@Test
	@Rollback(value = false)
	public void save() {
		for(int i=0;i<100;i++) {
			
//			User user = new User();
//			user.setUserName("张三");
//			user.setPassword("123");
//			user.setBirthday(new Date());
//			userService.saveOrUpdate(user);
//			System.out.println(user);
			
			EmployJob employJob = new EmployJob();
			employJob.setEmployJobId(i);
			employJob.setEmployJobNo("No"+i);
			employJobService.saveOrUpdate(employJob);
			System.out.println(employJob);
			
		}
		
	}
	
/*	//@Test
	@Rollback(value=false)
	public void delete() {
		User user = userService.findOne(4L);
		userService.delete(user);
	}*/
	
	//@Test
	@Rollback(value=false)
	public void delete() {
		for(int i=0;i<100;i++) {
		EmployJob employJob= employJobService.findOne(4L);
		employJobService.delete(employJob);
		}
	}
	
}
