package com.hrsys.wage.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.wage.entity.Pa;



public interface IPaService {
	public void saveOrUpdate(Pa pa);
	public void delete(Pa pa);
	public void delete(List<Long> ids);
	
	public Pa findOne(Long id);
	public List<Pa> findAll();
	public Page<Pa> findAll(Specification<Pa> spec, Pageable pageable);

}
