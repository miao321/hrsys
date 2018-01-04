package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainPlan;

/**
 * 培训计划类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainPlanDao extends PagingAndSortingRepository<TrainPlan, Long>, JpaSpecificationExecutor<TrainPlan> {

}
