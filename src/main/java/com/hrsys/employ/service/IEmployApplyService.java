package com.hrsys.employ.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployApply;



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
}
