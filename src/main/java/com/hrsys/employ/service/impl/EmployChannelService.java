package com.hrsys.employ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.employ.dao.IEmployChannelDao;
import com.hrsys.employ.entity.EmployChannel;
import com.hrsys.employ.service.IEmployChannelService;

/**
 * 招聘渠道类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployChannelService implements IEmployChannelService {

	@Autowired
	private IEmployChannelDao employChannelDao;
	
	public void saveOrUpdate(EmployChannel employChannel) {
		employChannelDao.save(employChannel);
		
	}

	
	public void delete(EmployChannel employChannel) {
		employChannelDao.delete(employChannel);
	}

	@Transactional(readOnly = true)
	public EmployChannel findOne(Long id) {
		return employChannelDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<EmployChannel> findAll() {
		return (List<EmployChannel>) employChannelDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<EmployChannel> findAll(Specification<EmployChannel> spec, Pageable pageable) {
		return employChannelDao.findAll(spec,pageable);
	}

}
