package com.hrsys.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.user.entity.User;

public interface IUserService {
	public void saveOrUpdate(User user);
	public void delete(User user);
	public void delete(List<Long> ids);
	public User findOne(Long id);
	public List<User> findAll();
	
	
	//动态条件查询
	public Page<User> findAll(Specification<User> spec,Pageable pageable);
	
   /* public User getByUserName(String userName);
	public Set<String> getRoles(String userName);
    public Set<String> getPermissions(String userName);*/
}
