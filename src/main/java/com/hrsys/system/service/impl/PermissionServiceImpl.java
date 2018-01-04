package com.hrsys.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsys.system.dao.PermissionRepository;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.service.IPermissionService;
@Service
public class PermissionServiceImpl implements IPermissionService {
	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	@Autowired
	private PermissionRepository permissionRepository;
	@Override
	public void saveOrUpdate(Permission permission) {
		permissionRepository.save(permission);
	}
	@Override
	public void delete(Permission permission) {
		permissionRepository.delete(permission);
	}
	@Override
	public void delete(List<Long> ids) {
		List<Permission> permissionLists = (List<Permission>) permissionRepository.findAll(ids);
		if(permissionLists != null) {
			permissionRepository.delete(permissionLists);
		}			
	}
	@Override
	public Permission findOne(Long id) {		
		return permissionRepository.findOne(id);
	}
	@Override
	public List<Permission> findAll() {
		return (List<Permission>) permissionRepository.findAll();
	}
	@Override
	public Page<Permission> findAll(Specification<Permission> spec, Pageable pageable) {
		return permissionRepository.findAll(spec, pageable);
	}

}
