package com.hrsys.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.IBreachDao;
import com.hrsys.attendance.entity.Breach;
import com.hrsys.attendance.service.IBreachService;

/**
 * 考勤模块-违规记录服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class BreachService implements IBreachService {
	
	@Autowired
	private IBreachDao breachDao;

	public void saveOrUpdate(Breach breach) {
		breachDao.save(breach);
	}

	public void delete(Breach breach) {
		breachDao.delete(breach);
	}

	public void delete(List<Integer> ids) {
		List<Breach> breachList = (List<Breach>) breachDao.findAll();
		if(breachList != null) {
			breachDao.delete(breachList);
		}
	}

	@Transactional(readOnly = true)
	public Breach findOne(Integer id) {
		return breachDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Breach> findAll() {
		return (List<Breach>) breachDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Breach> findAll(Specification<Breach> spec, Pageable pageable) {
		return breachDao.findAll(spec, pageable);
	}
}
