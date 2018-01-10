package com.hrsys.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.system.dao.RoleRepository;
import com.hrsys.system.entity.Role;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.dao.UserRoleRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
import com.hrsys.user.service.IUserRoleService;
@Service
public class UserRoleServiceImpl implements IUserRoleService {
	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public void saveOrUpdate(UserRole userRole) {		
		userRoleRepository.save(userRole);		
	}
	@Override
	public void delete(UserRole userRole) {
		userRoleRepository.delete(userRole);	
	}
	@Override
	public void delete(List<Long> ids) {
		List<UserRole> userRoles = (List<UserRole>) userRoleRepository.findAll(ids);
		if (userRoles != null) {
			userRoleRepository.delete(userRoles);
		}		
	}
	@Transactional(readOnly = true)
	public UserRole findOne(Long id) {
		return userRoleRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<UserRole> findAll() {
		return (List<UserRole>) userRoleRepository.findAll();
	}
	@Override
	public Page<UserRole> findAll(Specification<UserRole> spec, Pageable pageable) {
		return userRoleRepository.findAll(spec, pageable);
	}
}
