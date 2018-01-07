package com.hrsys.aop;

import org.apache.shiro.web.util.SavedRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.user.entity.User;
import com.hrsys.user.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class AopTest {
	@Autowired
	private static IUserService userService;

		
		//1.测试数据
		public static void main(String[] args) {
			//1.测试数据
			User user = new User();
			user.setUserName("admin");
			user.setPassword("123456");
					
					
			//2.根据配置文件初始化IOC容器
			//ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext-*.xml");

			//IUserService service = (IUserService) context.getBean("userService");

		
		userService.saveOrUpdate(user);

}
}
