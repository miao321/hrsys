package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Role;


public interface IRoleService {
	public void saveOrUpdate(Role role);
	public void delete(Role role);
	public void delete(List<Long> ids);
	public Role findOne(Long id);
	public List<Role> findAll();
	
	public Role findRole(String roleName);
	
	
	//动态条件查询
	public Page<Role> findAll(Specification<Role> spec,Pageable pageable);


}
