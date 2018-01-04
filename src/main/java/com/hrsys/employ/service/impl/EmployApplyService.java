package com.hrsys.employ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.employ.dao.IEmployApplyDao;
import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.service.IEmployApplyService;

/**
 * 应聘者信息类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployApplyService implements IEmployApplyService {
	@Autowired
	private IEmployApplyDao employApplyDao;
	
	public void saveOrUpdate(EmployApply employApply) {
		employApplyDao.save(employApply);
		
	}

	public void delete(EmployApply employApply) {
		employApplyDao.delete(employApply);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<EmployApply> employApplys =  (List<EmployApply>)employApplyDao.findAll(ids);
		if(employApplys!=null) {
			employApplyDao.delete(employApplys);
		}

	}
	@Transactional(readOnly = true)
	public EmployApply findOne(Long id) {
		return employApplyDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployApply> findAll() {
		return (List<EmployApply>) employApplyDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<EmployApply> findAll(Specification<EmployApply> spec, Pageable pageable) {
		
		return employApplyDao.findAll(spec,pageable);
	}
}
