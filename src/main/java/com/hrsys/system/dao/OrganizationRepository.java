package com.hrsys.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Organization;
import com.hrsys.user.entity.User;
@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long>,JpaSpecificationExecutor<User> {

}
