package com.hrsys.wage.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hrsys.wage.entity.Wage;



public interface WageRepository extends PagingAndSortingRepository<Wage,Long>,JpaSpecificationExecutor<Wage> {

}
