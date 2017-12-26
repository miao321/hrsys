package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.ClockQueryDTO;
import com.hrsys.attendance.entity.Clock;
import com.hrsys.attendance.service.IClockService;
import com.hrsys.attendance.web.IClockController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-打卡记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/clock")
public class ClockController implements IClockController {
	
	@Autowired
	private IClockService clockService;

	@RequestMapping(value = "/insertTestDate", method = RequestMethod.POST)
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Clock clock = new Clock();
				clock.setEmployNo("E000"+i);
				clock.setEmployName("职工"+i);
				
				clockService.saveOrUpdate(clock);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Clock clock) {
		try {
			clockService.saveOrUpdate(clock);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(Integer id) {
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

	@RequestMapping("/deleteClocks")
	@ResponseBody
	public ExtAjaxResponse deleteClocks(Integer[] ids) {
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

	@RequestMapping("/findOne")
	@ResponseBody
	public Clock findOne(Integer id) {
		return clockService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Clock> findAll() {
		return clockService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Clock> findByPage(ClockQueryDTO clockQueryDTO, ExtPageable pageable) {
		Page<Clock> clockPage = clockService.findAll(ClockQueryDTO.getSpecification(clockQueryDTO), pageable.getPageable());
		return clockPage;
	}
}
