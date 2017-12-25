package com.hrsys.attendance.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.attendance.service.IClockService;
import com.hrsys.attendance.web.IClockController;

/**
 * 考勤模块-打卡记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/clock")
public class ClockController implements IClockController {
	
	@Autowired
	private IClockService clockService;
}
