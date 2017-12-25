package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Organization;
public interface IOrganizationService {
	public void saveOrUpdate(Organization organization);
	public void delete(Organization organization);
	public void delete(List<Long> ids);
	public Organization findOne(Long id);
	public List<Organization> findAll();
	
	
	//动态条件查询
	public Page<Organization> findAll(Specification<Organization> spec,Pageable pageable);


}
