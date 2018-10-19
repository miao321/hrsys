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

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Overtime overtime) {
		if(overtime.getOvertimeDate()!=null && overtime.getOtEndTime()==null) {
			overtime.setOtEndTime(DateUtil.getNow());
		}
		if(overtime.getOvertimeDate()==null && overtime.getOtBeginTime()==null) {
			overtime.setOvertimeDate(DateUtil.nowToDate());
			overtime.setOtBeginTime(DateUtil.getNow());
		} 
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
	
	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = overtimeService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=overtime.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
