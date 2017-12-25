package com.hrsys.attendance.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.attendance.service.IOvertimeService;
import com.hrsys.attendance.web.IOvertimeController;

/**
 * 考勤模块-加班记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/overtime")
public class OvertimeController implements IOvertimeController {
	
	@Autowired
	private IOvertimeService overtimeService;
}
