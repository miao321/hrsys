package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Module;

public interface IModuleService {
	public void saveOrUpdate(Module module);
	public void delete(Module module);
	public void delete(List<Long> ids);
	public Module findOne(Long id);
	public List<Module> findAll();
	
	
	//动态条件查询
	public Page<Module> findAll(Specification<Module> spec,Pageable pageable);


}
