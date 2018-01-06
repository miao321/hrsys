package com.hrsys.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Log;
import com.hrsys.user.entity.User;


public interface ILogService {
	public void saveOrUpdate(Log log);
	public void delete(Log log);
	public void delete(List<Long> ids);
	public Log findOne(Long id);
	public List<Log> findAll();
	
	
	//动态条件查询
	public Page<Log> findAll(Specification<Log> spec,Pageable pageable);
	
	public User findUser(String userName);

}
