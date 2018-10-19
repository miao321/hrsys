package com.hrsys.attendance.web.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Clock clock) {
		if(clock.getClockDate() == null && clock.getClockTime() == null) {
			clock.setClockDate(DateUtil.getNow());
			clock.setClockTime(DateUtil.nowToStringHMS());
		}
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

	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = clockService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=clock.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
