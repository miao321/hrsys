package com.hrsys.personnel.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.personnel.entity.Dept;

/**
 * 人事模块-部门类数据访问层
 * @author Lofu
 *
 */
@Repository
public interface IDeptDao extends PagingAndSortingRepository<Dept,Integer>,JpaSpecificationExecutor<Dept>  {

}
