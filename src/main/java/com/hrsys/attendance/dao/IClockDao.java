package com.hrsys.attendance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Clock;

/**
 * 考勤模块-打卡记录数据访问层
 * @author Lofu
 */
@Repository
public interface IClockDao extends PagingAndSortingRepository<Clock,Integer>,JpaSpecificationExecutor<Clock> {
	
	/** 查找每个月上、下班打卡的人数 */
	@Query(value = "SELECT t.month, "
			+ "MAX(CASE t.clockType WHEN '上班' THEN t.num END) '上班', "
			+ "MAX(CASE t.clockType WHEN '下班' THEN t.num END) '下班' "
			+ "FROM(select EXTRACT(MONTH FROM clockDate) month, clockType, COUNT(*) num from t_clock group by EXTRACT(MONTH FROM clockDate), clockType) t "
			+ "GROUP BY t.month", nativeQuery = true)
	public List<Object[]> findClockCount();
	
//	/** 查找每个月下班打卡的人数 */
//	@Query(value = "select EXTRACT(MONTH FROM clockDate), count(*) from t_clock WHERE clockType='下班' group by EXTRACT(MONTH FROM clockDate)", nativeQuery = true)
//	public List<Object[]> findOutWorkCount();
}
