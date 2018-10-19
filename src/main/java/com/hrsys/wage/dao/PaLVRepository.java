package com.hrsys.wage.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.wage.entity.PaLV;






@Repository
public interface PaLVRepository extends PagingAndSortingRepository<PaLV ,Long>,JpaSpecificationExecutor<PaLV >{

	@Query("select distinct new map(e.parank as parank) from PaLV e")
	public List<PaLV> findByparank();

}