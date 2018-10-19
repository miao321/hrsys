package com.hrsys.personnel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.DTO.MonthDTO;
import com.hrsys.common.util.ListUtil;
import com.hrsys.personnel.dao.IChangeDao;
import com.hrsys.personnel.dao.IEmployDao;
import com.hrsys.personnel.dao.DTO.DeptDTO;
import com.hrsys.personnel.dao.DTO.EducationDTO;
import com.hrsys.personnel.dao.DTO.SexDTO;
import com.hrsys.personnel.service.IChartService;

/**
 * 人事模块-图表数据服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class ChartService implements IChartService {

	@Autowired
	private IEmployDao employDao;
	
	@Autowired
	private IChangeDao changeDao;
	
	@Transactional(readOnly = true)
	public List<SexDTO> findSexData() {
		List<Object[]> objectsList = employDao.countSex();
		List<SexDTO> result = new ArrayList<SexDTO>();
		for(Object[] objects : objectsList) {
			SexDTO sexDTO = new SexDTO();
			sexDTO.setSex(objects[0].toString());
			sexDTO.setCount(Integer.parseInt(objects[1].toString()));
			result.add(sexDTO);
		}
		return result;
	}

	@Transactional(readOnly = true)
	public List<EducationDTO> findEducationData() {
		List<Object[]> objectsList = employDao.countEducation();
		List<EducationDTO> result = new ArrayList<EducationDTO>();
		for(Object[] objects : objectsList) {
			EducationDTO educationDTO = new EducationDTO();
			educationDTO.setEducation(objects[0].toString());
			educationDTO.setCount(Integer.parseInt(objects[1].toString()));
			result.add(educationDTO);
		}
		return result;
	}

	@Transactional(readOnly = true)
	public List<DeptDTO> findDeptData() {
		List<Object[]> objectsList = employDao.countDept();
		List<DeptDTO> result = new ArrayList<DeptDTO>();
		for(Object[] objects : objectsList) {
			DeptDTO deptDTO = new DeptDTO();
			deptDTO.setDeptName(objects[0].toString());
			deptDTO.setCount(Integer.parseInt(objects[1].toString()));
			result.add(deptDTO);
		}
		return result;
	}

	@Transactional(readOnly = true)
	public List<MonthDTO> findChangeData() {
		List<Object[]> objectsList = changeDao.countChange();
		return ListUtil.toListDTO(objectsList);
	}
}
