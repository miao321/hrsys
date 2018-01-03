package com.hrsys.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsys.system.dao.DeptRepository;
import com.hrsys.system.entity.Dept;
import com.hrsys.system.service.IDeptService;


@Service
public class DeptServiceImpl implements IDeptService {
	private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
	@Autowired
	private DeptRepository deptRepository;
	@Override
	public void saveOrUpdate(Dept dept) {
		deptRepository.save(dept);
	}

	@Override
	public void delete(Dept dept) {
		deptRepository.delete(dept);
	}

	@Override
	public void delete(List<Long> ids) {
		List<Dept> deptLists = (List<Dept>) deptRepository.findAll(ids);
		if (deptLists != null) {
			deptRepository.delete(deptLists);
		}			
	}

	@Override
	public Dept findOne(Long id) {
		return deptRepository.findOne(id);
	}

	@Override
	public List<Dept> findAll() {
		return (List<Dept>) deptRepository.findAll();
	}

	@Override
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable) {
		return deptRepository.findAll(spec, pageable);
	}

}
