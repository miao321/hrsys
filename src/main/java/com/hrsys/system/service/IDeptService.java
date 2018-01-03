package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Dept;
public interface IDeptService {
	public void saveOrUpdate(Dept organization);
	public void delete(Dept organization);
	public void delete(List<Long> ids);
	public Dept findOne(Long id);
	public List<Dept> findAll();
	
	
	//动态条件查询
	public Page<Dept> findAll(Specification<Dept> spec,Pageable pageable);


}
