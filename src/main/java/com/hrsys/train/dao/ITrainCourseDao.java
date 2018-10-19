package com.hrsys.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainCourse;
/**
 * 培训课程类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainCourseDao extends PagingAndSortingRepository<TrainCourse, Long>, JpaSpecificationExecutor<TrainCourse> {
	//培训课程对象数目统计
	@Query("select new map(count(t.trainCourseObject) as trainCourseObjectNum,t.trainCourseObject as trainCourseObject) from TrainCourse t group by t.trainCourseObject")
	public List<TrainCourse> findByTrainCourseNum();
}
