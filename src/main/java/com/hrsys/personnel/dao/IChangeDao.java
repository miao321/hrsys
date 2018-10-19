package com.hrsys.personnel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.personnel.entity.Change;

/**
 * 人事模块-人事变动类数据访问层
 * @author Lofu
 */
@Repository
public interface IChangeDao extends PagingAndSortingRepository<Change,Integer>,JpaSpecificationExecutor<Change> {
	
	/** 查询每个月的人事变动数据 */
	@Query(value = "select EXTRACT(MONTH FROM applyTime), count(*) from t_change group by EXTRACT(MONTH FROM applyTime)", nativeQuery = true)
	public List<Object[]> countChange();
}
