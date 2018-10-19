package com.hrsys.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainExecute;


/**
 * 培训实施类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainExecuteDao extends PagingAndSortingRepository<TrainExecute, Long>, JpaSpecificationExecutor<TrainExecute> {
/*	@Query("select new map(count(t.trainCourseName) as trainCourseNameNum,"
			+ "month(t.trainPlanStartTime) as trainCourseMonth,"
			+ "year(t.trainPlanStartTime) as trainCourseYear) "
			+ "from TrainPlan t group by t.trainPlanStartTime")*/

	@Query("select new map(count(t.trainPlanId) as trainCourseNum,year(t.trainPlanStartTime) as trainCourseYear,month(t.trainPlanStartTime) as trainCourseMonth) from TrainPlan t group by year(t.trainPlanStartTime),month(t.trainPlanStartTime)")
	public List<TrainExecute> findByTrainExecuteNum();
}