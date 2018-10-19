package com.hrsys.wage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.wage.dao.PaLVRepository;
import com.hrsys.wage.entity.PaLV;



@Service
@Transactional
public class PaLVService implements IPaLVService{
	@Autowired
	private PaLVRepository paLVRepository;

	public void saveOrUpdate(PaLV paLV) {
		paLVRepository.save(paLV);
	}
	public void delete(PaLV paLV) {
		paLVRepository.delete(paLV);
	}
	
	public void delete(List<Long> ids) 
	{
		List<PaLV> paLVs =  (List<PaLV>) paLVRepository.findAll(ids);
		if(paLVs!=null) {
			paLVRepository.delete(paLVs);
		}
	}

	@Transactional(readOnly = true)
	public PaLV findOne(Long id) {
		return paLVRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<PaLV> findAll() {
		return (List<PaLV>) paLVRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<PaLV> findAll(Specification<PaLV> spec, Pageable pageable) {
		return paLVRepository.findAll(spec, pageable);
	}
	@Transactional(readOnly = true)
	public List<PaLV> findByparank(){
		return (List<PaLV>) paLVRepository.findByparank();
		
	}
	
}
