package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

}
