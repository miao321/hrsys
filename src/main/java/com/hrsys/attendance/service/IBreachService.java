package com.hrsys.attendance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.attendance.entity.Breach;

/**
 * 考勤模块-违规记录服务层接口
 * @author Lofu
 */
public interface IBreachService {
	/** 插入或保存违规记录数据 */
	public void saveOrUpdate(Breach breach);
	
	/** 删除某个违规记录数据*/
	public void delete(Breach breach);
	
	/** 根据id删除多个违规记录数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找违规记录数据 */
	public Breach findOne(Integer id);
	
	/** 查找所有违规记录数据 */
	public List<Breach> findAll();
	
	/** 违规记录高级查询-动态查询 */
	public Page<Breach> findAll(Specification<Breach> spec, Pageable pageable);
}
