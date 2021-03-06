package com.hrsys.attendance.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.hrsys.attendance.dao.DTO.OvertimeQueryDTO;
import com.hrsys.attendance.entity.Overtime;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-加班记录类控制层接口
 * @author Lofu
 */
public interface IOvertimeController {
	
	/** 插入或更改加班记录数据 */
	public ExtAjaxResponse saveOrUpdate(Overtime overtime);
	
	/** 删除加班记录数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除加班记录数据 */
	public ExtAjaxResponse deleteOvertimes(Integer[] ids);
	
	/** 根据id查找加班记录数据 */
	public Overtime findOne(Integer id);
	
	/** 查找全部加班记录数据 */
	public List<Overtime> findAll();
	
	/** 高级查询加班记录数据 */
	public Page<Overtime> findByPage(OvertimeQueryDTO overtimeQueryDTO, ExtPageable pageable);
	
	/** 下载加班记录数据的Excel数据报表 */
	public void downloadExcel(HttpServletResponse response);
}
