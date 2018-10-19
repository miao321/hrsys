package com.hrsys.attendance.web;

import com.hrsys.attendance.dao.DTO.BreachDTO;
import com.hrsys.attendance.dao.DTO.ClockDTO;
import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.common.ExtJason;

/**
 * 考勤模块-图表数据控制层接口
 * @author Lofu
 */
public interface IChart2Controller {
	
	/** 查找每个月上下班打卡的人次 */
	public ExtJason<ClockDTO> findClockData();
	
	/** 查找每个月加班的人次 */
	public ExtJason<MonthDTO> findOvertimeData();
	
	/** 查找每个月请假的人次 */
	public ExtJason<MonthDTO> findLeaveData();
	
	/** 查找每个月违规的人次 */
	public ExtJason<BreachDTO> findBreachData();
}
