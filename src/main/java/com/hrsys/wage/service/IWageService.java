package com.hrsys.wage.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.wage.entity.Wage;



public interface IWageService {
	public void saveOrUpdate(Wage wage);
	public void delete(Wage wage);
	public void delete(List<Long> ids);
	
	public Wage findOne(Long id);
	public List<Wage> findAll();
	public Page<Wage> findAll(Specification<Wage> spec, Pageable pageable);

}