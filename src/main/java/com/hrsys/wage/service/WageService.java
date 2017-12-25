package com.hrsys.wage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.wage.dao.WageRepository;
import com.hrsys.wage.entity.Wage;



@Service
@Transactional
public class WageService implements IWageService{
	@Autowired
	private WageRepository wageRepository;

	public void saveOrUpdate(Wage wage) {
		wageRepository.save(wage);
	}
	
	public void delete(Wage wage) {
		wageRepository.delete(wage);
	}
	
	public void delete(List<Long> ids) 
	{
		List<Wage> wages =  (List<Wage>) wageRepository.findAll(ids);
		if(wages!=null) {
			wageRepository.delete(wages);
		}
	}

	@Transactional(readOnly = true)
	public Wage findOne(Long id) {
		return wageRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<Wage> findAll() {
		return (List<Wage>) wageRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Wage> findAll(Specification<Wage> spec, Pageable pageable) {
		return wageRepository.findAll(spec, pageable);
	}
	

	
}