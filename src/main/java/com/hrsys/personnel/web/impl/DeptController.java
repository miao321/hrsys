package com.hrsys.personnel.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsys.personnel.service.IDeptService;
import com.hrsys.personnel.web.IDeptController;

/**
 * 人事模块-部门类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/dept")
public class DeptController implements IDeptController {
	
	@Autowired
	private IDeptService deptService;
}
