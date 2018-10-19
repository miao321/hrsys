package com.hrsys.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
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

	@Query("select new map(count(t.trainPlanId) as trainCourseNum,year(t.trainPlanStartTime) as trainPlanYear,month(t.trainPlanStartTime) as trainPlanMonth) from TrainPlan t group by year(t.trainPlanStartTime),month(t.trainPlanStartTime)")
	public List<TrainPlan> findByTrainPlanNum();
}
