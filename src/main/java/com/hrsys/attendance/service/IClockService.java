package com.hrsys.attendance.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.attendance.entity.Clock;

/**
 * 考勤模块-打卡记录服务层接口
 * @author Lofu
 */
public interface IClockService {
	/** 插入或保存打卡记录数据 */
	public void saveOrUpdate(Clock clock);
	
	/** 删除某个打卡记录数据*/
	public void delete(Clock clock);
	
	/** 根据id删除多个打卡记录数据 */
	public void delete(List<Integer> ids);
	
	/** 根据id查找打卡记录数据 */
	public Clock findOne(Integer id);
	
	/** 查找所有打卡记录数据 */
	public List<Clock> findAll();
	
	/** 打卡记录高级查询-动态查询 */
	public Page<Clock> findAll(Specification<Clock> spec, Pageable pageable);
	
	/** 下载打卡记录数据的Excel数据报表 */
	public HSSFWorkbook downloadExcel();
}
