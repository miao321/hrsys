package com.hrsys.employ;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.employ.entity.EmployChannel;

import com.hrsys.employ.service.IEmployChannelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class EmployChannelServiceTest {

	@Autowired
	private IEmployChannelService employChannelService;
	
	@Test
	@Rollback(value = true)
	public void save() {
		for(int i=0;i<100;i++) {
			
			EmployChannel employChannel = new EmployChannel();
			employChannel.setEmployChannelId((long) i);
			//employChannel.setEmployChannelNo("No"+i);
			employChannel.setEmployChannelName("Channel"+i);
			employChannel.setEmployChannelPhone("86000"+i);
			employChannel.setEmployChannelDescription("Description");
			employChannel.setEmployChannelMark("This is mark");
			employChannelService.saveOrUpdate(employChannel);
			System.out.println(employChannel);
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
