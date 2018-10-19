package com.hrsys.attendance.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.attendance.entity.Leave;

/**
 * 考勤模块-请假记录服务层接口
 * @author Lofu
 */
public interface ILeaveService {
	/** 插入或保存请假记录数据 */
	public void saveOrUpdate(Leave leave);
	
	/** 删除某个请假记录数据*/
	public void delete(Leave leave);
	
	/** 根据id删除多个请假记录数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找请假记录数据 */
	public Leave findOne(Integer id);
	
	/** 查找所有请假记录数据 */
	public List<Leave> findAll();
	
	/** 请假记录高级查询-动态查询 */
	public Page<Leave> findAll(Specification<Leave> spec, Pageable pageable);
	
	/** 下载请假记录数据的Excel数据报表 */
	public HSSFWorkbook downloadExcel();
}
