package com.hrsys.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.annotation.SysLog;
import com.hrsys.system.dao.PermissionRepository;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.service.IPermissionService;
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
	@Autowired
	private PermissionRepository permissionRepository;
	@SysLog(module="用户权限分配",methods="保存或者更新数据")
	public void saveOrUpdate(Permission permission) {
		permissionRepository.save(permission);
	}
	@SysLog(module="用户权限分配",methods="删除一条数据")
	public void delete(Permission permission) {
		permissionRepository.delete(permission);
	}
	@SysLog(module="用户权限分配",methods="删除多条数据")
	public void delete(List<Long> ids) {
		List<Permission> permissionLists = (List<Permission>) permissionRepository.findAll(ids);
		if(permissionLists != null) {
			permissionRepository.delete(permissionLists);
		}			
	}
	@SysLog(module="用户权限分配",methods="查找一条数据")
	public Permission findOne(Long id) {		
		return permissionRepository.findOne(id);
	}
	@SysLog(module="用户权限分配",methods="查找多条数据")
	public List<Permission> findAll() {
		return (List<Permission>) permissionRepository.findAll();
	}
	@SysLog(module="用户权限分配",methods="查找多条数据并分页排序")
	public Page<Permission> findAll(Specification<Permission> spec, Pageable pageable) {
		return permissionRepository.findAll(spec, pageable);
	}

}
