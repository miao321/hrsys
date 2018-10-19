package com.hrsys.attendance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Leave;

/**
 * 考勤模块-请假记录数据访问层
 * @author Lofu
 */
@Repository
public interface ILeaveDao extends PagingAndSortingRepository<Leave,Integer>,JpaSpecificationExecutor<Leave> {
	
	/** 查找每个月的请假人数 */
	@Query(value = "select EXTRACT(MONTH FROM leaveDate), count(*) from t_leave group by EXTRACT(MONTH FROM leaveDate)", nativeQuery = true)
	public List<Object[]> countLeave();
}
