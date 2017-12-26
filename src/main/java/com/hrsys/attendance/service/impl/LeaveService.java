package com.hrsys.attendance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.ILeaveDao;
import com.hrsys.attendance.entity.Leave;
import com.hrsys.attendance.service.ILeaveService;

/**
 * 考勤模块-请假记录服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class LeaveService implements ILeaveService {

	@Autowired
	private ILeaveDao leaveDao;

	public void saveOrUpdate(Leave leave) {
		leaveDao.save(leave);
	}

	public void delete(Leave leave) {
		leaveDao.delete(leave);
	}

	public void delete(List<Integer> ids) {
		List<Leave> leaveList = (List<Leave>) leaveDao.findAll();
		if(leaveList != null) {
			leaveDao.delete(leaveList);
		}
	}

	@Transactional(readOnly = true)
	public Leave findOne(Integer id) {
		return leaveDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Leave> findAll() {
		return (List<Leave>) leaveDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Leave> findAll(Specification<Leave> spec, Pageable pageable) {
		return leaveDao.findAll(spec, pageable);
	}
}
