package com.hrsys.personnel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.personnel.entity.Employ;

/**
 * 人事模块-职工类服务层接口
 * @author Lofu
 */
public interface IEmployService {
	/** 插入或保存职工数据 */
	public void saveOrUpdate(Employ employ);
	
	/** 删除某个职工数据*/
	public void delete(Employ employ);
	
	/** 根据id删除多个职工数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找职工数据 */
	public Employ findOne(Integer id);
	
	/** 查找所有职工数据 */
	public List<Employ> findAll();
	
	/** 职工高级查询-动态查询 */
	public Page<Employ> findAll(Specification<Employ> spec, Pageable pageable);
}
