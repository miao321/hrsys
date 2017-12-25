package com.hrsys.personnel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.personnel.dao.IChangeDao;
import com.hrsys.personnel.service.IChangeService;

/**
 * 人事模块-人事变动类服务层实现类
 * @author Lofu
 */
@Service
public class ChangeService implements IChangeService {
	
	@Autowired
	private IChangeDao changeDao;
}
