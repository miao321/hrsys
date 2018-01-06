package com.hrsys.employ;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.employ.entity.EmployActivity;
import com.hrsys.employ.service.IEmployActivityService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class EmployActivityServiceTest {
	@Autowired
	private IEmployActivityService employActivityService;
	
	@Test
	@Rollback(value = true)
	public void save() {
		 Date date = new Date(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	     String dateNowStr = sdf.format(date);  
		for(int i=0;i<100;i++) {
			
			EmployActivity employActivity = new EmployActivity();

			employActivity.setEmployActivityNo("No"+i);
			employActivity.setEmployActivityName("Activity"+i);
			employActivity.setEmployActivityDate(date);
			employActivity.setEmployActivityPlace("GZ");
			employActivity.setEmployActivityPhone("860000"+i);
						
			employActivityService.saveOrUpdate(employActivity);
			System.out.println(employActivity);
		}
		
	}
	
/*	//@Test
	@Rollback(value=false)
	public void delete() {
		User user = userService.findOne(4L);
		userService.delete(user);
	}*/
	
	//@Test
/*	@Rollback(value=false)
	public void delete() {
		for(int i=0;i<100;i++) {
		EmployJob employJob= employJobService.findOne(4L);
		employJobService.delete(employJob);
		}
	}*/
	
}
