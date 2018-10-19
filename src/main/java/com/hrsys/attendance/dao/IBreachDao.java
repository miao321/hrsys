package com.hrsys.attendance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Breach;

/**
 * 考勤模块-违规记录数据访问层
 * @author Lofu
 */
@Repository
public interface IBreachDao extends PagingAndSortingRepository<Breach,Integer>,JpaSpecificationExecutor<Breach> {

	/** 查找各违规类型人数 */
	@Query(value = "select content, count(*) count from t_breach group by content", nativeQuery = true)
	public List<Object[]> countBreach();
}
