package com.hrsys.employ.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployJob;


/**
 * 招聘职位类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployJobDao extends PagingAndSortingRepository<EmployJob,Long>, JpaSpecificationExecutor<EmployJob> {



}
