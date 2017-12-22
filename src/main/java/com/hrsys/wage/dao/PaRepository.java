package com.hrsys.wage.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.wage.entity.Pa;


@Repository
public interface PaRepository extends PagingAndSortingRepository<Pa,Long>,JpaSpecificationExecutor<Pa>{

}
