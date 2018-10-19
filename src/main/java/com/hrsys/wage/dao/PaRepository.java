package com.hrsys.wage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.wage.entity.Pa;




@Repository
public interface PaRepository extends PagingAndSortingRepository<Pa,Long>,JpaSpecificationExecutor<Pa>{

	//绩效分数统计
	@Query("select new map(count(t.pavalues) as pavaluesNum,t.pavalues as pavalues) from Pa t group by t.pavalues")
	public List<Pa> findBypavaluesNum();
}
