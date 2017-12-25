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

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);		
	}
	@Override
	public void delete(User user) {
		userRepository.delete(user);	
	}
	@Override
	public void delete(List<Long> ids) {
		List<User> users = (List<User>) userRepository.findAll(ids);
		if (users != null) {
			userRepository.delete(users);
		}		
	}
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	@Override
	public Page<User> findAll(Specification<User> spec, Pageable pageable) {
		return userRepository.findAll(spec, pageable);
	}
}