package com.hrsys.employ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.employ.dao.IEmployJobDao;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.service.IEmployJobService;

/**
 * 招聘职位类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployJobService implements IEmployJobService{

	@Autowired
	private IEmployJobDao employJobDao;
	
	public void saveOrUpdate(EmployJob employJob) {
		employJobDao.save(employJob);
		
	}

	public void delete(EmployJob employJob) {
		employJobDao.delete(employJob);
		
	}
	
	@Transactional(readOnly = true)
	public EmployJob findOne(Long id) {
		return employJobDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployJob> findAll() {
		return (List<EmployJob>) employJobDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<EmployJob> findAll(Specification<EmployJob> spec, Pageable pageable) {
		
		return employJobDao.findAll(spec,pageable);
	}
	


}
