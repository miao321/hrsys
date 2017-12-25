package com.hrsys.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.personnel.dao.IEmployDao;
import com.hrsys.personnel.entity.Employ;
import com.hrsys.personnel.service.IEmployService;

/**
 * 人事模块-职工类服务层实现类
 * @author Lofu
 */
@Service
public class EmployService implements IEmployService {
	
	@Autowired
	private IEmployDao employDao;

	public void saveOrUpdate(Employ employ) {
		employDao.save(employ);
	}

	public void delete(Employ employ) {
		employDao.delete(employ);
	}

	public void delete(List<Integer> ids) {
		List<Employ> employList = (List<Employ>) employDao.findAll(ids);
		for(Employ employ : employList) {
			employDao.delete(employ);
		}
	}

	@Transactional(readOnly = true)
	public Employ findOne(Integer id) {
		return employDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Employ> findAll() {
		return (List<Employ>)employDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Employ> findAll(Specification<Employ> spec, Pageable pageable) {
		return employDao.findAll(spec, pageable);
	}
}
