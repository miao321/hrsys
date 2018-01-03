package com.hrsys.user.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
@Repository 
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>,JpaSpecificationExecutor<UserRole> {
	
}
