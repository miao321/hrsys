package com.hrsys.personnel.web;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.DeptQueryDTO;
import com.hrsys.personnel.entity.Dept;

/**
 * 人事模块-部门类控制层接口
 * @author Lofu
 */
public interface IDeptController {
	/** 插入一些测试数据 */
	public String insertTestData();
	
	/** 插入或更改部门数据 */
	public ExtAjaxResponse saveOrUpdate(Dept dept);
	
	/** 删除部门数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除部门数据 */
	public ExtAjaxResponse deleteDepts(Integer[] ids);
	
	/** 根据id查找部门数据 */
	public Dept findOne(Integer id);
	
	/** 查找全部部门数据 */
	public List<Dept> findAll();
	
	/** 高级查询部门数据 */
	public Page<Dept> findByPage(DeptQueryDTO deptQueryDTO, ExtPageable pageable);
}
