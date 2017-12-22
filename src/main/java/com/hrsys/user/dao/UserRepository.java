package com.hrsys.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.user.entity.User;
@Repository 
public interface UserRepository extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {

}
