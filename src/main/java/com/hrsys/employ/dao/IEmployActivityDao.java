package com.hrsys.employ.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployActivity;
import com.hrsys.train.entity.TrainDemand;

/**
 * 招聘活动类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployActivityDao extends PagingAndSortingRepository<EmployActivity,Long>, JpaSpecificationExecutor<EmployActivity> {
	@Query("select new map(count(t.employActivityId) as employActivityNum,year(t.employActivityDate) as employActivityYear,month(t.employActivityDate) as employActivityMonth) from EmployActivity t group by year(t.employActivityDate),month(t.employActivityDate)")
	public List<EmployActivity> findByEmployActivityNum();
}
