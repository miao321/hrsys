package com.hrsys.attendance.service;

import java.util.List;

import com.hrsys.attendance.dao.DTO.BreachDTO;
import com.hrsys.attendance.dao.DTO.ClockDTO;
import com.hrsys.attendance.dao.DTO.MonthDTO;

/**
 * 考勤模块-图表数据服务层接口
 * @author Lofu
 */
public interface IChart2Service {
	
	/** 查找每个月上下班的打卡数 */
	public List<ClockDTO> findClockData();
	
	/** 查找每个月加班的记录 */
	public List<MonthDTO> findOvertimeData();
	
	/** 查找每个月请假的记录 */
	public List<MonthDTO> findLeaveData();
	
	/** 查找每个月违规的记录 */
	public List<BreachDTO> findBreachData();
}
