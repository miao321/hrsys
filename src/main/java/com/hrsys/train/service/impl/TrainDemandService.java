package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainDemandDao;
import com.hrsys.train.entity.TrainDemand;
import com.hrsys.train.service.ITrainDemandService;
/**
 * 培训需求类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainDemandService implements ITrainDemandService {

	@Autowired
	private ITrainDemandDao trainDemandDao;
	
	public void saveOrUpdate(TrainDemand trainDemand) {
		trainDemandDao.save(trainDemand);
		
	}

	public void delete(TrainDemand trainDemand) {
		trainDemandDao.delete(trainDemand);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainDemand> trainDemands =  (List<TrainDemand>)trainDemandDao.findAll(ids);
		if(trainDemands!=null) {
			trainDemandDao.delete(trainDemands);
		}

	}
	@Transactional(readOnly = true)
	public TrainDemand findOne(Long id) {
		return trainDemandDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainDemand> findAll() {
		return (List<TrainDemand>) trainDemandDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainDemand> findAll(Specification<TrainDemand> spec, Pageable pageable) {
		
		return trainDemandDao.findAll(spec,pageable);
	}
}