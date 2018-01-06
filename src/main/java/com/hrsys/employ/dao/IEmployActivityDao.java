package com.hrsys.employ.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployActivity;

/**
 * 招聘活动类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployActivityDao extends PagingAndSortingRepository<EmployActivity,Long>, JpaSpecificationExecutor<EmployActivity> {

}
