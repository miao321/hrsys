package com.hrsys.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>,JpaSpecificationExecutor<Permission> {
	@Query("from Permission permission where permission.url =?1")
	public Permission findUrl(String url);
}
