package com.hrsys.personnel.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.personnel.entity.Pdept;

/**
 * 人事模块-部门类服务层接口
 * @author Lofu
 */
public interface IPdeptService {
	/** 插入或保存部门数据 */
	public void saveOrUpdate(Pdept dept);
	
	/** 删除某个部门数据*/
	public void delete(Pdept dept);
	
	/** 根据id删除多个部门数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找部门数据 */
	public Pdept findOne(Integer id);
	
	/** 查找所有部门数据 */
	public List<Pdept> findAll();
	
	/** 部门高级查询-动态查询 */
	public Page<Pdept> findAll(Specification<Pdept> spec, Pageable pageable);
	
	/** 下载部门数据的Excel数据报表 */
	public HSSFWorkbook downloadExcel();
}
