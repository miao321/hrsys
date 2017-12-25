package com.hrsys.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.user.entity.User;

public interface IUserService {
	public void saveOrUpdate(User user);
	public void delete(User user);
	public void delete(List<Long> ids);
	public User findOne(Long id);
	public List<User> findAll();
	
	
	//动态条件查询
	public Page<User> findAll(Specification<User> spec,Pageable pageable);

}
