package com.hrsys.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.IClockDao;
import com.hrsys.attendance.entity.Clock;
import com.hrsys.attendance.service.IClockService;

/**
 * 考勤模块-打卡记录服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class ClockServive implements IClockService {
	
	@Autowired
	private IClockDao clockDao;

	public void saveOrUpdate(Clock clock) {
		clockDao.save(clock);
	}

	public void delete(Clock clock) {
		clockDao.delete(clock);
	}

	public void delete(List<Integer> ids) {
		List<Clock> clockList = (List<Clock>) clockDao.findAll();
		if(clockList != null) {
			clockDao.delete(clockList);
		}
	}

	@Transactional(readOnly = true)
	public Clock findOne(Integer id) {
		return clockDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Clock> findAll() {
		return (List<Clock>) clockDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Clock> findAll(Specification<Clock> spec, Pageable pageable) {
		return clockDao.findAll(spec, pageable);
	}
}
