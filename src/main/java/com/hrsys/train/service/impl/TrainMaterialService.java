package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainMaterialDao;
import com.hrsys.train.entity.TrainMaterial;
import com.hrsys.train.service.ITrainMaterialService;
/**
 * 培训材料类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainMaterialService implements ITrainMaterialService {

	@Autowired
	private ITrainMaterialDao trainMaterialDao;
	
	public void saveOrUpdate(TrainMaterial trainMaterial) {
		trainMaterialDao.save(trainMaterial);
		
	}

	public void delete(TrainMaterial trainMaterial) {
		trainMaterialDao.delete(trainMaterial);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainMaterial> trainMaterials =  (List<TrainMaterial>)trainMaterialDao.findAll(ids);
		if(trainMaterials!=null) {
			trainMaterialDao.delete(trainMaterials);
		}

	}
	@Transactional(readOnly = true)
	public TrainMaterial findOne(Long id) {
		return trainMaterialDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainMaterial> findAll() {
		return (List<TrainMaterial>) trainMaterialDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainMaterial> findAll(Specification<TrainMaterial> spec, Pageable pageable) {
		
		return trainMaterialDao.findAll(spec,pageable);
	}
}