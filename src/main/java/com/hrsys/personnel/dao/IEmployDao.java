package com.hrsys.personnel.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.personnel.entity.Employ;

/**
 * 人事模块-职工类数据访问层
 * @author Lofu
 *
 */
@Repository
public interface IEmployDao extends PagingAndSortingRepository<Employ,Integer>,JpaSpecificationExecutor<Employ> {

}
