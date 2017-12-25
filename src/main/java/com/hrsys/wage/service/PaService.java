package com.hrsys.wage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.wage.dao.PaRepository;
import com.hrsys.wage.entity.Pa;



@Service
@Transactional
public class PaService implements IPaService{
	@Autowired
	private PaRepository paRepository;

	public void saveOrUpdate(Pa pa) {
		paRepository.save(pa);
	}
	public void delete(Pa pa) {
		paRepository.delete(pa);
	}
	
	public void delete(List<Long> ids) 
	{
		List<Pa> pas =  (List<Pa>) paRepository.findAll(ids);
		if(pas!=null) {
			paRepository.delete(pas);
		}
	}

	@Transactional(readOnly = true)
	public Pa findOne(Long id) {
		return paRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<Pa> findAll() {
		return (List<Pa>) paRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Pa> findAll(Specification<Pa> spec, Pageable pageable) {
		return paRepository.findAll(spec, pageable);
	}
}
