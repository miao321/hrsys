package com.hrsys.employ.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployActivity;



/**
 * 招聘活动类Service层接口
 * @author Administrator
 *
 */
public interface IEmployActivityService {
	public void saveOrUpdate(EmployActivity employActivity);
	public void delete(EmployActivity employActivity);
	public EmployActivity findOne(Long id);
	public List<EmployActivity> findAll();
	//动态条件查询
	public Page<EmployActivity> findAll(Specification<EmployActivity> spec, Pageable pageable);
}
