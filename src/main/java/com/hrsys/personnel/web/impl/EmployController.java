package com.hrsys.personnel.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.personnel.service.IEmployService;
import com.hrsys.personnel.web.IEmployController;

/**
 * 人事模块-职工类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/employ")
public class EmployController implements IEmployController{
	
	@Autowired
	private IEmployService employService;
}
