package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Permission;


public interface IPermissionService {
	public void saveOrUpdate(Permission permission);
	public void delete(Permission permission);
	public void delete(List<Long> ids);
	public Permission findOne(Long id);
	public List<Permission> findAll();
	
	public Permission findUrl(String url);
	
	
	//动态条件查询
	public Page<Permission> findAll(Specification<Permission> spec,Pageable pageable);


}
