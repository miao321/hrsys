package com.hrsys.train.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.train.entity.TrainPersonal;



/**
 * 个人培训记录类Service层接口
 * @author Administrator
 *
 */
public interface ITrainPersonalService {
	public void saveOrUpdate(TrainPersonal trainPersonal);
	public void delete(TrainPersonal trainPersonal);
	//批量删除
	public void delete(List<Long> ids);
	public TrainPersonal findOne(Long id);
	public List<TrainPersonal> findAll();
	//动态条件查询
	public Page<TrainPersonal> findAll(Specification<TrainPersonal> spec, Pageable pageable);

}
