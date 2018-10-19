package com.hrsys.attendance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.IBreachDao;
import com.hrsys.attendance.dao.IClockDao;
import com.hrsys.attendance.dao.ILeaveDao;
import com.hrsys.attendance.dao.IOvertimeDao;
import com.hrsys.attendance.dao.DTO.BreachDTO;
import com.hrsys.attendance.dao.DTO.ClockDTO;
import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.attendance.service.IChart2Service;
import com.hrsys.common.util.ListUtil;

/**
 * 考勤模块-图表数据服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class Chart2Service implements IChart2Service {

	@Autowired
	private IClockDao clockDao;
	
	@Autowired
	private IOvertimeDao overtimeDao;
	
	@Autowired
	private ILeaveDao leaveDao;
	
	@Autowired
	private IBreachDao breachDao;
	
	@Transactional(readOnly = true)
	public List<ClockDTO> findClockData() {
		List<Object[]> objectsList = clockDao.findClockCount();
		List<ClockDTO> result = new ArrayList<ClockDTO>();
		for(Object[] objects : objectsList) {
			ClockDTO clockDTO = new ClockDTO();
			clockDTO.setMonth(objects[0].toString()+"月");
			clockDTO.setInCount(Integer.parseInt(objects[1].toString()));
			clockDTO.setOutCount(Integer.parseInt(objects[2].toString()));
			result.add(clockDTO);
		}
		return result;
	}
	

	@Transactional(readOnly = true)
	public List<MonthDTO> findOvertimeData() {
		List<Object[]> objectsList = overtimeDao.countOvertime();
		return ListUtil.toListDTO(objectsList);
	}

	@Transactional(readOnly = true)
	public List<MonthDTO> findLeaveData() {
		List<Object[]> objectsList = leaveDao.countLeave();
		return ListUtil.toListDTO(objectsList);
	}

	@Transactional(readOnly = true)
	public List<BreachDTO> findBreachData() {
		List<Object[]> objectsList = breachDao.countBreach();
		List<BreachDTO> result = new ArrayList<BreachDTO>();
		for(Object[] objects : objectsList) {
			BreachDTO breachDTO = new BreachDTO();
			breachDTO.setType(objects[0].toString());
			breachDTO.setCount(Integer.parseInt(objects[1].toString()));
			result.add(breachDTO);
		}
		return result;
	}

}
