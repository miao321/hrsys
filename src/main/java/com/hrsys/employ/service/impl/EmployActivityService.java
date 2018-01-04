package com.hrsys.employ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.employ.dao.IEmployActivityDao;
import com.hrsys.employ.entity.EmployActivity;
import com.hrsys.employ.service.IEmployActivityService;

/**
 * 招聘活动类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployActivityService implements IEmployActivityService {
	@Autowired
	private IEmployActivityDao employActivityDao;
	
	public void saveOrUpdate(EmployActivity employActivity) {
		employActivityDao.save(employActivity);
		
	}

	public void delete(EmployActivity employActivity) {
		employActivityDao.delete(employActivity);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<EmployActivity> employActivitys =  (List<EmployActivity>)employActivityDao.findAll(ids);
		if(employActivitys!=null) {
			employActivityDao.delete(employActivitys);
		}

	}
	@Transactional(readOnly = true)
	public EmployActivity findOne(Long id) {
		return employActivityDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployActivity> findAll() {
		return (List<EmployActivity>) employActivityDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<EmployActivity> findAll(Specification<EmployActivity> spec, Pageable pageable) {
		
		return employActivityDao.findAll(spec,pageable);
	}
}
