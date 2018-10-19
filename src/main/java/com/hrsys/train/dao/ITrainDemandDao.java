package com.hrsys.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainDemand;


/**
 * 培训需求类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainDemandDao extends PagingAndSortingRepository<TrainDemand, Long>, JpaSpecificationExecutor<TrainDemand> {
	@Query("select new map(count(t.trainDemandId) as trainCourseNum,year(t.trainDemandTime) as trainDemandYear,month(t.trainDemandTime) as trainDemandMonth) from TrainDemand t group by year(t.trainDemandTime),month(t.trainDemandTime)")
	public List<TrainDemand> findByTrainDemandNum();
}