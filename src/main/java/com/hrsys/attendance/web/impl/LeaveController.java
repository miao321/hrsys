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

import com.hrsys.attendance.dao.DTO.LeaveQueryDTO;
import com.hrsys.attendance.entity.Leave;
import com.hrsys.attendance.service.ILeaveService;
import com.hrsys.attendance.web.ILeaveController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-请假记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/leave")
public class LeaveController implements ILeaveController {

	@Autowired
	private ILeaveService leaveService;

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Leave leave) {
		try {
			leaveService.saveOrUpdate(leave);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Leave leave = leaveService.findOne(id);
			if (leave != null) {
				leaveService.delete(leave);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteLeaves")
	@ResponseBody
	public ExtAjaxResponse deleteLeaves(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				leaveService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Leave findOne(@RequestParam Integer id) {
		return leaveService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Leave> findAll() {
		return leaveService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Leave> findByPage(LeaveQueryDTO leaveQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return leaveService.findAll(LeaveQueryDTO.getSpecification(leaveQueryDTO), pageable.getPageable());
	}
	
	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = leaveService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=leave.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
