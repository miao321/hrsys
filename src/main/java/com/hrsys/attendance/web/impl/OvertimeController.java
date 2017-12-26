package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.OvertimeQueryDTO;
import com.hrsys.attendance.entity.Overtime;
import com.hrsys.attendance.service.IOvertimeService;
import com.hrsys.attendance.web.IOvertimeController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-加班记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/overtime")
public class OvertimeController implements IOvertimeController {
	
	@Autowired
	private IOvertimeService overtimeService;

	@RequestMapping(value = "/insertTestDate", method = RequestMethod.POST)
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Overtime overtime = new Overtime();
				overtime.setEmployNo("E000"+i);
				overtime.setEmployName("职工"+i);
				
				overtimeService.saveOrUpdate(overtime);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Overtime overtime) {
		try {
			overtimeService.saveOrUpdate(overtime);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(Integer id) {
		try {
			Overtime overtime = overtimeService.findOne(id);
			if (overtime != null) {
				overtimeService.delete(overtime);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/deleteOvertimes")
	@ResponseBody
	public ExtAjaxResponse deleteOvertimes(Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				overtimeService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Overtime findOne(Integer id) {
		return overtimeService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Overtime> findAll() {
		return overtimeService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Overtime> findByPage(OvertimeQueryDTO overtimeQueryDTO, ExtPageable pageable) {
		Page<Overtime> overtimePage = overtimeService.findAll(OvertimeQueryDTO.getSpecification(overtimeQueryDTO), pageable.getPageable());
		return overtimePage;
	}
}
