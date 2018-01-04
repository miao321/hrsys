package com.hrsys.employ;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.service.IEmployApplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})

public class EmployApplyServiceTest {
	@Autowired
	private IEmployApplyService employApplyService;
	
	@Test
	@Rollback(value = true)
	public void save() {
		Date date = new Date(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	     String dateNowStr = sdf.format(date);  
		for(int i=0;i<100;i++) {
			
			EmployApply employApply = new EmployApply();
			
			employApply.setEmployApplyNo("No"+i);
			employApply.setEmployApplyName("Apply"+i);
			employApply.setEmployJobNo("EmployJobNo"+i);
			employApply.setEmployJobName("Job");
			
			if(i%2==0) {
			employApply.setEmployApplySex("男");
			}else {			
				employApply.setEmployApplySex("女");
				}
			
			employApply.setEmployApplyPlace("China");
			employApply.setEmployApplyBirth(date);
			employApply.setEmployApplySchool("DGUT");
			employApply.setEmployApplyMajor("CS");
			employApply.setEmployApplyEducation("本科");
			employApply.setEmployApplyPhone("860000"+i);
			employApply.setEmployApplyEmail(i+"@employApply.com");
			employApply.setEmployApplySituation("未录用");
			
			employApplyService.saveOrUpdate(employApply);
			System.out.println(employApply);
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
