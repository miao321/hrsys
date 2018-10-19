package com.hrsys.attendance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Overtime;

/**
 * 考勤模块-加班记录数据访问层
 * @author Lofu
 */
@Repository
public interface IOvertimeDao extends PagingAndSortingRepository<Overtime,Integer>,JpaSpecificationExecutor<Overtime> {
	
	/** 查找每个月的加班人数 */
	@Query(value = "select EXTRACT(MONTH FROM overtimeDate), count(*) from t_overtime group by EXTRACT(MONTH FROM overtimeDate)", nativeQuery = true)
	public List<Object[]> countOvertime();
}
