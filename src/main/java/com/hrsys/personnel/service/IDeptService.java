package com.hrsys.personnel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.personnel.entity.Dept;

/**
 * 人事模块-部门类服务层接口
 * @author Lofu
 */
public interface IDeptService {
	/** 插入或保存部门数据 */
	public void saveOrUpdate(Dept dept);
	
	/** 删除某个部门数据*/
	public void delete(Dept dept);
	
	/** 根据id删除多个部门数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找部门数据 */
	public Dept findOne(Integer id);
	
	/** 查找所有部门数据 */
	public List<Dept> findAll();
	
	/** 部门高级查询-动态查询 */
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable);
}
