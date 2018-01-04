package com.hrsys.employ.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployJob;

/**
 * 招聘职位类Service层接口
 * @author Administrator
 *
 */

public interface IEmployJobService {
	public void saveOrUpdate(EmployJob employJob);
	public void delete(EmployJob employJob);
	//批量删除
	public void delete(List<Long> ids);
	public EmployJob findOne(Long id);
	public List<EmployJob> findAll();
	//动态条件查询
	public Page<EmployJob> findAll(Specification<EmployJob> spec, Pageable pageable);
}
