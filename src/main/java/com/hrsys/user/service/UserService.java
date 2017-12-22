package com.hrsys.user.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
@Service
public class UserService implements IUserService {
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
