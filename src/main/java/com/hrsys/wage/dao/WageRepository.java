package com.hrsys.wage.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.wage.entity.Wage;






@Repository
public interface WageRepository extends PagingAndSortingRepository<Wage,Long>,JpaSpecificationExecutor<Wage> {


	@Query("select new map(sum(t.finalWage) as finalWageNum,t.department as department) from Wage t group by t.department")
	public List<Wage> findByfinalWageNum();
	@Query(value = "select new map(month(t.time) as department , sum(t.finalWage) as finalWageNum )from Wage t  group by month(t.time)")
	public List<Wage> findByfinalWageSum();
}
