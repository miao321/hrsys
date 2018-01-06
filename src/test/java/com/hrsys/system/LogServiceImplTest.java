package com.hrsys.system;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hrsys.system.entity.Log;
import com.hrsys.system.service.ILogService;
import com.hrsys.user.service.ILoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext-core.xml"
		,"classpath*:applicationContext-jpa.xml"
})
public class LogServiceImplTest {
	@Autowired
	private ILogService logService;
	@Test
	@Rollback(value=false)
	public void save() {
		Log log = new Log();
		log.setModule("日志管理");
		log.setMethod("delete");
		log.setOperationTime(new Date());
		logService.saveOrUpdate(log);
	}

}
