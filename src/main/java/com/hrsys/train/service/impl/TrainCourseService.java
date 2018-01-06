package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainCourseDao;
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.service.ITrainCourseService;
/**
 * 培训课程类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainCourseService implements ITrainCourseService {

	@Autowired
	private ITrainCourseDao trainCourseDao;
	
	public void saveOrUpdate(TrainCourse trainCourse) {
		trainCourseDao.save(trainCourse);
		
	}

	public void delete(TrainCourse trainCourse) {
		trainCourseDao.delete(trainCourse);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainCourse> trainCourses =  (List<TrainCourse>)trainCourseDao.findAll(ids);
		if(trainCourses!=null) {
			trainCourseDao.delete(trainCourses);
		}

	}
	@Transactional(readOnly = true)
	public TrainCourse findOne(Long id) {
		return trainCourseDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainCourse> findAll() {
		return (List<TrainCourse>) trainCourseDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainCourse> findAll(Specification<TrainCourse> spec, Pageable pageable) {
		
		return trainCourseDao.findAll(spec,pageable);
	}
}
