package com.hrsys.personnel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.personnel.dao.IDeptDao;
import com.hrsys.personnel.service.IDeptService;

/**
 * 人事模块-部门类服务层实现类
 * @author Lofu
 */
@Service
public class DeptService implements IDeptService {

	@Autowired
	private IDeptDao deptdao;
}
