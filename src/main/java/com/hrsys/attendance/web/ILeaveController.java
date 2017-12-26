package com.hrsys.attendance.web;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hrsys.attendance.dao.DTO.LeaveQueryDTO;
import com.hrsys.attendance.entity.Leave;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-请假记录类控制层接口
 * @author Lofu
 */
public interface ILeaveController {
	/** 插入一些测试数据 */
	public String insertTestDate();
	
	/** 插入或更改请假记录数据 */
	public ExtAjaxResponse saveOrUpdate(Leave leave);
	
	/** 删除请假记录数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除请假记录数据 */
	public ExtAjaxResponse deleteLeaves(Integer[] ids);
	
	/** 根据id查找请假记录数据 */
	public Leave findOne(Integer id);
	
	/** 查找全部请假记录数据 */
	public List<Leave> findAll();
	
	/** 高级查询请假记录数据 */
	public Page<Leave> findByPage(LeaveQueryDTO leaveQueryDTO, ExtPageable pageable);
}
