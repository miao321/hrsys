package com.hrsys.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.common.ExtJsonResult;
import com.hrsys.system.entity.Log;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleDTO;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;

public interface IUserService {
	public void saveOrUpdate(User user);

	public void delete(User user);
	public void delete(List<Long> ids);
	public User findOne(Long id);
	public List<User> findAll();
	public List<UserRole> getRoleByUserName(String userName);
	public List<String> getPermissionsByUserName(String userName);
	//动态条件查询
	public Page<User> findAll(Specification<User> spec,Pageable pageable);
	public List<UserRoleQueryDTO> findUserRole();
	public List<UserRoleDTO> findUserRole2();
	public List<User> find(String hql, Class<User> class1, String[] strings);

}
