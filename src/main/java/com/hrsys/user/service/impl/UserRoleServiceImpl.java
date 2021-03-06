package com.hrsys.user.service.impl;

import java.util.List;

import javax.management.relation.RoleResult;

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
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void saveOrUpdate(UserRoleQueryDTO userRoleQueryDTO) {		
		//userRoleRepository.save(userRole);	
		User user = userRepository.findOne(userRoleQueryDTO.getUserId());
		Role role = roleRepository.findOne(userRoleQueryDTO.getRoleId());
		UserRole userRole = new UserRole();
		if(userRoleQueryDTO.getId() != null) {
			userRole.setId(userRoleQueryDTO.getId());
		}
		userRole.setUser(user);
		userRole.setRole(role);
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
