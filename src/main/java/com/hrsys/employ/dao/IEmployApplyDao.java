package com.hrsys.employ.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployApply;

/**
 * 应聘者信息类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployApplyDao extends PagingAndSortingRepository<EmployApply,Long>, JpaSpecificationExecutor<EmployApply> {

}
