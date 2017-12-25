package com.hrsys.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.personnel.dao.IDeptDao;
import com.hrsys.personnel.entity.Dept;
import com.hrsys.personnel.service.IDeptService;

/**
 * 人事模块-部门类服务层实现类
 * @author Lofu
 */
@Service
public class DeptService implements IDeptService {

	@Autowired
	private IDeptDao deptDao;

	public void saveOrUpdate(Dept dept) {
		deptDao.save(dept);
	}

	public void delete(Dept dept) {
		deptDao.delete(dept);
	}

	public void delete(List<Integer> ids) {
		List<Dept> deptList = (List<Dept>)deptDao.findAll();
		for(Dept dept : deptList) {
			deptDao.delete(dept);
		}
	}

	@Transactional(readOnly = true)
	public Dept findOne(Integer id) {
		return deptDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Dept> findAll() {
		return (List<Dept>) deptDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable) {
		return deptDao.findAll(spec, pageable);
	}
}
