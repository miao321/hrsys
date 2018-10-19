package com.hrsys.attendance.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.attendance.entity.Overtime;

/**
 * 考勤模块-加班记录服务层接口
 * @author Lofu
 */
public interface IOvertimeService {
	/** 插入或保存加班记录数据 */
	public void saveOrUpdate(Overtime overtime);
	
	/** 删除某个加班记录数据*/
	public void delete(Overtime overtime);
	
	/** 根据id删除多个加班记录数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找加班记录数据 */
	public Overtime findOne(Integer id);
	
	/** 查找所有加班记录数据 */
	public List<Overtime> findAll();
	
	/** 加班记录高级查询-动态查询 */
	public Page<Overtime> findAll(Specification<Overtime> spec, Pageable pageable);
	
	/** 下载加班记录数据的Excel数据报表 */
	public HSSFWorkbook downloadExcel();
}
