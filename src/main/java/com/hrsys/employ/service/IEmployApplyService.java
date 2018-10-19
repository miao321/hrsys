package com.hrsys.employ.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.entity.dto.EmployJobQueryDTO;



/**
 * 应聘者信息类Service层接口
 * @author Administrator
 *
 */
public interface IEmployApplyService {
	public void saveOrUpdate(EmployApply employApply);
	public void delete(EmployApply employApply);
	//批量删除
	public void delete(List<Long> ids);
	public EmployApply findOne(Long id);
	public List<EmployApply> findAll();
	//动态条件查询
	public Page<EmployApply> findAll(Specification<EmployApply> spec, Pageable pageable);
//	public Page<EmployJob> findByEmployJob(Specification<EmployJob> spec, Pageable pageable);
	
	//获取EmployApply数目
	public List<EmployApply> findByEmployApplyNum();
	//记录表Excel下载
	public HSSFWorkbook downloadExcel();
}
