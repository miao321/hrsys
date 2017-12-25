package com.hrsys.personnel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.personnel.entity.Change;

/**
 * 人事模块-人事变动类服务层接口
 * @author Lofu
 */
public interface IChangeService {
	/** 插入或保存人事变动数据 */
	public void saveOrUpdate(Change change);
	
	/** 删除某个人事变动数据*/
	public void delete(Change change);
	
	/** 根据id删除多个人事变动数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找人事变动数据 */
	public Change findOne(Integer id);
	
	/** 查找所有人事变动数据 */
	public List<Change> findAll();
	
	/** 人事变动高级查询-动态查询 */
	public Page<Change> findAll(Specification<Change> spec, Pageable pageable);
}
