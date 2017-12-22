package com.hrsys.personnel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.personnel.dao.IEmployDao;
import com.hrsys.personnel.service.IEmployService;

/**
 * 人事模块-职工类服务层实现类
 * @author Lofu
 */
@Service
public class EmployService implements IEmployService {
	
	@Autowired
	private IEmployDao employDao;
}
