package com.hrsys.train.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.train.dao.ITrainExecuteDao;
import com.hrsys.train.entity.TrainExecute;
import com.hrsys.train.service.ITrainExecuteService;
/**
 * 培训实施类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainExecuteService implements ITrainExecuteService {

	@Autowired
	private ITrainExecuteDao trainExecuteDao;
	
	public void saveOrUpdate(TrainExecute trainExecute) {
		trainExecuteDao.save(trainExecute);
		
	}

	public void delete(TrainExecute trainExecute) {
		trainExecuteDao.delete(trainExecute);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainExecute> trainExecutes =  (List<TrainExecute>)trainExecuteDao.findAll(ids);
		if(trainExecutes!=null) {
			trainExecuteDao.delete(trainExecutes);
		}

	}
	@Transactional(readOnly = true)
	public TrainExecute findOne(Long id) {
		return trainExecuteDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainExecute> findAll() {
		return (List<TrainExecute>) trainExecuteDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainExecute> findAll(Specification<TrainExecute> spec, Pageable pageable) {
		
		return trainExecuteDao.findAll(spec,pageable);
	}
}