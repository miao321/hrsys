package com.hrsys.train.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.train.entity.TrainPlan;



/**
 * 培训计划类Service层接口
 * @author Administrator
 *
 */
public interface ITrainPlanService {
	public void saveOrUpdate(TrainPlan trainPlan);
	public void delete(TrainPlan trainPlan);
	//批量删除
	public void delete(List<Long> ids);
	public TrainPlan findOne(Long id);
	public List<TrainPlan> findAll();
	//动态条件查询
	public Page<TrainPlan> findAll(Specification<TrainPlan> spec, Pageable pageable);
}
