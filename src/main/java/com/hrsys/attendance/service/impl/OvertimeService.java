package com.hrsys.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.IOvertimeDao;
import com.hrsys.attendance.entity.Overtime;
import com.hrsys.attendance.service.IOvertimeService;

/**
 * 考勤模块-加班记录服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class OvertimeService implements IOvertimeService {
	
	@Autowired
	private IOvertimeDao overtimeDao;

	public void saveOrUpdate(Overtime overtime) {
		overtimeDao.save(overtime);
	}

	public void delete(Overtime overtime) {
		overtimeDao.delete(overtime);
	}

	public void delete(List<Integer> ids) {
		List<Overtime> overtimeList = (List<Overtime>) overtimeDao.findAll();
		if(overtimeList != null) {
			overtimeDao.delete(overtimeList);
		}
	}

	@Transactional(readOnly = true)
	public Overtime findOne(Integer id) {
		return overtimeDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Overtime> findAll() {
		return (List<Overtime>) overtimeDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Overtime> findAll(Specification<Overtime> spec, Pageable pageable) {
		return overtimeDao.findAll(spec, pageable);
	}
}
