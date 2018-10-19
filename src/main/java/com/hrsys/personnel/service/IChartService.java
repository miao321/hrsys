package com.hrsys.personnel.service;

import java.util.List;

import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.personnel.dao.DTO.DeptDTO;
import com.hrsys.personnel.dao.DTO.EducationDTO;
import com.hrsys.personnel.dao.DTO.SexDTO;

/**
 * 人事模块-图表数据服务层接口
 * @author Lofu
 */
public interface IChartService {
	
	/** 查找职工性别比例数据 */
	public List<SexDTO> findSexData();
	
	/** 查找职工教育程度比例数据 */
	public List<EducationDTO> findEducationData();
	
	/** 查找职工部门人数数据 */
	public List<DeptDTO> findDeptData();
	
	/** 查找每月人事变动数据 */
	public List<MonthDTO> findChangeData();
}
