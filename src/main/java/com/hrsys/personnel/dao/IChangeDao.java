package com.hrsys.personnel.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.personnel.entity.Change;

/**
 * 人事模块-人事变动数据访问层
 * @author Lofu
 */
@Repository
public interface IChangeDao extends PagingAndSortingRepository<Change,Integer>,JpaSpecificationExecutor<Change> {

}
