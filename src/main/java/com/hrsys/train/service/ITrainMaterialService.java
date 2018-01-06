package com.hrsys.train.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.train.entity.TrainMaterial;



/**
 * 培训材料类Service层接口
 * @author Administrator
 *
 */
public interface ITrainMaterialService {
	public void saveOrUpdate(TrainMaterial trainMaterial);
	public void delete(TrainMaterial trainMaterial);
	//批量删除
	public void delete(List<Long> ids);
	public TrainMaterial findOne(Long id);
	public List<TrainMaterial> findAll();
	//动态条件查询
	public Page<TrainMaterial> findAll(Specification<TrainMaterial> spec, Pageable pageable);
}