package com.hrsys.wage.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.wage.entity.PaLV;





public interface IPaLVService {
	public void saveOrUpdate(PaLV paLV );
	public void delete(PaLV  paLV );
	public void delete(List<Long> ids);
	
	public PaLV  findOne(Long id);
	public List<PaLV > findAll();
	public Page<PaLV > findAll(Specification<PaLV > spec, Pageable pageable);
	public List<PaLV> findByparank();
}
