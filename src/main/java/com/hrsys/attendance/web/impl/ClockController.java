package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.ClockQueryDTO;
import com.hrsys.attendance.entity.Clock;
import com.hrsys.attendance.service.IClockService;
import com.hrsys.attendance.web.IClockController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-打卡记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/clock")
public class ClockController implements IClockController {
	
	@Autowired
	private IClockService clockService;

	@RequestMapping(value = "/insertTestData")
	@ResponseBody
	public String insertTestData() {
		try {
			for(int i=0; i<100; i++) {
				Clock clock = new Clock();
				clock.setEmployNo("E00"+i);
				clock.setEmployName("职工"+i);
				clock.setDeptName("人事部");
				clock.setClockType("上班");
				clock.setCreateTime(DateUtil.getNow());
				
				clockService.saveOrUpdate(clock);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Clock clock) {
		try {
			clockService.saveOrUpdate(clock);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Clock clock = clockService.findOne(id);
			if (clock != null) {
				clockService.delete(clock);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteClocks")
	@ResponseBody
	public ExtAjaxResponse deleteClocks(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				clockService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Clock findOne(@RequestParam Integer id) {
		return clockService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Clock> findAll() {
		return clockService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Clock> findByPage(ClockQueryDTO clockQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return clockService.findAll(ClockQueryDTO.getSpecification(clockQueryDTO), pageable.getPageable());
	}
}
