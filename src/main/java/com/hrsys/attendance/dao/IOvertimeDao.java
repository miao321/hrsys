package com.hrsys.attendance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Overtime;

/**
 * 考勤模块-加班记录数据访问层
 * @author Lofu
 */
@Repository
public interface IOvertimeDao extends PagingAndSortingRepository<Overtime,Integer>,JpaSpecificationExecutor<Overtime> {

}