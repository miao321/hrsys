package com.hrsys.employ.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployChannel;



/**
 * 招聘渠道类Service层接口
 * @author Administrator
 *
 */
public interface IEmployChannelService {
	public void saveOrUpdate(EmployChannel employChannel);
	public void delete(EmployChannel employChannel);
	public EmployChannel findOne(Long id);
	public List<EmployChannel> findAll();
	//动态条件查询
	public Page<EmployChannel> findAll(Specification<EmployChannel> spec, Pageable pageable);
}
