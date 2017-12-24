package com.hrsys.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Module;
import com.hrsys.user.entity.User;
@Repository
public interface ModuleRepository extends PagingAndSortingRepository<Module, Long>,JpaSpecificationExecutor<Module> {

}
