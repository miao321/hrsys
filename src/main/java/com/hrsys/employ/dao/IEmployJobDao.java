package com.hrsys.employ.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.entity.EmployJob;


/**
 * 招聘职位类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployJobDao extends PagingAndSortingRepository<EmployJob,Long>, JpaSpecificationExecutor<EmployJob> {

	
	@Query("select distinct new map(e.employJobName as employJobName) from EmployJob e")
		public List<EmployJob> findByEmployJob();

	@Query("select new map(sum(t.employJobNum) as employJobNum,t.employJobName as employJobName) from EmployJob t group by t.employJobName")
	public List<EmployJob> findByEmployJobNum();
	
}
