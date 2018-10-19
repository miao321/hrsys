package com.hrsys.train.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployJob;
import com.hrsys.train.entity.TrainCourse;



/**
 * 培训课程类Service层接口
 * @author Administrator
 *
 */
public interface ITrainCourseService {
	public void saveOrUpdate(TrainCourse trainCourse);
	public void delete(TrainCourse trainCourse);
	//批量删除
	public void delete(List<Long> ids);
	public TrainCourse findOne(Long id);
	public List<TrainCourse> findAll();
	//动态条件查询
	public Page<TrainCourse> findAll(Specification<TrainCourse> spec, Pageable pageable);
	
	//获取TrainCourse数目
	public List<TrainCourse> findByTrainCourseNum();

	//记录表Excel下载
	public HSSFWorkbook downloadExcel();
}
