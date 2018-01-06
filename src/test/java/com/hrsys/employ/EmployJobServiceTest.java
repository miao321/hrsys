package com.hrsys.employ;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.hrsys.util.DateUtils;
import com.hrsys.util.RandomNum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class EmployJobServiceTest {

	@Autowired
	private IEmployJobService employJobService;
	
	@Test
	@Rollback(value = false)
	public void save() {

	    DateUtils dateUtils=new DateUtils();
	    RandomNum randomNum=new RandomNum();
	    
	    for(int i=0;i<100;i++) {
			
//			User user = new User();
//			user.setUserName("张三");
//			user.setPassword("123");
//			user.setBirthday(new Date());
//			userService.saveOrUpdate(user);
//			System.out.println(user);
			
			EmployJob employJob = new EmployJob();

			employJob.setEmployJobNo("No"+i);
			employJob.setEmployJobName("Job00"+i);
			employJob.setEmployJobStartTime(dateUtils.getNowDateShort());
			employJob.setEmployJobEndTime(dateUtils.getNowDateShort());
			
			employJob.setEmployJobDescription("职位描述"+i);
			employJob.setEmployJobDemand("职位要求"+i);
			employJob.setEmployJobSalary("待遇"+i);
			employJob.setEmployJobPlace("工作地点"+i);
			employJob.setEmployJobDate(dateUtils.getNowDateShort());
			employJob.setEmployJobNum(randomNum.getRandomNum(20, 1));
			employJob.setEmployJobResponsible("负责人"+i);
			
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
