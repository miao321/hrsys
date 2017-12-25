package com.hrsys.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.attendance.dao.IOvertimeDao;
import com.hrsys.attendance.service.IOvertimeService;

/**
 * 考勤模块-加班记录服务层实现类
 * @author Lofu
 */
@Service
public class OvertimeService implements IOvertimeService {
	
	@Autowired
	private IOvertimeDao overtimeDao;
}
