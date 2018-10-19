package com.hrsys.train.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.train.entity.TrainExecute;

/**
 * 培训实施类Service层接口
 * @author Administrator
 *
 */
public interface ITrainExecuteService {
	public void saveOrUpdate(TrainExecute trainExecute);
	public void delete(TrainExecute trainExecute);
	//批量删除
	public void delete(List<Long> ids);
	public TrainExecute findOne(Long id);
	public List<TrainExecute> findAll();
	//动态条件查询
	public Page<TrainExecute> findAll(Specification<TrainExecute> spec, Pageable pageable);
	public List<TrainExecute> findByTrainExecuteNum();
	
	//记录表Excel下载
	public HSSFWorkbook downloadExcel();

}