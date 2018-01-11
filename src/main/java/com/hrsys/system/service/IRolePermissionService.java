package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import com.hrsys.system.entity.dto.RolePermissionQueryDTO;

public interface IRolePermissionService {
	
	public List<RolePermissionQueryDTO> findRolePermission();
	public List<RolePermissionQueryDTO> findPermission();

}
