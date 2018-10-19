package com.hrsys.personnel.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.common.ExtJason;
import com.hrsys.personnel.dao.DTO.DeptDTO;
import com.hrsys.personnel.dao.DTO.EducationDTO;
import com.hrsys.personnel.dao.DTO.SexDTO;
import com.hrsys.personnel.service.IChartService;
import com.hrsys.personnel.web.IChartController;

/**
 * 人事模块-图表数据控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/chart")
public class ChartController implements IChartController {

	@Autowired
	private IChartService chartService;
	
	@RequestMapping(value = "/findSexData")
	@ResponseBody
	public ExtJason<SexDTO> findSexData() {
		List<SexDTO> result = chartService.findSexData();
		return new ExtJason<SexDTO>(result);
	}

	@RequestMapping(value = "/findEducationData")
	@ResponseBody
	public ExtJason<EducationDTO> findEducationData() {
		List<EducationDTO> result = chartService.findEducationData();
		return new ExtJason<EducationDTO>(result);
	}

	@RequestMapping(value = "/findDeptData")
	@ResponseBody
	public ExtJason<DeptDTO> findDeptData() {
		List<DeptDTO> result = chartService.findDeptData();
		return new ExtJason<DeptDTO>(result);
	}
	
	@RequestMapping(value = "/findChangeData")
	@ResponseBody
	public ExtJason<MonthDTO> findChangeData() {
		List<MonthDTO> result = chartService.findChangeData();
		return new ExtJason<MonthDTO>(result);
	}

}
