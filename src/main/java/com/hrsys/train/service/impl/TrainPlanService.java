package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainPlanDao;
import com.hrsys.train.entity.TrainPlan;
import com.hrsys.train.service.ITrainPlanService;
/**
 * 培训计划类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainPlanService implements ITrainPlanService {

	@Autowired
	private ITrainPlanDao trainPlanDao;
	
	public void saveOrUpdate(TrainPlan trainPlan) {
		trainPlanDao.save(trainPlan);
		
	}

	public void delete(TrainPlan trainPlan) {
		trainPlanDao.delete(trainPlan);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainPlan> trainPlans =  (List<TrainPlan>)trainPlanDao.findAll(ids);
		if(trainPlans!=null) {
			trainPlanDao.delete(trainPlans);
		}

	}
	@Transactional(readOnly = true)
	public TrainPlan findOne(Long id) {
		return trainPlanDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainPlan> findAll() {
		return (List<TrainPlan>) trainPlanDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainPlan> findAll(Specification<TrainPlan> spec, Pageable pageable) {
		
		return trainPlanDao.findAll(spec,pageable);
	}
}