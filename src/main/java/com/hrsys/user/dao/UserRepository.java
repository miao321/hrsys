package com.hrsys.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.user.entity.User;
@Repository 
public interface UserRepository extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {
	@Query("from User user where user.userName =?1")
	public User findUser(String userName);
	@Query("from User user where user.userName = ?1 and user.password = ?2")
	public User findUser(String userName,String password);
	@Modifying
	@Query("update User user set user.password = ?2 where user.id = ?1")
	public User updateUser(Long id,String password);
}
