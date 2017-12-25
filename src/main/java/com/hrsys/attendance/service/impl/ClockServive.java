package com.hrsys.attendance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.attendance.dao.IClockDao;
import com.hrsys.attendance.service.IClockService;

/**
 * 考勤模块-打卡记录服务层实现类
 * @author Lofu
 */
@Service
public class ClockServive implements IClockService {
	
	@Autowired
	private IClockDao clockDao;
}
