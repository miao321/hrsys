package com.hrsys.attendance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Breach;

/**
 * 考勤模块-违规记录数据访问层
 * @author Lofu
 */
@Repository
public interface IBreachDao extends PagingAndSortingRepository<Breach,Integer>,JpaSpecificationExecutor<Breach> {

}
