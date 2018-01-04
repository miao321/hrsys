package com.hrsys.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;

public interface IUserRoleService {
	public void saveOrUpdate(UserRole userRole);
	public void delete(UserRole userRole);
	public void delete(List<Long> ids);
	public UserRole findOne(Long id);
	public List<UserRole> findAll();
	
	
	//动态条件查询
	public Page<UserRole> findAll(Specification<UserRole> spec,Pageable pageable);
	
   /* public UserRole getByUserRoleName(String userRoleName);
	public Set<String> getRoles(String userRoleName);
    public Set<String> getPermissions(String userRoleName);*/
}
