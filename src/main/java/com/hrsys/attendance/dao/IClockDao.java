package com.hrsys.attendance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Clock;

/**
 * 考勤模块-打卡记录数据访问层
 * @author Lofu
 */
@Repository
public interface IClockDao extends PagingAndSortingRepository<Clock,Integer>,JpaSpecificationExecutor<Clock> {

}
