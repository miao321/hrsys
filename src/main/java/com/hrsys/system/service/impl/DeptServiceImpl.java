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
	private DeptRepository organizationRepository;
	@Override
	public void saveOrUpdate(Dept organization) {
		organizationRepository.save(organization);
	}

	@Override
	public void delete(Dept organization) {
		organizationRepository.delete(organization);
	}

	@Override
	public void delete(List<Long> ids) {
		List<Dept> organizationLists = (List<Dept>) organizationRepository.findAll(ids);
		if (organizationLists != null) {
			organizationRepository.delete(organizationLists);
		}			
	}

	@Override
	public Dept findOne(Long id) {
		return organizationRepository.findOne(id);
	}

	@Override
	public List<Dept> findAll() {
		return (List<Dept>) organizationRepository.findAll();
	}

	@Override
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable) {
		return organizationRepository.findAll(spec, pageable);
	}

}
