package com.hrsys.personnel.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.personnel.service.IChangeService;
import com.hrsys.personnel.web.IChangeController;

/**
 * 人事模块-人事变动类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/change")
public class ChangeController implements IChangeController {
	
	@Autowired
	private IChangeService changeService;
}
