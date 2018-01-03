package com.hrsys.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Permission;
@Repository
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>,JpaSpecificationExecutor<Permission> {

}
