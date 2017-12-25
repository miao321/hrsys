package com.hrsys.attendance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Leave;

/**
 * 考勤模块-请假记录数据访问层
 * @author Lofu
 */
@Repository
public interface ILeaveDao extends PagingAndSortingRepository<Leave,Integer>,JpaSpecificationExecutor<Leave> {

}
