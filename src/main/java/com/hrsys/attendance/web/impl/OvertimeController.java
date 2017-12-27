package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.OvertimeQueryDTO;
import com.hrsys.attendance.entity.Overtime;
import com.hrsys.attendance.service.IOvertimeService;
import com.hrsys.attendance.web.IOvertimeController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-加班记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/overtime")
public class OvertimeController implements IOvertimeController {
	
	@Autowired
	private IOvertimeService overtimeService;

	@RequestMapping(value = "/insertTestData")
	@ResponseBody
	public String insertTestData() {
		try {
			for(int i=0; i<100; i++) {
				Overtime overtime = new Overtime();
				overtime.setEmployNo("E00"+i);
				overtime.setEmployName("职工"+i);
				overtime.setCreateTime(DateUtil.stringToDay("2017-12-25"));
				overtime.setOtBeginTime(DateUtil.StringToHMS("2017-12-12 19:00:00"));
				overtime.setOtEndTime(DateUtil.StringToHMS("2017-12-12 21:00:00"));
				
				overtimeService.saveOrUpdate(overtime);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Overtime overtime) {
		try {
			overtimeService.saveOrUpdate(overtime);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
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

	@RequestMapping(value = "/deleteOvertimes")
	@ResponseBody
	public ExtAjaxResponse deleteOvertimes(@RequestParam Integer[] ids) {
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

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Overtime findOne(@RequestParam Integer id) {
		return overtimeService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Overtime> findAll() {
		return overtimeService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Overtime> findByPage(OvertimeQueryDTO overtimeQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return overtimeService.findAll(OvertimeQueryDTO.getSpecification(overtimeQueryDTO), pageable.getPageable());
	}
}
