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
import com.hrsys.train.entity.TrainCourse;

/**
 * 应聘者信息类Dao层
 * @author Administrator
 *
 */
@Repository
public interface IEmployApplyDao extends PagingAndSortingRepository<EmployApply,Long>, JpaSpecificationExecutor<EmployApply> {
	/*@Query("from EmployApply e where e.employJob.id = ?1")
	public Page<EmployJob>findByEmployJob(Specification<EmployJob> spec,Pageable pageable);*/
	@Query("select new map(count(t.employApplyEducation) as employApplyEducationNum,t.employApplyEducation as employApplyEducation) from EmployApply t group by t.employApplyEducation")
	public List<EmployApply> findByEmployApplyNum();

}
