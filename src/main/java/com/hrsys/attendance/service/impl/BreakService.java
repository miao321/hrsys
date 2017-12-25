package com.hrsys.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.attendance.dao.IBreakDao;
import com.hrsys.attendance.service.IBreakService;

/**
 * 考勤模块-加班记录服务层实现类
 * @author Lofu
 */
@Service
public class BreakService implements IBreakService {
	
	@Autowired
	private IBreakDao breakDao;
}
