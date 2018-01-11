package com.hrsys.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.hrsys.common.util.DateUtil;

import com.hrsys.system.dao.RolePermissionRepository;
import com.hrsys.system.dao.RoleRepository;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
import com.hrsys.system.entity.dto.RolePermissionQueryDTO;
import com.hrsys.system.service.IRolePermissionService;
@Service
@Transactional
public class RolePermissionServiceImpl implements IRolePermissionService {
	private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
	@Autowired
	private RoleRepository roleRepository;
	
	@SysLog(module="角色权限管理",methods="查看列表")
	public List<RolePermissionQueryDTO> findRolePermission() {
		List<RolePermissionQueryDTO>  list = new ArrayList<RolePermissionQueryDTO>();
		List<Object[]> rolePermission = roleRepository.findRolePermission();
		for(Object[] obj : rolePermission) {
			RolePermissionQueryDTO dto = new RolePermissionQueryDTO();			
			//dto.setId(Long.parseLong(obj[0].toString()));
			dto.setUrl(obj[0]+"");
			dto.setRoleName(obj[1]+"");
			dto.setRemark(obj[2]+"");
			dto.setOrderNo(Integer.valueOf(obj[3]+""));
			dto.setCreateModule(obj[4]+"");
			dto.setCreateBy(obj[5]+"");
			dto.setCreateTime(DateUtil.StringToHMS(obj[6]+""));
			dto.setUpdateBy(obj[7]+"");
			dto.setUpdateTime(DateUtil.StringToHMS(obj[8]+""));
			
			System.out.println(dto);
		
			list.add(dto);
		}
		return list;
	}

	@Override
	public List<RolePermissionQueryDTO> findPermission() {
		List<RolePermissionQueryDTO>  list = new ArrayList<RolePermissionQueryDTO>();
		List<Object[]> rolePermission = roleRepository.findPermission();
		for(Object[] obj : rolePermission) {
			RolePermissionQueryDTO dto = new RolePermissionQueryDTO();			
			dto.setId(Long.parseLong(obj[0].toString()));
			dto.setUrl(obj[1]+"");
			
			System.out.println(dto);
		
			list.add(dto);
		}
		return list;
	}	
}
