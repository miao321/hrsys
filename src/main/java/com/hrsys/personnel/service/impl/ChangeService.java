package com.hrsys.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.personnel.dao.IChangeDao;
import com.hrsys.personnel.entity.Change;
import com.hrsys.personnel.service.IChangeService;

/**
 * 人事模块-人事变动类服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class ChangeService implements IChangeService {
	
	@Autowired
	private IChangeDao changeDao;

	public void saveOrUpdate(Change change) {
		changeDao.save(change);
	}

	public void delete(Change change) {
		changeDao.delete(change);
	}

	public void delete(List<Integer> ids) {
		List<Change> changeList = (List<Change>) changeDao.findAll(ids);
		if(changeList != null) {
			changeDao.delete(changeList);
		}
	}

	@Transactional(readOnly = true)
	public Change findOne(Integer id) {
		return changeDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Change> findAll() {
		return (List<Change>) changeDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Change> findAll(Specification<Change> spec, Pageable pageable) {
		return changeDao.findAll(spec, pageable);
	}
}
