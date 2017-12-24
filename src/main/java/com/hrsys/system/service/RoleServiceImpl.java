package com.hrsys.system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsys.system.dao.RoleRepository;
import com.hrsys.system.entity.Role;
@Service
public class RoleServiceImpl implements IRoleService {
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void saveOrUpdate(Role role) {
		roleRepository.save(role);
	}
	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}
	@Override
	public void delete(List<Long> ids) {
		List<Role> roleLists = (List<Role>) roleRepository.findAll(ids);
		if(roleLists != null) {
			roleRepository.delete(roleLists);
		}			
	}
	@Override
	public Role findOne(Long id) {		
		return roleRepository.findOne(id);
	}
	@Override
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}
	@Override
	public Page<Role> findAll(Specification<Role> spec, Pageable pageable) {
		return roleRepository.findAll(spec, pageable);
	}

}
