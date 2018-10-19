package com.hrsys.attendance.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.attendance.dao.DTO.ClockQueryDTO;
import com.hrsys.attendance.entity.Clock;

/**
 * 考勤模块-打卡记录类控制层接口
 * @author Lofu
 */
public interface IClockController {
	
	/** 插入或更改打卡记录数据 */
	public ExtAjaxResponse saveOrUpdate(Clock clock);
	
	/** 删除打卡记录数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除打卡记录数据 */
	public ExtAjaxResponse deleteClocks(Integer[] ids);
	
	/** 根据id查找打卡记录数据 */
	public Clock findOne(Integer id);
	
	/** 查找全部打卡记录数据 */
	public List<Clock> findAll();
	
	/** 高级查询打卡记录数据 */
	public Page<Clock> findByPage(ClockQueryDTO clockQueryDTO, ExtPageable pageable);
	
	/** 下载打卡记录数据的Excel数据报表 */
	public void downloadExcel(HttpServletResponse response);
}
