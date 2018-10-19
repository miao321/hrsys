package com.hrsys.personnel.web;

import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.common.ExtJason;
import com.hrsys.personnel.dao.DTO.DeptDTO;
import com.hrsys.personnel.dao.DTO.EducationDTO;
import com.hrsys.personnel.dao.DTO.SexDTO;

/**
 * 人事模块-图表数据控制层接口
 * @author Lofu
 */
public interface IChartController {
	
	/** 查找职工性别比例数据 */
	public ExtJason<SexDTO> findSexData();
	
	/** 查找职工教育程度人数数据 */
	public ExtJason<EducationDTO> findEducationData();
	
	/** 查找职工部门人数比例数据 */
	public ExtJason<DeptDTO> findDeptData();
	
	/** 查找每月人事变动数据 */
	public ExtJason<MonthDTO> findChangeData();
}
