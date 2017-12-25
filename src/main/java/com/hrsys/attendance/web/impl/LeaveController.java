package com.hrsys.attendance.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.attendance.service.ILeaveService;
import com.hrsys.attendance.web.ILeaveController;

/**
 * 考勤模块-请假记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/leave")
public class LeaveController implements ILeaveController {

	@Autowired
	private ILeaveService leaveService;
}
