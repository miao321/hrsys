package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainPersonalDao;
import com.hrsys.train.entity.TrainPersonal;
import com.hrsys.train.service.ITrainPersonalService;
/**
 * 个人培训记录类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainPersonalService implements ITrainPersonalService {
	@Autowired
	private ITrainPersonalDao trainPersonalDao;
	
	public void saveOrUpdate(TrainPersonal trainPersonal) {
		trainPersonalDao.save(trainPersonal);
		
	}

	public void delete(TrainPersonal trainPersonal) {
		trainPersonalDao.delete(trainPersonal);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainPersonal> trainPersonals =  (List<TrainPersonal>)trainPersonalDao.findAll(ids);
		if(trainPersonals!=null) {
			trainPersonalDao.delete(trainPersonals);
		}

	}
	@Transactional(readOnly = true)
	public TrainPersonal findOne(Long id) {
		return trainPersonalDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainPersonal> findAll() {
		return (List<TrainPersonal>) trainPersonalDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainPersonal> findAll(Specification<TrainPersonal> spec, Pageable pageable) {
		
		return trainPersonalDao.findAll(spec,pageable);
	}
}