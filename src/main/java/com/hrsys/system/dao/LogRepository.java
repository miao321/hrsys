package com.hrsys.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Log;
import com.hrsys.user.entity.User;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long>,JpaSpecificationExecutor<Log> {
	@Query("from User user where user.userName =?1")
	public User findUser(String userName);
}
