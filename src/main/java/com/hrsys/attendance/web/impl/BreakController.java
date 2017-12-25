package com.hrsys.attendance.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.attendance.service.IBreakService;
import com.hrsys.attendance.web.IBreakController;

/**
 * 考勤模块-违规记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/break")
public class BreakController implements IBreakController {
	
	@Autowired
	private IBreakService breadService;
}
