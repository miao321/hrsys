package com.hrsys.train.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.train.entity.TrainDemand;



/**
 * 培训课程类Service层接口
 * @author Administrator
 *
 */
public interface ITrainDemandService {
	public void saveOrUpdate(TrainDemand trainDemand);
	public void delete(TrainDemand trainDemand);
	//批量删除
	public void delete(List<Long> ids);
	public TrainDemand findOne(Long id);
	public List<TrainDemand> findAll();
	//动态条件查询
	public Page<TrainDemand> findAll(Specification<TrainDemand> spec, Pageable pageable);
}