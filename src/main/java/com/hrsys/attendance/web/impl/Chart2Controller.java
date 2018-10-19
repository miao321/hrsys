package com.hrsys.attendance.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.BreachDTO;
import com.hrsys.attendance.dao.DTO.ClockDTO;
import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.attendance.service.IChart2Service;
import com.hrsys.attendance.web.IChart2Controller;
import com.hrsys.common.ExtJason;

/**
 * 考勤模块-图表数据控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/chart")
public class Chart2Controller implements IChart2Controller {

	@Autowired
	private IChart2Service chart2Service;
	
	@RequestMapping(value = "/findClockData")
	@ResponseBody
	public ExtJason<ClockDTO> findClockData() {
		List<ClockDTO> result = chart2Service.findClockData();
		return new ExtJason<ClockDTO>(result);
	}

	@RequestMapping(value = "/findOvertimeData")
	@ResponseBody
	public ExtJason<MonthDTO> findOvertimeData() {
		List<MonthDTO> result = chart2Service.findOvertimeData();
		return new ExtJason<MonthDTO>(result);
	}

	@RequestMapping(value = "/findLeaveData")
	@ResponseBody
	public ExtJason<MonthDTO> findLeaveData() {
		List<MonthDTO> result = chart2Service.findLeaveData();
		return new ExtJason<MonthDTO>(result);
	}

	@RequestMapping(value = "/findBreachData")
	@ResponseBody
	public ExtJason<BreachDTO> findBreachData() {
		List<BreachDTO> result = chart2Service.findBreachData();
		return new ExtJason<BreachDTO>(result);
	}

}
